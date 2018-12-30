package seminar.pojo.enumration;

/**
 * @author Cesare
 */
public enum TeamStatus {
    /**
     * Represents the status of the team
     */
    Invalid(0), Valid(1), Checking(2);
    int status;

    TeamStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
