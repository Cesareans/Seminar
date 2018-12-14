package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seminar.entity.*;
import seminar.pojo.vo.KlassCreateVO;
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
        model.addAttribute("teacher", teacher);
        return "teacher/index";
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


    @GetMapping("/setting")
    public String option(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = accountManageService.getTeacherByTN(user.getUsername()).get(0);
        model.addAttribute("teacher", teacher);

        return "teacher/setting";
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

    @GetMapping("/course/klassList")
    public String klassList(String courseId, Model model, HttpSession session) {
        if (courseId == null) {
            courseId = ((String) session.getAttribute("courseId"));
        } else {
            session.setAttribute("courseId", courseId);
        }
        model.addAttribute("klasses", seminarService.getKlassByCourseId(courseId));
        return "teacher/course/klassList";
    }

    @GetMapping("/course/klass/create")
    public String klassCreate(Model model, HttpSession session) {
        model.addAttribute("courseId", session.getAttribute("courseId"));
        return "teacher/course/klass/create";
    }

    @PutMapping("/course/klass")
    public @ResponseBody
    ResponseEntity<Object> createKlass(@RequestBody KlassCreateVO vo) {
        Klass klass = vo.getKlass();
        if (teacherService.createKlass(klass)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("/course/klass/{klassId}")
    public @ResponseBody
    ResponseEntity<Object> deleteKlass(@PathVariable String klassId) {
        teacherService.deleteKlassById(klassId);
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
        model.addAttribute("klasses", seminarService.getKlassByCourseId(courseId));

        return "teacher/course/seminarList";
    }

    @PostMapping("/course/round/add")
    public @ResponseBody
    ResponseEntity<Object> addRound(String courseId) {
        teacherService.addRound(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /**
     * Todo[Priority]: Remain to be realize,
     */
    @GetMapping("/course/seminar/create")
    public String seminarCreate() {
        return "teacher/course/seminar/create";
    }

    @GetMapping("/course/seminar/info")
    public String seminarInfo(String klassId, String seminarId, String klassSeminarId, Model model) {
        List<KlassSeminar> klassSeminar;
        if(klassSeminarId == null) {
            klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        }else{
            klassSeminar = seminarService.getKlassSeminarByKlassSeminarId(klassSeminarId);
        }
        if (klassSeminar.size() == 0) {
            //TODO:need better code here.
            throw new RuntimeException("No klass seminar");
        }
        model.addAttribute("klassSeminar", klassSeminar.get(0));
        return "teacher/course/seminar/info";
    }

    @GetMapping("/course/seminar/enrollList")
    public String seminarEnrollList(String klassSeminarId, Model model) {
        //TODO:need exceptions handling here
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassSeminarId(klassSeminarId).get(0);
        List<Attendance> enrollList = new LinkedList<>();
        IntStream.range(1, klassSeminar.getSeminar().getMaxTeam() + 1).forEach(i -> {
            boolean isEnrolled = false;
            for (Attendance attendance : klassSeminar.getAttendances()) {
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
    public String seminarProgressing(String klassSeminarId, Model model) {
        model.addAttribute("ksId", klassSeminarId);
        return "teacher/course/seminar/progressing";
    }

    @GetMapping("/course/teamList")
    public String teamList(String courseId, Model model) {
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
