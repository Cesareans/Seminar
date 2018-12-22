package seminar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import seminar.pojo.websocket.RawMessage;
import seminar.service.WebSocketService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cesare
 */
@Controller
public class WebSocketController {
    private final WebSocketService service;
    private final ObjectMapper objectMapper;

    @Autowired
    public WebSocketController(WebSocketService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @MessageMapping("/teacher/klassSeminar/{ksId}")
    @SendTo("/topic/client/{ksId}")
    public RawMessage teacherMessage(@DestinationVariable String ksId, RawMessage message, HttpSession session) {
        String teacherId = ((String) session.getAttribute("teacherId"));
        try{
            JsonNode jsonContent = objectMapper.readTree(message.getJsonContent());
            ((ObjectNode) jsonContent).put("teacherId", teacherId);
            message.setJsonContent(jsonContent.toString());
        }catch (Exception ex){
            return null;
        }
        return service.handleMessage(ksId, message);
    }

    @MessageMapping("/student/klassSeminar/{ksId}")
    @SendTo("/topic/client/{ksId}")
    public RawMessage studentMessage(@DestinationVariable String ksId, RawMessage message, HttpSession session) {
        String studentId = ((String) session.getAttribute("studentId"));
        try{
            JsonNode jsonContent = objectMapper.readTree(message.getJsonContent());
            ((ObjectNode) jsonContent).put("studentId", studentId);
            message.setJsonContent(jsonContent.toString());
        }catch (Exception ex){
            return null;
        }
        return service.handleMessage(ksId, message);
    }
}
