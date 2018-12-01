package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(target = "seminar.mapper")
public class Course {
    @ID(isIncrement = true)
    private String id;
    private String name;
    private String introduction;
    private int prePercentage;
    private int reportPercentage;
    private int quesPercentage;
    private int teamStartDate;
    private int teamEndDate;
    @Gist
    private String teacherId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTeamStartDate() {
        return teamStartDate;
    }

    public void setTeamStartDate(int teamStartDate) {
        this.teamStartDate = teamStartDate;
    }

    public int getTeamEndDate() {
        return teamEndDate;
    }

    public void setTeamEndDate(int teamEndDate) {
        this.teamEndDate = teamEndDate;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
