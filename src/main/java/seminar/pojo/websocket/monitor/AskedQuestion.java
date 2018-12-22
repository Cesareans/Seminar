package seminar.pojo.websocket.monitor;

import seminar.entity.Student;
import seminar.entity.Team;

/**
 * @author Cesare
 */
class AskedQuestion extends RequestQuestion {
    private int score;

    public AskedQuestion(Student student, Team team, int score) {
        super(student, team);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
