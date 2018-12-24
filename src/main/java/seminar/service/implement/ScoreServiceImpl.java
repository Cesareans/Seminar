package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.service.ScoreService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    private final SeminarScoreDAO seminarScoreDAO;
    private final KlassSeminarDAO klassSeminarDAO;
    private final SeminarDAO seminarDAO;
    private final CourseDAO courseDAO;
    private final RoundDAO roundDAO;
    private final AttendanceDAO attendanceDAO;
    private final QuestionDAO questionDAO;
    private final TeamDAO teamDAO;

    @Autowired
    public ScoreServiceImpl(SeminarScoreDAO seminarScoreDAO, KlassSeminarDAO klassSeminarDAO, SeminarDAO seminarDAO, CourseDAO courseDAO, RoundDAO roundDAO, AttendanceDAO attendanceDAO, QuestionDAO questionDAO, TeamDAO teamDAO)
    {
        this.seminarScoreDAO = seminarScoreDAO;
        this.klassSeminarDAO = klassSeminarDAO;
        this.seminarDAO = seminarDAO;
        this.courseDAO = courseDAO;
        this.roundDAO = roundDAO;
        this.attendanceDAO = attendanceDAO;
        this.questionDAO = questionDAO;
        this.teamDAO = teamDAO;

    }

    @Override
    public SeminarScore calculateScoreOfOneSeminar(String teamId, String klassSeminarId)
    {
        SeminarScore seminarScore = seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId).get(0);
        calculateQuestionScoreOfSeminar(klassSeminarId,teamId);
        KlassSeminar klassSeminar = klassSeminarDAO.getByKlassSeminarId(seminarScore.getKlassSeminarId()).get(0);
        Seminar seminar = seminarDAO.getBySeminarId(klassSeminar.getSeminarId()).get(0);
        Course course = courseDAO.getByCourseId(seminar.getCourseId()).get(0);
        List<Attendance> attendances = attendanceDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
        if(!attendances.isEmpty())
        {
            BigDecimal totalScore =(seminarScore.getPresentationScore().multiply(new BigDecimal(course.getPrePercentage()))).add(seminarScore.getReportScore().multiply(new BigDecimal(course.getReportPercentage()))).add(seminarScore.getQuestionScore().multiply(new BigDecimal(course.getQuesPercentage())));
            totalScore = totalScore.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
            seminarScore.setTotalScore(totalScore);
            seminarScoreDAO.update(seminarScore);
        }
        return seminarScore;
    }

    @Override
    public RoundScore calculateScoreOfOneRound(String teamId, String roundId)
    {
        Round round = roundDAO.getByRoundId(roundId).get(0);
        List<Seminar> seminarsInRound = seminarDAO.getByRoundId(roundId);
        List<Attendance> attendances  = new ArrayList<>();
        List<KlassSeminar> klassSeminars = new ArrayList<>();
        Team team = teamDAO.getById(teamId).get(0);

        for(Seminar seminar : seminarsInRound)
        {
            KlassSeminar klassSeminar = klassSeminarDAO.getByKlassIdAndSeminarId(team.getKlassId(),seminar.getId()).get(0);
            klassSeminars.add(klassSeminar);
            calculateQuestionScoreOfSeminar(klassSeminar.getId(),teamId);
            List<Attendance> attendanceTemp = attendanceDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminar.getId());
            if(!attendanceTemp.isEmpty()) {
                attendances.add(attendanceTemp.get(0));
            }
        }

        BigDecimal preScore = calculateSeparateScore(0,round.getPreScoreType(),teamId,attendances);
        BigDecimal quesScore = calculateQuestionScoreOfRound(klassSeminars,teamId,round.getQuesScoreType());
        BigDecimal reportScore = calculateSeparateScore(2,round.getReportScoreType(),teamId,attendances);

        Course course = courseDAO.getByCourseId(round.getCourseId()).get(0);
        BigDecimal totalScore = (preScore.multiply(new BigDecimal(course.getPrePercentage()))).add(quesScore.multiply(new BigDecimal(course.getQuesPercentage()))).add(reportScore.multiply(new BigDecimal(course.getReportPercentage())));
        totalScore = totalScore.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        RoundScore roundScore = new RoundScore();
        roundScore.setRoundId(roundId);
        roundScore.setPresentationScore(preScore);
        roundScore.setQuestionScore(quesScore);
        roundScore.setReportScore(reportScore);
        roundScore.setTotalScore(totalScore);
        return roundScore;
    }

    private BigDecimal calculateSeparateScore(int kind, int method, String teamId, List<Attendance> attendances)
    {
        //kind: 0:pre 1:question 2:report
        BigDecimal score = new BigDecimal(0);

        //average score
        if(method==0)
        {
            int attendanceTimes = 0;
            for(Attendance attendance : attendances)
            {
                if(kind==0) {
                    score = score.add(seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId, attendance.getKlassSeminarId()).get(0).getPresentationScore());
                }else if(kind==2) {
                    score = score.add(seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId, attendance.getKlassSeminarId()).get(0).getReportScore());
                }
                attendanceTimes++;
            }

            score = score.divide(new BigDecimal(attendanceTimes),2, BigDecimal.ROUND_HALF_UP);
        }
        //maximum score
        else if(method==1)
        {
            for(Attendance attendance : attendances)
            {
                if(kind==0)
                {
                    BigDecimal temp = seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,attendance.getKlassSeminarId()).get(0).getPresentationScore();
                    if(score.compareTo(temp)<0) {
                        score = temp;
                    }
                }
                else if(kind==2)
                {
                    BigDecimal temp = seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,attendance.getKlassSeminarId()).get(0).getReportScore();
                    if(score.compareTo(temp)<0) {
                        score = temp;
                    }
                }
            }
        }
        return score;
    }

    private void calculateQuestionScoreOfSeminar(String klassSeminarId, String teamId)
    {
        List<Question> questions = questionDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
        KlassSeminar klassSeminar = klassSeminarDAO.getByKlassSeminarId(klassSeminarId).get(0);
        Seminar seminar = seminarDAO.getBySeminarId(klassSeminar.getSeminarId()).get(0);
        Round round = roundDAO.getByRoundId(seminar.getRoundId()).get(0);
        BigDecimal quesScore = new BigDecimal(0);
        if(round.getQuesScoreType()==0)
        {

            // average score
            int times = 0;
            for(Question question : questions)
            {
                if(question.getScore()!=null)
                {
                    quesScore = quesScore.add(question.getScore());
                    times++;
                }
            }
            if(times!=0) {
                quesScore = quesScore.divide(new BigDecimal(times), 2, BigDecimal.ROUND_HALF_UP);
            }
            else {
                quesScore = new BigDecimal(0);
            }

        }
        else if(round.getQuesScoreType()==1)
        {
            //maximum score
            for(Question question:questions)
            {
                if(question.getScore()!=null)
                {
                    BigDecimal temp = question.getScore();
                    if(quesScore.compareTo(temp)<0) {
                        quesScore = temp;
                    }
                }

            }
        }
        SeminarScore seminarScore = seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId).get(0);
        seminarScore.setQuestionScore(quesScore);
        seminarScoreDAO.update(seminarScore);
    }

    private BigDecimal calculateQuestionScoreOfRound(List<KlassSeminar> klassSeminars, String teamId, int method)
    {
        List<Question> questions = new ArrayList<>();
        for(KlassSeminar klassSeminar:klassSeminars)
        {
            List<Question> questionsInOneSeminar = questionDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminar.getId());
            questions.addAll(questionsInOneSeminar);
        }

        BigDecimal quesScore = new BigDecimal(0);
        if(method==0)
        {
            // average score
            int times = 0;
            for(Question question : questions)
            {
                if(question.getScore()!=null)
                {
                    quesScore = quesScore.add(question.getScore());
                    times++;
                }
            }
            quesScore = quesScore.divide(new BigDecimal(times), 2, BigDecimal.ROUND_HALF_UP);

        }
        else if(method==1)
        {
            //maximum score
            for(Question question:questions)
            {
                BigDecimal temp = question.getScore();
                if(quesScore.compareTo(temp)<0) {
                    quesScore = temp;
                }
            }
        }
        return quesScore;
    }

}
