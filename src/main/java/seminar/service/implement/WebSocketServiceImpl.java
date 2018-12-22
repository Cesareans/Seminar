package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.config.websocket.RawMessageConverter;
import seminar.dao.KlassSeminarDAO;
import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.request.Request;
import seminar.pojo.websocket.response.Response;
import seminar.service.WebSocketService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cesare
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {
    private final KlassSeminarDAO klassSeminarDAO;
    private final RawMessageConverter rawMessageConverter;
    private Map<String, SeminarMonitor> monitorMap = new HashMap<>();

    @Autowired
    public WebSocketServiceImpl(KlassSeminarDAO klassSeminarDAO, RawMessageConverter rawMessageConverter) {
        this.klassSeminarDAO = klassSeminarDAO;
        this.rawMessageConverter = rawMessageConverter;
    }

    @Override
    public SeminarMonitor getMonitor(String ksId) {
        if (monitorMap.containsKey(ksId)) {
            return monitorMap.get(ksId);
        }
        SeminarMonitor seminarMonitor = new SeminarMonitor(klassSeminarDAO.getEnrollList(ksId), null);
        monitorMap.put(ksId, seminarMonitor);
        return seminarMonitor;
    }

    @Override
    public RawMessage handleMessage(String ksId, RawMessage message) {
        if(!monitorMap.containsKey(ksId)){
            return null;
        }
        SeminarMonitor monitor = monitorMap.get(ksId);
        Request request = rawMessageConverter.convertToRequest(message);
        request.execute(monitor);
        Response response = null;
        try {
            response = request.getClass().getAnnotation(BindResponse.class).response().asSubclass(Response.class).newInstance();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return rawMessageConverter.convertFromResponse(response.execute(monitor));
    }
}
