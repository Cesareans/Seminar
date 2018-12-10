package seminar.pojo.vo;

import seminar.entity.Clbum;

/**
 * @author Cesare
 */
public class ClbumCreateVO {
    private String gradeNum;
    private String clbumNum;
    private String clbumTime;
    private String location;
    private String courseId;

    public Clbum getClbum() {
        Clbum clbum = new Clbum();
        clbum.setClbumName(gradeNum + "-" + clbumNum);
        clbum.setTime(clbumTime);
        clbum.setLocation(location);
        clbum.setCourseId(courseId);
        return clbum;
    }

    @Override
    public String toString() {
        return "gradeNum:" + gradeNum + " clbumNum:" + clbumNum + " clbumTime:" + clbumTime
                + " location:" + location + " courseId:" + courseId;
    }

    public String getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(String gradeNum) {
        this.gradeNum = gradeNum;
    }

    public String getClbumNum() {
        return clbumNum;
    }

    public void setClbumNum(String clbumNum) {
        this.clbumNum = clbumNum;
    }

    public String getClbumTime() {
        return clbumTime;
    }

    public void setClbumTime(String clbumTime) {
        this.clbumTime = clbumTime;
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
