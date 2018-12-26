package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;
import seminar.service.StrategyService;

/**
 * @author Xinyu Shi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyServiceImplTest {

    @Autowired
    StrategyService strategyService;

    @Test
    public void validateTest()
    {
        DebugLogger.logJson(strategyService.validate("26","16"));
    }

}