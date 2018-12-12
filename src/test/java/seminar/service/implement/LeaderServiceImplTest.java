package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.dao.TeamDAO;
import seminar.dao.TeamStudentDAO;
import seminar.logger.DebugLogger;

import static sun.misc.Version.println;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeaderServiceImplTest {

    @Autowired
    LeaderServiceImpl leaderService;
    @Autowired
    TeamDAO teamDAO;
    @Autowired
    TeamStudentDAO teamStudentDAO;

    @Test
    public void addGroupMemberTest()
    {
        boolean r = leaderService.addGroupMember("112","111","45678960");
        DebugLogger.log(r);
        DebugLogger.logJson(teamStudentDAO.getAllStudentByTeamId("111"));

    }

    @Test
    public void deleteGroupMemberTest()
    {
        leaderService.deleteGroupMember("112","111","20161037");
        DebugLogger.logJson(teamDAO.getById("111"));
    }


}