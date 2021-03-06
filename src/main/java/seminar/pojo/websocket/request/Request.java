package seminar.pojo.websocket.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import seminar.pojo.websocket.monitor.SeminarMonitor;

/**
 * @author Cesare
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Request {
    /**
     * Operate the SeminarMonitor
     *
     * @param monitor the seminarMonitor
     */
    void execute(SeminarMonitor monitor);


}
