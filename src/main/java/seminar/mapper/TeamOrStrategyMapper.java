package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.StrategyNameId;

import java.util.List;
import java.util.Map;

/**
 * @author Xinyu Shi
 */
@Mapper
public interface TeamOrStrategyMapper {

    /**
     *
     * Select a 'And'Strategy via id
     * @author Xinyu Shi
     * @param id the select gist
     * @return
     */
    @Select("select strategy_name,strategy_id from team_or_strategy where id =#{id} ")
    @Results({
            @Result(property = "strategyName", column = "strategy_name"),
            @Result(property = "strategyId", column = "strategy_id")
    })
    List<StrategyNameId> selectStrategiesById(String id);

    /**
     * allocate one id
     * @author Xinyu Shi
     * @return
     */
    @Select("select ifnull(max(id)+1,1) from team_or_strategy")
    String allocateId();

    /**
     * insert single record into team_and_strategy table.
     * @author Xinyu Shi
     * @param id
     * @param strategyName
     * @param strategyId
     */
    @Insert("insert into team_or_strategy(id, strategy_name,strategy_id) values(#{id}, #{strategyName},#{strategyId})")
    void insertSingleTeamOrStrategy(@Param("id") String id, @Param("strategyName") String strategyName, @Param("strategyId") String strategyId);
}