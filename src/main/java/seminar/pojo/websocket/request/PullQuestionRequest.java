package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.PullQuestionResponse;

/**
 * @author Cesare
 */
@BindResponse(response = PullQuestionResponse.class)
public class PullQuestionRequest implements Request {
    @Override
    public void execute(SeminarMonitor monitor) {
        monitor.pullQuestion();
    }
}
