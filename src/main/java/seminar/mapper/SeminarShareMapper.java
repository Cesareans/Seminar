package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.share.SeminarShare;

import java.util.List;

/**
 * An automatic generated mapper for the entity SeminarShare.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface SeminarShareMapper {
    /**
     * Insert a SeminarShare entity
     *
     * @param seminarShare the SeminarShare entity that will be inserted
     */
    @Insert("insert into seminar_share(principal_course_id, subordinate_course_id) values(#{principalCourseId}, #{subordinateCourseId})")
    void insertSeminarShare(SeminarShare seminarShare);

    /**
     * Update a SeminarShare entity's information
     *
     * @param seminarShare the SeminarShare entity that will be updated via the id
     */
    @Update("update seminar_share set principal_course_id=#{principalCourseId}, subordinate_course_id=#{subordinateCourseId} where id=#{id}")
    void updateSeminarShare(SeminarShare seminarShare);

    /**
     * Select all SeminarShare entities
     *
     * @return List<seminarShare> the selected SeminarShare entities list
     */
    @Select("select * from seminar_share")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShare> selectAllSeminarShare();

    /**
     * Select a SeminarShare entity via principalCourseId
     *
     * @param principalCourseId the select gist
     * @return List<seminarShare> the selected SeminarShare entity as list
     */
    @Select("select * from seminar_share where principal_course_id=#{principalCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShare> selectSeminarShareByPrincipalCourseId(String principalCourseId);

    /**
     * Select a SeminarShare entity via subordinateCourseId
     *
     * @param subordinateCourseId the select gist
     * @return List<seminarShare> the selected SeminarShare entity as list
     */
    @Select("select * from seminar_share where subordinate_course_id=#{subordinateCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShare> selectSeminarShareBySubordinateCourseId(String subordinateCourseId);

    /**
     * Select a SeminarShare entity via id
     *
     * @param id the select gist
     * @return List<seminarShare> the selected SeminarShare entity as list
     */
    @Select("select * from seminar_share where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "principalCourseId", column = "principal_course_id"),
            @Result(property = "subordinateCourseId", column = "subordinate_course_id")
    })
    List<SeminarShare> selectSeminarShareById(String id);

    /**
     * Delete a SeminarShare entity via principalCourseId
     *
     * @param principalCourseId the select gist
     */
    @Delete("delete from seminar_share where principal_course_id=#{principalCourseId}")
    void deleteSeminarShareByPrincipalCourseId(String principalCourseId);

    /**
     * Delete a SeminarShare entity via subordinateCourseId
     *
     * @param subordinateCourseId the select gist
     */
    @Delete("delete from seminar_share where subordinate_course_id=#{subordinateCourseId}")
    void deleteSeminarShareBySubordinateCourseId(String subordinateCourseId);

    /**
     * Delete a SeminarShare entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from seminar_share where id=#{id}")
    void deleteSeminarShareById(String id);

}
