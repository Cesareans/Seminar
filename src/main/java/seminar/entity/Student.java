package seminar.entity;

import cesare.mybatis.annotations.*;

import java.util.List;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Student {
    @ID(isIncrement = true)
    private String id;
    @Gist
    private String studentName;
    @Gist
    @SqlMap("account")
    private String studentNum;
    private String password;
    private String email;
    @SqlMap("is_active")
    private boolean activated;

    @Link(gist = "id", select = "seminar.mapper.relation.KlassStudentMapper.selectCourseByStudentId")
    private List<Course> courses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
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

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
