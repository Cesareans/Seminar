package seminar.pojo.websocket.response;

import seminar.pojo.websocket.monitor.RequestQuestion;
import seminar.pojo.websocket.monitor.SeminarMonitor;

/**
 * @author Cesare
 */
public class PullQuestionResponse implements Response {
    private String studentNum;
    private String teamSerial;
    private String teamName;
    private int questionCount;

    @Override
    public Response execute(SeminarMonitor monitor) {
        RequestQuestion question = monitor.getChosenQuestion();
        studentNum = question.getStudent().getStudentNum();
        teamSerial = question.getTeam().getSerial();
        teamName = question.getTeam().getTeamName();
        questionCount = monitor.getRaisedQuestionsCount();
        return this;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getTeamSerial() {
        return teamSerial;
    }

    public void setTeamSerial(String teamSerial) {
        this.teamSerial = teamSerial;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}
