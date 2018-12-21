package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seminar.entity.KlassSeminar;
import seminar.entity.Student;
import seminar.logger.DebugLogger;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final SeminarService seminarService;
    private final CaptchaService captchaService;
    private final MailService mailService;
    private final AccountManageService accountManageService;

    private final static String STUDENT_ID_GIST = "studentId";
    @Autowired
    public StudentController(StudentService studentService, SeminarService seminarService, CaptchaService captchaService, MailService mailService, AccountManageService accountManageService) {
        this.studentService = studentService;
        this.seminarService = seminarService;
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.accountManageService = accountManageService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = accountManageService.getStudentBySN(user.getUsername()).get(0);
        session.setAttribute(STUDENT_ID_GIST, student.getId());
        if(student.isActivated()){
            model.addAttribute("student", student);
            return "student/index";
        }else{
            return "redirect:/student/activation";
        }
    }


    @PostMapping("/captcha/{type}")
    public @ResponseBody
    ResponseEntity<Object> getCaptcha(@PathVariable String type, String email, HttpSession session) {
        String captcha = captchaService.generateCaptcha();
        mailService.sendCaptcha(captcha, email);
        session.setAttribute(type + "Captcha", captcha);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/activation")
    public String activation() {
        return "student/activation";
    }

    @PostMapping("/activation")
    public @ResponseBody
    ResponseEntity<Object> activate(String password, String email, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("activationCaptcha"));
        if (captcha.equals(senderCaptcha)) {
            if(studentService.activate(((String) session.getAttribute(STUDENT_ID_GIST)), password, email)){
                session.removeAttribute("activationCaptcha");
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body("学生不存在");
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("验证码错误");
        }
    }

    @GetMapping("/setting")
    public String option(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = accountManageService.getStudentBySN(user.getUsername()).get(0);
        model.addAttribute("student", student);

        return "student/setting";
    }


    @GetMapping("/modifyEmail")
    public String modifyEmail() {
        return "student/modifyEmail";
    }

    @PostMapping("/modifyEmail")
    public @ResponseBody
    ResponseEntity<Object> modifyEmail(String email, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("modifyEmailCaptcha"));
        if (captcha.equals(senderCaptcha)) {
            studentService.modifyEmail(((String) session.getAttribute(STUDENT_ID_GIST)), email);
            session.removeAttribute("modifyEmailCaptcha");
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword() {
        return "student/modifyPassword";
    }

    @PostMapping("/modifyPassword")
    public @ResponseBody
    ResponseEntity<Object> modifyPassword(String password, HttpSession session) {
        studentService.modifyPasswordViaId(((String) session.getAttribute(STUDENT_ID_GIST)), password);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/courseList")
    public String courses(Model model, HttpSession session) {
        model.addAttribute("klasses", studentService.getKlassesByStudentId(((String) session.getAttribute(STUDENT_ID_GIST))));
        return "student/courseList";
    }

    @PostMapping("/course/seminarList")
    public String seminarList(String courseId, Model model) {
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(courseId));
        return "student/course/seminarList";
    }

    @PostMapping("/course/seminar/info")
    public String seminarInfo(String klassId, String seminarId, Model model) {
        List<KlassSeminar> klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        model.addAttribute("klassSeminar", klassSeminar.get(0));
        return "student/course/seminar/info";
    }

    @PostMapping("/course/seminar/enrollList")
    public String seminarEnrollList(String klassId, String seminarId, Model model){
        List<KlassSeminar> klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        model.addAttribute("enrollList", seminarService.getEnrollListByKsId(klassSeminar.get(0).getId()));
        return "student/course/seminar/enrollList";
    }

    @PostMapping("/course/seminar/grade")
    public String seminarGrade(String klassId, String seminarId, Model model){
        return "student/course/seminar/grade";
    }

    @PostMapping("/course/seminar/report")
    public String seminarReport(String klassId, String seminarId, Model model){
        return "student/course/seminar/report";
    }

    @PostMapping("/course/seminar/processing")
    public String seminarProcessing(String klassId, String seminarId, Model model){
        return "student/course/seminar/processing";
    }

    @PostMapping("/course/team")
    public String teamList(String courseId, Model model) {
        model.addAttribute("teams", seminarService.getTeamsByCourseId(courseId));
        return "student/course/teamList";
    }
    @PostMapping("/course/info")
    public String courseInfo(String courseId, Model model) {
        return "student/course/info";
    }
    @PostMapping("/course/grade")
    public String seminarGrade(String courseId, Model model){
        return "student/course/grade";
    }
}
