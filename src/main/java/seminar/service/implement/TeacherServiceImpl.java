package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeacherDAO;
import seminar.entity.Teacher;
import seminar.service.TeacherService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getTeacherByTN(String teacherNum) {
        return teacherDAO.getByTN(teacherNum);
    }
}
