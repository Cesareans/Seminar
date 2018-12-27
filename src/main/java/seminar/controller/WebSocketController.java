package seminar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import seminar.entity.KlassSeminar;
import seminar.logger.DebugLogger;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.service.SeminarService;
import seminar.service.StudentService;
import seminar.service.WebSocketService;
import sun.awt.ModalExclude;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

/**
 * @author Cesare
 */
@Controller
public class WebSocketController {
    private final WebSocketService webSocketService;
    private final SeminarService seminarService;
    private final ObjectMapper objectMapper;

    @Autowired
    public WebSocketController(WebSocketService webSocketService, SeminarService seminarService, ObjectMapper objectMapper) {
        this.webSocketService = webSocketService;
        this.seminarService = seminarService;
        this.objectMapper = objectMapper;
    }


    @PostMapping("/teacher/course/seminar/progressing")
    public String seminarProgressing(String klassSeminarId, Model model) {
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassSeminarId(klassSeminarId).get(0);
        Boolean hasEnd = klassSeminar.getState() == 2;
        model.addAttribute("ksId", klassSeminarId);
        model.addAttribute("hasEnd", hasEnd);
        DebugLogger.log(klassSeminar.getState());
        if(!hasEnd) {
            model.addAttribute("monitor", webSocketService.getMonitor(klassSeminarId));
        }
        return "teacher/course/seminar/progressing";
    }

    @MessageMapping("/teacher/klassSeminar/{ksId}")
    @SendTo("/topic/client/{ksId}")
    public RawMessage teacherMessage(@DestinationVariable String ksId, RawMessage message, Principal principal) {
        try{
            JsonNode jsonContent = objectMapper.readTree(message.getContent());
            ((ObjectNode) jsonContent).put("teacherNum", principal.getName());
            message.setContent(jsonContent.toString());
            return webSocketService.handleMessage(ksId, message);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    @PostMapping("/student/course/seminar/processing")
    public String seminarProcessing(String klassId, String seminarId, Model model, Principal principal){
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId).get(0);
        SeminarMonitor monitor = webSocketService.getMonitor(klassSeminar.getId());
        int end = 2;
        Integer state = klassSeminar.getState();
        model.addAttribute("state", state);
        model.addAttribute("studentNum", principal.getName());
        model.addAttribute("team", monitor.getTeamByStudentNum(principal.getName()));
        model.addAttribute("ksId", klassSeminar.getId());
        if(state != end) {
            model.addAttribute("monitor", monitor);
        }
        return "student/course/seminar/progressing";
    }

    @MessageMapping("/student/klassSeminar/{ksId}")
    @SendTo("/topic/client/{ksId}")
    public RawMessage studentMessage(@DestinationVariable String ksId, RawMessage message, Principal principal) throws IOException {
            JsonNode jsonContent = objectMapper.readTree(message.getContent());
            ((ObjectNode) jsonContent).put("studentNum", principal.getName());
            message.setContent(jsonContent.toString());
            return webSocketService.handleMessage(ksId, message);

    }
}
