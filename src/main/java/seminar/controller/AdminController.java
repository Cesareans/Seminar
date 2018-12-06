package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seminar.config.SeminarConfig;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.vo.StudentFilter;
import seminar.entity.vo.TeacherFilter;
import seminar.logger.DebugLogger;
import seminar.service.AccountManageService;

import java.util.List;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AccountManageService accountManageService;

    @Autowired
    public AdminController(AccountManageService accountManageService) {
        this.accountManageService = accountManageService;
    }


    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/teacherManage")
    public String teacherManage() {
        return "admin/teacherManage";
    }

    @PostMapping("/teacherList")
    public String teacherList(Model model, TeacherFilter filter) {
        List<Teacher> teachers = accountManageService.getTeachersByFilter(filter);
        int sumPage = (teachers.size() - 1) / filter.getCount() + 1;
        int page = filter.getPage() < 1 ? 1 : (filter.getPage() > sumPage ? sumPage : filter.getPage());
        int fromIndex = (page - 1) * filter.getCount();
        int toIndex = page * filter.getCount();
        toIndex = toIndex > teachers.size() ? teachers.size() : toIndex;

        //Using this converter to make this declaration recognizable for freemarker template.
        Boolean mNewFilter = filter.isNewFilter();
        Number mFromIndex = fromIndex,mSumPage = sumPage,mPage = page;
        model.addAttribute("newFilter", mNewFilter);
        model.addAttribute("fromIndex", mFromIndex);
        model.addAttribute("sumPage", mSumPage);
        model.addAttribute("page", mPage);
        model.addAttribute("teachers", teachers.subList(fromIndex, toIndex));
        return "admin/teacherList";
    }

    @PutMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> addTeacher(@RequestBody Teacher teacher) {
        if (teacher.getTeacherName().length() == 0 || teacher.getTeacherNum().length() == 0 || teacher.getEmail().length() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        teacher.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        teacher.setActivated(false);
        if (accountManageService.addTeacher(teacher)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping(value = "/teacher")
    public @ResponseBody
    ResponseEntity<Object> updateTeacher(@RequestBody Teacher teacher) {
        if (accountManageService.updateTeacher(teacher)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/teacher/{teacherNum}/resetPwd")
    public @ResponseBody
    ResponseEntity<Object> resetTeacherPassword(@PathVariable String teacherNum) {
        if (accountManageService.teacherResetPassword(teacherNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping("/teacher/{teacherNum}")
    public @ResponseBody
    ResponseEntity<Object> deleteTeacher(@PathVariable String teacherNum) {
        if (accountManageService.deleteByTeacherNum(teacherNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> deleteTeacher(@RequestBody String[] teacherNum) {
        for (String s : teacherNum) {
            if (!accountManageService.deleteByTeacherNum(s)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @GetMapping("/studentManage")
    public String studentManage() {
        return "admin/studentManage";
    }

    @PostMapping("/studentList")
    public String studentList(Model model, StudentFilter filter) {
        List<Student> students = accountManageService.getStudentsByFilter(filter);
        int sumPage = (students.size() - 1) / filter.getCount() + 1;
        int page = filter.getPage() < 1 ? 1 : (filter.getPage() > sumPage ? sumPage : filter.getPage());
        int fromIndex = (page - 1) * filter.getCount();
        int toIndex = page * filter.getCount();
        toIndex = toIndex > students.size() ? students.size() : toIndex;

        //Using this converter to make this declaration recognizable for freemarker template.
        Boolean mNewFilter = filter.isNewFilter();
        Number mFromIndex = fromIndex,mSumPage = sumPage,mPage = page;
        model.addAttribute("newFilter", mNewFilter);
        model.addAttribute("fromIndex", mFromIndex);
        model.addAttribute("sumPage", mSumPage);
        model.addAttribute("page", mPage);
        model.addAttribute("students", students.subList(fromIndex, toIndex));
        return "admin/studentList";
    }

    @PutMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> addStudent(@RequestBody Student student) {
        if (student.getStudentName().length() == 0 || student.getStudentNum().length() == 0 || student.getEmail().length() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        student.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        student.setActivated(false);
        if (accountManageService.addStudent(student)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        if (accountManageService.updateStudent(student)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/student/{studentNum}/resetPwd")
    public @ResponseBody
    ResponseEntity<Object> resetStudentPassword(@PathVariable String studentNum) {
        if (accountManageService.studentResetPassword(studentNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping("/student/{studentNum}")
    public @ResponseBody
    ResponseEntity<Object> deleteStudent(@PathVariable String studentNum) {
        if (accountManageService.deleteStudentByStuNum(studentNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> deleteStudent(@RequestBody String[] studentNum) {
        for (String s : studentNum) {
            if (!accountManageService.deleteStudentByStuNum(s)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
