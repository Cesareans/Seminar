package seminar.pojo.dto;

import seminar.entity.Round;
import seminar.entity.relation.KlassRound;
import seminar.logger.DebugLogger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
public class RoundSettingDTO {
    private String roundId;
    private Integer preScoreType;
    private Integer quesScoreType;
    private Integer reportScoreType;
    private String[] klassId;
    private Integer[] enrollLimit;

    public Round getRound(){
        Round round = new Round();
        round.setId(roundId);
        round.setPreScoreType(preScoreType);
        round.setQuesScoreType(quesScoreType);
        round.setReportScoreType(reportScoreType);
        return round;
    }

    public List<KlassRound> getKlassRounds(){
        if(klassId.length != enrollLimit.length) {
            return null;
        }
        List<KlassRound> klassRounds = new LinkedList<>();
        for (int i = 0; i < klassId.length; i++) {
            KlassRound klassRound = new KlassRound();
            klassRound.setEnrollLimit(enrollLimit[i]);
            klassRound.setKlassId(klassId[i]);
            klassRound.setRoundId(roundId);
            klassRounds.add(klassRound);
        }
        return klassRounds;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public Integer getPreScoreType() {
        return preScoreType;
    }

    public void setPreScoreType(Integer preScoreType) {
        this.preScoreType = preScoreType;
    }

    public Integer getQuesScoreType() {
        return quesScoreType;
    }

    public void setQuesScoreType(Integer quesScoreType) {
        this.quesScoreType = quesScoreType;
    }

    public Integer getReportScoreType() {
        return reportScoreType;
    }

    public void setReportScoreType(Integer reportScoreType) {
        this.reportScoreType = reportScoreType;
    }

    public String[] getKlassId() {
        return klassId;
    }

    public void setKlassId(String[] klassId) {
        this.klassId = klassId;
    }

    public Integer[] getEnrollLimit() {
        return enrollLimit;
    }

    public void setEnrollLimit(Integer[] enrollLimit) {
        this.enrollLimit = enrollLimit;
    }

    @Override
    public String toString() {
        return DebugLogger.toJsonString(this);
    }
}
