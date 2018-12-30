package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarMapperTest {
    @Autowired
    SeminarMapper seminarMapper;

    @Test
    public void selectSeminarByRoundId() {
        DebugLogger.logJson(seminarMapper.selectSeminarByRoundId("111"));
    }

    @Test
    public void selectMaxSerialOfCourse() {
        DebugLogger.log(seminarMapper.selectMaxSeminarSerial("112"));
    }

}