package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.message.SeminarShareMsg;

import java.util.List;

/**
 * An automatic generated mapper for the entity SeminarShareMsg.
 * This mapper is for a increment primary key table.
 *
 * @author SWJ
 */
@Mapper
public interface SeminarShareMsgMapper {
    /**
     * Insert a SeminarShareMsg entity
     *
     * @param seminarShareMsg the SeminarShareMsg entity that will be inserted
     */
    @Insert("insert into seminar_share_msg(content, teacher_id, principal_course_id, subordinate_course_id) values(#{content}, #{teacherId}, #{principalCourseId}, #{subordinateCourseId})")
    void insertSeminarShareMsg(SeminarShareMsg seminarShareMsg);

    /**
     * Update a SeminarShareMsg entity's information
     *
     * @param seminarShareMsg the SeminarShareMsg entity that will be updated via the private java.lang.String seminar.entity.SeminarShareMsg.id
     */
    @Update("update seminar_share_msg set content=#{content}, teacher_id=#{teacherId}, principal_course_id=#{principalCourseId}, subordinate_course_id=#{subordinateCourseId} where id=#{id}")
    void updateSeminarShareMsg(SeminarShareMsg seminarShareMsg);

    /**
     * Select all SeminarShareMsg entities
     *
     * @return List<seminarShareMsg> the selected SeminarShareMsg entities list
     */
    @Select("select * from seminar_share_msg")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShareMsg> selectAllSeminarShareMsg();

    /**
     * Select a SeminarShareMsg entity via teacherId
     *
     * @param teacherId the select gist
     * @return List<seminarShareMsg> the selected SeminarShareMsg entity as list
     */
    @Select("select * from seminar_share_msg where teacher_id=#{teacherId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShareMsg> selectSeminarShareMsgByTeacherId(String teacherId);

    /**
     * Select a SeminarShareMsg entity via principalCourseId
     *
     * @param principalCourseId the select gist
     * @return List<seminarShareMsg> the selected SeminarShareMsg entity as list
     */
    @Select("select * from seminar_share_msg where principal_course_id=#{principalCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShareMsg> selectSeminarShareMsgByPrincipalCourseId(String principalCourseId);

    /**
     * Select a SeminarShareMsg entity via subordinateCourseId
     *
     * @param subordinateCourseId the select gist
     * @return List<seminarShareMsg> the selected SeminarShareMsg entity as list
     */
    @Select("select * from seminar_share_msg where subordinate_course_id=#{subordinateCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShareMsg> selectSeminarShareMsgBySubordinateCourseId(String subordinateCourseId);

    /**
     * Select a SeminarShareMsg entity via id
     *
     * @param id the select gist
     * @return List<seminarShareMsg> the selected SeminarShareMsg entity as list
     */
    @Select("select * from seminar_share_msg where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "content"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShareMsg> selectSeminarShareMsgById(String id);

    /**
     * Delete a SeminarShareMsg entity via private java.lang.String seminar.entity.SeminarShareMsg.teacherId
     *
     * @param teacherId the select gist
     */
    @Delete("delete from seminar_share_msg where teacher_id=#{teacherId}")
    void deleteSeminarShareMsgByTeacherId(String teacherId);

    /**
     * Delete a SeminarShareMsg entity via private java.lang.String seminar.entity.SeminarShareMsg.principalCourseId
     *
     * @param principalCourseId the select gist
     */
    @Delete("delete from seminar_share_msg where principal_course_id=#{principalCourseId}")
    void deleteSeminarShareMsgByPrincipalCourseId(String principalCourseId);

    /**
     * Delete a SeminarShareMsg entity via private java.lang.String seminar.entity.SeminarShareMsg.subordinateCourseId
     *
     * @param subordinateCourseId the select gist
     */
    @Delete("delete from seminar_share_msg where subordinate_course_id=#{subordinateCourseId}")
    void deleteSeminarShareMsgBySubordinateCourseId(String subordinateCourseId);

    /**
     * Delete a SeminarShareMsg entity via private java.lang.String seminar.entity.SeminarShareMsg.id
     *
     * @param id the select gist
     */
    @Delete("delete from seminar_share_msg where id=#{id}")
    void deleteSeminarShareMsgById(String id);

}
