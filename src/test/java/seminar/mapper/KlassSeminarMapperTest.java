package seminar.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KlassSeminarMapperTest {
    @Autowired
    KlassSeminarMapper klassSeminarMapper;


    /**
     * This test checks out a problem that the KlassSeminar cannot be serialized.
     * reasonOut: when a class's link field was defined with lazy fetch type. The class will be registered with a handler which could not be serialized.
     */
    @Test
    public void selectKlassSeminarByKlassIdAndSeminarId() throws JsonProcessingException {
        DebugLogger.logJson(klassSeminarMapper.selectKlassSeminarByKlassIdAndSeminarId("143", "111"));

    }

    @Test
    public void selectKlassSeminarById() throws JsonProcessingException {
        DebugLogger.logJson(klassSeminarMapper.selectKlassSeminarById("1"));
    }
}