package seminar.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.Round;
import seminar.logger.DebugLogger;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundMapperTest {
    @Autowired
    RoundMapper roundMapper;

    @Test
    public void selectRoundByCourseId() {
        List<Round> rounds = roundMapper.selectRoundByCourseId("112");
        DebugLogger.logJson(rounds);
    }

    @Test
    public void addRound() {
        Round round = new Round();
        round.setCourseId("112");
        DebugLogger.logJson(round);
        roundMapper.addRound(round);
        DebugLogger.logJson(round);
    }
}