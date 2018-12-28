package seminar.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import seminar.entity.Klass;
import seminar.entity.KlassSeminar;
import seminar.entity.Student;
import seminar.entity.Team;
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
    private enum SeminarState{
        /**
         * Introduce the state of seminar
         */
        preparatory(0),progressing(1),terminate(2);

        SeminarState(Integer state) {
            this.state = state;
        }
        Integer state;
        public Integer getState() {
            return state;
        }
        public void setState(Integer state) {
            this.state = state;
        }
    }

    @Autowired
    public WebSocketController(WebSocketService webSocketService, SeminarService seminarService, ObjectMapper objectMapper) {
        this.webSocketService = webSocketService;
        this.seminarService = seminarService;
        this.objectMapper = objectMapper;
    }


    @PostMapping("/teacher/course/seminar/progressing")
    public String teacherSeminarProgressing(String klassSeminarId, Model model) {
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassSeminarId(klassSeminarId).get(0);
        if(klassSeminar.getState() == SeminarState.preparatory.getState()){
            webSocketService.initMonitor(klassSeminar);
        }
        Integer state = klassSeminar.getState();
        model.addAttribute("state", state);
        model.addAttribute("ksId", klassSeminarId);
        if(state.equals(SeminarState.progressing.getState())) {
            SeminarMonitor monitor = webSocketService.getMonitor(klassSeminarId);
            if(monitor == null){
                webSocketService.initMonitor(klassSeminar);
                monitor = webSocketService.getMonitor(klassSeminarId);
            }
            model.addAttribute("monitor", monitor);
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


    @PostMapping("/student/course/seminar/progressing")
    public String studentSeminarProgressing(String klassId, String seminarId, Model model, Principal principal){
        Klass klass = seminarService.getKlassById(klassId).get(0);
        Student student = seminarService.getStudentBySN(principal.getName()).get(0);
        Team team = seminarService.getTeamByCourseIdAndStudentId(klass.getId(),student.getId());
        KlassSeminar klassSeminar = seminarService.getKlassSeminarByKlassIdAndSeminarId(klassId, seminarId).get(0);
        Integer state = klassSeminar.getState();
        if(team == null){
            state = -1;
        }
        model.addAttribute("state", state);
        model.addAttribute("studentNum", principal.getName());
        model.addAttribute("ksId", klassSeminar.getId());
        if(state.equals(SeminarState.progressing.getState())) {
            SeminarMonitor monitor = webSocketService.getMonitor(klassSeminar.getId());
            if(monitor == null){
                webSocketService.initMonitor(klassSeminar);
                monitor = webSocketService.getMonitor(klassSeminar.getId());
            }
            model.addAttribute("monitor", monitor);
            model.addAttribute("team", monitor.getTeamByStudentNum(principal.getName()));
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
