package seminar.entity;


import cesare.mybatis.annotations.*;

import java.util.List;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Teacher {
    @ID(isIncrement = true)
    private String id;
    @Gist
    private String teacherName;
    @Gist
    @SqlMap("account")
    private String teacherNum;
    private String password;
    private String email;
    @SqlMap("is_active")
    private boolean activated;

    @Link(gist = "id", select = "seminar.mapper.CourseMapper.selectCourseByTeacherId")
    private List<Course> courses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
