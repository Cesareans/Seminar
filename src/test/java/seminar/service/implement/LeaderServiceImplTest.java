package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.dao.TeamDAO;
import seminar.logger.DebugLogger;
import seminar.service.LeaderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeaderServiceImplTest {

    @Autowired
    LeaderService leaderService;
    @Autowired
    TeamDAO teamDAO;

    @Test
    public void addGroupMemberTest()
    {
        DebugLogger.logJson(teamDAO.getById("6").get(0));
        DebugLogger.logJson(leaderService.addGroupMember("106","16","6"));
        DebugLogger.logJson(teamDAO.getById("6").get(0));
    }

    @Test
    public void deleteGroupMemberTest()
    {
        leaderService.deleteGroupMember("106","16","6");
        DebugLogger.logJson(teamDAO.getById("6").get(0));
    }

}