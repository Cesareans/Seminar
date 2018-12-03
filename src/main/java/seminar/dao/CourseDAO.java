package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Course;
import seminar.mapper.CourseMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class CourseDAO {
    private final CourseMapper courseMapper;

    @Autowired
    public CourseDAO(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<Course> getCoursesByTeacherId(String teacherId) {
        return courseMapper.selectCourseByTeacherId(teacherId);
    }

    /**
     * @author lyf
     */
    public void createCourse(Course course) {
        courseMapper.insertCourse(course);
    }

    /**
     * @author lyf
     */
    public void deleteCourseById(String courseId){
        courseMapper.deleteCourseById(courseId);
    }

    /**
     * @author lyf
     */
    public void updateCourseById(Course course){
        courseMapper.updateCourse(course);
    }
}
