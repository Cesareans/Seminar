package seminar.pojo.websocket.monitor;

import seminar.entity.Student;
import seminar.entity.Team;

/**
 * @author Cesare
 */
public class RequestQuestion {
    protected Student student;
    protected Team team;

    public RequestQuestion(Student student, Team team) {
        this.student = student;
        this.team = team;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
