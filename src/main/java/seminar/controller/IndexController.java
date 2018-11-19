package seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cesare
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }

}
