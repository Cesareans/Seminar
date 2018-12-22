package seminar.pojo.websocket.response;

import seminar.pojo.websocket.monitor.SeminarMonitor;

/**
 * 后端反馈消息
 *      提问请求变化
 *      讨论课状态变化
 *      小组状态变化
 *      评分状态变化
 * @author Cesare
 */
public interface Response {
    /**
     * Get response from the SeminarMonitor
     * @param monitor the seminarMonitor
     * @return the gotten response
     */
    Response execute(SeminarMonitor monitor);
}
