package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.KlassDao;
import seminar.dao.StudentDAO;
import seminar.entity.Course;
import seminar.entity.Klass;
import seminar.entity.Student;
import seminar.service.StudentService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;
    private final KlassDao klassDao;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, CourseDAO courseDAO, KlassDao klassDao) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.klassDao = klassDao;
    }

    @Override
    public boolean activate(String studentId, String password, String email) {
        Student student = studentDAO.getById(studentId).get(0);
        student.setPassword(password);
        student.setEmail(email);
        student.setActivated(true);
        studentDAO.update(student);
        return true;
    }

    @Override
    public boolean modifyEmail(String studentId, String email) {
        List<Student> students = studentDAO.getById(studentId);
        if(students.isEmpty()){
            return false;
        }
        Student student = students.get(0);
        student.setEmail(email);
        studentDAO.update(student);
        return true;
    }

    /**
     * @author Cesare
     */
    @Override
    public boolean modifyPasswordViaSn(String sn, String password) {
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

    /**
     * @author Cesare
     */
    @Override
    public boolean modifyPasswordViaId(String studentId, String password) {
        List<Student> students = studentDAO.getById(studentId);
        if (students.isEmpty()) {
            return false;
        }
        Student student = students.get(0);
        student.setPassword(password);
        studentDAO.update(student);
        return true;
    }

    @Override
    public List<Course> getCoursesByStudentId(String studentId) {
        return courseDAO.getByStudentId(studentId);
    }

    @Override
    public List<Klass> getKlassesByStudentId(String studentId) {
        return klassDao.getByStudentId(studentId);
    }
}
