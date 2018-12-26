package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.config.websocket.RawMessageConverter;
import seminar.dao.KlassSeminarDAO;
import seminar.dao.TeamDAO;
import seminar.entity.Attendance;
import seminar.entity.Team;
import seminar.logger.DebugLogger;
import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.request.Request;
import seminar.pojo.websocket.response.Response;
import seminar.service.WebSocketService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {
    private final KlassSeminarDAO klassSeminarDAO;
    private final TeamDAO teamDAO;
    private final RawMessageConverter rawMessageConverter;
    private Map<String, SeminarMonitor> monitorMap = new HashMap<>();

    @Autowired
    public WebSocketServiceImpl(KlassSeminarDAO klassSeminarDAO, TeamDAO teamDAO, RawMessageConverter rawMessageConverter) {
        this.klassSeminarDAO = klassSeminarDAO;
        this.teamDAO = teamDAO;
        this.rawMessageConverter = rawMessageConverter;
    }

    @Override
    public SeminarMonitor getMonitor(String ksId) {
        if (monitorMap.containsKey(ksId)) {
            return monitorMap.get(ksId);
        }
        List<Attendance> enrollList = klassSeminarDAO.getEnrollList(ksId);
        List<Team> teams = teamDAO.getOwnStudentsTeamByCourseId(klassSeminarDAO.getById(ksId).get(0).getSeminar().getCourseId());
        SeminarMonitor seminarMonitor = new SeminarMonitor(enrollList, teams);
        monitorMap.put(ksId, seminarMonitor);
        return seminarMonitor;
    }

    @Override
    public RawMessage handleMessage(String ksId, RawMessage message) {
        SeminarMonitor monitor = getMonitor(ksId);
        Request request = rawMessageConverter.convertToRequest(message);
        request.execute(monitor);
        DebugLogger.logJson(request);
        try {
            Response response = request.getClass().getAnnotation(BindResponse.class).response().asSubclass(Response.class).newInstance();
            return rawMessageConverter.convertFromResponse(response.execute(monitor));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
