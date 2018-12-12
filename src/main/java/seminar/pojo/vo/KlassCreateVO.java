package seminar.pojo.vo;

import seminar.entity.Klass;

/**
 * @author Cesare
 */
public class KlassCreateVO {
    private String gradeNum;
    private String klassNum;
    private String klassTime;
    private String location;
    private String courseId;

    public Klass getKlass() {
        Klass klass = new Klass();
        klass.setKlassName(gradeNum + "-" + klassNum);
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

    public String getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(String gradeNum) {
        this.gradeNum = gradeNum;
    }

    public String getKlassNum() {
        return klassNum;
    }

    public void setKlassNum(String klassNum) {
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
