package seminar.pojo.websocket.response;

import seminar.pojo.websocket.monitor.SeminarMonitor;

/**
 * @author Cesare
 */
public class RaiseQuestionResponse implements Response {
    private int questionNum;

    @Override
    public Response execute(SeminarMonitor monitor) {
        questionNum = monitor.getRaisedQuestionsCount();
        return this;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }
}
