package seminar.mapper.application;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.application.ShareTeamApplication;

import java.util.List;

/**
 * An automatic generated mapper for the entity ShareTeamApplication.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface ShareTeamApplicationMapper {
    /**
     * Insert a ShareTeamApplication entity
     *
     * @param shareTeamApplication the ShareTeamApplication entity that will be inserted
     */
    @Insert("insert into share_team_application(sub_course_teacher_id, main_course_id, sub_course_id) values(#{teacherId}, #{mainCourseId}, #{subCourseId})")
    @Options(useGeneratedKeys = true)
    void insertShareTeamApplication(ShareTeamApplication shareTeamApplication);

    /**
     * Update a ShareTeamApplication entity's information
     *
     * @param shareTeamApplication the ShareTeamApplication entity that will be updated via the id
     */
    @Update("update share_team_application set sub_course_teacher_id=#{teacherId}, main_course_id=#{mainCourseId}, sub_course_id=#{subCourseId} where id=#{id}")
    void updateShareTeamApplication(ShareTeamApplication shareTeamApplication);

    /**
     * Select all ShareTeamApplication entities
     *
     * @return List<shareTeamApplication> the selected ShareTeamApplication entities list
     */
    @Select("select * from share_team_application")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareTeamApplication> selectAllShareTeamApplication();

    /**
     * Select a ShareTeamApplication entity via teacherId
     *
     * @param teacherId the select gist
     * @return List<shareTeamApplication> the selected ShareTeamApplication entity as list
     */
    @Select("select * from share_team_application where sub_course_teacher_id=#{teacherId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareTeamApplication> selectShareTeamApplicationByTeacherId(String teacherId);

    /**
     * Select a ShareTeamApplication entity via mainCourseId
     *
     * @param mainCourseId the select gist
     * @return List<shareTeamApplication> the selected ShareTeamApplication entity as list
     */
    @Select("select * from share_team_application where main_course_id=#{mainCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareTeamApplication> selectShareTeamApplicationByMainCourseId(String mainCourseId);

    /**
     * Select a ShareTeamApplication entity via subCourseId
     *
     * @param subCourseId the select gist
     * @return List<shareTeamApplication> the selected ShareTeamApplication entity as list
     */
    @Select("select * from share_team_application where sub_course_id=#{subCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareTeamApplication> selectShareTeamApplicationBySubCourseId(String subCourseId);

    /**
     * Select a ShareTeamApplication entity via id
     *
     * @param id the select gist
     * @return List<shareTeamApplication> the selected ShareTeamApplication entity as list
     */
    @Select("select * from share_team_application where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareTeamApplication> selectShareTeamApplicationById(String id);

    /**
     * Select a ShareTeamApplication entity via union
     *
     * @param mainCourseId the select gist
     * @param subCourseId  the union gist
     * @return List<shareTeamApplication> the selected ShareTeamApplication entity as list
     */
    @Select("select * from share_team_application where main_course_id=#{mainCourseId} and sub_course_id=#{subCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareTeamApplication> selectShareTeamApplicationByMainCourseIdAndSubCourseId(@Param("mainCourseId") String mainCourseId, @Param("subCourseId") String subCourseId);

    /**
     * Delete a ShareTeamApplication entity via teacherId
     *
     * @param teacherId the select gist
     */
    @Delete("delete from share_team_application where sub_course_teacher_id=#{teacherId}")
    void deleteShareTeamApplicationByTeacherId(String teacherId);

    /**
     * Delete a ShareTeamApplication entity via mainCourseId
     *
     * @param mainCourseId the select gist
     */
    @Delete("delete from share_team_application where main_course_id=#{mainCourseId}")
    void deleteShareTeamApplicationByMainCourseId(String mainCourseId);

    /**
     * Delete a ShareTeamApplication entity via subCourseId
     *
     * @param subCourseId the select gist
     */
    @Delete("delete from share_team_application where sub_course_id=#{subCourseId}")
    void deleteShareTeamApplicationBySubCourseId(String subCourseId);

    /**
     * Delete a ShareTeamApplication entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from share_team_application where id=#{id}")
    void deleteShareTeamApplicationById(String id);

}
