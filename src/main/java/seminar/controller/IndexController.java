package seminar.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.logger.DebugLogger;
import seminar.pojo.exception.CannotAccessResetPwdException;
import seminar.service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Path;
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
    private final FileService fileService;

    @Autowired
    public IndexController(CaptchaService captchaService, MailService mailService, AccountManageService accountManageService, TeacherService teacherService, StudentService studentService, FileService fileService) {
        this.captchaService = captchaService;
        this.mailService = mailService;
        this.accountManageService = accountManageService;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.fileService = fileService;
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

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }
    @PostMapping("/upload")
    public ResponseEntity<Object> fileUpload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                XSSFRow row = sheet.getRow(j);
                for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                    DebugLogger.log(row.getCell(k).getStringCellValue());
                }
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
