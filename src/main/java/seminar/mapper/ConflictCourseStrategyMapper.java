package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.ConflictCourseStrategy;

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
     * Select a ConflictCourseStrategy entity via id
     *
     * @param id the select gist
     * @return List<conflictCourseStrategy> the selected ConflictCourseStrategy entity as list
     */
    @Select("select course_id from conflict_course_strategy where id=#{id}")
    List<String> selectConflictCoursesById(String id);


}