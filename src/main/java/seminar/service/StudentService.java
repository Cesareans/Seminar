package seminar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.StudentDAO;
import seminar.entity.Admin;
import seminar.entity.Student;
import seminar.entity.view.StudentFilter;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    public List<Student> getByFilter(StudentFilter filter){
        return studentDAO.getByFilter(filter);
    }
    public boolean add(Student student){
        if(studentDAO.getBySN(student.getStuNum()).size() == 0){
            studentDAO.add(student);
            return true;
        }else {
            return false;
        }
    }

    public boolean update(Student student){
        List<Student> students = studentDAO.getBySN(student.getStuNum());
        if(students.size() == 0){
            return false;
        }else {
            Student targetStudent = students.get(0);
            student.setPassword(targetStudent.getPassword());
            student.setActivated(targetStudent.isActivated());
            studentDAO.update(student);
            return true;
        }
    }

    public boolean deleteByStuNum(String stuNum){
        if(studentDAO.getBySN(stuNum).size() == 0){
            return false;
        }else {
            studentDAO.deleteBySN(stuNum);
            return true;
        }
    }

    public boolean resetPassword(String stuNum){
        List<Student> students = studentDAO.getBySN(stuNum);
        if (students.size() == 0){
            return false;
        }
        Student student = students.get(0);
        student.setPassword(Admin.DEFAULT_PASSWORD);
        return update(student);
    }
}
