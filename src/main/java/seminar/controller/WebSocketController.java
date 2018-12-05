package seminar.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Cesare
 */
@Controller
public class WebSocketController {
    @MessageMapping("/teacher/clbumSeminar/{csId}")
    @SendTo("/topic/client/{csId}")
    public String teacherMessage(@DestinationVariable String csId, String message) {
        return message;
    }

    @MessageMapping("/student/clbumSeminar/{csId}")
    @SendTo("/topic/client/{csId}")
    public String studentMessage(@DestinationVariable String csId, String message) {
        return message;
    }
}
