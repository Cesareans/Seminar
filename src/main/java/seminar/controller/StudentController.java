package seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/index")
    public String index(){
        return "/student/index";
    }

    @GetMapping("/course")
    public String courses(){
        return "/student/course";
    }
}
