package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seminar.entity.Student;
import seminar.service.AccountManageService;
import seminar.service.SeminarService;
import seminar.service.StudentService;

import javax.servlet.http.HttpSession;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final SeminarService seminarService;
    private final AccountManageService accountManageService;

    @Autowired
    public StudentController(StudentService studentService, SeminarService seminarService, AccountManageService accountManageService) {
        this.studentService = studentService;
        this.seminarService = seminarService;
        this.accountManageService = accountManageService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = accountManageService.getStudentBySN(user.getUsername()).get(0);
        session.setAttribute("studentId", student.getId());
        model.addAttribute("student", student);
        return "student/index";
    }

    @GetMapping("/activation")
    public String activation() {
        return "student/activation";
    }

    @GetMapping("/option")
    public String option(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = accountManageService.getStudentBySN(user.getUsername()).get(0);
        model.addAttribute("student", student);

        return "student/option";
    }

    @GetMapping("/courseList")
    public String courses(Model model, HttpSession session) {
        return "courseList";
    }

    @GetMapping("/gradesList")
    public String grades() { return "student/grades";}

    @GetMapping("/group")
    public String group() { return "student/group"; }

}