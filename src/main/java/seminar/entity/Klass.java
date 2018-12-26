package seminar.entity;

import cesare.mybatis.annotations.*;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Klass {
    @ID(isIncrement = true)
    private String id;
    private int grade;
    @SqlMap("klass_serial")
    private int serial;
    @SqlMap("klass_time")
    private String time;
    @SqlMap("klass_location")
    private String location;

    @Gist
    private String courseId;

    @Link(gist = "courseId", select = "seminar.mapper.CourseMapper.selectCourseById")
    private Course course;

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Klass)) {
            return false;
        }
        return id.equals(((Klass) obj).id);
    }

    public String getKlassName() {
        return grade + "-" + serial + "班";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
