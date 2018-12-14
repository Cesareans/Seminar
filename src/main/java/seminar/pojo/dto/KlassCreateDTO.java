package seminar.pojo.dto;

import seminar.entity.Klass;

/**
 * @author Cesare
 */
public class KlassCreateDTO {
    private Integer gradeNum;
    private Integer klassNum;
    private String klassTime;
    private String location;
    private String courseId;

    public Klass getKlass() {
        Klass klass = new Klass();
        klass.setGrade(gradeNum);
        klass.setSerial(klassNum);
        klass.setTime(klassTime);
        klass.setLocation(location);
        klass.setCourseId(courseId);
        return klass;
    }

    @Override
    public String toString() {
        return "gradeNum:" + gradeNum + " klassNum:" + klassNum + " klassTime:" + klassTime
                + " location:" + location + " courseId:" + courseId;
    }

    public Integer getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }

    public Integer getKlassNum() {
        return klassNum;
    }

    public void setKlassNum(Integer klassNum) {
        this.klassNum = klassNum;
    }

    public String getKlassTime() {
        return klassTime;
    }

    public void setKlassTime(String klassTime) {
        this.klassTime = klassTime;
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
}
