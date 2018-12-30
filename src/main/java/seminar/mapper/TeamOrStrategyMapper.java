package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.StrategyNameId;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@Mapper
public interface TeamOrStrategyMapper {

    /**
     * Select a 'And'Strategy via id
     *
     * @param id the select gist
     * @return
     * @author Xinyu Shi
     */
    @Select("select strategy_name,strategy_id from team_or_strategy where id =#{id} ")
    @Results({
            @Result(property = "strategyName", column = "strategy_name"),
            @Result(property = "strategyId", column = "strategy_id")
    })
    List<StrategyNameId> selectStrategiesById(String id);

    /**
     * allocate one id
     *
     * @return
     * @author Xinyu Shi
     */
    @Select("select ifnull(max(id)+1,1) from team_or_strategy")
    String allocateId();

    /**
     * insert single record into team_and_strategy table.
     *
     * @param id
     * @param strategyName
     * @param strategyId
     * @author Xinyu Shi
     */
    @Insert("insert into team_or_strategy(id, strategy_name,strategy_id) values(#{id}, #{strategyName},#{strategyId})")
    void insertSingleTeamOrStrategy(@Param("id") String id, @Param("strategyName") String strategyName, @Param("strategyId") String strategyId);
}