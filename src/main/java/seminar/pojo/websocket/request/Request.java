package seminar.pojo.websocket.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.Response;

/**
 * 前端请求消息
 * 学生：
 *     发起提问请求
 * 教师：
 *     讨论课控制
 *     切换小组
 *     抽取提问
 *     给出评分
 *          - 演示分
 *          - 报告分
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
