package seminar.pojo.websocket.monitor;

import org.springframework.security.core.parameters.P;
import seminar.entity.Attendance;
import seminar.entity.Student;
import seminar.entity.Team;

import javax.swing.plaf.nimbus.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public class SeminarMonitor {
    private List<Attendance> enrollList;
    private List<Team> teams;

    private QuestionPool questionPool;
    private Map<String, Team> studentNumTeamMap;
    private Attendance onPreAttendance;

    private SeminarState state;

    public SeminarMonitor(List<Attendance> enrollList, List<Team> teams) {
        this.enrollList = enrollList;
        this.teams = teams;
        init();
    }

    private void init() {
        studentNumTeamMap = new HashMap<>(teams.size() * 5);
        teams.forEach(team -> {
            for (Student student : team.getStudents()) {
                studentNumTeamMap.put(student.getStudentNum(), team);
            }
        });
        questionPool = new QuestionPool(enrollList);
        if(enrollList.size() > 0){
            onPreAttendance = enrollList.get(0);
        }
        state = SeminarState.PAUSE;
    }

    public void start(){
        if(state == SeminarState.PAUSE){
            state = SeminarState.PROCESSING;
        }
    }

    public void pause(){
        if(state == SeminarState.PROCESSING){
            state = SeminarState.PAUSE;
        }
    }

    public List<Attendance> getEnrollList() {
        return enrollList;
    }

    public void setEnrollList(List<Attendance> enrollList) {
        this.enrollList = enrollList;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public QuestionPool getQuestionPool() {
        return questionPool;
    }

    public void setQuestionPool(QuestionPool questionPool) {
        this.questionPool = questionPool;
    }

    public Map<String, Team> getStudentNumTeamMap() {
        return studentNumTeamMap;
    }

    public void setStudentNumTeamMap(Map<String, Team> studentNumTeamMap) {
        this.studentNumTeamMap = studentNumTeamMap;
    }

    public Attendance getOnPreAttendance() {
        return onPreAttendance;
    }

    public void setOnPreAttendance(Attendance onPreAttendance) {
        this.onPreAttendance = onPreAttendance;
    }

    public SeminarState getState() {
        return state;
    }

    public void setState(SeminarState state) {
        this.state = state;
    }
}
