package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import seminar.entity.CourseShareMsg;
import java.util.List;

/**
* An automatic generated mapper for the entity CourseShareMsg. 
* This mapper is for a increment primary key table.
*
* @author SWJ
*/
@Mapper
public interface CourseShareMsgMapper {
/**
* Insert a CourseShareMsg entity
*
* @param courseShareMsg the CourseShareMsg entity that will be inserted
*/
@Insert("insert into course_share_msg(content, teacher_id, principal_course_id, subordinate_course_id) values(#{content}, #{teacherId}, #{principalCourseId}, #{subordinateCourseId})")
void insertCourseShareMsg(CourseShareMsg courseShareMsg);

/**
* Update a CourseShareMsg entity's information
*
* @param courseShareMsg the CourseShareMsg entity that will be updated via the private java.lang.String seminar.entity.CourseShareMsg.id
*/
@Update("update course_share_msg set content=#{content}, teacher_id=#{teacherId}, principal_course_id=#{principalCourseId}, subordinate_course_id=#{subordinateCourseId} where id=#{id}")
void updateCourseShareMsg(CourseShareMsg courseShareMsg);

/**
* Select all CourseShareMsg entities
*
* @return List<courseShareMsg> the selected CourseShareMsg entities list
*/
@Select("select * from course_share_msg")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<CourseShareMsg> selectAllCourseShareMsg();

/**
* Select a CourseShareMsg entity via teacherId
*
* @param teacherId the select gist
* @return List<courseShareMsg> the selected CourseShareMsg entity as list
*/
@Select("select * from course_share_msg where teacher_id=#{teacherId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<CourseShareMsg> selectCourseShareMsgByTeacherId(String teacherId);

/**
* Select a CourseShareMsg entity via principalCourseId
*
* @param principalCourseId the select gist
* @return List<courseShareMsg> the selected CourseShareMsg entity as list
*/
@Select("select * from course_share_msg where principal_course_id=#{principalCourseId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<CourseShareMsg> selectCourseShareMsgByPrincipalCourseId(String principalCourseId);

/**
* Select a CourseShareMsg entity via subordinateCourseId
*
* @param subordinateCourseId the select gist
* @return List<courseShareMsg> the selected CourseShareMsg entity as list
*/
@Select("select * from course_share_msg where subordinate_course_id=#{subordinateCourseId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<CourseShareMsg> selectCourseShareMsgBySubordinateCourseId(String subordinateCourseId);

/**
* Select a CourseShareMsg entity via id
*
* @param id the select gist
* @return List<courseShareMsg> the selected CourseShareMsg entity as list
*/
@Select("select * from course_share_msg where id=#{id}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "content", column = "content"),
@Result(property = "teacherId", column = "teacher_id"),
@Result(property = "principalCourseId", column = "principal_course_id"),
@Result(property = "subordinateCourseId", column = "subordinate_course_id")
})
List<CourseShareMsg> selectCourseShareMsgById(String id);

/**
* Delete a CourseShareMsg entity via private java.lang.String seminar.entity.CourseShareMsg.teacherId
*
* @param teacherId the select gist
*/
@Delete("delete from course_share_msg where teacher_id=#{teacherId}")
void deleteCourseShareMsgByTeacherId(String teacherId);

/**
* Delete a CourseShareMsg entity via private java.lang.String seminar.entity.CourseShareMsg.principalCourseId
*
* @param principalCourseId the select gist
*/
@Delete("delete from course_share_msg where principal_course_id=#{principalCourseId}")
void deleteCourseShareMsgByPrincipalCourseId(String principalCourseId);

/**
* Delete a CourseShareMsg entity via private java.lang.String seminar.entity.CourseShareMsg.subordinateCourseId
*
* @param subordinateCourseId the select gist
*/
@Delete("delete from course_share_msg where subordinate_course_id=#{subordinateCourseId}")
void deleteCourseShareMsgBySubordinateCourseId(String subordinateCourseId);

/**
* Delete a CourseShareMsg entity via private java.lang.String seminar.entity.CourseShareMsg.id
*
* @param id the select gist
*/
@Delete("delete from course_share_msg where id=#{id}")
void deleteCourseShareMsgById(String id);

}
