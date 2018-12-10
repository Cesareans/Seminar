package seminar.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.ClbumSeminar;
import seminar.logger.DebugLogger;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClbumSeminarMapperTest {
    @Autowired
    ClbumSeminarMapper clbumSeminarMapper;


    /**
     * This test checks out a problem that the ClbumSeminar cannot be serialized.
     * reasonOut: when a class's link field was defined with lazy fetch type. The class will be registered with a handler which could not be serialized.
     */
    @Test
    public void selectClbumSeminarByClbumIdAndSeminarId() throws JsonProcessingException {
        DebugLogger.logJson(clbumSeminarMapper.selectClbumSeminarByClbumIdAndSeminarId("143", "111"));

    }

    @Test
    public void selectClbumSeminarById() throws JsonProcessingException {
        DebugLogger.logJson(clbumSeminarMapper.selectClbumSeminarById("1"));
    }
}