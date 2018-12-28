package seminar.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seminar.config.SeminarConfig;
import seminar.entity.*;
import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.application.ShareTeamApplication;
import seminar.entity.relation.KlassRound;
import seminar.logger.DebugLogger;
import seminar.pojo.dto.*;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final SeminarService seminarService;
    private final CaptchaService captchaService;
    private final MailService mailService;
    private final FileService fileService;
    private final ApplicationService applicationService;
    private final ScoreService scoreService;

    private final static String TEACHER_ID_GIST = "teacherId";

    @Autowired
    public TeacherController(TeacherService teacherService, SeminarService seminarService, CaptchaService captchaService, MailService mailService, FileService fileService, ApplicationService applicationService, ScoreService scoreService) {
        this.teacherService = teacherService;
        this.seminarService = seminarService;
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.fileService = fileService;
        this.applicationService = applicationService;
        this.scoreService = scoreService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = seminarService.getTeacherByTN(user.getUsername()).get(0);
        session.setAttribute(TEACHER_ID_GIST, teacher.getId());
        if (teacher.isActivated()) {
            model.addAttribute("teacher", teacher);
            return "teacher/index";
        } else {
            return "redirect:/teacher/activation";
        }
    }

    @PostMapping("/captcha/{type}")
    public @ResponseBody
    ResponseEntity<Object> getCaptcha(@PathVariable String type, String email, HttpSession session) {
        String captcha = captchaService.generateCaptcha();
        session.setAttribute(type + "Captcha", captcha);
        mailService.sendCaptcha(captcha, email);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/activation")
    public String activation(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = seminarService.getTeacherByTN(user.getUsername()).get(0);
        model.addAttribute("teacher", teacher);
        return "teacher/activation";
    }

    @PostMapping("/activation")
    public @ResponseBody
    ResponseEntity<Object> activate(String password, HttpSession session) {
        if (teacherService.activate(((String) session.getAttribute(TEACHER_ID_GIST)), password)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("教师不存在");
        }
    }


    @GetMapping("/setting")
    public String setting(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = seminarService.getTeacherByTN(user.getUsername()).get(0);
        model.addAttribute("teacher", teacher);

        return "teacher/setting";
    }

    @GetMapping("/modifyEmail")
    public String modifyEmail() {
        return "teacher/modifyEmail";
    }

    @PostMapping("/modifyEmail")
    public @ResponseBody
    ResponseEntity<Object> modifyEmail(String email, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("modifyEmailCaptcha"));
        if (captcha.equals(senderCaptcha)) {
            teacherService.modifyEmail(((String) session.getAttribute(TEACHER_ID_GIST)), email);
            session.removeAttribute("modifyEmailCaptcha");
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword() {
        return "teacher/modifyPassword";
    }

    @PostMapping("/modifyPassword")
    public @ResponseBody
    ResponseEntity<Object> modifyPassword(String password, HttpSession session) {
        if (!teacherService.modifyPasswordViaId(((String) session.getAttribute(TEACHER_ID_GIST)), password)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/notification")
    public String notification(Model model, HttpSession session) {
        String teacherId = ((String) session.getAttribute(TEACHER_ID_GIST));
        //STApps:ShareTeamApplications     SSApps:ShareSeminarApplications
        model.addAttribute("STApps", applicationService.getShareTeamApplicationByTeacherId(teacherId));
        model.addAttribute("SSApps", applicationService.getShareSeminarApplicationByTeacherId(teacherId));
        model.addAttribute("TVApps", applicationService.getTeamValidApplicationByTeacherId(teacherId));
        return "teacher/notification";
    }

    @PostMapping("/notification/handle")
    public @ResponseBody
    ResponseEntity<Object> handleApplication(@RequestBody ApplicationHandleDTO applicationHandleDTO) {
        /*
         * 0 : ShareSeminar
         * 1 : ShareTeam
         * 2 : Team valid
         */
        switch (applicationHandleDTO.getAppType()) {
            case 0:
                if (applicationService.handleShareSeminarApplication(applicationHandleDTO)) {
                    return ResponseEntity.status(HttpStatus.OK).body(null);
                } else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
                }
            case 1:
                if (applicationService.handleShareTeamApplication(applicationHandleDTO)) {
                    return ResponseEntity.status(HttpStatus.OK).body(null);
                } else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
                }
            case 2:
                if (applicationService.handleTeamValidApplication(applicationHandleDTO)) {
                    return ResponseEntity.status(HttpStatus.OK).body(null);
                } else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
                }
            default:
                throw new RuntimeException();
        }
    }

    @GetMapping("/courseList")
    public String course(Model model, HttpSession session) {
        model.addAttribute("courses", seminarService.getCoursesByTeacherId(((String) session.getAttribute(TEACHER_ID_GIST))));
        return "teacher/courseList";
    }

    @PostMapping("/course/info")
    public String courseInfo(String courseId, Model model) {
        model.addAttribute("course", seminarService.getCourseByCourseId(courseId).get(0));
        return "teacher/course/info";
    }

    @GetMapping("/course/create")
    public String courseCreate(Model model) {
        model.addAttribute("courses", seminarService.getAllCoursesWithTeacher());
        return "teacher/course/create";
    }

    @PutMapping("/course")
    public ResponseEntity<Object> courseCreate(@RequestBody CourseCreateDTO courseCreateDTO, HttpSession session) {
        DebugLogger.logJson(courseCreateDTO);
        //Course course = courseCreateDTO.getCourse();
        //course.setTeacherId(((String) session.getAttribute(TEACHER_ID_GIST)));
        //teacherService.createCourse(course);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String courseId) {
        teacherService.deleteCourseById(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @PostMapping("/course/seminarList")
    public String seminarList(String courseId, Model model) {
        Course course = seminarService.getCourseByCourseId(courseId).get(0);
        Boolean canAdd = course.getSeminarMainCourseId() == null;
        model.addAttribute("canAdd", canAdd);
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(courseId));
        model.addAttribute("klasses", seminarService.getKlassByCourseId(courseId));

        return "teacher/course/seminarList";
    }

    @PostMapping("/course/round/setting")
    public String roundSetting(String roundId, String courseId, Model model) {
        Round round = seminarService.getRoundByRoundId(roundId).get(0);
        Map<String, KlassRound> klassRoundMap = new HashMap<>(5);
        List<Klass> klasses = seminarService.getKlassByCourseId(courseId);
        klasses.forEach(klass -> {
            klassRoundMap.put(klass.getId(), seminarService.getKlassRoundsByKlassIdAndRoundId(klass.getId(), roundId).get(0));
        });
        model.addAttribute("klasses", klasses);
        model.addAttribute("klassRoundMap", klassRoundMap);
        model.addAttribute("round", round);
        return "teacher/course/roundSetting";
    }

    @PostMapping("/course/round/setting/update")
    public @ResponseBody
    ResponseEntity<Object> updateRoundSetting(@RequestBody RoundSettingDTO roundSettingDTO) {
        Round round = roundSettingDTO.getRound();
        List<KlassRound> klassRounds = roundSettingDTO.getKlassRounds();

        if (!teacherService.updateRoundScoreType(round)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("更新轮次分数计算失败");
        }
        for (KlassRound klassRound : klassRounds) {
            teacherService.updateKlassRound(klassRound);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/course/seminar/create")
    public String seminarCreate(String courseId, Model model) {
        Integer maxSerial = seminarService.getMaxSeminarSerialByCourseId(courseId);
        model.addAttribute("maxSerial", maxSerial);
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(courseId));
        return "teacher/course/seminar/create";
    }

    @PutMapping("/course/seminar")
    public ResponseEntity<Object> createSeminar(@RequestBody Seminar seminar) {
        Round round = new Round();
        round.setCourseId(seminar.getCourseId());
        if (seminar.getRoundId().length() == 0) {
            teacherService.addRound(round);
            seminar.setRoundId(round.getId());
        }
        teacherService.createSeminar(seminar);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/course/seminar/option")
    public String seminarOption(String seminarId, Model model) {
        Seminar seminar = seminarService.getSeminarBySeminarId(seminarId).get(0);
        model.addAttribute("seminar", seminar);
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(seminar.getCourseId()));
        return "teacher/course/seminar/option";
    }

    @PatchMapping("/course/seminar")
    public ResponseEntity<Object> updateSeminar(@RequestBody Seminar seminar) {
        Round round = new Round();
        if (seminar.getRoundId().length() == 0) {
            round.setCourseId(seminar.getCourseId());
            teacherService.addRound(round);
            seminar.setRoundId(round.getId());
        }
        if (!teacherService.updateSeminar(seminar)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /**
     * TODO:Should delete the klass seminar
     */
    @DeleteMapping("/course/seminar/{seminarId}")
    public ResponseEntity<Object> deleteSeminar(@PathVariable String seminarId) {
        teacherService.deleteSeminarById(seminarId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/course/seminar/info")
    public String seminarInfo(String klassId, String seminarId, String ksId, Model model) {
        List<KlassSeminar> klassSeminar;
        if (ksId != null) {
            klassSeminar = seminarService.getKlassSeminarByKlassSeminarId(ksId);
        } else {
            klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        }
        if (klassSeminar.size() == 0) {
            throw new RuntimeException("No klass seminar");
        }
        model.addAttribute("klassSeminar", klassSeminar.get(0));
        return "teacher/course/seminar/info";
    }

    @PostMapping("/course/seminar/grade")
    public String seminarGrade(String klassSeminarId, Model model) {
        List<Attendance> attendances = seminarService.getAttendanceByKsId(klassSeminarId);
        Map<String, SeminarScore> seminarScoreMap = new HashMap<>(attendances.size());
        attendances.forEach(attendance -> {
            seminarScoreMap.put(attendance.getId(), scoreService.calculateScoreOfOneSeminar(attendance.getTeamId(), klassSeminarId));
        });
        model.addAttribute("seminarScore", seminarScoreMap);
        model.addAttribute("attendances", attendances);
        model.addAttribute("ksId", klassSeminarId);
        return "teacher/course/seminar/grade";
    }

    @PostMapping("/course/seminar/grade/modify")
    public ResponseEntity<Object> modifyGrade(String attendanceId, BigDecimal preScore, BigDecimal queScore, BigDecimal reportScore) {
        teacherService.updateSeminarScore(attendanceId, preScore, queScore, reportScore);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/course/seminar/enrollList")
    public String seminarEnrollList(String klassSeminarId, Model model) {
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassSeminarId(klassSeminarId).get(0);
        Boolean hasEnd = (klassSeminar.getState() == 2);
        model.addAttribute("hasEnd", hasEnd);
        model.addAttribute("ksId", klassSeminar.getId());
        model.addAttribute("enrollList", seminarService.getEnrollListByKsId(klassSeminarId));
        return "teacher/course/seminar/enrollList";
    }

    @PostMapping("/course/seminar/enrollList/giveScore")
    public ResponseEntity<Object> giveScore(BigDecimal score, String ksId, String teamId) {
        teacherService.updateReportScore(score, ksId, teamId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value = "/course/seminar/downloadPPT", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<FileSystemResource> downloadPPT(String fileName, String teamId) {
        return ResponseEntity.status(HttpStatus.OK).body(new FileSystemResource(fileService.load(fileName)));
    }

    @GetMapping(value = "/course/seminar/downloadReport", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<FileSystemResource> downloadReport(String fileName, String teamId) {
        return ResponseEntity.status(HttpStatus.OK).body(new FileSystemResource(fileService.load(fileName)));
    }

    @PostMapping("/course/klassList")
    public String klassList(String courseId, Model model) {
        model.addAttribute("klasses", seminarService.getKlassByCourseId(courseId));
        return "teacher/course/klassList";
    }

    @GetMapping("/course/klass/create")
    public String klassCreate() {
        return "teacher/course/klass/create";
    }

    @PutMapping("/course/klass")
    public @ResponseBody
    ResponseEntity<Object> createKlass(KlassCreateDTO vo, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        Klass klass = vo.getKlass();
        Workbook workbook;
        String type = fileService.getFileType(multipartFile);
        if (type.equals(SeminarConfig.WorkBookType.HSSF.getType())) {
            workbook = new HSSFWorkbook(multipartFile.getInputStream());
        } else if (type.equals(SeminarConfig.WorkBookType.XSSF.getType())) {
            workbook = new XSSFWorkbook(multipartFile.getInputStream());
        } else {
            //TODO:Exception handling here
            throw new RuntimeException();
        }
        if (teacherService.createKlass(klass)) {
            teacherService.insertKlassStudent(klass, workbook);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/course/klass/insertStudents")
    public ResponseEntity<Object> insertStudents(@RequestParam("file") MultipartFile multipartFile, String klassId) throws IOException {
        String type = fileService.getFileType(multipartFile);
        Klass klass = seminarService.getKlassById(klassId).get(0);
        if (type.equals(SeminarConfig.WorkBookType.HSSF.getType())) {
            teacherService.insertKlassStudent(klass, new HSSFWorkbook(multipartFile.getInputStream()));
        } else if (type.equals(SeminarConfig.WorkBookType.XSSF.getType())) {
            teacherService.insertKlassStudent(klass, new XSSFWorkbook(multipartFile.getInputStream()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/course/klass/{klassId}")
    public @ResponseBody
    ResponseEntity<Object> deleteKlass(@PathVariable String klassId) {
        teacherService.deleteKlassById(klassId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/course/teamList")
    public String teamList(String courseId, Model model) {
        model.addAttribute("teams", seminarService.getTeamsByCourseId(courseId));
        return "teacher/course/teamList";
    }

    @PostMapping("/course/grade")
    public String grade(String courseId, Model model) {
        //Map roundId - roundScores(for every team in the course)
        List<Round> rounds = seminarService.getRoundsByCourseId(courseId);
        List<Team> teams = seminarService.getTeamsByCourseId(courseId);
        model.addAttribute("rounds", rounds);
        model.addAttribute("teams", teams);
        model.addAttribute("roundScores", scoreService.calculateCourseScore(rounds, teams));
        return "teacher/course/grade";
    }


    @PostMapping("/course/share")
    public String courseShare(String courseId, Model model) {
        model.addAttribute("course", seminarService.getCourseByCourseId(courseId).get(0));
        model.addAttribute("mainCourse", seminarService.getMainCoursesByCourseId(courseId));
        model.addAttribute("subCourse", seminarService.getSubCoursesByCourseId(courseId));
        return "teacher/course/share";
    }

    @PostMapping("/course/share/create")
    public String courseShareCreate(String courseId, Model model) {
        model.addAttribute("course", seminarService.getCourseByCourseId(courseId).get(0));
        model.addAttribute("seminarCourses", seminarService.getCanShareSeminarCourse());
        model.addAttribute("teamCourses", seminarService.getCanShareTeamCourse());
        return "teacher/course/share/create";
    }

    @PostMapping("/course/share/cancelTeamShare")
    public ResponseEntity<Object> cancelTeamShare(String subCourseId) {
        teacherService.cancelTeamShare(subCourseId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/course/share/cancelSeminarShare")
    public ResponseEntity<Object> cancelSeminarShare(String subCourseId) {
        teacherService.cancelSeminarShare(subCourseId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/course/shareApplication")
    public @ResponseBody
    ResponseEntity<Object> createCourseShareApplication(@RequestBody ShareApplicationDTO shareApplicationDTO) {
        String teacherId = seminarService.getCourseByCourseId(shareApplicationDTO.getSubCourseId()).get(0).getTeacherId();
        if (shareApplicationDTO.getShareType() == 0) {
            //Share team
            ShareTeamApplication shareTeamApplication = new ShareTeamApplication();
            shareTeamApplication.setMainCourseId(shareApplicationDTO.getMainCourseId());
            shareTeamApplication.setSubCourseId(shareApplicationDTO.getSubCourseId());
            shareTeamApplication.setTeacherId(teacherId);
            Course course = seminarService.getCourseByCourseId(shareApplicationDTO.getSubCourseId()).get(0);
            if (course.getTeamMainCourseId() != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            if (applicationService.createShareTeamApplication(shareTeamApplication)) {
                return ResponseEntity.status(HttpStatus.OK).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        } else if (shareApplicationDTO.getShareType() == 1) {
            ShareSeminarApplication shareSeminarApplication = new ShareSeminarApplication();
            Course course = seminarService.getCourseByCourseId(shareApplicationDTO.getSubCourseId()).get(0);
            if (course.getSeminarMainCourseId() != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            shareSeminarApplication.setMainCourseId(shareApplicationDTO.getMainCourseId());
            shareSeminarApplication.setSubCourseId(shareApplicationDTO.getSubCourseId());
            shareSeminarApplication.setTeacherId(teacherId);
            if (applicationService.createShareSeminarApplication(shareSeminarApplication)) {
                return ResponseEntity.status(HttpStatus.OK).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        } else {
            throw new RuntimeException();
        }
    }


}
