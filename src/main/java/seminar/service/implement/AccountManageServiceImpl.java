package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.config.SeminarConfig;
import seminar.dao.StudentDAO;
import seminar.dao.TeacherDAO;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.vo.StudentFilter;
import seminar.entity.vo.TeacherFilter;
import seminar.service.AccountManageService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class AccountManageServiceImpl implements AccountManageService {
    private final StudentDAO studentDAO;
    private final TeacherDAO teacherDAO;
    @Autowired
    public AccountManageServiceImpl(StudentDAO studentDAO, TeacherDAO teacherDAO) {
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;
    }


    @Override
    public List<Student> getStudentsByFilter(StudentFilter filter) {
        return studentDAO.getByFilter(filter);
    }

    @Override
    public boolean addStudent(Student student) {
        if (studentDAO.getBySN(student.getStudentNum()).size() == 0) {
            studentDAO.add(student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        List<Student> students = studentDAO.getBySN(student.getStudentNum());
        if (students.size() == 0) {
            return false;
        } else {
            Student targetStudent = students.get(0);
            student.setPassword(targetStudent.getPassword());
            student.setActivated(targetStudent.isActivated());
            studentDAO.update(student);
            return true;
        }
    }

    @Override
    public boolean deleteStudentByStuNum(String stuNum) {
        if (studentDAO.getBySN(stuNum).size() == 0) {
            return false;
        } else {
            studentDAO.deleteBySN(stuNum);
            return true;
        }
    }

    @Override
    public boolean studentResetPassword(String stuNum) {
        List<Student> students = studentDAO.getBySN(stuNum);
        if (students.size() == 0) {
            return false;
        }
        Student student = students.get(0);
        student.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        return updateStudent(student);
    }

    @Override
    public List<Teacher> getTeachersByFilter(TeacherFilter filter) {
        return teacherDAO.getByFilter(filter);
    }


    @Override
    public boolean addTeacher(Teacher teacher) {
        if (teacherDAO.getByTN(teacher.getTeacherNum()).size() == 0) {
            teacherDAO.add(teacher);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        List<Teacher> teachers = teacherDAO.getByTN(teacher.getTeacherNum());
        if (teachers.size() == 0) {
            return false;
        } else {
            Teacher targetTeacher = teachers.get(0);
            teacher.setPassword(targetTeacher.getPassword());
            teacher.setActivated(targetTeacher.isActivated());
            teacherDAO.update(teacher);
            return true;
        }
    }

    @Override
    public boolean deleteByTeacherNum(String teacherNum) {
        if (teacherDAO.getByTN(teacherNum).size() == 0) {
            return false;
        } else {
            teacherDAO.deleteByTN(teacherNum);
            return true;
        }
    }

    @Override
    public boolean teacherResetPassword(String teacherNum) {
        List<Teacher> teachers = teacherDAO.getByTN(teacherNum);
        if (teachers.size() == 0) {
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        return updateTeacher(teacher);
    }
}
