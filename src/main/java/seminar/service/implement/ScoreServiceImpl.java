package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.service.ScoreService;

import java.math.BigDecimal;
import java.util.*;

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
    private final int AVG_SCORE_CAL_METHOD = 0;
    private final int MAX_SCORE_CAL_METHOD = 1;
    private final int PRE_SCORE = 0;
    private final int REPORT_SCORE = 1;

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
        List<SeminarScore> seminarScores =  seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
        if(seminarScores.isEmpty()){
            return null;
        }
        SeminarScore seminarScore =seminarScores.get(0);
        seminarScore.setQuestionScore(calculateQuestionScoreOfSeminar(klassSeminarId,teamId));
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
            List<Attendance> attendanceTemp = attendanceDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminar.getId());
            if(!attendanceTemp.isEmpty()) {
                attendances.add(attendanceTemp.get(0));
            }
        }

        BigDecimal preScore = calculateSeparateScore(0,round.getPreScoreType(),teamId,attendances);
        BigDecimal quesScore = calculateQuestionScoreOfRound(klassSeminars,teamId,round.getQuesScoreType());
        BigDecimal reportScore = calculateSeparateScore(1,round.getReportScoreType(),teamId,attendances);

        Course course = courseDAO.getByCourseId(round.getCourseId()).get(0);
        BigDecimal totalScore = (preScore.multiply(new BigDecimal(course.getPrePercentage()))).add(quesScore.multiply(new BigDecimal(course.getQuesPercentage()))).add(reportScore.multiply(new BigDecimal(course.getReportPercentage())));
        totalScore = totalScore.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        RoundScore roundScore = new RoundScore();
        roundScore.setRoundId(roundId);
        roundScore.setTeamId(teamId);
        roundScore.setPresentationScore(preScore);
        roundScore.setQuestionScore(quesScore);
        roundScore.setReportScore(reportScore);
        roundScore.setTotalScore(totalScore);
        return roundScore;
    }

    @Override
    public Map<String, List<RoundScore>> calculateScoreOfOneCourse(String courseId)
    {
        List<Round> rounds = roundDAO.getByCourseId(courseId);
        List<Team> teams = teamDAO.getNoStudentTeamsByCourseId(courseId);
        Map<String, List<RoundScore>> totalScoreOfCourse = new HashMap<>();
        for(Round round : rounds)
        {
            List<RoundScore> roundScores = new ArrayList<>();
            for(Team team:teams)
            {
                roundScores.add(calculateScoreOfOneRound(team.getId(),round.getId()));
            }
            totalScoreOfCourse.put(round.getId(),roundScores);
        }
        return totalScoreOfCourse;
    }

    private BigDecimal calculateSeparateScore(int kind, int method, String teamId, List<Attendance> attendances)
    {
        BigDecimal score = new BigDecimal(0);
        List<SeminarScore> seminarScores = new ArrayList<>();
        for(Attendance attendance:attendances)
        {
            seminarScores.add(seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId, attendance.getKlassSeminarId()).get(0));
        }
        if(method== AVG_SCORE_CAL_METHOD)
        {
            if(kind==PRE_SCORE){
                score =seminarScores.stream().map(SeminarScore::getPresentationScore).reduce(new BigDecimal("0"), BigDecimal::add);

            }
            else if(kind==REPORT_SCORE) {
                score = seminarScores.stream().map(SeminarScore::getReportScore).reduce(new BigDecimal("0"), BigDecimal::add);
            }
            long count = (long)seminarScores.size();
            if(!seminarScores.isEmpty()){
                score = score.divide(new BigDecimal(count) , 2, BigDecimal.ROUND_HALF_UP);
            }
            else{
                score = new BigDecimal(0);
            }
        }
        else if(method==MAX_SCORE_CAL_METHOD)
        {
            if(kind==PRE_SCORE){
                Optional<BigDecimal> max = seminarScores.stream().map(SeminarScore::getPresentationScore).reduce(BigDecimal::max);
                score = max.orElse(new BigDecimal(0));
            }
            else if(kind==REPORT_SCORE){
                Optional<BigDecimal> max = seminarScores.stream().map(SeminarScore::getReportScore).reduce(BigDecimal::max);
                score = max.orElse(new BigDecimal(0));
            }
        }
        return score;
    }

    private BigDecimal calculateQuestionScoreOfSeminar(String klassSeminarId, String teamId)
    {
        List<Question> questions = questionDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
        KlassSeminar klassSeminar = klassSeminarDAO.getByKlassSeminarId(klassSeminarId).get(0);
        Seminar seminar = seminarDAO.getBySeminarId(klassSeminar.getSeminarId()).get(0);
        Round round = roundDAO.getByRoundId(seminar.getRoundId()).get(0);
        BigDecimal quesScore = new BigDecimal(0);
        if(round.getQuesScoreType()== AVG_SCORE_CAL_METHOD)
        {
            quesScore = averageScore(questions);
        }
        else if(round.getQuesScoreType()==MAX_SCORE_CAL_METHOD)
        {
            quesScore = maxScore(questions);
        }
       return quesScore;
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
        if(method== AVG_SCORE_CAL_METHOD) {
           quesScore = averageScore(questions);
        }
        else if(method==MAX_SCORE_CAL_METHOD) {
           quesScore = maxScore(questions);
        }
        return quesScore;
    }

    private BigDecimal averageScore(List<Question> questions)
    {
        BigDecimal quesScore ;
        BigDecimal sum = questions.stream().map(Question::getScore).reduce(new BigDecimal("0"), BigDecimal::add);
        long count = (long) questions.size();
        if(!questions.isEmpty()){
            quesScore = sum.divide(new BigDecimal(count) , 2, BigDecimal.ROUND_HALF_UP);
        }
        else{
            quesScore = new BigDecimal(0);
        }
        return quesScore;
    }

    private BigDecimal maxScore(List<Question> questions)
    {
        BigDecimal quesScore;
        Optional<BigDecimal> max = questions.stream().map(Question::getScore).reduce(BigDecimal::max);
        quesScore = max.orElse(new BigDecimal(0));
        return quesScore;
    }

}
