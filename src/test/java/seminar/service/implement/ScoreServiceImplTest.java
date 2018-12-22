package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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

    @Test
    public void calculateScoreOfOneSeminar()
    {
        SeminarScore seminarScore = scoreService.calculateScoreOfOneSeminar("132","8");
        DebugLogger.logJson(seminarScore);
    }

    @Test
    public void  calculateScoreOfOneRound()
    {
        RoundScore roundScore = scoreService.calculateScoreOfOneRound("132","111");
        DebugLogger.logJson(roundScore);
    }

}