package seminar.entity.application;

import seminar.entity.Course;
import seminar.entity.Teacher;

/**
 * @author Cesare
 */
public class ShareTeamApplication {
    private String id;
    private String teacherId;
    private String mainCourseId;
    private String subCourseId;

    private Course mainCourse;
    private Course subCourse;
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
