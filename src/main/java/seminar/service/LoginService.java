package seminar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.AdminDAO;
import seminar.dao.StudentDAO;
import seminar.dao.TeacherDAO;
import seminar.entity.Admin;
import seminar.entity.Student;
import seminar.entity.Teacher;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class LoginService {
    private AdminDAO adminDAO;
    private StudentDAO studentDAO;
    private TeacherDAO teacherDAO;

    @Autowired
    public LoginService(AdminDAO adminDAO, StudentDAO studentDAO, TeacherDAO teacherDAO) {
        this.adminDAO = adminDAO;
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;
    }


    public boolean adminLogin(Admin admin){
        List<Admin> foundAdmin = adminDAO.getByName(admin.getName());
        return foundAdmin.size() != 0 && foundAdmin.get(0).getPassword().equals(admin.getPassword());
    }

    public boolean teacherLogin(Teacher teacher){
        List<Teacher> foundTeachers = teacherDAO.getByTN(teacher.getTeacherNum());
        return foundTeachers.size() != 0 && foundTeachers.get(0).getPassword().equals(teacher.getPassword());
    }

    public boolean studentLogin(Student student){
        List<Student> foundStudent = studentDAO.getBySN(student.getStudentNum());
        return foundStudent.size() != 0 && foundStudent.get(0).getPassword().equals(student.getPassword());
    }
}
