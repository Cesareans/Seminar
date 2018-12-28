package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import seminar.entity.RoundScore;
import java.util.List;

/**
* An automatic generated mapper for the entity RoundScore. 
* This mapper is for a increment primary key table.
*
* @author Xinyu Shi
*/
@Mapper
public interface RoundScoreMapper {
/**
* Insert a RoundScore entity
*
* @param roundScore the RoundScore entity that will be inserted
*/
@Insert("insert into round_score(total_score, presentation_score, question_score, report_score, round_id, team_id) values(#{totalScore}, #{presentationScore}, #{questionScore}, #{reportScore}, #{roundId}, #{teamId})")
void insertRoundScore(RoundScore roundScore);

/**
* Update a RoundScore entity's information
*
* @param roundScore the RoundScore entity that will be updated via the id
*/
@Update("update round_score set total_score=#{totalScore}, presentation_score=#{presentationScore}, question_score=#{questionScore}, report_score=#{reportScore}, round_id=#{roundId}, team_id=#{teamId} where round_id=#{roundId} and team_id=#{teamId}")
void updateRoundScore(RoundScore roundScore);

/**
* Select all RoundScore entities
*
* @return List<roundScore> the selected RoundScore entities list
*/
@Select("select * from round_score")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "totalScore", column = "total_score"),
@Result(property = "presentationScore", column = "presentation_score"),
@Result(property = "questionScore", column = "question_score"),
@Result(property = "reportScore", column = "report_score"),
@Result(property = "roundId", column = "round_id"),
@Result(property = "teamId", column = "team_id")
})
List<RoundScore> selectAllRoundScore();

/**
* Select a RoundScore entity via roundId
*
* @param roundId the select gist
* @return List<roundScore> the selected RoundScore entity as list
*/
@Select("select * from round_score where round_id=#{roundId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "totalScore", column = "total_score"),
@Result(property = "presentationScore", column = "presentation_score"),
@Result(property = "questionScore", column = "question_score"),
@Result(property = "reportScore", column = "report_score"),
@Result(property = "roundId", column = "round_id"),
@Result(property = "teamId", column = "team_id")
})
List<RoundScore> selectRoundScoreByRoundId(String roundId);

/**
* Select a RoundScore entity via teamId
*
* @param teamId the select gist
* @return List<roundScore> the selected RoundScore entity as list
*/
@Select("select * from round_score where team_id=#{teamId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "totalScore", column = "total_score"),
@Result(property = "presentationScore", column = "presentation_score"),
@Result(property = "questionScore", column = "question_score"),
@Result(property = "reportScore", column = "report_score"),
@Result(property = "roundId", column = "round_id"),
@Result(property = "teamId", column = "team_id")
})
List<RoundScore> selectRoundScoreByTeamId(String teamId);

/**
* Select a RoundScore entity via id
*
* @param id the select gist
* @return List<roundScore> the selected RoundScore entity as list
*/
@Select("select * from round_score where id=#{id}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "totalScore", column = "total_score"),
@Result(property = "presentationScore", column = "presentation_score"),
@Result(property = "questionScore", column = "question_score"),
@Result(property = "reportScore", column = "report_score"),
@Result(property = "roundId", column = "round_id"),
@Result(property = "teamId", column = "team_id")
})
List<RoundScore> selectRoundScoreById(String id);

    /**
     * select roundScore via teamId and roundId
     * @author Xinyu Shi
     * @param teamId
     * @param roundId
     * @return
     */
    @Select("select * from round_score where round_id=#{roundId} and team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "presentationScore", column = "presentation_score"),
            @Result(property = "questionScore", column = "question_score"),
            @Result(property = "reportScore", column = "report_score"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "teamId", column = "team_id")
    })
    List<RoundScore> selectRoundScoreByTeamIdAndRoundId(@Param("teamId") String teamId, @Param("roundId") String roundId);

/**
* Delete a RoundScore entity via roundId
*
* @param roundId the select gist
*/
@Delete("delete from round_score where round_id=#{roundId}")
void deleteRoundScoreByRoundId(String roundId);

/**
* Delete a RoundScore entity via teamId
*
* @param teamId the select gist
*/
@Delete("delete from round_score where team_id=#{teamId}")
void deleteRoundScoreByTeamId(String teamId);

/**
* Delete a RoundScore entity via id
*
* @param id the select gist
*/
@Delete("delete from round_score where id=#{id}")
void deleteRoundScoreById(String id);

}
