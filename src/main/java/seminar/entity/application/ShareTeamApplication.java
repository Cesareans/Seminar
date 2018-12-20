package seminar.entity.application;

import cesare.mybatis.annotations.*;
import seminar.entity.Course;
import seminar.entity.Teacher;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper.application")
public class ShareTeamApplication {
    @ID(isIncrement = true)
    private String id;
    @Gist
    @SqlMap("sub_course_teacher_id")
    private String teacherId;
    @Gist(unions = "subCourseId")
    private String mainCourseId;
    @Gist
    private String subCourseId;

    @Link(gist = "mainCourseId", select = "seminar.mapper.CourseMapper.selectCourseById")
    private Course mainCourse;
    @Link(gist = "subCourseId", select = "seminar.mapper.CourseMapper.selectCourseById")
    private Course subCourse;
    @Block
    private Teacher mainTeacher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getMainCourseId() {
        return mainCourseId;
    }

    public void setMainCourseId(String mainCourseId) {
        this.mainCourseId = mainCourseId;
    }

    public String getSubCourseId() {
        return subCourseId;
    }

    public void setSubCourseId(String subCourseId) {
        this.subCourseId = subCourseId;
    }

    public Course getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(Course mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Course getSubCourse() {
        return subCourse;
    }

    public void setSubCourse(Course subCourse) {
        this.subCourse = subCourse;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }
}
