package seminar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.service.LoginService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Cesare
 */
@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public @ResponseBody
    ResponseEntity<Object> login(@Valid LoginForm loginForm, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Teacher teacher = new Teacher();
        teacher.setBadgeNum(loginForm.getUsername());
        teacher.setPassword(loginForm.getPassword());
        if(loginService.teacherLogin(teacher)){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        Student student = new Student();
        student.setStuNum(loginForm.getUsername());
        student.setPassword(loginForm.getPassword());
        if(loginService.studentLogin(student)){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
}


class LoginForm{
    public LoginForm(){}
    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}