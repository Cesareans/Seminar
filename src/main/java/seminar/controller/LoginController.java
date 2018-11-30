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
import seminar.entity.view.LoginForm;
import seminar.service.LoginService;

import javax.validation.Valid;

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
    ResponseEntity<String> login(@Valid LoginForm loginForm, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherNum(loginForm.getUsername());
        teacher.setPassword(loginForm.getPassword());
        if(loginService.teacherLogin(teacher)){
            return ResponseEntity.status(HttpStatus.OK).body("Teacher");
        }
        Student student = new Student();
        student.setStudentNum(loginForm.getUsername());
        student.setPassword(loginForm.getPassword());
        if(loginService.studentLogin(student)){
            return ResponseEntity.status(HttpStatus.OK).body("Student");
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }


    /**
     * Todo: Remain to be realize
     * @return ViewName
     */
    @GetMapping("/activation")
    public String activation(){
        return "/activation";
    }


    /**
     * Todo: Remain to be realize
     * @return ViewName
     */
    @GetMapping("/forgetPassword")
    public String forgetPassword(){
        return "/forgetPassword";
    }
}


