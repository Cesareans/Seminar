package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import seminar.entity.SeminarScore;

import java.util.List;

/**
 * An automatic generated mapper for the entity SeminarScore.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface SeminarScoreMapper {
    /**
     * Insert a SeminarScore entity
     *
     * @param seminarScore the SeminarScore entity that will be inserted
     */
    @Insert("insert into seminar_score(total_score, presentation_score, question_score, report_score, klass_seminar_id, team_id) values(#{totalScore}, #{presentationScore}, #{questionScore}, #{reportScore}, #{klassSeminarId}, #{teamId})")
    @Options(useGeneratedKeys = true)
    void insertSeminarScore(SeminarScore seminarScore);

    /**
     * Update a SeminarScore entity's information
     *
     * @param seminarScore the SeminarScore entity that will be updated via the id
     */
    @Update("update seminar_score set total_score=#{totalScore}, presentation_score=#{presentationScore}, question_score=#{questionScore}, report_score=#{reportScore}, klass_seminar_id=#{klassSeminarId}, team_id=#{teamId} where klass_seminar_id=#{klassSeminarId} and team_id=#{teamId}")
    void updateSeminarScore(SeminarScore seminarScore);

    /**
     * Select all SeminarScore entities
     *
     * @return List<seminarScore> the selected SeminarScore entities list
     */
    @Select("select * from seminar_score")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "presentationScore", column = "presentation_score"),
            @Result(property = "questionScore", column = "question_score"),
            @Result(property = "reportScore", column = "report_score"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "teamId", column = "team_id")
    })
    List<SeminarScore> selectAllSeminarScore();

    /**
     * Select a SeminarScore entity via klassSeminarId
     *
     * @param klassSeminarId the select gist
     * @return List<seminarScore> the selected SeminarScore entity as list
     */
    @Select("select * from seminar_score where klass_seminar_id=#{klassSeminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "presentationScore", column = "presentation_score"),
            @Result(property = "questionScore", column = "question_score"),
            @Result(property = "reportScore", column = "report_score"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "teamId", column = "team_id")
    })
    List<SeminarScore> selectSeminarScoreByKlassSeminarId(String klassSeminarId);

    /**
     * Select a SeminarScore entity via teamId
     *
     * @param teamId the select gist
     * @return List<seminarScore> the selected SeminarScore entity as list
     */
    @Select("select * from seminar_score where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "presentationScore", column = "presentation_score"),
            @Result(property = "questionScore", column = "question_score"),
            @Result(property = "reportScore", column = "report_score"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "teamId", column = "team_id")
    })
    List<SeminarScore> selectSeminarScoreByTeamId(String teamId);

    /**
     * Select a SeminarScore entity via id
     *
     * @param id the select gist
     * @return List<seminarScore> the selected SeminarScore entity as list
     */
    @Select("select * from seminar_score where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "presentationScore", column = "presentation_score"),
            @Result(property = "questionScore", column = "question_score"),
            @Result(property = "reportScore", column = "report_score"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "teamId", column = "team_id")
    })
    List<SeminarScore> selectSeminarScoreById(String id);

    /**
     * Delete a SeminarScore entity via klassSeminarId
     *
     * @param klassSeminarId the select gist
     */
    @Delete("delete from seminar_score where klass_seminar_id=#{klassSeminarId}")
    void deleteSeminarScoreByKlassSeminarId(String klassSeminarId);

    /**
     * Delete a SeminarScore entity via teamId
     *
     * @param teamId the select gist
     */
    @Delete("delete from seminar_score where team_id=#{teamId}")
    void deleteSeminarScoreByTeamId(String teamId);

    /**
     * Delete a SeminarScore entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from seminar_score where id=#{id}")
    void deleteSeminarScoreById(String id);

    /**
     * Select a SeminarScore entity via teamId and klassSeminarId
     * @author Xinyu Shi
     * @param id the select gist
     * @return List<seminarScore> the selected SeminarScore entity as list
     */
    @Select("select * from seminar_score where team_id=#{teamId} and klass_seminar_id=#{klassSeminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "presentationScore", column = "presentation_score"),
            @Result(property = "questionScore", column = "question_score"),
            @Result(property = "reportScore", column = "report_score"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "teamId", column = "team_id")
    })
    List<SeminarScore> selectSeminarScoreByTeamIdAndKlassSeminarId(@Param("teamId") String teamId, @Param("klassSeminarId") String klassSeminarId);

}
