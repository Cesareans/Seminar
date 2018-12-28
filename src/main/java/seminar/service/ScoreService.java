package seminar.service;

import seminar.entity.Round;
import seminar.entity.RoundScore;
import seminar.entity.SeminarScore;
import seminar.entity.Team;

import java.util.List;
import java.util.Map;


/**
 * @author Xinyu Shi
 */

public interface ScoreService {
    /**
     * Calculate score of a team in one seminar
     * @author Xinyu Shi
     * @param teamId the team refer gist
     * @param klassSeminarId the klassSeminar refer gist
     * @return the calculated seminar score
     */
    SeminarScore calculateScoreOfOneSeminar(String teamId, String klassSeminarId);

    /**
     * Calculate score of a team in one round
     * @author Xinyu Shi
     * @param teamId the team refer gist
     * @param roundId the round refer gist
     * @return the calculated seminar score
     */
    RoundScore calculateScoreOfOneRound(String teamId, String roundId);

    /**
     * Calculate score of course score
     * @author Xinyu Shi
     * @param rounds the rounds
     * @param teams the teams
     * @return the calculated course score
     */
    Map<String, List<RoundScore>> calculateScoreOfOneCourse(List<Round> rounds, List<Team> teams);

    /**
     * Get score of course score
     * @author Xinyu Shi
     * @param rounds the rounds
     * @param teams the teams
     * @return the calculated course score
     */
    List<Map<String,RoundScore>> calculateCourseScore(List<Round> rounds, List<Team> teams);

    /**
     * Get seminar score
     * @author Xinyu Shi
     * @param teamId the refer gist
     * @param klassSeminarId the refer gist
     * @return the seminar score
     */
    SeminarScore getSeminarScore(String teamId, String klassSeminarId);

    /**
     * Get round score
     * @author Xinyu Shi
     * @param teamId the refer gist
     * @param roundId the refer gist
     * @return the round score
     */
    RoundScore getRoundScore(String teamId, String roundId);

    /**
     * calculate scores of one round
     * @author Xinyu Shi
     * @param roundScore the wanna update score
     */
    void updateRoundScore(RoundScore roundScore);

    /**
     * calculate scores of one seminar
     * @author Xinyu Shi
     * @param seminarScore the wanna update score
     */
    void updateSeminarScore(SeminarScore seminarScore);

    /**
     * calculate question score of one seminar according to 'question' table in DB.
     * @author Xinyu Shi
     * @param klassSeminarId the refer gist
     * @param teamId the refer gist
     */
    void updateQuestionScore(String klassSeminarId, String teamId);

}
