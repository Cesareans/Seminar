package seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cesare
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/login"})
    public String login() {
        return "/login";
    }

    @RequestMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/activation")
    public String activation() {
        return "activation";
    }


    /**
     * Todo: Remain to be realize
     *
     * @return ViewName
     */
    @GetMapping("/forgetPassword")
    public String forgetPassword() {
        return "forgetPassword";
    }

}
