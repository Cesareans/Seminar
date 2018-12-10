package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Course;
import seminar.entity.regulation.MaxMinRegulation;
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

    public List<Course> getByCourseId(String courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    public List<Course> getByTeacherId(String teacherId) {
        return courseMapper.selectCourseByTeacherId(teacherId);
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
    public boolean create(Course course, MaxMinRegulation maxMinRegulation) {
        List<Course> courses = courseMapper.selectCourseByTeacherId(course.getTeacherId());
        for (Course c : courses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                return false;
            }
        }
        courseMapper.insertCourse(course);
        List<Course> cs = courseMapper.selectCourseByTeacherId(course.getTeacherId());
        for (Course c : cs) {
            if (c.getCourseName().equals(course.getCourseName())) {
                maxMinRegulation.setCourseId(c.getId());
                maxMinRegulationMapper.insertMaxMinRegulation(maxMinRegulation);
                return true;
            }
        }
        return false;
    }

    /**
     * @author lyf
     */
    public void deleteByCourseId(String courseId) {
        courseMapper.deleteCourseById(courseId);
        maxMinRegulationMapper.deleteMaxMinRegulationByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public boolean update(Course course, MaxMinRegulation maxMinRegulation) {
        if (!courseMapper.selectCourseById(course.getId()).isEmpty()) {
            courseMapper.updateCourse(course);
            List<MaxMinRegulation> maxMinRegulations = maxMinRegulationMapper.selectMaxMinRegulationByCourseId(course.getId());
            if (!maxMinRegulations.isEmpty()) {
                maxMinRegulationMapper.updateMaxMinRegulation(maxMinRegulation);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
