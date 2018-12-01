package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.QuestionPool;

import java.util.List;

/**
 * An automatic generated mapper for the entity QuestionPool.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface QuestionPoolMapper {
    /**
     * Insert a QuestionPool entity
     *
     * @param questionPool the QuestionPool entity that will be inserted
     */
    @Insert("insert into question_pool(clbum_seminar_id, team_id, student_id) values(#{clbumSeminarId}, #{teamId}, #{studentId})")
    void insertQuestionPool(QuestionPool questionPool);

    /**
     * Update a QuestionPool entity's information
     *
     * @param questionPool the QuestionPool entity that will be updated via the private java.lang.String seminar.entity.QuestionPool.id
     */
    @Update("update question_pool set clbum_seminar_id=#{clbumSeminarId}, team_id=#{teamId}, student_id=#{studentId} where id=#{id}")
    void updateQuestionPool(QuestionPool questionPool);

    /**
     * Select all QuestionPool entities
     *
     * @return List<questionPool> the selected QuestionPool entities list
     */
    @Select("select * from question_pool")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumSeminarId", column = "clbum_seminar_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<QuestionPool> selectAllQuestionPool();

    /**
     * Select a QuestionPool entity via clbumSeminarId
     *
     * @param clbumSeminarId the select gist
     * @return List<questionPool> the selected QuestionPool entity as list
     */
    @Select("select * from question_pool where clbum_seminar_id=#{clbumSeminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumSeminarId", column = "clbum_seminar_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<QuestionPool> selectQuestionPoolByClbumSeminarId(String clbumSeminarId);

    /**
     * Select a QuestionPool entity via teamId
     *
     * @param teamId the select gist
     * @return List<questionPool> the selected QuestionPool entity as list
     */
    @Select("select * from question_pool where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumSeminarId", column = "clbum_seminar_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<QuestionPool> selectQuestionPoolByTeamId(String teamId);

    /**
     * Select a QuestionPool entity via studentId
     *
     * @param studentId the select gist
     * @return List<questionPool> the selected QuestionPool entity as list
     */
    @Select("select * from question_pool where student_id=#{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumSeminarId", column = "clbum_seminar_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<QuestionPool> selectQuestionPoolByStudentId(String studentId);

    /**
     * Select a QuestionPool entity via id
     *
     * @param id the select gist
     * @return List<questionPool> the selected QuestionPool entity as list
     */
    @Select("select * from question_pool where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumSeminarId", column = "clbum_seminar_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<QuestionPool> selectQuestionPoolById(String id);

    /**
     * Delete a QuestionPool entity via private java.lang.String seminar.entity.QuestionPool.clbumSeminarId
     *
     * @param clbumSeminarId the select gist
     */
    @Delete("delete from question_pool where clbum_seminar_id=#{clbumSeminarId}")
    void deleteQuestionPoolByClbumSeminarId(String clbumSeminarId);

    /**
     * Delete a QuestionPool entity via private java.lang.String seminar.entity.QuestionPool.teamId
     *
     * @param teamId the select gist
     */
    @Delete("delete from question_pool where team_id=#{teamId}")
    void deleteQuestionPoolByTeamId(String teamId);

    /**
     * Delete a QuestionPool entity via private java.lang.String seminar.entity.QuestionPool.studentId
     *
     * @param studentId the select gist
     */
    @Delete("delete from question_pool where student_id=#{studentId}")
    void deleteQuestionPoolByStudentId(String studentId);

    /**
     * Delete a QuestionPool entity via private java.lang.String seminar.entity.QuestionPool.id
     *
     * @param id the select gist
     */
    @Delete("delete from question_pool where id=#{id}")
    void deleteQuestionPoolById(String id);

}
