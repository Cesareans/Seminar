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
import seminar.mapper.TeamMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
public class KlassStudentMapperTest {
    @Autowired
    KlassStudentMapper klassStudentMapper;
    @Autowired
    TeamMapper teamMapper;


    @Test
    public void selectNotTeamedStudentsByCourseId() {
        DebugLogger.logJson(klassStudentMapper.selectNotTeamedStudentsByCourseId("20"));
    }

    @Test
    public void selectTeamByCourseIdAndStudentId() {
        DebugLogger.logJson(klassStudentMapper.selectTeamByCourseIdAndStudentId("16", "103"));
    }

    @Test
    public void selectTeamByCourseId() {
        List<Team> teams = klassStudentMapper.selectTeamsByCourseId("17");
        DebugLogger.logJson(teams);
        DebugLogger.log(teams.size());
        List<Team> teams1 = teamMapper.selectTeamByMainCourseId("17");
        ;
        DebugLogger.logJson(teams1);
        DebugLogger.log(teams1.size());
    }


    @Test
    public void selectKlassByStudentId() {
        DebugLogger.logJson(klassStudentMapper.selectKlassByStudentId("1"));
    }
}