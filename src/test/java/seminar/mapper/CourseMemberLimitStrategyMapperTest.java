package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMemberLimitStrategyMapperTest {

    @Autowired
    CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper;

    @Test
    public void getByIdTest()
    {
        DebugLogger.logJson(courseMemberLimitStrategyMapper.selectCourseMemberLimitStrategyById("1").get(0));
    }
}