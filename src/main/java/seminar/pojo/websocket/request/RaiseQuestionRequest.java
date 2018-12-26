package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.RaiseQuestionResponse;

/**
 * @author Cesare
 */
@BindResponse(response = RaiseQuestionResponse.class)
public class RaiseQuestionRequest implements Request {
    private String studentNum;
    @Override
    public void execute(SeminarMonitor monitor) {
        monitor.putQuestion(studentNum);
    }
    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
}
