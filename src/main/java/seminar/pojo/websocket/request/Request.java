package seminar.pojo.websocket.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.Response;

/**
 * @author Cesare
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Request {
    /**
     * Operate the SeminarMonitor
     * @param monitor the seminarMonitor
     */
    void execute(SeminarMonitor monitor);


}
