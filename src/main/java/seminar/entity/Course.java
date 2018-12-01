package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

import java.util.Date;

/**
 * @author Cesare
 */
@TargetPackage(target = "seminar.mapper")
public class Course {
    @ID(isIncrement = true)
    private String id;
    private String courseName;
    private String introduction;
    private int prePercentage;
    private int reportPercentage;
    private int quesPercentage;
    private Date teamStartDate;
    private Date teamEndDate;
    @Gist
    private String teacherId;

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
}
