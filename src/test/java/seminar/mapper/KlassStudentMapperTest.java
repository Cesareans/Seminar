package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KlassStudentMapperTest {
    @Autowired
    KlassStudentMapper klassStudentMapper;

    @Test
    public void selectStudentsByTeamId() {
        DebugLogger.logJson(klassStudentMapper.selectStudentsByTeamId("113"));
    }

    @Test
    public void selectNotTeamedStudentsByCourseId() {
        DebugLogger.logJson(klassStudentMapper.selectNotTeamedStudentsByCourseId("112"));
    }
}