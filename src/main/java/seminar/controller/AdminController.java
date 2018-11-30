package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seminar.entity.Admin;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.view.StudentFilter;
import seminar.entity.view.TeacherFilter;
import seminar.service.LoginService;
import seminar.service.StudentService;
import seminar.service.TeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final LoginService loginService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Autowired
    public AdminController(LoginService loginService, TeacherService teacherService, StudentService studentService) {
        this.loginService = loginService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }


    @PostMapping("/login")
    public @ResponseBody
    ResponseEntity<Object> adminLogin(Admin admin) {
        if (loginService.adminLogin(admin)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
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
        List<Teacher> teachers = teacherService.getByFilter(filter);
        int sumPage = (teachers.size() - 1) / filter.getCount() + 1;
        int page = filter.getPage() < 1 ? 1 : (filter.getPage() > sumPage ? sumPage : filter.getPage());
        int fromIndex = (page - 1) * filter.getCount();
        int toIndex = page * filter.getCount();
        toIndex = toIndex > teachers.size() ? teachers.size() : toIndex;
        model.addAttribute("newFilter", filter.isNewFilter());
        model.addAttribute("fromIndex", fromIndex);
        model.addAttribute("sumPage", sumPage);
        model.addAttribute("page", page);
        model.addAttribute("teachers", teachers.subList(fromIndex, toIndex));
        return "admin/teacherList";
    }

    @PutMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> addTeacher(Teacher teacher) {
        if (teacher.getName().length() == 0 || teacher.getTeacherNum().length() == 0 || teacher.getEmail().length() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        teacher.setPassword(Admin.DEFAULT_PASSWORD);
        teacher.setActivated(false);
        if (teacherService.add(teacher)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> updateTeacher(Teacher teacher) {
        if (teacherService.update(teacher)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/teacher/{teacherNum}/resetPwd")
    public @ResponseBody
    ResponseEntity<Object> resetTeacherPassword(@PathVariable String teacherNum) {
        if (teacherService.resetPassword(teacherNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping("/teacher/{teacherNum}")
    public @ResponseBody
    ResponseEntity<Object> deleteTeacher(@PathVariable String teacherNum) {
        if (teacherService.deleteByTeacherNum(teacherNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/teacher")
    public @ResponseBody
    ResponseEntity<Object> deleteTeacher(String[] teacherNum) {
        for (String s : teacherNum) {
            if (!teacherService.deleteByTeacherNum(s)) {
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
        List<Student> students = studentService.getByFilter(filter);
        int sumPage = (students.size() - 1) / filter.getCount() + 1;
        int page = filter.getPage() < 1 ? 1 : (filter.getPage() > sumPage ? sumPage : filter.getPage());
        int fromIndex = (page - 1) * filter.getCount();
        int toIndex = page * filter.getCount();
        toIndex = toIndex > students.size() ? students.size() : toIndex;
        Map<String, Object> root = new HashMap<>(5);
        root.put("newFilter", filter.isNewFilter());
        root.put("fromIndex", fromIndex);
        root.put("sumPage", sumPage);
        root.put("page", page);
        root.put("students", students.subList(fromIndex, toIndex));
        model.addAllAttributes(root);
        return "admin/studentList";
    }

    @PutMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> addStudent(Student student) {
        if (student.getName().length() == 0 || student.getStudentNum().length() == 0 || student.getEmail().length() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        student.setPassword(Admin.DEFAULT_PASSWORD);
        student.setActivated(false);
        if (studentService.add(student)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> updateStudent(Student student) {
        if (studentService.update(student)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PatchMapping("/student/{studentNum}/resetPwd")
    public @ResponseBody
    ResponseEntity<Object> resetStudentPassword(@PathVariable String studentNum) {
        if (studentService.resetPassword(studentNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @DeleteMapping("/student/{studentNum}")
    public @ResponseBody
    ResponseEntity<Object> deleteStudent(@PathVariable String studentNum) {
        if (studentService.deleteByStuNum(studentNum)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/student")
    public @ResponseBody
    ResponseEntity<Object> deleteStudent(String[] studentNum) {
        for (String s : studentNum) {
            if (!studentService.deleteByStuNum(s)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
