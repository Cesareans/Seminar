package seminar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Cesare
 */
public class Course {
    private String id;
    private String courseName;
    private String introduction;
    private int prePercentage;
    private int reportPercentage;
    private int quesPercentage;
    @JsonFormat(pattern = "yyyy-MM-dd H:mm", timezone = "GMT+8")
    private Date teamStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd H:mm", timezone = "GMT+8")
    private Date teamEndDate;
    private String teacherId;
    private String teamMainCourseId;
    private String seminarMainCourseId;

    private Teacher teacher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPrePercentage() {
        return prePercentage;
    }

    public void setPrePercentage(int prePercentage) {
        this.prePercentage = prePercentage;
    }

    public int getReportPercentage() {
        return reportPercentage;
    }

    public void setReportPercentage(int reportPercentage) {
        this.reportPercentage = reportPercentage;
    }

    public int getQuesPercentage() {
        return quesPercentage;
    }

    public void setQuesPercentage(int quesPercentage) {
        this.quesPercentage = quesPercentage;
    }

    public Date getTeamStartDate() {
        return teamStartDate;
    }

    public void setTeamStartDate(Date teamStartDate) {
        this.teamStartDate = teamStartDate;
    }

    public Date getTeamEndDate() {
        return teamEndDate;
    }

    public void setTeamEndDate(Date teamEndDate) {
        this.teamEndDate = teamEndDate;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeamMainCourseId() {
        return teamMainCourseId;
    }

    public void setTeamMainCourseId(String teamMainCourseId) {
        this.teamMainCourseId = teamMainCourseId;
    }

    public String getSeminarMainCourseId() {
        return seminarMainCourseId;
    }

    public void setSeminarMainCourseId(String seminarMainCourseId) {
        this.seminarMainCourseId = seminarMainCourseId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
