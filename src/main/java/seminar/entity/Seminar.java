package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.SqlMap;
import cesare.mybatis.annotations.TargetPackage;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Seminar {
    @ID(isIncrement = true)
    private String id;
    @SqlMap("seminar_name")
    private String theme;
    @SqlMap("introduction")
    private String content;
    @SqlMap("seminar_serial")
    private String serial;
    private int maxTeam;
    private boolean visible;
    @SqlMap("enroll_start_time")
    @JsonFormat(pattern="yyyy-MM-dd H:mm", timezone = "GMT+8")
    private Date enrollStartDate;
    @SqlMap("enroll_end_time")
    @JsonFormat(pattern="yyyy-MM-dd H:mm", timezone = "GMT+8")
    private Date enrollEndDate;
    @Gist
    private String roundId;
    @Gist
    private String courseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getMaxTeam() {
        return maxTeam;
    }

    public void setMaxTeam(int maxTeam) {
        this.maxTeam = maxTeam;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Date getEnrollStartDate() {
        return enrollStartDate;
    }

    public void setEnrollStartDate(Date enrollStartDate) {
        this.enrollStartDate = enrollStartDate;
    }

    public Date getEnrollEndDate() {
        return enrollEndDate;
    }

    public void setEnrollEndDate(Date enrollEndDate) {
        this.enrollEndDate = enrollEndDate;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
