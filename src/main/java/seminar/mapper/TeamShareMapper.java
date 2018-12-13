package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import seminar.entity.share.TeamShare;
import java.util.List;

/**
* An automatic generated mapper for the entity TeamShare. 
* This mapper is for a increment primary key table.
*
* @author Cesare
*/
@Mapper
public interface TeamShareMapper {
/**
* Insert a TeamShare entity
*
* @param teamShare the TeamShare entity that will be inserted
*/
@Insert("insert into team_share(principal_course_id, subordinate_course_id) values(#{principalCourseId}, #{subordinateCourseId})")
void insertTeamShare(TeamShare teamShare);

/**
* Update a TeamShare entity's information
*
* @param teamShare the TeamShare entity that will be updated via the id
*/
@Update("update team_share set principal_course_id=#{principalCourseId}, subordinate_course_id=#{subordinateCourseId} where id=#{id}")
void updateTeamShare(TeamShare teamShare);

/**
* Select all TeamShare entities
*
* @return List<teamShare> the selected TeamShare entities list
*/
@Select("select * from team_share")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<TeamShare> selectAllTeamShare();

/**
* Select a TeamShare entity via principalCourseId
*
* @param principalCourseId the select gist
* @return List<teamShare> the selected TeamShare entity as list
*/
@Select("select * from team_share where principal_course_id=#{principalCourseId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<TeamShare> selectTeamShareByPrincipalCourseId(String principalCourseId);

/**
* Select a TeamShare entity via subordinateCourseId
*
* @param subordinateCourseId the select gist
* @return List<teamShare> the selected TeamShare entity as list
*/
@Select("select * from team_share where subordinate_course_id=#{subordinateCourseId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<TeamShare> selectTeamShareBySubordinateCourseId(String subordinateCourseId);

/**
* Select a TeamShare entity via id
*
* @param id the select gist
* @return List<teamShare> the selected TeamShare entity as list
*/
@Select("select * from team_share where id=#{id}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<TeamShare> selectTeamShareById(String id);

/**
* Delete a TeamShare entity via principalCourseId
*
* @param principalCourseId the select gist
*/
@Delete("delete from team_share where principal_course_id=#{principalCourseId}")
void deleteTeamShareByPrincipalCourseId(String principalCourseId);

/**
* Delete a TeamShare entity via subordinateCourseId
*
* @param subordinateCourseId the select gist
*/
@Delete("delete from team_share where subordinate_course_id=#{subordinateCourseId}")
void deleteTeamShareBySubordinateCourseId(String subordinateCourseId);

/**
* Delete a TeamShare entity via id
*
* @param id the select gist
*/
@Delete("delete from team_share where id=#{id}")
void deleteTeamShareById(String id);

}
