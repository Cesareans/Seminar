package seminar.entity;

import java.math.BigDecimal;

/**
 * @author Cesare
 */
public class SeminarScore {
    private String id;

    private BigDecimal totalScore;
    private BigDecimal presentationScore;
    private BigDecimal questionScore;
    private BigDecimal reportScore;

    private String klassSeminarId;
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
