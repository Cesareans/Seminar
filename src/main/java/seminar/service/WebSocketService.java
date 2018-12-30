package seminar.service;

import seminar.entity.KlassSeminar;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.monitor.SeminarMonitor;

/**
 * @author Cesare
 */
public interface WebSocketService {
    /**
     * Init the monitor on the given klassSeminar
     *
     * @param klassSeminar the based klassSeminar
     */
    void initMonitor(KlassSeminar klassSeminar);

    /**
     * Terminate the monitor
     *
     * @param ksId the monitor corresponding ksId
     */
    void endMonitor(String ksId);

    /**
     * Get the corresponding SeminarMonitor
     *
     * @param ksId the refer gist as the id of klass seminar
     * @return the corresponding SeminarMonitor
     */
    SeminarMonitor getMonitor(String ksId);


    /**
     * Handle RawMessage from the front end.
     *
     * @param ksId    the refer gist as the id of klass seminar
     * @param message the raw handler from the front end.
     * @return the raw handler send to the front end.
     */
    RawMessage handleMessage(String ksId, RawMessage message);
}
