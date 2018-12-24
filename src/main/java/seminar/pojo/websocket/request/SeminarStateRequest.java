package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.SeminarStateResponse;

/**
 * @author Cesare
 */
@BindResponse(response = SeminarStateResponse.class)
public class SeminarStateRequest implements Request{
    private StateRequest request;
    private Integer timeStamp;
    @Override
    public void execute(SeminarMonitor monitor) {
        switch (request){
            case PAUSE:
                monitor.pauseAt(timeStamp);
                break;
            case START:
                monitor.startAt(timeStamp);
                break;
            default:
                break;
        }
    }

    public StateRequest getRequest() {
        return request;
    }

    public void setRequest(StateRequest request) {
        this.request = request;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }
}

enum StateRequest{
    /**
     * Promote for pause seminar
     */
    PAUSE,
    /**
     * Promote for start seminar
     */
    START
}


