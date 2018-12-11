package seminar.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import seminar.pojo.websocket.ResponseMessage;

import java.security.Principal;

/**
 * @author Cesare
 */
@Controller
public class WebSocketController {
    @MessageMapping("/teacher/klassSeminar/{ksId}")
    @SendTo("/topic/client/{ksId}")
    public ResponseMessage teacherMessage(@DestinationVariable String ksId, String message, Principal principal) {
        return new ResponseMessage(principal.getName(), message);
    }

    @MessageMapping("/student/klassSeminar/{ksId}")
    @SendTo("/topic/client/{ksId}")
    public ResponseMessage studentMessage(@DestinationVariable String ksId, String message, Principal principal) {
        return new ResponseMessage(principal.getName(), message);
    }
}
