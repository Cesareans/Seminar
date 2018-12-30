package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceMapperTest {
    @Autowired
    AttendanceMapper mapper;

    @Test
    public void selectAttendanceByKlassSeminarId() {
        DebugLogger.logJson(mapper.selectAttendanceByKlassSeminarId("1"));
    }
}