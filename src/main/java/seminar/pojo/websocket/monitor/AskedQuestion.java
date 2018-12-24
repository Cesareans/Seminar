package seminar.pojo.websocket.monitor;

import seminar.entity.Student;
import seminar.entity.Team;

import java.math.BigDecimal;

/**
 * @author Cesare
 */
public class AskedQuestion extends RequestQuestion {
    private BigDecimal score;

    public AskedQuestion(Student student, Team team, BigDecimal score) {
        super(student, team);
        this.score = score;
    }

    public AskedQuestion(RequestQuestion question) {
        super(question.student, question.team);
        this.score = new BigDecimal(-1);
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
