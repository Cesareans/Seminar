package seminar.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

import javax.jws.Oneway;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceMapperTest {
    @Autowired
    AttendanceMapper mapper;

    @Test
    public void selectAttendanceByKlassSeminarId() throws JsonProcessingException {
        DebugLogger.logJson(mapper.selectAttendanceByKlassSeminarId("1"));
    }
}