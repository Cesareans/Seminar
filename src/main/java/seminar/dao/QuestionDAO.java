package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Question;
import seminar.mapper.QuestionMapper;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class QuestionDAO {

    private final QuestionMapper questionMapper;

    /**
     * @author Xinyu Shi
     */
    @Autowired
    public QuestionDAO(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    /**
     * @author Xinyu Shi
     */
    public List<Question> getAll() {
        return questionMapper.selectAllQuestion();
    }

    /**
     * @author Xinyu Shi
     */
    public List<Question> getByAttendanceId(String attendanceId) {
        return questionMapper.selectQuestionByAttendanceId(attendanceId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Question> getById(String id) {
        return questionMapper.selectQuestionById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Question> getByStudentId(String studentId) {
        return questionMapper.selectQuestionByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Question> getByTeamId(String teamId) {
        return questionMapper.selectQuestionByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByAttendanceId(String attendanceId) {
        questionMapper.deleteQuestionByAttendanceId(attendanceId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        questionMapper.deleteQuestionById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByStudentId(String studentId) {
        questionMapper.deleteQuestionByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByTeamId(String teamId) {
        questionMapper.deleteQuestionByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void create(Question question) {
        questionMapper.insertQuestion(question);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(Question question) {
        questionMapper.updateQuestion(question);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Question> getByTeamIdAndKlassSeminarId(String teamId, String klassSeminarId)
    {
        return questionMapper.selectQuestionByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
    }


}
