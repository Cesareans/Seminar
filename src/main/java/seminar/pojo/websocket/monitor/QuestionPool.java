package seminar.pojo.websocket.monitor;

import seminar.entity.Attendance;
import seminar.entity.Student;
import seminar.entity.Team;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Cesare
 */
public class QuestionPool {
    private List<RequestQuestion> raisedQuestion = new LinkedList<>();
    private Map<String, List<AskedQuestion>> askedQuestion = new HashMap<>();
    private Map<Team, Integer> teamTimes = new HashMap<>(5);
    private AskedQuestion onAskQuestion;

    private Random rd = new Random();

    QuestionPool(List<Attendance> attendances, List<Team> teams) {
        attendances.forEach(attendance -> {
            if (attendance != null) {
                askedQuestion.put(attendance.getId(), new LinkedList<>());
            }
        });
        teams.forEach(team -> teamTimes.put(team, 0));
        onAskQuestion = null;
    }

    boolean putRequest(Student student, Team team) {
        for (RequestQuestion question : raisedQuestion) {
            if (question.student.getStudentNum().equals(student.getStudentNum())) {
                return false;
            }
        }
        raisedQuestion.add(new RequestQuestion(student, team));
        return true;
    }

    void clearRequest() {
        raisedQuestion.clear();
    }

    void pullQuestion(Attendance attendance) {
        if (onAskQuestion == null && raisedQuestion.size() > 0) {
            int i = rd.nextInt(raisedQuestion.size());
            onAskQuestion = new AskedQuestion(raisedQuestion.get(i));

            teamTimes.put(onAskQuestion.getTeam(), teamTimes.get(onAskQuestion.getTeam()) + 1);
            raisedQuestion.remove(i);
            askedQuestion.get(attendance.getId()).add(onAskQuestion);
        }
    }

    RequestQuestion getOnAskQuestion() {
        return onAskQuestion;
    }

    void endQuestion() {
        onAskQuestion = null;
    }

    int getRaisedQuestionsCount() {
        return raisedQuestion.size();
    }

    void scoreQuestion(BigDecimal score, Attendance attendance, int questionIdx) {
        if (questionIdx == -1) {
            onAskQuestion.setScore(score);
        } else {
            askedQuestion.get(attendance.getId()).get(questionIdx).setScore(score);
        }
    }

    Map<String, List<AskedQuestion>> getAskedQuestion() {
        return askedQuestion;
    }
}
