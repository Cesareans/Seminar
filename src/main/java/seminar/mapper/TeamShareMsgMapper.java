package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.message.TeamShareMsg;

import java.util.List;

/**
 * An automatic generated mapper for the entity TeamShareMsg.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface TeamShareMsgMapper {
    /**
     * Insert a TeamShareMsg entity
     *
     * @param teamShareMsg the TeamShareMsg entity that will be inserted
     */
    @Insert("insert into team_share_msg(content, teacher_id, principal_course_id, subordinate_course_id) values(#{content}, #{teacherId}, #{principalCourseId}, #{subordinateCourseId})")
    @Options(useGeneratedKeys = true)
    void insertTeamShareMsg(TeamShareMsg teamShareMsg);

    /**
     * Update a TeamShareMsg entity's information
     *
     * @param teamShareMsg the TeamShareMsg entity that will be updated via the id
     */
    @Update("update team_share_msg set content=#{content}, teacher_id=#{teacherId}, principal_course_id=#{principalCourseId}, subordinate_course_id=#{subordinateCourseId} where id=#{id}")
    void updateTeamShareMsg(TeamShareMsg teamShareMsg);

    /**
     * Select all TeamShareMsg entities
     *
     * @return List<teamShareMsg> the selected TeamShareMsg entities list
     */
    @Select("select * from team_share_msg")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<TeamShareMsg> selectAllTeamShareMsg();

    /**
     * Select a TeamShareMsg entity via teacherId
     *
     * @param teacherId the select gist
     * @return List<teamShareMsg> the selected TeamShareMsg entity as list
     */
    @Select("select * from team_share_msg where teacher_id=#{teacherId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<TeamShareMsg> selectTeamShareMsgByTeacherId(String teacherId);

    /**
     * Select a TeamShareMsg entity via principalCourseId
     *
     * @param principalCourseId the select gist
     * @return List<teamShareMsg> the selected TeamShareMsg entity as list
     */
    @Select("select * from team_share_msg where principal_course_id=#{principalCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<TeamShareMsg> selectTeamShareMsgByPrincipalCourseId(String principalCourseId);

    /**
     * Select a TeamShareMsg entity via subordinateCourseId
     *
     * @param subordinateCourseId the select gist
     * @return List<teamShareMsg> the selected TeamShareMsg entity as list
     */
    @Select("select * from team_share_msg where subordinate_course_id=#{subordinateCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<TeamShareMsg> selectTeamShareMsgBySubordinateCourseId(String subordinateCourseId);

    /**
     * Select a TeamShareMsg entity via id
     *
     * @param id the select gist
     * @return List<teamShareMsg> the selected TeamShareMsg entity as list
     */
    @Select("select * from team_share_msg where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<TeamShareMsg> selectTeamShareMsgById(String id);

    /**
     * Delete a TeamShareMsg entity via teacherId
     *
     * @param teacherId the select gist
     */
    @Delete("delete from team_share_msg where teacher_id=#{teacherId}")
    void deleteTeamShareMsgByTeacherId(String teacherId);

    /**
     * Delete a TeamShareMsg entity via principalCourseId
     *
     * @param principalCourseId the select gist
     */
    @Delete("delete from team_share_msg where principal_course_id=#{principalCourseId}")
    void deleteTeamShareMsgByPrincipalCourseId(String principalCourseId);

    /**
     * Delete a TeamShareMsg entity via subordinateCourseId
     *
     * @param subordinateCourseId the select gist
     */
    @Delete("delete from team_share_msg where subordinate_course_id=#{subordinateCourseId}")
    void deleteTeamShareMsgBySubordinateCourseId(String subordinateCourseId);

    /**
     * Delete a TeamShareMsg entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from team_share_msg where id=#{id}")
    void deleteTeamShareMsgById(String id);

}
