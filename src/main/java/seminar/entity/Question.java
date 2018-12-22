package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

import java.math.BigDecimal;

/**
 * @author Cesare
 * modify by Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class Question {
    @ID(isIncrement = true)
    private String id;
    private BigDecimal score;
    @Gist
    private String teamId;
    @Gist
    private String studentId;
    @Gist
    private String attendanceId;
    /**
     * TODO:This field is a totally redundant field.
     */
    @Gist
    private String klassSeminarId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getKlassSeminarId() {
        return klassSeminarId;
    }

    public void setKlassSeminarId(String klassSeminarId) {
        this.klassSeminarId = klassSeminarId;
    }
}
