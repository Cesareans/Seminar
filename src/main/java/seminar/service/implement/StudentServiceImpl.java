package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.StudentDAO;
import seminar.entity.Student;
import seminar.service.StudentService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getStudentBySN(String studentNum) {
        return studentDAO.getBySN(studentNum);
    }

    /**
     * @author lyf
     */
    @Override
    public void updatePasswordByStudentId(Student student, String password, String id){
        studentDAO.updatePasswordByStudentId(student, password, id);
    }
}
