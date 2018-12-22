package seminar.config.websocket;

import org.junit.Test;
import seminar.logger.DebugLogger;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.monitor.SeminarState;
import seminar.pojo.websocket.response.SeminarStateResponse;

public class RawMessageConverterTest {
    private RawMessageConverter converter = new RawMessageConverter();

    @Test
    public void convertToRequest() {
        RawMessage rawMessage = new RawMessage();
        rawMessage.setType("SeminarStateRequest");
        rawMessage.setJsonContent("{\"attendanceId\":\"1\",\"studentId\", \"2\"}");
        DebugLogger.logJson(converter.convertToRequest(rawMessage));
        DebugLogger.log(rawMessage.getJsonContent());
    }

    @Test
    public void convertFromResponse() {
        SeminarStateResponse response = new SeminarStateResponse();
        response.setState(SeminarState.PAUSE);
        DebugLogger.logJson(converter.convertFromResponse(response));
    }
}