package seminar.dao.strategy;

import org.springframework.stereotype.Component;
import seminar.entity.strategy.CourseMemberLimitStrategy;
import seminar.mapper.strategy.CourseMemberLimitStrategyMapper;

/**
 * @author Xinyu Shi
 */
@Component
public class CourseMemberLimitStrategyDAO {

    private final CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper;

    public CourseMemberLimitStrategyDAO(CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper)
    {
        this.courseMemberLimitStrategyMapper = courseMemberLimitStrategyMapper;
    }

    public CourseMemberLimitStrategy getById(String strategyId)
    {
        return courseMemberLimitStrategyMapper.selectCourseMemberLimitStrategyById(strategyId).get(0);
    }

}
