package seminar.dao.strategy;

import org.springframework.stereotype.Component;
import seminar.entity.strategy.ConflictCourseStrategy;
import seminar.mapper.strategy.ConflictCourseStrategyMapper;

/**
 * @author Xinyu Shi
 */
@Component
public class ConflictCourseStrategyDAO {

    private final ConflictCourseStrategyMapper conflictCourseStrategyMapper;

    public ConflictCourseStrategyDAO(ConflictCourseStrategyMapper conflictCourseStrategyMapper)
    {
        this.conflictCourseStrategyMapper = conflictCourseStrategyMapper;
    }

    public ConflictCourseStrategy getById(String strategyId)
    {
        return conflictCourseStrategyMapper.selectConflictCourseStrategyById(strategyId).get(0);
    }


}
