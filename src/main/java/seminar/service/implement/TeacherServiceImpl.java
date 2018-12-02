package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.ClbumDao;
import seminar.dao.CourseDAO;
import seminar.dao.TeacherDAO;
import seminar.entity.Clbum;
import seminar.entity.Course;
import seminar.entity.Teacher;
import seminar.service.TeacherService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherDAO teacherDAO;
    private final CourseDAO courseDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, CourseDAO courseDAO) {
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Teacher> getTeacherByTN(String teacherNum) {
        return teacherDAO.getByTN(teacherNum);
    }

    @Override
    public List<Course> getCoursesByTeacherId(String teacherId) {
        return courseDAO.getCoursesByTeacherId(teacherId);
    }


}
