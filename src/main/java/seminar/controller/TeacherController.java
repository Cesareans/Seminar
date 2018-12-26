package seminar.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import seminar.pojo.dto.ApplicationHandleDTO;
import seminar.pojo.dto.KlassCreateDTO;
import seminar.pojo.dto.RoundSettingDTO;
import seminar.pojo.dto.ShareApplicationDTO;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final AccountManageService accountManageService;
    private final TeacherService teacherService;
    private final SeminarService seminarService;
    private final CaptchaService captchaService;
    private final MailService mailService;
    private final FileService fileService;
    private final ApplicationService applicationService;
    private final ScoreService scoreService;

    private final static String TEACHER_ID_GIST = "teacherId";

    @Autowired
    public TeacherController(AccountManageService accountManageService, TeacherService teacherService, SeminarService seminarService, CaptchaService captchaService, MailService mailService, FileService fileService, ApplicationService applicationService, ScoreService scoreService) {
        this.accountManageService = accountManageService;
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
        Teacher teacher = accountManageService.getTeacherByTN(user.getUsername()).get(0);
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
        Teacher teacher = accountManageService.getTeacherByTN(user.getUsername()).get(0);
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
        Teacher teacher = accountManageService.getTeacherByTN(user.getUsername()).get(0);
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
        teacherService.modifyPasswordViaId(((String) session.getAttribute("teacherId")), password);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/notification")
    public String notification(Model model, HttpSession session) {
        String teacherId = ((String) session.getAttribute(TEACHER_ID_GIST));
        //STApps:ShareTeamApplications     SSApps:ShareSeminarApplications
        List<ShareTeamApplication> shareTeamApplications = applicationService.getShareTeamApplicationByTeacherId(teacherId);
        model.addAttribute("STApps", shareTeamApplications);
        model.addAttribute("SSApps", applicationService.getShareSeminarApplicationByTeacherId(teacherId));

        return "teacher/notification";
    }

    @PostMapping("/notification/handle")
    public @ResponseBody
    ResponseEntity<Object> handleApplication(@RequestBody ApplicationHandleDTO applicationHandleDTO) {
        DebugLogger.logJson(applicationHandleDTO);
        /*
         * 0 : ShareSeminar
         * 1 : ShareTeam
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
                return ResponseEntity.status(HttpStatus.OK).body(null);
            default:
                throw new RuntimeException();
        }
    }

    @GetMapping("/courseList")
    public String course(Model model, HttpSession session) {
        model.addAttribute("courses", seminarService.getCoursesByTeacherId(((String) session.getAttribute(TEACHER_ID_GIST))));
        return "teacher/courseList";
    }

    /**
     * Todo: Remains to be deepen designed
     */
    @PostMapping("/course/info")
    public String courseInfo(String courseId, Model model) {
        model.addAttribute("course", seminarService.getCourseByCourseId(courseId).get(0));
        return "teacher/course/info";
    }


    @GetMapping("/course/create")
    public String courseCreate() {
        return "teacher/course/create";
    }

    /**
     * Todo[cesare]: Remain to be realized
     */
    @PutMapping("/course")
    public @ResponseBody
    ResponseEntity<Object> courseCreate(Course course) {
        return null;
    }


    @PostMapping("/course/seminarList")
    public String seminarList(String courseId, Model model) {
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(courseId));
        model.addAttribute("klasses", seminarService.getKlassByCourseId(courseId));

        return "teacher/course/seminarList";
    }

    @PostMapping("/course/round/setting")
    public String roundSetting(String roundId, String courseId, Model model) {
        Round round = seminarService.getRoundByRoundId(roundId).get(0);
        Map<String, Klass> klassMap = new HashMap<>(5);
        round.getKlassRounds().forEach(klassRound -> {
            klassMap.put(klassRound.getKlassId(), seminarService.getKlassById(klassRound.getKlassId()).get(0));
        });
        model.addAttribute("klassMap", klassMap);
        model.addAttribute("round", round);
        return "teacher/course/roundSetting";
    }

    @PostMapping("/course/round/setting/update")
    public @ResponseBody
    ResponseEntity<Object> updateRoundSetting(@RequestBody RoundSettingDTO roundSettingDTO) {
        Round round = roundSettingDTO.getRound();
        List<KlassRound> klassRounds = roundSettingDTO.getKlassRounds();

        teacherService.updateRoundScoreType(round);
        klassRounds.forEach(teacherService::updateKlassRound);
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
        teacherService.updateSeminar(seminar);
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
    public String seminarInfo(String klassId, String seminarId, Model model) {
        List<KlassSeminar> klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        if (klassSeminar.size() == 0) {
            //TODO:need better code here.
            throw new RuntimeException("No klass seminar");
        }
        model.addAttribute("klassSeminar", klassSeminar.get(0));
        return "teacher/course/seminar/info";
    }

    @PostMapping("/course/seminar/enrollList")
    public String seminarEnrollList(String klassSeminarId, Model model) {
        model.addAttribute("enrollList", seminarService.getEnrollListByKsId(klassSeminarId));
        return "teacher/course/seminar/enrollList";
    }

    /**
     * Todo: Remain to be realize
     */
    @PostMapping("/course/seminar/grade")
    public String seminarGrade(String courseId, Model model) {
        List<Round> rounds = seminarService.getRoundsByCourseId(courseId);
        List<Team> teams = seminarService.getTeamsByCourseId(courseId);
        Map<String, List<RoundScore>> scoreMap = new HashMap<>(rounds.size());
        rounds.forEach(round -> {

            List<RoundScore> roundScores = new LinkedList<>();
        });
        return "teacher/course/seminar/grade";
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

    /**
     * Todo: Remain to be realize
     */
    @PostMapping("/course/grade")
    public String grade(String courseId) {
        return "teacher/course/grade";
    }


    @PostMapping("/course/share")
    public String courseShare(String courseId, Model model) {
        model.addAttribute("mainCourse", seminarService.getMainCoursesByCourseId(courseId));
        model.addAttribute("subCourse", seminarService.getSubCoursesByCourseId(courseId));
        return "teacher/course/share";
    }

    @PostMapping("/course/share/create")
    public String courseShareCreate(String courseId, Model model) {
        model.addAttribute("otherCourses", seminarService.getOtherCoursesByCourseId(courseId));
        return "teacher/course/share/create";
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
            if (applicationService.createShareTeamApplication(shareTeamApplication)) {
                return ResponseEntity.status(HttpStatus.OK).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        } else if (shareApplicationDTO.getShareType() == 1) {
            ShareSeminarApplication shareSeminarApplication = new ShareSeminarApplication();
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
