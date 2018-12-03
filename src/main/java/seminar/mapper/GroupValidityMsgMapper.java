package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import seminar.entity.GroupValidityMsg;
import java.util.List;

/**
* An automatic generated mapper for the entity GroupValidityMsg. 
* This mapper is for a increment primary key table.
*
* @author SWJ
*/
@Mapper
public interface GroupValidityMsgMapper {
/**
* Insert a GroupValidityMsg entity
*
* @param groupValidityMsg the GroupValidityMsg entity that will be inserted
*/
@Insert("insert into group_validity_msg(content, teacher_id, team_id) values(#{content}, #{teacherId}, #{teamId})")
void insertGroupValidityMsg(GroupValidityMsg groupValidityMsg);

/**
* Update a GroupValidityMsg entity's information
*
* @param groupValidityMsg the GroupValidityMsg entity that will be updated via the private java.lang.String seminar.entity.GroupValidityMsg.id
*/
@Update("update group_validity_msg set content=#{content}, teacher_id=#{teacherId}, team_id=#{teamId} where id=#{id}")
void updateGroupValidityMsg(GroupValidityMsg groupValidityMsg);

/**
* Select all GroupValidityMsg entities
*
* @return List<groupValidityMsg> the selected GroupValidityMsg entities list
*/
@Select("select * from group_validity_msg")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "teamId", column = "team_id")
})
List<GroupValidityMsg> selectAllGroupValidityMsg();

/**
* Select a GroupValidityMsg entity via teacherId
*
* @param teacherId the select gist
* @return List<groupValidityMsg> the selected GroupValidityMsg entity as list
*/
@Select("select * from group_validity_msg where teacher_id=#{teacherId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "teamId", column = "team_id")
})
List<GroupValidityMsg> selectGroupValidityMsgByTeacherId(String teacherId);

/**
* Select a GroupValidityMsg entity via teamId
*
* @param teamId the select gist
* @return List<groupValidityMsg> the selected GroupValidityMsg entity as list
*/
@Select("select * from group_validity_msg where team_id=#{teamId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "teamId", column = "team_id")
})
List<GroupValidityMsg> selectGroupValidityMsgByTeamId(String teamId);

/**
* Select a GroupValidityMsg entity via id
*
* @param id the select gist
* @return List<groupValidityMsg> the selected GroupValidityMsg entity as list
*/
@Select("select * from group_validity_msg where id=#{id}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "teamId", column = "team_id")
})
List<GroupValidityMsg> selectGroupValidityMsgById(String id);

/**
* Delete a GroupValidityMsg entity via private java.lang.String seminar.entity.GroupValidityMsg.teacherId
*
* @param teacherId the select gist
*/
@Delete("delete from group_validity_msg where teacher_id=#{teacherId}")
void deleteGroupValidityMsgByTeacherId(String teacherId);

/**
* Delete a GroupValidityMsg entity via private java.lang.String seminar.entity.GroupValidityMsg.teamId
*
* @param teamId the select gist
*/
@Delete("delete from group_validity_msg where team_id=#{teamId}")
void deleteGroupValidityMsgByTeamId(String teamId);

/**
* Delete a GroupValidityMsg entity via private java.lang.String seminar.entity.GroupValidityMsg.id
*
* @param id the select gist
*/
@Delete("delete from group_validity_msg where id=#{id}")
void deleteGroupValidityMsgById(String id);

}
