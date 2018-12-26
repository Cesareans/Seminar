package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.entity.regulation.CourseMemberLimitStrategy;

import java.util.List;

/**
* An automatic generated mapper for the entity CourseMemberLimitStrategy. 
* This mapper is for a increment primary key table.
*
* @author Xinyu Shi
*/
@Mapper
public interface ConflictCourseStrategyMapper {


/**
* Select a CourseMemberLimitStrategy entity via id
*
* @param id the select gist
* @return List<courseMemberLimitStrategy> the selected CourseMemberLimitStrategy entity as list
*/
@Select("select *.course_id from course_conflict_strategy where id=#{id}")
List<String> selectConflictCoursesById(String id);


}
