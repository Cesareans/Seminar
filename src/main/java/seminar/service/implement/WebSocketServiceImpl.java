package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.websocket.SeminarMonitorDAO;
import seminar.pojo.websocket.SeminarMonitor;
import seminar.service.SeminarService;
import seminar.service.WebSocketService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cesare
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {
    private Map<String , SeminarMonitor> monitorMap = new HashMap<>();

    private final SeminarMonitorDAO seminarMonitorDAO;

    @Autowired
    public WebSocketServiceImpl(SeminarMonitorDAO seminarMonitorDAO) {
        this.seminarMonitorDAO = seminarMonitorDAO;
    }


    @Override
    public SeminarMonitor initController(String ksId) {
        if(monitorMap.containsKey(ksId)){
            return monitorMap.get(ksId);
        }else{
            SeminarMonitor monitor = seminarMonitorDAO.getByKsId(ksId);
            monitorMap.put(ksId,monitor);
            return monitor;
        }
    }
}
