package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Course;
import seminar.mapper.CourseMapper;
import seminar.mapper.MaxMinRegulationMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class CourseDAO {
    private final CourseMapper courseMapper;
    private final MaxMinRegulationMapper maxMinRegulationMapper;

    @Autowired
    public CourseDAO(CourseMapper courseMapper, MaxMinRegulationMapper maxMinRegulationMapper) {
        this.courseMapper = courseMapper;
        this.maxMinRegulationMapper = maxMinRegulationMapper;
    }

    /**
     * @author cesare
     */
    public List<Course> getByCourseId(String courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    /**
     * @author cesare
     */
    public List<Course> getByTeacherId(String teacherId) {
        return courseMapper.selectCourseByTeacherId(teacherId);
    }

    /**
     * @author cesare
     */
    public List<Course> getBySeminarMainCourseId(String seminarMainCourseId){
        return courseMapper.selectCourseBySeminarMainCourseId(seminarMainCourseId);
    }

    /**
     * @author cesare
     */
    public List<Course> getByTeamMainCourseId(String teamMainCourseId){
        return courseMapper.selectCourseByTeamMainCourseId(teamMainCourseId);
    }


    /**
     * @author lyf
     */
    public boolean deleteByTeacherId(String teacherId) {
        List<Course> courses = courseMapper.selectCourseByTeacherId(teacherId);
        if (courses.isEmpty()) {
            return false;
        } else {
            courseMapper.deleteCourseByTeacherId(teacherId);
            return true;
        }
    }

    /**
     * @author lyf
     */
    public boolean create(Course course) {
        List<Course> courses = courseMapper.selectCourseByTeacherId(course.getTeacherId());
        for (Course c : courses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                return false;
            }
        }
        courseMapper.insertCourse(course);
        return true;
    }

    /**
     * @author lyf
     */
    public void deleteByCourseId(String courseId) {
        courseMapper.deleteCourseById(courseId);
    }

    /**
     * @author lyf
     */
    public boolean update(Course course) {
        if (!courseMapper.selectCourseById(course.getId()).isEmpty()) {
            courseMapper.updateCourse(course);
            return true;
        } else {
            return false;
        }
    }

}
