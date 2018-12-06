package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seminar.entity.Student;
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

    @Autowired
    public StudentController(StudentService studentService, SeminarService seminarService) {
        this.studentService = studentService;
        this.seminarService = seminarService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = studentService.getStudentBySN(user.getUsername()).get(0);
        session.setAttribute("studentId", student.getId());
        model.addAttribute("student", student);
        return "student/index";
    }

    @GetMapping("/option")
    public String info(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = studentService.getStudentBySN(user.getUsername()).get(0);
        model.addAttribute("student", student);

        return "student/option";
    }

    @GetMapping("/courseList")
    public String courses(Model model, HttpSession session) {
        return "courseList";
    }
}
