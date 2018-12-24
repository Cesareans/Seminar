package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.ScoreResponse;

import java.math.BigDecimal;
import java.nio.channels.NonReadableChannelException;

/**
 * @author Cesare
 */
@BindResponse(response = ScoreResponse.class)
public class ScoreRequest implements Request {
    private BigDecimal score;
    private ScoreType type;
    private int attendanceIdx;
    private int questionIdx;
    @Override
    public void execute(SeminarMonitor monitor) {
        switch (type){
            case Attendance:
                monitor.scoreAttendance(score, attendanceIdx);
                break;
            case Question:
                monitor.scoreQuestion(score, attendanceIdx, questionIdx);
                break;
            default:
                break;
        }
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public ScoreType getType() {
        return type;
    }

    public void setType(ScoreType type) {
        this.type = type;
    }

    public int getAttendanceIdx() {
        return attendanceIdx;
    }

    public void setAttendanceIdx(int attendanceIdx) {
        this.attendanceIdx = attendanceIdx;
    }

    public int getQuestionIdx() {
        return questionIdx;
    }

    public void setQuestionIdx(int questionIdx) {
        this.questionIdx = questionIdx;
    }
}
enum ScoreType{
    /**
     * Score attendance
     */
    Attendance,
    /**
     * Score question
     */
    Question
}