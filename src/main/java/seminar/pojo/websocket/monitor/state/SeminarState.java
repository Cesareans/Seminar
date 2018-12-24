package seminar.pojo.websocket.monitor.state;

/**
 * @author Cesare
 */

public class SeminarState {
    private ProgressState progressState;
    private Integer timeStamp;

    public SeminarState() {
        this.progressState = ProgressState.PAUSE;
        this.timeStamp = 0;
    }

    public ProgressState getProgressState() {
        return progressState;
    }

    public void setProgressState(ProgressState progressState) {
        this.progressState = progressState;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }
}

