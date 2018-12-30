package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamAndStrategyMapperTest {

    @Autowired
    TeamAndStrategyMapper teamAndStrategyMapper;

    @Test
    public void allocateIdTest() {
        DebugLogger.logJson(teamAndStrategyMapper.allocateId());
    }

}