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
    private AskedQuestion onAskQuestion;

    private Random rd = new Random();

    QuestionPool(List<Attendance> attendances) {
        attendances.forEach(attendance -> {
            if (attendance != null) {
                askedQuestion.put(attendance.getId(), new LinkedList<>());
            }
        });
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

    void pullQuestion() {
        if (onAskQuestion == null && raisedQuestion.size() > 0) {
            int i = rd.nextInt(raisedQuestion.size());
            onAskQuestion = new AskedQuestion(raisedQuestion.get(i));
            raisedQuestion.remove(i);
        }
    }

    RequestQuestion getOnAskQuestion() {
        return onAskQuestion;
    }

    void endQuestion(Attendance attendance) {
        askedQuestion.get(attendance.getId()).add(onAskQuestion);
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
