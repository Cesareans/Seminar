package seminar.config.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.request.Request;
import seminar.pojo.websocket.response.Response;

/**
 * @author Cesare
 */
@Component
public class RawMessageConverter {
    private final String MESSAGE_PACKAGE_PREFIX = "seminar.pojo.websocket.request.";
    private ObjectMapper objectMapper = new ObjectMapper();

    public Request convertToRequest(RawMessage rawMessage) {
        try {
            Class<? extends Request> messageClass = Class.forName(MESSAGE_PACKAGE_PREFIX + rawMessage.getType()).asSubclass(Request.class);
            return objectMapper.readValue(rawMessage.getContent(), messageClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RawMessage convertFromResponse(Response response) {
        try {
            RawMessage message = new RawMessage();
            message.setType(response.getClass().getSimpleName());
            message.setContent(objectMapper.writeValueAsString(response));
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
