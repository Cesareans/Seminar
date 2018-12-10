package seminar.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarMapperTest {
    @Autowired
    SeminarMapper seminarMapper;
    @Test
    public void selectSeminarByRoundId() throws JsonProcessingException {
        DebugLogger.logJson(seminarMapper.selectSeminarByRoundId("111"));
    }
}