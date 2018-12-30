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
     *
     * @param teamId         the team refer gist
     * @param klassSeminarId the klassSeminar refer gist
     * @return the calculated seminar score
     * @author Xinyu Shi
     */
    SeminarScore calculateScoreOfOneSeminar(String teamId, String klassSeminarId);

    /**
     * Calculate score of a team in one round
     *
     * @param teamId  the team refer gist
     * @param roundId the round refer gist
     * @return the calculated seminar score
     * @author Xinyu Shi
     */
    RoundScore calculateScoreOfOneRound(String teamId, String roundId);

    /**
     * Calculate score of course score
     *
     * @param rounds the rounds
     * @param teams  the teams
     * @return the calculated course score
     * @author Xinyu Shi
     */
    Map<String, List<RoundScore>> calculateScoreOfOneCourse(List<Round> rounds, List<Team> teams);

    /**
     * Get score of course score
     *
     * @param rounds the rounds
     * @param teams  the teams
     * @return the calculated course score
     * @author Xinyu Shi
     */
    List<Map<String, RoundScore>> calculateCourseScore(List<Round> rounds, List<Team> teams);

    /**
     * Get seminar score
     *
     * @param teamId         the refer gist
     * @param klassSeminarId the refer gist
     * @return the seminar score
     * @author Xinyu Shi
     */
    SeminarScore getSeminarScore(String teamId, String klassSeminarId);

    /**
     * Get round score
     *
     * @param teamId  the refer gist
     * @param roundId the refer gist
     * @return the round score
     * @author Xinyu Shi
     */
    RoundScore getRoundScore(String teamId, String roundId);

    /**
     * calculate scores of one round
     *
     * @param roundScore the wanna update score
     * @author Xinyu Shi
     */
    void updateRoundScore(RoundScore roundScore);

    /**
     * calculate scores of one seminar
     *
     * @param seminarScore the wanna update score
     * @author Xinyu Shi
     */
    void updateSeminarScore(SeminarScore seminarScore);

    /**
     * calculate question score of one seminar according to 'question' table in DB.
     *
     * @param klassSeminarId the refer gist
     * @param teamId         the refer gist
     * @author Xinyu Shi
     */
    void updateQuestionScore(String klassSeminarId, String teamId);

}
