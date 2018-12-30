package seminar.dao.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.mapper.CourseMemberLimitStrategyMapper;


/**
 * @author Xinyu Shi
 */
@Component
public class CourseMemberLimitStrategyDAO {

    private final CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper;

    @Autowired
    public CourseMemberLimitStrategyDAO(CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper) {
        this.courseMemberLimitStrategyMapper = courseMemberLimitStrategyMapper;
    }

    public CourseMemberLimitStrategy getById(String strategyId) {
        return courseMemberLimitStrategyMapper.selectCourseMemberLimitStrategyById(strategyId).get(0);
    }

    public void createCourseMemberLimitStrategy(CourseMemberLimitStrategy courseMemberLimitStrategy) {
        courseMemberLimitStrategyMapper.insertCourseMemberLimitStrategy(courseMemberLimitStrategy);
    }

}