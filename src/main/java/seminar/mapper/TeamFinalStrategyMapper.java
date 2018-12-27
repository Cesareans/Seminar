package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.StrategyNameId;

import java.util.List;
import java.util.Map;

/**
 * @author Xinyu Shi
 */
@Mapper
public interface TeamFinalStrategyMapper {

    /**
     * Select a 'Final'Strategy via id
     * @author Xinyu Shi
     * @param courseId
     * @return
     */
    @Select("select strategy_name, strategy_id from team_strategy where course_id =#{courseId} ")
    @Results({
            @Result(property = "strategyName", column = "strategy_name"),
            @Result(property = "strategyId", column = "strategy_id")
    })
    List<StrategyNameId> selectStratigiesById(String courseId);
}