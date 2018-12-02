package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seminar.entity.Round;
import seminar.entity.Teacher;
import seminar.service.SeminarService;
import seminar.service.TeacherService;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final SeminarService seminarService;

    @Autowired
    public TeacherController(TeacherService teacherService, SeminarService seminarService) {
        this.teacherService = teacherService;
        this.seminarService = seminarService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model,HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = teacherService.getTeacherByTN(user.getUsername()).get(0);
        session.setAttribute("teacherId", teacher.getId());
        model.addAttribute("teacher", teacher);
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
    public String course(Model model, HttpSession session) {
        model.addAttribute("courses", teacherService.getCoursesByTeacherId(((String) session.getAttribute("teacherId"))));
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

    /**
     * Todo: Page finished. Remain to be realize Post
     *
     * @return ViewName
     */
    @GetMapping("/course/create")
    public String courseCreate() {
        return "/teacher/course/create";
    }

    @GetMapping("/course/clbum")
    public String clbum(String courseId, Model model, HttpSession session) {
        if(courseId == null){
            courseId = ((String) session.getAttribute("courseId"));
        }else{
            session.setAttribute("courseId", courseId);
        }
        model.addAttribute("clbums", seminarService.getClbumByCourseId(courseId));
        return "/teacher/course/clbum";
    }

    @GetMapping("/course/createClbum")
    public String clbumCreate() {
        return "/teacher/course/createClbum";
    }

    @GetMapping("/course/seminar")
    public String seminar(String courseId, Model model, HttpSession session) {
        if(courseId == null){
            courseId = ((String) session.getAttribute("courseId"));
        }else{
            session.setAttribute("courseId", courseId);
        }
        List<Map<String,Object>> root = new LinkedList<>();
        List<Round> rounds = seminarService.getRoundsByCourseId(courseId);
        for (Round round : rounds) {
            Map<String, Object> roundSeminar = new HashMap<>(4);
            roundSeminar.put("round", round);
            roundSeminar.put("seminars", seminarService.getSeminarsByRoundId(round.getId()));
            root.add(roundSeminar);
        }
        model.addAttribute("rounds", root);

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
     * TODO:Need better design [Inferiority]
     * @param courseId
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/course/team")
    public String team(String courseId, Model model, HttpSession session) {
        if(courseId == null){
            courseId = ((String) session.getAttribute("courseId"));
        }else{
            session.setAttribute("courseId", courseId);
        }
        model.addAttribute("teams", seminarService.getTeamsByCourseId(courseId));
        return "/teacher/course/team";
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
