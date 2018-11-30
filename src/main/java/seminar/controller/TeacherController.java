package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seminar.service.TeacherService;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping(value = {"", "/index"})
    public String index() {
        return "/teacher/index";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/info")
    public String info() {
        return "/teacher/info";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/notification")
    public String notification() {
        return "/teacher/notification";
    }

    @GetMapping("/course")
    public String course() {
        return "/teacher/course";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/course/info")
    public String courseInfo() {
        return "/teacher/course/info";
    }

    @GetMapping("/course/create")
    public String courseCreate() {
        return "/teacher/course/create";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/clbum")
    public String clbum() {
        return "/teacher/course/clbum";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/clbum/create")
    public String clbumCreate() {
        return "/teacher/course/clbum/create";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/course/clbum/info")
    public String clbumInfo() {
        return "/teacher/course/clbum/info";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/seminar")
    public String seminar() {
        return "/teacher/course/seminar";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/seminar/create")
    public String seminarCreate() {
        return "/teacher/course/seminar/create";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/course/seminar/info")
    public String seminarInfo() {
        return "/teacher/course/seminar/info";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/seminar/round")
    public String seminarRound() {
        return "/teacher/course/seminar/round";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/course/seminar/grade")
    public String seminarGrade() {
        return "/teacher/course/seminar/grade";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/seminar/progressing")
    public String seminarProgressing() {
        return "/teacher/course/seminar/progressing";
    }

    /**
     * Todo: Remain to be realize, Priority
     *
     * @return ViewName
     */
    @GetMapping("/course/group")
    public String group() {
        return "/teacher/course/group";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/course/grade")
    public String grade() {
        return "/teacher/course/grade";
    }
}
