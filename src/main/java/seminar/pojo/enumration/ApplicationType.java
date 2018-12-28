package seminar.pojo.enumration;

/**
 * @author Cesare
 */
public enum  ApplicationType {
    /**
     * The type of the application
     */
    ShareSeminar(0),ShareTeam(1),TeamValid(2);
    int type;

    ApplicationType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
