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
    List<StrategyNameId> selectStrategiesById(String courseId);

    /**
     * allocate one id
     * @author Xinyu Shi
     * @param courseId
     * @return String
     */
    @Select("select ifnull(max(strategy_serial)+1,1) from team_strategy where course_id=#{courseId}")
    String allocateStrategySerial(String courseId);

    /**
     * insert record into team_strategy table
     * @author Xinyu Shi
     * @param courseId
     * @param strategySerial
     * @param strategyName
     * @param strategyId
     */
    @Insert("insert into team_strategy(course_id, strategy_serial, strategy_name,strategy_id) values(#{courseId}, #{strategySerial},#{strategyName},#{strategyId})")
    void insertSingleTeamAndStrategy(@Param("courseId") String courseId, @Param("strategySerial") String strategySerial, @Param("strategyName") String strategyName,@Param("strategyId") String strategyId);
}