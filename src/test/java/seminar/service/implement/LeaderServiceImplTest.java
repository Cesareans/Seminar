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
        leaderService.addGroupMember("1238","112","132");
        DebugLogger.logJson(teamDAO.getById("132").get(0));
    }

    @Test
    public void deleteGroupMemberTest()
    {
        leaderService.deleteGroupMember("1237","112","132");
        DebugLogger.logJson(teamDAO.getById("132").get(0));
    }

}