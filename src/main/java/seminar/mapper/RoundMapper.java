package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.Round;

import java.util.List;

/**
 * An automatic generated mapper for the entity Round.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface RoundMapper {
    /**
     * Insert a Round entity
     *
     * @param round the Round entity that will be inserted
     */
    @Insert("insert into round(round_serial, presentation_score_method, report_score_method, question_score_method, course_id) values(#{roundNum}, #{preScoreType}, #{reportScoreType}, #{quesScoreType}, #{courseId})")
    @Options(useGeneratedKeys = true)
    void insertRound(Round round);

    /**
     * Update a Round entity's information
     *
     * @param round the Round entity that will be updated via the id
     */
    @Update("update round set round_serial=#{roundNum}, presentation_score_method=#{preScoreType}, report_score_method=#{reportScoreType}, question_score_method=#{quesScoreType}, course_id=#{courseId} where id=#{id}")
    void updateRound(Round round);

    /**
     * Select all Round entities
     *
     * @return List<round> the selected Round entities list
     */
    @Select("select * from round")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roundNum", column = "round_serial"),
            @Result(property = "preScoreType", column = "presentation_score_method"),
            @Result(property = "reportScoreType", column = "report_score_method"),
            @Result(property = "quesScoreType", column = "question_score_method"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "seminars", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", fetchType = FetchType.LAZY)),
            @Result(property = "klassRounds", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassRoundMapper.selectKlassRoundByRoundId", fetchType = FetchType.LAZY))
    })
    List<Round> selectAllRound();

    /**
     * Select a Round entity via courseId
     *
     * @param courseId the select gist
     * @return List<round> the selected Round entity as list
     */
    @Select("select * from round where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roundNum", column = "round_serial"),
            @Result(property = "preScoreType", column = "presentation_score_method"),
            @Result(property = "reportScoreType", column = "report_score_method"),
            @Result(property = "quesScoreType", column = "question_score_method"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "seminars", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", fetchType = FetchType.LAZY)),
            @Result(property = "klassRounds", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassRoundMapper.selectKlassRoundByRoundId", fetchType = FetchType.LAZY))
    })
    List<Round> selectRoundByCourseId(String courseId);

    /**
     * Select a Round entity via id
     *
     * @param id the select gist
     * @return List<round> the selected Round entity as list
     */
    @Select("select * from round where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roundNum", column = "round_serial"),
            @Result(property = "preScoreType", column = "presentation_score_method"),
            @Result(property = "reportScoreType", column = "report_score_method"),
            @Result(property = "quesScoreType", column = "question_score_method"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "seminars", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", fetchType = FetchType.LAZY)),
            @Result(property = "klassRounds", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassRoundMapper.selectKlassRoundByRoundId", fetchType = FetchType.LAZY))
    })
    List<Round> selectRoundById(String id);

    /**
     * Delete a Round entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from round where course_id=#{courseId}")
    void deleteRoundByCourseId(String courseId);

    /**
     * Delete a Round entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from round where id=#{id}")
    void deleteRoundById(String id);

    /**
     * Insert a new Round into a course.
     * Only the courseId is used.
     *
     * @param round the wanted round
     */
    @Insert("insert into round(round_serial, course_id, presentation_score_method, report_score_method, question_score_method) select max(round_serial) + 1,course_id, 0, 0, 0 from round where course_id = #{courseId}")
    @Options(useGeneratedKeys = true)
    void addRound(Round round);
}
