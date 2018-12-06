package seminar.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import seminar.entity.websocket.ResponseMessage;

import java.security.Principal;

/**
 * @author Cesare
 */
@Controller
public class WebSocketController {
    @MessageMapping("/teacher/clbumSeminar/{csId}")
    @SendTo("/topic/client/{csId}")
    public ResponseMessage teacherMessage(@DestinationVariable String csId, String message, Principal principal) {
        return new ResponseMessage(principal.getName(),message);
    }

    @MessageMapping("/student/clbumSeminar/{csId}")
    @SendTo("/topic/client/{csId}")
    public ResponseMessage studentMessage(@DestinationVariable String csId, String message, Principal principal) {
        return new ResponseMessage(principal.getName(),message);
    }
}
