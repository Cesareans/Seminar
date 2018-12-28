package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.config.websocket.RawMessageConverter;
import seminar.dao.*;
import seminar.entity.*;
import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.AskedQuestion;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.RawMessage;
import seminar.pojo.websocket.request.Request;
import seminar.pojo.websocket.response.EndSeminarResponse;
import seminar.pojo.websocket.response.Response;
import seminar.service.ScoreService;
import seminar.service.WebSocketService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {
    private final ScoreService scoreService;
    private final KlassSeminarDAO klassSeminarDAO;
    private final TeamDAO teamDAO;
    private final SeminarScoreDAO seminarScoreDAO;
    private final QuestionDAO questionDAO;
    private final RawMessageConverter rawMessageConverter;
    private final AttendanceDAO attendanceDAO;
    private Map<String, SeminarMonitor> monitorMap = new HashMap<>();

    @Autowired
    public WebSocketServiceImpl(ScoreService scoreService, KlassSeminarDAO klassSeminarDAO, TeamDAO teamDAO, SeminarScoreDAO seminarScoreDAO, QuestionDAO questionDAO, RawMessageConverter rawMessageConverter, AttendanceDAO attendanceDAO) {
        this.scoreService = scoreService;
        this.klassSeminarDAO = klassSeminarDAO;
        this.teamDAO = teamDAO;
        this.seminarScoreDAO = seminarScoreDAO;
        this.questionDAO = questionDAO;
        this.rawMessageConverter = rawMessageConverter;
        this.attendanceDAO = attendanceDAO;
    }

    @Override
    public void initMonitor(KlassSeminar klassSeminar) {
        klassSeminar.setState(1);
        klassSeminarDAO.update(klassSeminar);

        List<Attendance> attendanceList = attendanceDAO.getByKlassSeminarId(klassSeminar.getId());
        List<Team> teams = teamDAO.getOwnStudentsTeamByCourseId(klassSeminarDAO.getById(klassSeminar.getId()).get(0).getSeminar().getCourseId());
        SeminarMonitor seminarMonitor = new SeminarMonitor(attendanceList, teams);
        monitorMap.put(klassSeminar.getId(), seminarMonitor);
    }

    @Override
    public void endMonitor(String ksId) {
        SeminarMonitor monitor = getMonitor(ksId);
        KlassSeminar klassSeminar = klassSeminarDAO.getById(ksId).get(0);
        klassSeminar.setState(2);
        klassSeminarDAO.update(klassSeminar);
        monitorMap.remove(ksId);

        Map<String, BigDecimal> scoreMap = monitor.getPreScoreMap();
        SeminarScore seminarScore = new SeminarScore();
        Question question = new Question();
        BigDecimal score;
        question.setKlassSeminarId(ksId);
        List<SeminarScore> seminarScores;
        List<AskedQuestion> askedQuestions;
        for (Attendance attendance : monitor.getAttendanceList()) {
            if(attendance == null){
                continue;
            }
            score = scoreMap.get(attendance.getId());
            if (score.intValue() < 0) {score = new BigDecimal(0);}
            seminarScores = seminarScoreDAO.getByTeamIdAndKlassSeminarId(attendance.getTeamId(), attendance.getKlassSeminarId());
            if(seminarScores.isEmpty()){
                seminarScore.setPresentationScore(score);
                seminarScore.setTeamId(attendance.getTeamId());
                seminarScore.setKlassSeminarId(attendance.getKlassSeminarId());
                seminarScoreDAO.createSeminarScore(seminarScore);
            }else{
                seminarScore = seminarScores.get(0);
                seminarScore.setPresentationScore(score);
                seminarScoreDAO.update(seminarScore);
            }
            askedQuestions = monitor.getAskedQuestion().get(attendance.getId());
            askedQuestions.forEach(askedQuestion -> {
                BigDecimal queScore = askedQuestion.getScore();
                if(queScore.intValue()<0){queScore = new BigDecimal(0);}
                question.setAttendanceId(attendance.getId());
                question.setScore(queScore);
                question.setStudentId(askedQuestion.getStudent().getId());
                question.setTeamId(askedQuestion.getTeam().getId());
                questionDAO.create(question);
            });
            scoreService.updateQuestionScore(ksId, attendance.getTeamId());
        }
    }

    @Override
    public SeminarMonitor getMonitor(String ksId) {
        return monitorMap.getOrDefault(ksId, null);
    }


    @Override
    public RawMessage handleMessage(String ksId, RawMessage message) {
        SeminarMonitor monitor = getMonitor(ksId);
        Request request = rawMessageConverter.convertToRequest(message);
        request.execute(monitor);
        try {
            Class<?> responseClass = request.getClass().getAnnotation(BindResponse.class).response();
            if(responseClass == EndSeminarResponse.class){
                endMonitor(ksId);
            }
            Response response = responseClass.asSubclass(Response.class).newInstance();
            return rawMessageConverter.convertFromResponse(response.execute(monitor));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
