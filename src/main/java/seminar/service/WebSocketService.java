package seminar.service;

import seminar.pojo.websocket.SeminarMonitor;

/**
 * @author Cesare
 */
public interface WebSocketService {
    SeminarMonitor initController(String ksId);
}
