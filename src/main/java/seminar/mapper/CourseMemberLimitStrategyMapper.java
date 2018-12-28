package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import seminar.entity.regulation.CourseMemberLimitStrategy;
import java.util.List;

/**
* An automatic generated mapper for the entity CourseMemberLimitStrategy. 
* This mapper is for a increment primary key table.
*
* @author Xinyu Shi
*/
@Mapper
public interface CourseMemberLimitStrategyMapper {
/**
* Insert a CourseMemberLimitStrategy entity
*
* @param courseMemberLimitStrategy the CourseMemberLimitStrategy entity that will be inserted
*/
@Insert("insert into course_member_limit_strategy(min, max, course_id) values(#{min}, #{max}, #{courseId})")
@Options(useGeneratedKeys = true)
void insertCourseMemberLimitStrategy(CourseMemberLimitStrategy courseMemberLimitStrategy);

/**
* Update a CourseMemberLimitStrategy entity's information
*
* @param courseMemberLimitStrategy the CourseMemberLimitStrategy entity that will be updated via the id
*/
@Update("update course_member_limit_strategy set min=#{min}, max=#{max}, course_id=#{courseId} where id=#{id}")
void updateCourseMemberLimitStrategy(CourseMemberLimitStrategy courseMemberLimitStrategy);

/**
* Select all CourseMemberLimitStrategy entities
*
* @return List<courseMemberLimitStrategy> the selected CourseMemberLimitStrategy entities list
*/
@Select("select * from course_member_limit_strategy")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "min", column = "min"),
@Result(property = "max", column = "max"),
@Result(property = "courseId", column = "course_id")
})
List<CourseMemberLimitStrategy> selectAllCourseMemberLimitStrategy();

/**
* Select a CourseMemberLimitStrategy entity via courseId
*
* @param courseId the select gist
* @return List<courseMemberLimitStrategy> the selected CourseMemberLimitStrategy entity as list
*/
@Select("select * from course_member_limit_strategy where course_id=#{courseId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "min", column = "min"),
@Result(property = "max", column = "max"),
@Result(property = "courseId", column = "course_id")
})
List<CourseMemberLimitStrategy> selectCourseMemberLimitStrategyByCourseId(String courseId);

/**
* Select a CourseMemberLimitStrategy entity via id
*
* @param id the select gist
* @return List<courseMemberLimitStrategy> the selected CourseMemberLimitStrategy entity as list
*/
@Select("select * from course_member_limit_strategy where id=#{id}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "min", column = "min"),
@Result(property = "max", column = "max"),
@Result(property = "courseId", column = "course_id")
})
List<CourseMemberLimitStrategy> selectCourseMemberLimitStrategyById(String id);

/**
* Delete a CourseMemberLimitStrategy entity via courseId
*
* @param courseId the select gist
*/
@Delete("delete from course_member_limit_strategy where course_id=#{courseId}")
void deleteCourseMemberLimitStrategyByCourseId(String courseId);

/**
* Delete a CourseMemberLimitStrategy entity via id
*
* @param id the select gist
*/
@Delete("delete from course_member_limit_strategy where id=#{id}")
void deleteCourseMemberLimitStrategyById(String id);

}
