package seminar.pojo.websocket.response;

import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.monitor.state.SeminarState;

/**
 * @author Cesare
 */
public class SeminarStateResponse implements Response{
    private SeminarState state;
    @Override
    public Response execute(SeminarMonitor monitor) {
        state = monitor.getState();
        return this;
    }

    public SeminarState getState() {
        return state;
    }

    public void setState(SeminarState state) {
        this.state = state;
    }
}
