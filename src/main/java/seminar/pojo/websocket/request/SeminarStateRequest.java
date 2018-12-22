package seminar.pojo.websocket.request;

import org.springframework.security.core.parameters.P;
import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.SeminarStateResponse;

/**
 * @author Cesare
 */
@BindResponse(response = SeminarStateResponse.class)
public class SeminarStateRequest implements Request{
    private StateRequest request;
    @Override
    public void execute(SeminarMonitor monitor) {
        switch (request){
            case PAUSE:
                monitor.pause();
                break;
            case START:
                monitor.start();
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


