package seminar.dao.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.dao.KlassSeminarDAO;
import seminar.pojo.websocket.SeminarMonitor;

/**
 * @author Cesare
 */
@Component
public class SeminarMonitorDAO {
    private final KlassSeminarDAO klassSeminarDAO;

    @Autowired
    public SeminarMonitorDAO(KlassSeminarDAO klassSeminarDAO) {
        this.klassSeminarDAO = klassSeminarDAO;
    }

    public SeminarMonitor getByKsId(String ksId){
        SeminarMonitor seminarMonitor = new SeminarMonitor();
        seminarMonitor.setEnrollList(klassSeminarDAO.getEnrollList(ksId));
        seminarMonitor.init();
        return seminarMonitor;
    }
}
