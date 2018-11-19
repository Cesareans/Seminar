package seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cesare
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }

}
