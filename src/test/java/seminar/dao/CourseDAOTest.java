package seminar.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.Team;
import seminar.logger.DebugLogger;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDAOTest {
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    KlassStudentMapper klassStudentMapper;

    @Test
    public void getOtherCoursesByCourseId() {
        DebugLogger.logJson(courseDAO.getCanShareCoursesByCourseId("112"));
        DebugLogger.logJson(courseDAO.getCanShareCoursesByCourseId("113"));
        DebugLogger.logJson(courseDAO.getCanShareCoursesByCourseId("114"));

    }

    @Test
    public void buildTeamShare() {
        courseDAO.buildTeamShare("16", "17");
        List<Team> teams = klassStudentMapper.selectTeamsByCourseId("16");
        DebugLogger.logJson(teams);
        DebugLogger.log(teams.size());
        List<Team> teams1 = klassStudentMapper.selectTeamsByCourseId("17");
        DebugLogger.logJson(teams1);
        DebugLogger.log(teams1.size());

    }
}