package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seminar.entity.*;
import seminar.logger.DebugLogger;
import seminar.pojo.hso.ClbumSeminarHso;
import seminar.pojo.vo.ClbumCreateVO;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

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

    @Autowired
    public TeacherController(AccountManageService accountManageService, TeacherService teacherService, SeminarService seminarService, CaptchaService captchaService, MailService mailService) {
        this.accountManageService = accountManageService;
        this.teacherService = teacherService;
        this.seminarService = seminarService;
        this.captchaService = captchaService;
        this.mailService = mailService;
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
            return "redirect:teacher/activation";
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


    @GetMapping("/option")
    public String option(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = accountManageService.getTeacherByTN(user.getUsername()).get(0);
        model.addAttribute("teacher", teacher);

        return "teacher/option";
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
    @GetMapping("/course/info")
    public String courseInfo(String courseId, Model model) {
        model.addAttribute("course", seminarService.getCourseByCourseId(courseId).get(0));
        return "teacher/course/info";
    }


    @GetMapping("/course/create")
    public String courseCreate() {
        return "teacher/course/create";
    }

    /**
     * Todo[cesare]: Remain to br realized
     */
    @PutMapping("/course")
    public @ResponseBody
    ResponseEntity<Object> courseCreate(Course course) {
        return null;
    }

    @GetMapping("/course/clbumList")
    public String clbumList(String courseId, Model model, HttpSession session) {
        if (courseId == null) {
            courseId = ((String) session.getAttribute("courseId"));
        } else {
            session.setAttribute("courseId", courseId);
        }
        model.addAttribute("clbums", seminarService.getClbumByCourseId(courseId));
        return "teacher/course/clbumList";
    }

    @GetMapping("/course/clbum/create")
    public String clbumCreate(Model model, HttpSession session) {
        model.addAttribute("courseId", session.getAttribute("courseId"));
        return "teacher/course/createClbum";
    }

    @PutMapping("/course/clbum")
    public @ResponseBody
    ResponseEntity<Object> createClbum(@RequestBody ClbumCreateVO vo) {
        Clbum clbum = vo.getClbum();
        if (teacherService.createClbum(clbum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/course/clbum/{clbumId}")
    public @ResponseBody
    ResponseEntity<Object> deleteClbum(@PathVariable String clbumId) {
        teacherService.deleteClbumById(clbumId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @GetMapping("/course/seminarList")
    public String seminarList(String courseId, Model model, HttpSession session) {
        if (courseId == null) {
            courseId = ((String) session.getAttribute("courseId"));
        } else {
            session.setAttribute("courseId", courseId);
        }
        model.addAttribute("courseId", courseId);
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(courseId));
        model.addAttribute("clbums", seminarService.getClbumByCourseId(courseId));

        return "teacher/course/seminarList";
    }

    @PostMapping("/course/round/add")
    public @ResponseBody
    ResponseEntity<Object> addRound(String courseId) {
        teacherService.addRound(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /**
     * Todo: Remain to be realize, Priority
     */
    @GetMapping("/course/seminar/create")
    public String seminarCreate() {
        return "teacher/course/seminar/create";
    }

    /**
     * TODO:May need change url here to be /course/clbumSeminar/info
     */
    @GetMapping("/course/seminar/info")
    public String seminarInfo(String clbumId, String seminarId, Model model, HttpSession session) {
        String sessionKey = "clbumSeminarHso";
        ClbumSeminarHso clbumSeminarHso;
        if (clbumId == null || seminarId == null) {
            clbumSeminarHso = ((ClbumSeminarHso) session.getAttribute(sessionKey));
        } else {
            clbumSeminarHso = new ClbumSeminarHso(clbumId, seminarId);
            session.setAttribute(sessionKey, clbumSeminarHso);
        }
        List<ClbumSeminar> clbumSeminar = seminarService.getClbumSeminarByClbumIdAndSeminarId(clbumSeminarHso.getClbumId(), clbumSeminarHso.getSeminarId());
        if (clbumSeminar.size() == 0) {
            //TODO:need better code here.
            throw new RuntimeException("No clbum seminar");
        }
        model.addAttribute("clbumSeminar", clbumSeminar.get(0));
        return "teacher/course/seminar/info";
    }

    @GetMapping("/course/seminar/enrollList")
    public String seminarEnrollList(String clbumSeminarId, Model model) {
        //TODO:need exceptions handling here
        ClbumSeminar clbumSeminar = seminarService.getClbumSeminarByClbumSeminarId(clbumSeminarId).get(0);
        List<Attendance> enrollList = new LinkedList<>();
        IntStream.range(1, clbumSeminar.getSeminar().getMaxTeam() + 1).forEach(i -> {
            boolean isEnrolled = false;
            for (Attendance attendance : clbumSeminar.getAttendances()) {
                if (attendance.getSn() == i) {
                    isEnrolled = true;
                    enrollList.add(attendance);
                    break;
                }
            }
            if (!isEnrolled) {
                enrollList.add(null);
            }
        });
        model.addAttribute("enrollList", enrollList);
        return "teacher/course/seminar/enrollList";
    }

    /**
     * Todo: Remain to be realize
     */
    @GetMapping("/course/seminar/grade")
    public String seminarGrade() {
        return "teacher/course/seminar/grade";
    }

    /**
     * Todo[Priority]: Remain to be realize
     */
    @GetMapping("/course/seminar/progressing")
    public String seminarProgressing(String clbumSeminarId, Model model) {
        model.addAttribute("csId", clbumSeminarId);
        return "teacher/course/seminar/progressing";
    }

    @GetMapping("/course/teamList")
    public String team(String courseId, Model model) {
        model.addAttribute("teams", seminarService.getTeamsByCourseId(courseId));
        return "teacher/course/teamList";
    }

    /**
     * Todo: Remain to be realize
     */
    @GetMapping("/course/grade")
    public String grade() {
        return "teacher/course/grade";
    }
}
