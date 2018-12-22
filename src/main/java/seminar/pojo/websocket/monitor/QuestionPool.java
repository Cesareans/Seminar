package seminar.pojo.websocket.monitor;

import seminar.entity.Attendance;
import seminar.entity.Student;
import seminar.entity.Team;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public class QuestionPool {
    private Map<Attendance, List<RequestQuestion>> raisedQuestion = new HashMap<>();
    private Map<Attendance, List<AskedQuestion>> askedQuestion = new HashMap<>();
    private RequestQuestion onAskingQuestion;

    public QuestionPool(List<Attendance> attendances){
        attendances.forEach(attendance -> {
            raisedQuestion.put(attendance, new LinkedList<>());
            askedQuestion.put(attendance, new LinkedList<>());
        });
        onAskingQuestion = null;
    }

    public void putRequest(Attendance attendance, Student student, Team team){
        List<RequestQuestion> questions = raisedQuestion.get(attendance);
        questions.add(new RequestQuestion(student, team));
    }


    public int getRaisedQuestionsCount(){
        return raisedQuestion.size();
    }

}
