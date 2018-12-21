package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Course;
import seminar.mapper.CourseMapper;
import seminar.mapper.TeacherMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class CourseDAO {
    private final CourseMapper courseMapper;
    private final TeacherMapper teacherMapper;
    private final KlassStudentMapper klassStudentMapper;

    @Autowired
    public CourseDAO(CourseMapper courseMapper, TeacherMapper teacherMapper, KlassStudentMapper klassStudentMapper) {
        this.courseMapper = courseMapper;
        this.teacherMapper = teacherMapper;
        this.klassStudentMapper = klassStudentMapper;
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
    public List<Course> getByStudentId(String studentId){
        return klassStudentMapper.selectCourseByStudentId(studentId);
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
     * @author cesare
     */
    public List<Course> getOtherCoursesByCourseId(String courseId){
        Course course = courseMapper.selectCourseById(courseId).get(0);
        List<Course> otherCourses = courseMapper.selectOtherCoursesById(course.getId(), course.getTeamMainCourseId(), course.getSeminarMainCourseId());
        otherCourses.forEach(this::setTeacher);
        return otherCourses;
    }

    /**
     * @author Cesare
     */
    public void setTeacher(Course course){
        course.setTeacher(teacherMapper.selectTeacherById(course.getTeacherId()).get(0));
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
