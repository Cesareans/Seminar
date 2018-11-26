package seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping("/course")
    public String course(String courseID,Model model){
        //TODO:add courses information into model
        return "/teacher/course";
    }

    @GetMapping("/course/seminar")
    public String seminar(String seminarID,Model model){
        //TODO:get course's seminar information by courseID
        //TODO:add seminar information into model
        return "/teacher/seminar";
    }
}
