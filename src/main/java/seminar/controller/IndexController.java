package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Cesare
 */
@Controller
public class IndexController {
    private final CaptchaService captchaService;
    private final MailService mailService;
    private final SeminarService seminarService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Autowired
    public IndexController(CaptchaService captchaService, MailService mailService, SeminarService seminarService, TeacherService teacherService, StudentService studentService) {
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.seminarService = seminarService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @RequestMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/forgetPassword")
    public String forgetPassword() {
        return "forgetPassword";
    }

    @PostMapping("/captcha/forgetPassword")
    public @ResponseBody
    ResponseEntity<Object> getCaptcha(String account, HttpSession session) {
        String captcha = captchaService.generateCaptcha();
        List<Teacher> teachers = seminarService.getTeacherByTN(account);
        if (teachers.size() != 0) {
            Teacher teacher = teachers.get(0);
            if (!teacher.isActivated()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON_UTF8).body("该教师尚未激活");
            }
            session.setAttribute("forgetPasswordCaptcha", captcha);
            session.setAttribute("forgetType", "teacher");
            session.setAttribute("forgetAccount", account);
            mailService.sendCaptcha(captcha, teacher.getEmail());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(null);
        }
        List<Student> students = seminarService.getStudentBySN(account);
        if (students.size() != 0) {
            Student student = students.get(0);
            if (!student.isActivated()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON_UTF8).body("该学生尚未激活");
            }
            session.setAttribute("forgetPasswordCaptcha", captcha);
            session.setAttribute("forgetType", "student");
            session.setAttribute("forgetAccount", account);
            mailService.sendCaptcha(captcha, student.getEmail());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(null);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON_UTF8).body("账户不存在");
    }

    @PostMapping("/forgetPassword")
    public @ResponseBody
    ResponseEntity<Object> forgetPassword(String account, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("forgetPasswordCaptcha"));
        if (captcha.equals(senderCaptcha)) {
            session.setAttribute("enableModify", true);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword(HttpSession session) {
        String enableModify = "enableModify";
        if (session.getAttribute(enableModify) != null) {
            return "modifyPassword";
        } else {
            return "error/page";
        }
    }

    @PostMapping("/modifyPassword")
    public @ResponseBody
    ResponseEntity<Object> modifyPassword(String password, HttpSession session) {
        String forgetType = "forgetType";
        String studentType = "student", teacherType = "teacher";
        String forgetAccount = (String) session.getAttribute("forgetAccount");
        if (studentType.equals(session.getAttribute(forgetType))) {
            if (!studentService.modifyPasswordViaSn(forgetAccount, password)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        } else if (teacherType.equals(session.getAttribute(forgetType))) {
            if (!teacherService.modifyPasswordViaTn(forgetAccount, password)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
