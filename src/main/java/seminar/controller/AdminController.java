package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seminar.entity.Admin;
import seminar.service.AdminService;
import util.log.DebugLogger;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }


    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }


    @PostMapping("/login")
    public @ResponseBody
    String login(Admin admin){
        DebugLogger.log(admin.getName());
        if(service.adminLogin(admin)){
            return "success";
        }else{
            return "fail";
        }
    }
}
