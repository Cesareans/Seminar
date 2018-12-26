package seminar.strategy.mapper;

import org.apache.ibatis.annotations.*;

import seminar.entity.strategy.ConflictCourseStrategy;
import java.util.List;

/**
 * An automatic generated mapper for the entity ConflictCourseStrategy.
 * This mapper is for a increment primary key table.
 *
 * @author Xinyu Shi
 */
@Mapper
public interface ConflictCourseStrategyMapper {
    /**
     * Insert a ConflictCourseStrategy entity
     *
     * @param conflictCourseStrategy the ConflictCourseStrategy entity that will be inserted
     */
    @Insert("insert into conflict_course_strategy(conflict_boundary, conflict_courses) values(#{CONFLICT_BOUNDARY}, #{conflictCourses})")
    void insertConflictCourseStrategy(ConflictCourseStrategy conflictCourseStrategy);

    /**
     * Update a ConflictCourseStrategy entity's information
     *
     * @param conflictCourseStrategy the ConflictCourseStrategy entity that will be updated via the id
     */
    @Update("update conflict_course_strategy set conflict_boundary=#{CONFLICT_BOUNDARY}, conflict_courses=#{conflictCourses} where id=#{id}")
    void updateConflictCourseStrategy(ConflictCourseStrategy conflictCourseStrategy);

    /**
     * Select all ConflictCourseStrategy entities
     *
     * @return List<conflictCourseStrategy> the selected ConflictCourseStrategy entities list
     */
    @Select("select * from conflict_course_strategy")
    @Results({
            @Result(property = "CONFLICT_BOUNDARY", column = "conflict_boundary"),
            @Result(property = "id", column = "id", id = true),
            @Result(property = "conflictCourses", column = "conflict_courses")
    })
    List<ConflictCourseStrategy> selectAllConflictCourseStrategy();

    /**
     * Select a ConflictCourseStrategy entity via id
     *
     * @param id the select gist
     * @return List<conflictCourseStrategy> the selected ConflictCourseStrategy entity as list
     */
    @Select("select * from conflict_course_strategy where id=#{id}")
    @Results({
            @Result(property = "CONFLICT_BOUNDARY", column = "conflict_boundary"),
            @Result(property = "id", column = "id", id = true),
            @Result(property = "conflictCourses", column = "conflict_courses")
    })
    List<ConflictCourseStrategy> selectConflictCourseStrategyById(String id);

    /**
     * Delete a ConflictCourseStrategy entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from conflict_course_strategy where id=#{id}")
    void deleteConflictCourseStrategyById(String id);

}
