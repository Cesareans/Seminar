package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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

    @Test
    public void calculateScoreOfOneSeminar()
    {
        DebugLogger.logJson(seminarScoreDAO.getByTeamIdAndKlassSeminarId("21","9"));
        SeminarScore seminarScore = scoreService.calculateScoreOfOneSeminar("21","9");
        DebugLogger.logJson(seminarScore);
    }

    @Test
    public void  calculateScoreOfOneRound()
    {
        RoundScore roundScore = scoreService.calculateScoreOfOneRound("26","6");
        DebugLogger.logJson(roundScore);
    }

    @Test
    public void calculateScore()
    {
        DebugLogger.logJson(scoreService.calculateCourseScore("16"));
    }

}