package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.StrategyNameId;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@Mapper
public interface TeamFinalStrategyMapper {

    /**
     * Select a 'Final'Strategy via id
     *
     * @param courseId
     * @return
     * @author Xinyu Shi
     */
    @Select("select strategy_name, strategy_id from team_strategy where course_id =#{courseId} ")
    @Results({
            @Result(property = "strategyName", column = "strategy_name"),
            @Result(property = "strategyId", column = "strategy_id")
    })
    List<StrategyNameId> selectStrategiesById(String courseId);

    /**
     * allocate one id
     *
     * @param courseId
     * @return String
     * @author Xinyu Shi
     */
    @Select("select ifnull(max(strategy_serial)+1,1) from team_strategy where course_id=#{courseId}")
    String allocateStrategySerial(String courseId);

    /**
     * insert record into team_strategy table
     *
     * @param courseId
     * @param strategySerial
     * @param strategyName
     * @param strategyId
     * @author Xinyu Shi
     */
    @Insert("insert into team_strategy(course_id, strategy_serial, strategy_name,strategy_id) values(#{courseId}, #{strategySerial},#{strategyName},#{strategyId})")
    void insertSingleTeamAndStrategy(@Param("courseId") String courseId, @Param("strategySerial") String strategySerial, @Param("strategyName") String strategyName, @Param("strategyId") String strategyId);
}