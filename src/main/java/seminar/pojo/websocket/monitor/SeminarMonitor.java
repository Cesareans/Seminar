package seminar.pojo.websocket.monitor;

import seminar.entity.Attendance;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.pojo.websocket.monitor.state.ProgressState;
import seminar.pojo.websocket.monitor.state.SeminarState;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public class SeminarMonitor {
    private List<Attendance> attendanceList;
    private List<Team> teams;
    private Map<String, Team> studentNumTeamMap;
    private Map<String, BigDecimal> preScoreMap;

    private QuestionPool questionPool;
    private int onPreAttendanceIndex;
    private SeminarState state = new SeminarState();

    public SeminarMonitor(List<Attendance> attendanceList, List<Team> teams) {
        this.attendanceList = attendanceList;
        this.teams = teams;
        init();
    }

    private void init() {
        studentNumTeamMap = new HashMap<>(teams.size() * 5);
        preScoreMap = new HashMap<>(teams.size());
        questionPool = new QuestionPool(attendanceList, teams);
        onPreAttendanceIndex = 0;
        attendanceList.forEach(enroll -> {
            if (enroll != null) {
                preScoreMap.put(enroll.getId(), new BigDecimal(-1));
            }
        });
        teams.forEach(team -> {
            for (Student student : team.getStudents()) {
                studentNumTeamMap.put(student.getStudentNum(), team);
            }
        });
    }

    //Method for request

    public void startAt(Integer timeStamp) {
        if (state.getProgressState() == ProgressState.PAUSE) {
            state.setProgressState(ProgressState.PROCESSING);
        }
        state.setTimeStamp(timeStamp);
    }

    public void pauseAt(Integer timeStamp) {
        if (state.getProgressState() == ProgressState.PROCESSING) {
            state.setProgressState(ProgressState.PAUSE);
        }
        state.setTimeStamp(timeStamp);
    }

    public void terminate() {
        state.setProgressState(ProgressState.TERMINATE);
    }

    public void switchTeam() {
        onPreAttendanceIndex += 1;
        if (onPreAttendanceIndex < attendanceList.size()) {
            pauseAt(0);
        } else {
            terminate();
        }
        questionPool.clearRequest();
    }

    public void pullQuestion() {
        questionPool.pullQuestion(attendanceList.get(onPreAttendanceIndex));
    }

    public void putQuestion(String studentNum) {
        Team team = studentNumTeamMap.get(studentNum);
        for (Student student : team.getStudents()) {
            if (student.getStudentNum().equals(studentNum)) {
                questionPool.putRequest(student, team);
            }
        }
    }

    public void endQuestion() {
        questionPool.endQuestion();
    }

    public void scoreAttendance(BigDecimal score, int attendanceIdx) {
        if (state.getProgressState() == ProgressState.TERMINATE) {
            return;
        }
        preScoreMap.put(attendanceList.get(attendanceIdx).getId(), score);
    }

    public void scoreQuestion(BigDecimal score, int attendanceIdx, int questionIdx) {
        if (state.getProgressState() == ProgressState.TERMINATE) {
            return;
        }
        questionPool.scoreQuestion(score, attendanceList.get(attendanceIdx), questionIdx);
    }

    //Method for response

    public int getRaisedQuestionsCount() {
        return questionPool.getRaisedQuestionsCount();
    }

    public RequestQuestion getChosenQuestion() {
        return questionPool.getOnAskQuestion();
    }

    public int getOnPreAttendanceIndex() {
        return onPreAttendanceIndex;
    }

    public SeminarState getState() {
        return state;
    }

    //Method for freemarker

    public Map<String, BigDecimal> getPreScoreMap() {
        return preScoreMap;
    }

    public Attendance getOnPreAttendance() {
        if (onPreAttendanceIndex >= attendanceList.size()) {
            return null;
        }
        return attendanceList.get(onPreAttendanceIndex);
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public Team getTeamByStudentNum(String studentNum) {
        return studentNumTeamMap.get(studentNum);
    }

    public Map<String, List<AskedQuestion>> getAskedQuestion() {
        return questionPool.getAskedQuestion();
    }
}
