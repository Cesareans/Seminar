package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.EndQuestionResponse;

/**
 * @author Cesare
 */
@BindResponse(response = EndQuestionResponse.class)
public class EndQuestionRequest implements Request{

    @Override
    public void execute(SeminarMonitor monitor) {
        monitor.endQuestion();
    }
}
