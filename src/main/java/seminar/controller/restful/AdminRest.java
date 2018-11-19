package seminar.controller.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seminar.entity.Admin;
import seminar.service.AdminService;

/**
 * @author Cesare
 */
@RestController
@RequestMapping("/admin")
public class AdminRest {
    private AdminService service;

    @Autowired
    public AdminRest(AdminService service) {
        this.service = service;
    }

    @PostMapping(value = "/verify")
    public String verify(Admin admin){
        if(service.adminVerify(admin)){
            return "success";
        }else{
            return "fail";
        }
    }
}
