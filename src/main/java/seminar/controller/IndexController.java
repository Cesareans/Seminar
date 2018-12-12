package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.pojo.exception.CannotAccessResetPwdException;
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
    private final AccountManageService accountManageService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Autowired
    public IndexController(CaptchaService captchaService, MailService mailService, AccountManageService accountManageService, TeacherService teacherService, StudentService studentService) {
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.accountManageService = accountManageService;
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
        List<Teacher> teachers = accountManageService.getTeacherByTN(account);
        if (teachers.size() != 0) {
            session.setAttribute("forgetPasswordCaptcha", captcha);
            session.setAttribute("forgetType", "teacher");
            session.setAttribute("forgetAccount", account);
            mailService.sendCaptcha(captcha, teachers.get(0).getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        List<Student> students = accountManageService.getStudentBySN(account);
        if (students.size() != 0) {
            session.setAttribute("forgetPasswordCaptcha", captcha);
            session.setAttribute("forgetType", "student");
            session.setAttribute("forgetAccount", account);
            mailService.sendCaptcha(captcha, students.get(0).getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(null);

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
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
            throw new CannotAccessResetPwdException();
        }
    }

    @PostMapping("/modifyPassword")
    public @ResponseBody
    ResponseEntity<Object> modifyPassword(String password, HttpSession session) {
        String forgetType = "forgetType";
        String studentType = "student", teacherType = "teacher";
        String forgetAccount = (String) session.getAttribute("forgetAccount");
        if (studentType.equals(session.getAttribute(forgetType))) {
            studentService.modifyPasswordViaSn(forgetAccount, password);
        } else if (teacherType.equals(session.getAttribute(forgetType))) {
            teacherService.modifyPasswordViaTn(forgetAccount, password);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
