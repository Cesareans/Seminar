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
import seminar.entity.Course;
import seminar.entity.Klass;
import seminar.entity.KlassSeminar;
import seminar.entity.Teacher;
import seminar.pojo.dto.KlassCreateDTO;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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

    @Autowired
    public TeacherController(AccountManageService accountManageService, TeacherService teacherService, SeminarService seminarService, CaptchaService captchaService, MailService mailService, FileService fileService) {
        this.accountManageService = accountManageService;
        this.teacherService = teacherService;
        this.seminarService = seminarService;
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.fileService = fileService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = accountManageService.getTeacherByTN(user.getUsername()).get(0);
        session.setAttribute("teacherId", teacher.getId());
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
    public String activation() {
        return "teacher/activation";
    }

    @PostMapping("/activation")
    public @ResponseBody
    ResponseEntity<Object> activate(String password, String email, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("activationCaptcha"));

        if (captcha.equals(senderCaptcha)) {
            teacherService.activate(((String) session.getAttribute("teacherId")), password, email);
            session.removeAttribute("activationCaptcha");
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
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
            teacherService.modifyEmail(((String) session.getAttribute("teacherId")), email);
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

    /**
     * Todo: Remain to be realized
     */
    @GetMapping("/notification")
    public String notification() {
        return "teacher/notification";
    }

    @GetMapping("/courseList")
    public String course(Model model, HttpSession session) {
        model.addAttribute("courses", teacherService.getCoursesByTeacherId(((String) session.getAttribute("teacherId"))));
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

    @PostMapping("/course/round/add")
    public @ResponseBody
    ResponseEntity<Object> addRound(String courseId) {
        teacherService.addRound(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /**
     * Todo[Priority]: Remain to be realize,
     */
    @GetMapping("/course/seminar/create")
    public String seminarCreate() {
        return "teacher/course/seminar/create";
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
    public String seminarGrade() {
        return "teacher/course/seminar/grade";
    }

    @PostMapping("/course/share")
    public String seminarShare(String courseId, Model model) {
        model.addAttribute("mainCourse", seminarService.getMainCourses(courseId));
        model.addAttribute("subCourse", seminarService.getSubCourses(courseId));
        return "teacher/course/seminar/share";
    }


    @PostMapping("/course/seminar/progressing")
    public String seminarProgressing(String klassSeminarId, Model model) {
        model.addAttribute("ksId", klassSeminarId);
        model.addAttribute("enrollList", seminarService.getEnrollListByKsId(klassSeminarId));
        return "teacher/course/seminar/progressing";
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
}
