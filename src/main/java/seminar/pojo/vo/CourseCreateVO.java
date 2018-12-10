package seminar.pojo.vo;

import seminar.entity.Course;
import seminar.entity.regulation.MaxMinRegulation;

import java.util.Date;

/**
 * @author Cesare
 */
public class CourseCreateVO {
    private String courseName;
    private String intro;
    private Integer prePer;
    private Integer quePer;
    private Integer repPer;
    private Date teamStartDate;
    private Date teamEndDate;

    private Integer teamMax;
    private Integer teamMin;

    public Course getCourse() {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setIntroduction(intro);
        course.setPrePercentage(prePer);
        course.setQuesPercentage(quePer);
        course.setReportPercentage(repPer);
        course.setTeamStartDate(teamStartDate);
        course.setTeamEndDate(teamEndDate);
        return course;
    }

    public MaxMinRegulation getMaxMinReg() {
        MaxMinRegulation maxMinReg = new MaxMinRegulation();
        maxMinReg.setMax(teamMax);
        maxMinReg.setMin(teamMin);
        return maxMinReg;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getPrePer() {
        return prePer;
    }

    public void setPrePer(Integer prePer) {
        this.prePer = prePer;
    }

    public Integer getQuePer() {
        return quePer;
    }

    public void setQuePer(Integer quePer) {
        this.quePer = quePer;
    }

    public Integer getRepPer() {
        return repPer;
    }

    public void setRepPer(Integer repPer) {
        this.repPer = repPer;
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

    public Integer getTeamMax() {
        return teamMax;
    }

    public void setTeamMax(Integer teamMax) {
        this.teamMax = teamMax;
    }

    public Integer getTeamMin() {
        return teamMin;
    }

    public void setTeamMin(Integer teamMin) {
        this.teamMin = teamMin;
    }
}
