package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.dao.RoundScoreDAO;
import seminar.dao.SeminarScoreDAO;
import seminar.entity.RoundScore;
import seminar.entity.SeminarScore;
import seminar.logger.DebugLogger;
import seminar.service.ScoreService;

/**
 * @author Xinyu Shi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreServiceImplTest {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private SeminarScoreDAO seminarScoreDAO;
    @Autowired
    private RoundScoreDAO roundScoreDAO;

    @Test
    public void calculateScoreOfOneSeminar() {
        DebugLogger.logJson(seminarScoreDAO.getByTeamIdAndKlassSeminarId("21", "9"));
        SeminarScore seminarScore = scoreService.calculateScoreOfOneSeminar("21", "9");
        DebugLogger.logJson(seminarScore);
    }

    @Test
    public void calculateScoreOfOneRound() {
        RoundScore roundScore = scoreService.calculateScoreOfOneRound("26", "6");
        DebugLogger.logJson(roundScore);
    }

    @Test
    public void getSeminarScore() {
        DebugLogger.logJson(scoreService.getSeminarScore("26", "11"));
        DebugLogger.logJson(scoreService.getSeminarScore("27", "11"));
    }

    @Test
    public void getRoundScore() {
        DebugLogger.logJson(scoreService.getRoundScore("26", "4"));
    }

    @Test
    public void updateRoundScore() {
        RoundScore roundScore = roundScoreDAO.getByTeamIdAndRoundId("26", "4").get(0);
        DebugLogger.logJson(scoreService.getRoundScore("26", "4"));
        scoreService.updateRoundScore(roundScore);
        DebugLogger.logJson(scoreService.getRoundScore("26", "4"));
    }

    @Test
    public void updateSeminarScore() {
        SeminarScore seminarScore = seminarScoreDAO.getByTeamIdAndKlassSeminarId("27", "11").get(0);
        DebugLogger.logJson(scoreService.getSeminarScore("27", "11"));
        scoreService.updateSeminarScore(seminarScore);
        DebugLogger.logJson(scoreService.getSeminarScore("27", "11"));
    }

    @Test
    public void updateQuestionScore() {
        DebugLogger.logJson(scoreService.getSeminarScore("25", "11"));
        scoreService.updateQuestionScore("11", "25");
        DebugLogger.logJson(scoreService.getSeminarScore("25", "11"));
    }

}