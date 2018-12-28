package seminar.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import seminar.entity.Course;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.entity.regulation.MemberLimitStrategy;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
public class CourseCreateDTO {
    private String courseName;
    private String intro;
    private Integer prePer;
    private Integer quePer;
    private Integer repPer;
    @JsonFormat(pattern="yyyy-MM-dd H:mm", timezone = "GMT+8")
    private Date teamStartDate;
    @JsonFormat(pattern="yyyy-MM-dd H:mm", timezone = "GMT+8")
    private Date teamEndDate;

    private Integer teamMax;
    private Integer teamMin;

    private List<CourseMemberLimit> courseMemberLimits;
    private List<ConflictCourse> conflictCourses;

//    public Course getCourse() {
//        Course course = new Course();
//        course.setCourseName(courseName);
//        course.setIntroduction(intro);
//        course.setPrePercentage(prePer);
//        course.setQuesPercentage(quePer);
//        course.setReportPercentage(repPer);
//        course.setTeamStartDate(teamStartDate);
//        course.setTeamEndDate(teamEndDate);
//        return course;
//    }

    public MemberLimitStrategy getMemberLimitStrategy(){
        MemberLimitStrategy memberLimitStrategy = new MemberLimitStrategy();
        memberLimitStrategy.setMax(teamMax);
        memberLimitStrategy.setMin(teamMin);
        return memberLimitStrategy;
    }

    public List<CourseMemberLimitStrategy> getCourseMemberLimitStrategies(){
        List<CourseMemberLimitStrategy> courseMemberLimitStrategies = new LinkedList<>();
        courseMemberLimits.forEach(courseMemberLimit -> {
            CourseMemberLimitStrategy courseMemberLimitStrategy = new CourseMemberLimitStrategy();
            courseMemberLimitStrategy.setCourseId(courseMemberLimit.getCourseId());
            courseMemberLimitStrategy.setMin(courseMemberLimit.getMin());
            courseMemberLimitStrategy.setMax(courseMemberLimit.getMax());
            courseMemberLimitStrategies.add(courseMemberLimitStrategy);
        });
        return courseMemberLimitStrategies;
    }

    public List<ConflictCourseStrategy> getConflictCourseStrategies(){
        List<ConflictCourseStrategy> conflictCourseStrategies = new LinkedList<>();
        conflictCourses.forEach(conflictCourse -> {
            ConflictCourseStrategy conflictCourseStrategy = new ConflictCourseStrategy();
            conflictCourseStrategy.setConflictCourses(conflictCourse.getCourseId());
            conflictCourseStrategies.add(conflictCourseStrategy);
        });
        return conflictCourseStrategies;
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

    public List<CourseMemberLimit> getCourseMemberLimits() {
        return courseMemberLimits;
    }

    public void setCourseMemberLimits(List<CourseMemberLimit> courseMemberLimits) {
        this.courseMemberLimits = courseMemberLimits;
    }

    public List<ConflictCourse> getConflictCourses() {
        return conflictCourses;
    }

    public void setConflictCourses(List<ConflictCourse> conflictCourses) {
        this.conflictCourses = conflictCourses;
    }
}

class CourseMemberLimit{
    private String courseId;
    private Integer max;
    private Integer min;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }
}

class ConflictCourse{
    private Integer serial;
    private List<String> courseId;

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public List<String> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<String> courseId) {
        this.courseId = courseId;
    }
}