package seminar.pojo.websocket;

import seminar.entity.Attendance;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public class SeminarMonitor {
    private Teacher teacher;
    private List<Attendance> enrollList;
    private List<Team> teams;
    private Map<Attendance, List<QuestionScore>> askedQuestion;
    private QuestionPool questionPool;

    private Map<String, Team> studentNumTeamMap;

    public void init() {
        questionPool = new QuestionPool();
        studentNumTeamMap = new HashMap<>(teams.size() * 5);
        teams.forEach(team -> {
            for (Student student : team.getStudents()) {
                studentNumTeamMap.put(student.getStudentNum(), team);
            }
        });
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Map<Attendance, List<QuestionScore>> getAskedQuestion() {
        return askedQuestion;
    }

    public void setAskedQuestion(Map<Attendance, List<QuestionScore>> askedQuestion) {
        this.askedQuestion = askedQuestion;
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
}
