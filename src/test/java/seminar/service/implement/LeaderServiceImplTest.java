package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.dao.TeamDAO;
import seminar.logger.DebugLogger;
import seminar.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeaderServiceImplTest {

    @Autowired
    StudentService studentService;
    @Autowired
    TeamDAO teamDAO;

    @Test
    public void addGroupMemberTest()
    {
        //DebugLogger.logJson(teamDAO.getById("6").get(0));
        DebugLogger.logJson(studentService.addTeamMember("106","26"));
        DebugLogger.logJson(teamDAO.getById("26").get(0));
    }

    @Test
    public void deleteGroupMemberTest()
    {
        studentService.deleteTeamMember("106","6");
        DebugLogger.logJson(teamDAO.getById("6").get(0));
    }

    @Test
    public void dissolveTest()
    {
        studentService.dissolveTeam("6");
    }

}