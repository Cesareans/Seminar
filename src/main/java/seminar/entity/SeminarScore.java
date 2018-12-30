package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

import java.math.BigDecimal;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class SeminarScore {
    @ID(isIncrement = true)
    private String id;

    private BigDecimal totalScore;
    private BigDecimal presentationScore;
    private BigDecimal questionScore;
    private BigDecimal reportScore;

    @Gist
    private String klassSeminarId;
    @Gist
    private String teamId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public BigDecimal getPresentationScore() {
        return presentationScore;
    }

    public void setPresentationScore(BigDecimal presentationScore) {
        this.presentationScore = presentationScore;
    }

    public BigDecimal getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(BigDecimal questionScore) {
        this.questionScore = questionScore;
    }

    public BigDecimal getReportScore() {
        return reportScore;
    }

    public void setReportScore(BigDecimal reportScore) {
        this.reportScore = reportScore;
    }

    public String getKlassSeminarId() {
        return klassSeminarId;
    }

    public void setKlassSeminarId(String klassSeminarId) {
        this.klassSeminarId = klassSeminarId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
