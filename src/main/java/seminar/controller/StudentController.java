package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seminar.entity.*;
import seminar.logger.DebugLogger;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final SeminarService seminarService;
    private final CaptchaService captchaService;
    private final MailService mailService;
    private final AccountManageService accountManageService;
    private final ScoreService scoreService;
    private final FileService fileService;

    private final static String STUDENT_ID_GIST = "studentId";
    @Autowired
    public StudentController(StudentService studentService, SeminarService seminarService, CaptchaService captchaService, MailService mailService, AccountManageService accountManageService, ScoreService scoreService, FileService fileService) {
        this.studentService = studentService;
        this.seminarService = seminarService;
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.accountManageService = accountManageService;
        this.scoreService = scoreService;
        this.fileService = fileService;
    }

    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = accountManageService.getStudentBySN(user.getUsername()).get(0);
        session.setAttribute(STUDENT_ID_GIST, student.getId());
        if(student.isActivated()){
            model.addAttribute("student", student);
            return "student/index";
        }else{
            return "redirect:/student/activation";
        }
    }


    @PostMapping("/captcha/{type}")
    public @ResponseBody
    ResponseEntity<Object> getCaptcha(@PathVariable String type, String email, HttpSession session) {
        String captcha = captchaService.generateCaptcha();
        mailService.sendCaptcha(captcha, email);
        session.setAttribute(type + "Captcha", captcha);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/activation")
    public String activation() {
        return "student/activation";
    }

    @PostMapping("/activation")
    public @ResponseBody
    ResponseEntity<Object> activate(String password, String email, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("activationCaptcha"));
        if (captcha.equals(senderCaptcha)) {
            if(studentService.activate(((String) session.getAttribute(STUDENT_ID_GIST)), password, email)){
                session.removeAttribute("activationCaptcha");
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body("学生不存在");
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("验证码错误");
        }
    }

    @GetMapping("/setting")
    public String option(Model model) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = accountManageService.getStudentBySN(user.getUsername()).get(0);
        model.addAttribute("student", student);

        return "student/setting";
    }


    @GetMapping("/modifyEmail")
    public String modifyEmail() {
        return "student/modifyEmail";
    }

    @PostMapping("/modifyEmail")
    public @ResponseBody
    ResponseEntity<Object> modifyEmail(String email, String captcha, HttpSession session) {
        String senderCaptcha = ((String) session.getAttribute("modifyEmailCaptcha"));
        if (captcha.equals(senderCaptcha)) {
            studentService.modifyEmail(((String) session.getAttribute(STUDENT_ID_GIST)), email);
            session.removeAttribute("modifyEmailCaptcha");
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword() {
        return "student/modifyPassword";
    }

    @PostMapping("/modifyPassword")
    public @ResponseBody
    ResponseEntity<Object> modifyPassword(String password, HttpSession session) {
        studentService.modifyPasswordViaId(((String) session.getAttribute(STUDENT_ID_GIST)), password);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/courseList")
    public String courses(Model model, HttpSession session) {
        model.addAttribute("klasses", studentService.getKlassesByStudentId(((String) session.getAttribute(STUDENT_ID_GIST))));
        return "student/courseList";
    }

    @PostMapping("/course/seminarList")
    public String seminarList(String courseId, Model model) {
        model.addAttribute("rounds", seminarService.getRoundsByCourseId(courseId));
        return "student/course/seminarList";
    }

    @PostMapping("/course/seminar/info")
    public String seminarInfo(String klassId, String seminarId, Model model) {
        List<KlassSeminar> klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        model.addAttribute("klassSeminar", klassSeminar.get(0));
        return "student/course/seminar/info";
    }

    @PostMapping("/course/seminar/enrollList")
    public String seminarEnrollList(String klassId, String seminarId, Model model, HttpSession session){
        Klass klass = seminarService.getKlassById(klassId).get(0);
        List<KlassSeminar> klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        model.addAttribute("enrollList", seminarService.getEnrollListByKsId(klassSeminar.get(0).getId()));
        model.addAttribute("team", seminarService.getTeamByKlassIdAndStudentId(klass.getId(), ((String) session.getAttribute("studentId"))));
        model.addAttribute("ksId", klassSeminar.get(0).getId());
        return "student/course/seminar/enrollList";
    }

    @PostMapping("/course/seminar/uploadPPT")
    public ResponseEntity<Object> uploadPPT(@RequestParam("file") MultipartFile multipartFile, String attendanceId){
        if(fileService.store(multipartFile) != null) {
            studentService.uploadPreFile(attendanceId, multipartFile.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping(value = "/course/seminar/downloadPPT", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<FileSystemResource> downloadPPT(String fileName){
        return ResponseEntity.status(HttpStatus.OK).body(new FileSystemResource(fileService.load(fileName)));
    }

    @PostMapping("/course/seminar/enroll")
    public ResponseEntity<Object> seminarEnroll(String ksId, String teamId, Integer sn){
        if (studentService.seminarEnroll(ksId, teamId, sn)){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/course/seminar/report")
    public String seminarReport(String klassId, String seminarId, Model model, HttpSession session){
        Klass klass = seminarService.getKlassById(klassId).get(0);
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId).get(0);
        Team team = seminarService.getTeamByKlassIdAndStudentId(klass.getId(), ((String) session.getAttribute("studentId")));
        Attendance attendance;
        if(team != null){
            attendance = seminarService.getAttendanceById(team.getId(),klassSeminar.getId()).get(0);
        }else{
            attendance = null;
        }
        model.addAttribute("attendance", attendance);
        return "student/course/seminar/report";
    }

    @PostMapping("/course/seminar/uploadReport")
    public ResponseEntity<Object> uploadReport(@RequestParam("file") MultipartFile multipartFile, String attendanceId){
        DebugLogger.log(multipartFile.getOriginalFilename());
        if(fileService.store(multipartFile) != null) {
            studentService.uploadReportFile(attendanceId, multipartFile.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/course/teamList")
    public String teamList(String courseId,String klassId, Model model, HttpSession session) {
        model.addAttribute("myTeam", seminarService.getTeamByKlassIdAndStudentId(klassId, ((String) session.getAttribute("studentId"))));
        model.addAttribute("teams", seminarService.getTeamsByCourseId(courseId));
        model.addAttribute("students", studentService.getAllUnTeamedStudentsByCourseId(courseId));
        return "student/course/teamList";
    }
    @PostMapping("/course/team/create")
    public String createTeam(String courseId, Model model, HttpSession session){
        model.addAttribute("leaderId", session.getAttribute(STUDENT_ID_GIST));
        model.addAttribute("klasses", seminarService.getKlassByCourseId(courseId));
        return "student/course/team/create";
    }
    @PutMapping("/course/team")
    public ResponseEntity<Object> createTeam(@RequestBody Team team){
        DebugLogger.logJson(team);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @PostMapping("/course/myTeam")
    public String myTeam(String teamId, Model model, HttpSession session){
        Team team = seminarService.getTeamByTeamId(teamId);
        model.addAttribute("studentId", session.getAttribute(STUDENT_ID_GIST));
        model.addAttribute("team", team);
        model.addAttribute("students", studentService.getAllUnTeamedStudentsByCourseId(team.getCourseId()));
        return "student/course/myTeam";
    }
    @PostMapping("/course/myTeam/addMembers")
    public ResponseEntity<Object> addMembers(String teamId, String[] studentId){
        DebugLogger.logJson(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @PostMapping("/course/myTeam/deleteMember")
    public ResponseEntity<Object> deleteMember(String teamId, String studentId){
        DebugLogger.logJson(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @PostMapping("/course/info")
    public String courseInfo(String courseId, Model model) {
        return "student/course/info";
    }
    @PostMapping("/course/grade")
    public String seminarGrade(String courseId, String klassId, Model model, HttpSession session){
//        List<Round> rounds = seminarService.getRoundsByCourseId(courseId);
//        Team team = seminarService.getTeamByKlassIdAndStudentId(klassId, ((String) session.getAttribute(STUDENT_ID_GIST)));
//        Map<String, SeminarScore> seminarScoreMap = new HashMap<>(rounds.size());
//        Map<String, RoundScore> roundScoreMap = new HashMap<>(rounds.size());
//        rounds.forEach(round -> {
//            roundScoreMap.put(round.getId(), scoreService.calculateScoreOfOneRound(team.getId(), round.getId()));
//        });
//        model.addAttribute("rounds", rounds);
//        model.addAttribute("seminarScoreMap", seminarScoreMap);
//        model.addAttribute("roundScoreMap", roundScoreMap);
        return "student/course/grade";
    }
}
