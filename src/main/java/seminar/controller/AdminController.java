package seminar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seminar.entity.Admin;
import seminar.service.AdminService;
import seminar.service.TeacherService;
import util.log.DebugLogger;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/teacher")
    public String teacher(Model model) {
        model.addAttribute("teachers",teacherService.getAll());
        return "admin/teacher";
    }

    @GetMapping("/student")
    public String student() {
        return "admin/student";
    }


    @PostMapping("/login")
    public @ResponseBody
    String login(Admin admin) {
        DebugLogger.log(admin.getName());
        if (service.adminLogin(admin)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
