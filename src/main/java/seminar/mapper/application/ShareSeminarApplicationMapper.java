package seminar.mapper.application;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.application.ShareSeminarApplication;

import java.util.List;

/**
 * An automatic generated mapper for the entity ShareSeminarApplication.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface ShareSeminarApplicationMapper {
    /**
     * Insert a ShareSeminarApplication entity
     *
     * @param shareSeminarApplication the ShareSeminarApplication entity that will be inserted
     */
    @Insert("insert into share_seminar_application(sub_course_teacher_id, main_course_id, sub_course_id) values(#{teacherId}, #{mainCourseId}, #{subCourseId})")
    @Options(useGeneratedKeys = true)
    void insertShareSeminarApplication(ShareSeminarApplication shareSeminarApplication);

    /**
     * Update a ShareSeminarApplication entity's information
     *
     * @param shareSeminarApplication the ShareSeminarApplication entity that will be updated via the id
     */
    @Update("update share_seminar_application set sub_course_teacher_id=#{teacherId}, main_course_id=#{mainCourseId}, sub_course_id=#{subCourseId} where id=#{id}")
    void updateShareSeminarApplication(ShareSeminarApplication shareSeminarApplication);

    /**
     * Select all ShareSeminarApplication entities
     *
     * @return List<shareSeminarApplication> the selected ShareSeminarApplication entities list
     */
    @Select("select * from share_seminar_application")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareSeminarApplication> selectAllShareSeminarApplication();

    /**
     * Select a ShareSeminarApplication entity via teacherId
     *
     * @param teacherId the select gist
     * @return List<shareSeminarApplication> the selected ShareSeminarApplication entity as list
     */
    @Select("select * from share_seminar_application where sub_course_teacher_id=#{teacherId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareSeminarApplication> selectShareSeminarApplicationByTeacherId(String teacherId);

    /**
     * Select a ShareSeminarApplication entity via mainCourseId
     *
     * @param mainCourseId the select gist
     * @return List<shareSeminarApplication> the selected ShareSeminarApplication entity as list
     */
    @Select("select * from share_seminar_application where main_course_id=#{mainCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareSeminarApplication> selectShareSeminarApplicationByMainCourseId(String mainCourseId);

    /**
     * Select a ShareSeminarApplication entity via subCourseId
     *
     * @param subCourseId the select gist
     * @return List<shareSeminarApplication> the selected ShareSeminarApplication entity as list
     */
    @Select("select * from share_seminar_application where sub_course_id=#{subCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareSeminarApplication> selectShareSeminarApplicationBySubCourseId(String subCourseId);

    /**
     * Select a ShareSeminarApplication entity via id
     *
     * @param id the select gist
     * @return List<shareSeminarApplication> the selected ShareSeminarApplication entity as list
     */
    @Select("select * from share_seminar_application where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareSeminarApplication> selectShareSeminarApplicationById(String id);

    /**
     * Select a ShareSeminarApplication entity via union
     *
     * @param mainCourseId the select gist
     * @param subCourseId  the union gist
     * @return List<shareSeminarApplication> the selected ShareSeminarApplication entity as list
     */
    @Select("select * from share_seminar_application where main_course_id=#{mainCourseId} and sub_course_id=#{subCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherId", column = "sub_course_teacher_id"),
            @Result(property = "mainCourseId", column = "main_course_id"),
            @Result(property = "subCourseId", column = "sub_course_id"),
            @Result(property = "mainCourse", column = "main_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY)),
            @Result(property = "subCourse", column = "sub_course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<ShareSeminarApplication> selectShareSeminarApplicationByMainCourseIdAndSubCourseId(@Param("mainCourseId") String mainCourseId, @Param("subCourseId") String subCourseId);

    /**
     * Delete a ShareSeminarApplication entity via teacherId
     *
     * @param teacherId the select gist
     */
    @Delete("delete from share_seminar_application where sub_course_teacher_id=#{teacherId}")
    void deleteShareSeminarApplicationByTeacherId(String teacherId);

    /**
     * Delete a ShareSeminarApplication entity via mainCourseId
     *
     * @param mainCourseId the select gist
     */
    @Delete("delete from share_seminar_application where main_course_id=#{mainCourseId}")
    void deleteShareSeminarApplicationByMainCourseId(String mainCourseId);

    /**
     * Delete a ShareSeminarApplication entity via subCourseId
     *
     * @param subCourseId the select gist
     */
    @Delete("delete from share_seminar_application where sub_course_id=#{subCourseId}")
    void deleteShareSeminarApplicationBySubCourseId(String subCourseId);

    /**
     * Delete a ShareSeminarApplication entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from share_seminar_application where id=#{id}")
    void deleteShareSeminarApplicationById(String id);

}
