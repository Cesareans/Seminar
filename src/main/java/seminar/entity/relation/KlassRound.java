package seminar.entity.relation;

/**
 * @author Cesare
 */
public class KlassRound {
    private String klassId;
    private String roundId;
    private int enrollLimit;

    public String getKlassId() {
        return klassId;
    }

    public void setKlassId(String klassId) {
        this.klassId = klassId;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public int getEnrollLimit() {
        return enrollLimit;
    }

    public void setEnrollLimit(int enrollLimit) {
        this.enrollLimit = enrollLimit;
    }
}
