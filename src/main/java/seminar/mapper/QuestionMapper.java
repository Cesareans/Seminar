package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Question;

import java.util.List;

/**
 * An automatic generated mapper for the entity Question.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface QuestionMapper {
    /**
     * Insert a Question entity
     *
     * @param question the Question entity that will be inserted
     */
    @Insert("insert into question(que_score, team_id, student_id, attendance_id) values(#{queScore}, #{teamId}, #{studentId}, #{attendanceId})")
    void insertQuestion(Question question);

    /**
     * Update a Question entity's information
     *
     * @param question the Question entity that will be updated via the private java.lang.String seminar.entity.Question.id
     */
    @Update("update question set que_score=#{queScore}, team_id=#{teamId}, student_id=#{studentId}, attendance_id=#{attendanceId} where id=#{id}")
    void updateQuestion(Question question);

    /**
     * Select all Question entities
     *
     * @return List<question> the selected Question entities list
     */
    @Select("select * from question")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "queScore", column = "que_score"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "attendanceId", column = "attendance_id")
    })
    List<Question> selectAllQuestion();

    /**
     * Select a Question entity via teamId
     *
     * @param teamId the select gist
     * @return List<question> the selected Question entity as list
     */
    @Select("select * from question where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "queScore", column = "que_score"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "attendanceId", column = "attendance_id")
    })
    List<Question> selectQuestionByTeamId(String teamId);

    /**
     * Select a Question entity via studentId
     *
     * @param studentId the select gist
     * @return List<question> the selected Question entity as list
     */
    @Select("select * from question where student_id=#{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "queScore", column = "que_score"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "attendanceId", column = "attendance_id")
    })
    List<Question> selectQuestionByStudentId(String studentId);

    /**
     * Select a Question entity via attendanceId
     *
     * @param attendanceId the select gist
     * @return List<question> the selected Question entity as list
     */
    @Select("select * from question where attendance_id=#{attendanceId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "queScore", column = "que_score"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "attendanceId", column = "attendance_id")
    })
    List<Question> selectQuestionByAttendanceId(String attendanceId);

    /**
     * Select a Question entity via id
     *
     * @param id the select gist
     * @return List<question> the selected Question entity as list
     */
    @Select("select * from question where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "queScore", column = "que_score"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "attendanceId", column = "attendance_id")
    })
    List<Question> selectQuestionById(String id);

    /**
     * Delete a Question entity via private java.lang.String seminar.entity.Question.teamId
     *
     * @param teamId the select gist
     */
    @Delete("delete from question where team_id=#{teamId}")
    void deleteQuestionByTeamId(String teamId);

    /**
     * Delete a Question entity via private java.lang.String seminar.entity.Question.studentId
     *
     * @param studentId the select gist
     */
    @Delete("delete from question where student_id=#{studentId}")
    void deleteQuestionByStudentId(String studentId);

    /**
     * Delete a Question entity via private java.lang.String seminar.entity.Question.attendanceId
     *
     * @param attendanceId the select gist
     */
    @Delete("delete from question where attendance_id=#{attendanceId}")
    void deleteQuestionByAttendanceId(String attendanceId);

    /**
     * Delete a Question entity via private java.lang.String seminar.entity.Question.id
     *
     * @param id the select gist
     */
    @Delete("delete from question where id=#{id}")
    void deleteQuestionById(String id);

}
