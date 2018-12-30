package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.Klass;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KlassMapperTest {
    @Autowired
    KlassMapper klassMapper;

    @Test
    public void insertKlass() {
        Klass klass = new Klass();
        klass.setCourseId("112");
        klass.setGrade(2018);
        klass.setSerial(4);
        klass.setTime("-213");
        klass.setLocation("213");
        klassMapper.insertKlass(klass);
        DebugLogger.logJson(klass);
    }

    @Test
    public void selectKlassByCourseId() {
        DebugLogger.logJson(klassMapper.selectKlassByCourseId("112"));
    }
}