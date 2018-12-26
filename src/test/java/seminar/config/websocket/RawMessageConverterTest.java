package seminar.config.websocket;

import org.junit.Test;
import seminar.logger.DebugLogger;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.response.SeminarStateResponse;

public class RawMessageConverterTest {
    private RawMessageConverter converter = new RawMessageConverter();

    @Test
    public void convertToRequest() {
        RawMessage rawMessage = new RawMessage();
        rawMessage.setType("SeminarStateRequest");
        rawMessage.setContent("{\"request\":\"PAUSE\",\"studentId\":\"2\"}");
        DebugLogger.logJson(converter.convertToRequest(rawMessage));
        DebugLogger.log(rawMessage.getContent());
    }

    @Test
    public void convertFromResponse() {
        SeminarStateResponse response = new SeminarStateResponse();
        DebugLogger.logJson(converter.convertFromResponse(response));
    }
}