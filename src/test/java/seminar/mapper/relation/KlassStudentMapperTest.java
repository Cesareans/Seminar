package seminar.mapper.relation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import seminar.entity.Team;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
public class KlassStudentMapperTest {
    @Autowired
    KlassStudentMapper klassStudentMapper;


    @Test
    public void selectNotTeamedStudentsByCourseId() {
        DebugLogger.logJson(klassStudentMapper.selectNotTeamedStudentsByCourseId("20"));
    }

    @Test
    public void selectTeamByCourseIdAndStudentId(){
        DebugLogger.logJson(klassStudentMapper.selectTeamByCourseIdAndStudentId("16", "103"));
    }

//    @Test
//    public void selectCourseByStudentId(){
//        DebugLogger.logJson(klassStudentMapper.selectCourseByStudentId("1234"));
//    }

    @Test
    public void selectKlassByStudentId(){
        DebugLogger.logJson(klassStudentMapper.selectKlassByStudentId("1"));
    }
}