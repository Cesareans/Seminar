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
    private final RoundScoreDAO roundScoreDAO;
    private final int AVG_SCORE_CAL_METHOD = 0;
    private final int MAX_SCORE_CAL_METHOD = 1;
    private final int PRE_SCORE = 0;
    private final int REPORT_SCORE = 1;
    private final int QUES_SCORE = 2;

    @Autowired
    public ScoreServiceImpl(SeminarScoreDAO seminarScoreDAO, KlassSeminarDAO klassSeminarDAO, SeminarDAO seminarDAO, CourseDAO courseDAO, RoundDAO roundDAO, AttendanceDAO attendanceDAO, QuestionDAO questionDAO, TeamDAO teamDAO, RoundScoreDAO roundScoreDAO)
    {
        this.seminarScoreDAO = seminarScoreDAO;
        this.klassSeminarDAO = klassSeminarDAO;
        this.seminarDAO = seminarDAO;
        this.courseDAO = courseDAO;
        this.roundDAO = roundDAO;
        this.attendanceDAO = attendanceDAO;
        this.questionDAO = questionDAO;
        this.teamDAO = teamDAO;
        this.roundScoreDAO = roundScoreDAO;
    }

    /**
     * TODO: to delete
     * @param teamId the team refer gist
     * @param klassSeminarId the klassSeminar refer gist
     * @return
     */
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

    /**
     * TODO: To delete
     * @param teamId the team refer gist
     * @param roundId the round refer gist
     * @return
     */
    @Override
    public RoundScore calculateScoreOfOneRound(String teamId, String roundId)
    {
        Round round = roundDAO.getByRoundId(roundId).get(0);
        List<Seminar> seminarsInRound = seminarDAO.getByRoundId(roundId);
        List<Attendance> attendances  = new ArrayList<>();
        List<KlassSeminar> klassSeminars = new ArrayList<>();
        String klassId = teamDAO.getKlassIdByTeamIdAndCourseId(teamId,round.getCourseId());

        for(Seminar seminar : seminarsInRound)
        {
            KlassSeminar klassSeminar = klassSeminarDAO.getByKlassIdAndSeminarId(klassId,seminar.getId()).get(0);
            klassSeminars.add(klassSeminar);
            List<Attendance> attendanceTemp = attendanceDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminar.getId());
            if(!attendanceTemp.isEmpty()) {
                attendances.add(attendanceTemp.get(0));
            }
        }

        List<SeminarScore> seminarScores = new ArrayList<>();
        for(Attendance attendance:attendances)
        {
            seminarScores.add(seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId, attendance.getKlassSeminarId()).get(0));
        }

        BigDecimal preScore = calculateSeparateScore(0,round.getPreScoreType(),seminarScores);
        BigDecimal quesScore = calculateQuestionScoreOfRound(klassSeminars,teamId,round.getQuesScoreType());
        BigDecimal reportScore = calculateSeparateScore(1,round.getReportScoreType(),seminarScores);

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
    public Map<String, List<RoundScore>> calculateScoreOfOneCourse(List<Round> rounds, List<Team> teams)
    {
        Map<String, List<RoundScore>> totalScoreOfCourse = new HashMap<>(rounds.size());
        for(Round round : rounds)
        {
            List<RoundScore> roundScores = new ArrayList<>();
            for(Team team:teams)
            {
                roundScores.add(getRoundScore(team.getId(),round.getId()));
            }
            totalScoreOfCourse.put(round.getId(),roundScores);
        }
        return totalScoreOfCourse;
    }

    @Override
    public List<Map<String,RoundScore>> calculateCourseScore(List<Round> rounds, List<Team> teams)
    {
        List<Map<String, RoundScore>> scoreTable = new ArrayList<>();
        for(Round round: rounds)
        {
            Map<String,RoundScore> map = new HashMap<>(rounds.size());
            for(Team team:teams)
            {
                RoundScore roundScore = getRoundScore(team.getId(),round.getId());
                map.put(team.getId(),roundScore);
            }
            scoreTable.add(map);
        }
        return scoreTable;
    }

    @Override
    public SeminarScore getSeminarScore(String teamId, String klassSeminarId)
    {
        List<SeminarScore> seminarScores =  seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
        if(seminarScores.isEmpty()){
            return null;
        }
        return seminarScores.get(0);
    }

    @Override
    public RoundScore getRoundScore(String teamId, String roundId)
    {
        List<RoundScore> roundScores = roundScoreDAO.getByTeamIdAndRoundId(teamId,roundId);
        if(roundScores.isEmpty()){
            return null;
        }
        return roundScores.get(0);
    }

    @Override
    public void updateRoundScore(RoundScore roundScore)
    {
        Round round = roundDAO.getByRoundId(roundScore.getRoundId()).get(0);
        Course course = courseDAO.getByCourseId(round.getCourseId()).get(0);
        BigDecimal totalScore = (roundScore.getPresentationScore().multiply(new BigDecimal(course.getPrePercentage()))).add(roundScore.getQuestionScore().multiply(new BigDecimal(course.getQuesPercentage()))).add(roundScore.getReportScore().multiply(new BigDecimal(course.getReportPercentage())));
        totalScore = totalScore.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        roundScore.setTotalScore(totalScore);
        roundScoreDAO.update(roundScore);
    }

    @Override
    public void updateSeminarScore(SeminarScore seminarScore)
    {
        KlassSeminar klassSeminar = klassSeminarDAO.getByKlassSeminarId(seminarScore.getKlassSeminarId()).get(0);
        Seminar seminar = seminarDAO.getBySeminarId(klassSeminar.getSeminarId()).get(0);
        Course course = courseDAO.getByCourseId(seminar.getCourseId()).get(0);
        BigDecimal totalScore =(seminarScore.getPresentationScore().multiply(new BigDecimal(course.getPrePercentage()))).add(seminarScore.getReportScore().multiply(new BigDecimal(course.getReportPercentage()))).add(seminarScore.getQuestionScore().multiply(new BigDecimal(course.getQuesPercentage())));
        totalScore = totalScore.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        seminarScore.setTotalScore(totalScore);
        seminarScoreDAO.update(seminarScore);

        KlassSeminar kSeminar = klassSeminarDAO.getByKlassSeminarId(seminarScore.getKlassSeminarId()).get(0);
        Seminar seminar1 = seminarDAO.getBySeminarId(kSeminar.getSeminarId()).get(0);
        RoundScore roundScore = roundScoreDAO.getByTeamIdAndRoundId(seminarScore.getTeamId(),seminar1.getRoundId()).get(0);
        calculateRoundScore(roundScore,seminarScore.getTeamId(),klassSeminar.getKlassId());
    }

    @Override
    public void updateQuestionScore(String klassSeminarId, String teamId)
    {
        SeminarScore seminarScore = seminarScoreDAO.getByKlassSeminarId(klassSeminarId).get(0);
        seminarScore.setQuestionScore(calculateQuestionScoreOfSeminar(klassSeminarId,teamId));
        updateSeminarScore(seminarScore);
    }

    private void calculateRoundScore(RoundScore roundScore, String teamId, String klassId)
    {

        Round round = roundDAO.getByRoundId(roundScore.getRoundId()).get(0);
        List<Seminar> seminars = seminarDAO.getByRoundId(round.getId());
        List<SeminarScore> seminarScores = new ArrayList<>();
        for(Seminar seminar:seminars)
        {
            KlassSeminar klassSeminar = klassSeminarDAO.getByKlassIdAndSeminarId(klassId,seminar.getId()).get(0);
            seminarScores.add(seminarScoreDAO.getByTeamIdAndKlassSeminarId(teamId,klassSeminar.getId()).get(0));
        }
        roundScore.setPresentationScore(calculateSeparateScore(PRE_SCORE,round.getPreScoreType(),seminarScores));
        roundScore.setReportScore(calculateSeparateScore(REPORT_SCORE,round.getReportScoreType(),seminarScores));
        roundScore.setQuestionScore(calculateSeparateScore(QUES_SCORE,round.getQuesScoreType(),seminarScores));

        updateRoundScore(roundScore);

    }

    private BigDecimal calculateSeparateScore(int kind, int method, List<SeminarScore> seminarScores)
    {
        BigDecimal score = new BigDecimal(0);
        if(method== AVG_SCORE_CAL_METHOD)
        {
            if(kind==PRE_SCORE){
                score =seminarScores.stream().map(SeminarScore::getPresentationScore).filter(Objects::nonNull).reduce(new BigDecimal("0"), BigDecimal::add);

            }
            else if(kind==REPORT_SCORE) {
                score = seminarScores.stream().map(SeminarScore::getReportScore).filter(Objects::nonNull).reduce(new BigDecimal("0"), BigDecimal::add);
            }
            else if(kind==QUES_SCORE){
                score = seminarScores.stream().map(SeminarScore::getQuestionScore).filter(Objects::nonNull).reduce(new BigDecimal("0"), BigDecimal::add);
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
                Optional<BigDecimal> max = seminarScores.stream().map(SeminarScore::getPresentationScore).filter(Objects::nonNull).reduce(BigDecimal::max);
                score = max.orElse(new BigDecimal(0));
            }
            else if(kind==REPORT_SCORE){
                Optional<BigDecimal> max = seminarScores.stream().map(SeminarScore::getReportScore).filter(Objects::nonNull).reduce(BigDecimal::max);
                score = max.orElse(new BigDecimal(0));
            }
            else if(kind==QUES_SCORE){
                Optional<BigDecimal> max = seminarScores.stream().map(SeminarScore::getQuestionScore).filter(Objects::nonNull).reduce(BigDecimal::max);
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

    /**
     * @author Xinyu Shi
     * TODO: to delete
     */
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
        BigDecimal sum = questions.stream().map(Question::getScore).filter(Objects::nonNull).reduce(new BigDecimal("0"), BigDecimal::add);
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
        Optional<BigDecimal> max = questions.stream().map(Question::getScore).filter(Objects::nonNull).reduce(BigDecimal::max);
        quesScore = max.orElse(new BigDecimal(0));
        return quesScore;
    }

}
