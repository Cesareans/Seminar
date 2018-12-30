package seminar.entity;

import seminar.entity.relation.KlassRound;

import java.util.List;

/**
 * When the round is generated, the seminars belonging to the round will also be generated via a eager type
 *
 * @author Cesare
 */
public class Round {
    private String id;
    private String roundNum;
    private int preScoreType;
    private int reportScoreType;
    private int quesScoreType;
    private String courseId;

    private List<Seminar> seminars;
    private List<KlassRound> klassRounds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(String roundNum) {
        this.roundNum = roundNum;
    }

    public int getPreScoreType() {
        return preScoreType;
    }

    public void setPreScoreType(int preScoreType) {
        this.preScoreType = preScoreType;
    }

    public int getReportScoreType() {
        return reportScoreType;
    }

    public void setReportScoreType(int reportScoreType) {
        this.reportScoreType = reportScoreType;
    }

    public int getQuesScoreType() {
        return quesScoreType;
    }

    public void setQuesScoreType(int quesScoreType) {
        this.quesScoreType = quesScoreType;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    public List<KlassRound> getKlassRounds() {
        return klassRounds;
    }

    public void setKlassRounds(List<KlassRound> klassRounds) {
        this.klassRounds = klassRounds;
    }
}
