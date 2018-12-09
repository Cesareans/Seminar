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
    public List<Student> getStudentBySN(String sn) {
        return studentDAO.getBySN(sn);
    }

    @Override
    public List<Student> getStudentById(String id) {
        return studentDAO.getById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        if (studentDAO.getBySN(student.getStudentNum()).size() == 0) {
            student.setPassword(SeminarConfig.DEFAULT_PASSWORD);
            student.setActivated(false);
            studentDAO.create(student);
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
    public boolean deleteStudentBySN(String sn) {
        if (studentDAO.getBySN(sn).size() == 0) {
            return false;
        } else {
            studentDAO.deleteBySN(sn);
            return true;
        }
    }

    @Override
    public boolean studentModifyPassword(String sn, String password){
        List<Student> students = studentDAO.getBySN(sn);
        if (students.size() == 0) {
            return false;
        } else {
            Student targetStudent = students.get(0);
            targetStudent.setPassword(password);
            studentDAO.update(targetStudent);
            return true;
        }
    }

    @Override
    public boolean studentResetPassword(String sn) {
        List<Student> students = studentDAO.getBySN(sn);
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
    public List<Teacher> getTeacherByTN(String tn) {
        return teacherDAO.getByTN(tn);
    }

    @Override
    public List<Teacher> getTeacherById(String id) {
        return teacherDAO.getById(id);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        if (teacherDAO.getByTN(teacher.getTeacherNum()).size() == 0) {
            teacherDAO.create(teacher);
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
    public boolean deleteTeacherByTN(String tn) {
        if (teacherDAO.getByTN(tn).size() == 0) {
            return false;
        } else {
            teacherDAO.deleteByTN(tn);
            return true;
        }
    }

    @Override
    public boolean teacherModifyPassword(String tn, String password) {
        List<Teacher> teachers = teacherDAO.getByTN(tn);
        if (teachers.size() == 0) {
            return false;
        } else {
            Teacher targetTeacher = teachers.get(0);
            targetTeacher.setPassword(password);
            teacherDAO.update(targetTeacher);
            return true;
        }
    }

    @Override
    public boolean teacherResetPassword(String tn) {
        List<Teacher> teachers = teacherDAO.getByTN(tn);
        if (teachers.size() == 0) {
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        return updateTeacher(teacher);
    }
}
