package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.EndSeminarResponse;

/**
 * @author Cesare
 */
@BindResponse(response = EndSeminarResponse.class)
public class EndSeminarRequest implements Request {
    @Override
    public void execute(SeminarMonitor monitor) {

    }
}
