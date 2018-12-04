package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Course;
import seminar.mapper.CourseMapper;

import java.util.Date;
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

    public List<Course> getByTeacherId(String teacherId) {
        return courseMapper.selectCourseByTeacherId(teacherId);
    }
    /**
    * @author lyf
    */
    public boolean deleteByTeacherId(String teacherId){
        List<Course> courses = courseMapper.selectCourseByTeacherId(teacherId);
        if(courses.isEmpty()) return false;
        else{
            courseMapper.deleteCourseByTeacherId(teacherId);
            return true;
        }
    }
    /**
     * @author lyf
     */
    public boolean create(Course course) {
        List<Course> courses = courseMapper.selectCourseByTeacherId(course.getTeacherId());
        for(Course c: courses) {
            if (c.getCourseName().equals(course.getCourseName()))
                return false;
        }
        courseMapper.insertCourse(course);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean deleteByCoruseId(String courseId){
        if(courseMapper.selectCourseById(courseId).isEmpty()) {
            courseMapper.deleteCourseById(courseId);
            return true;
        }
        else return false;
    }

    /**
     * @author lyf
     */
    public boolean update(Course course) {
        if (courseMapper.selectCourseById(course.getId()).isEmpty()) {
            courseMapper.updateCourse(course);
            return true;
        }
        else return false;
    }

}
