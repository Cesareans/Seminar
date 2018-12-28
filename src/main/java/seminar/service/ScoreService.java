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
     * Calculate score of course score
     * @author Xinyu Shi
     * @param rounds the rounds
     * @param teams the teams
     * @return the calculated course score
     */
    List<Map<String,RoundScore>> calculateCourseScore(List<Round> rounds, List<Team> teams);

    /**
     * @author Xinyu Shi
     * @param teamId
     * @param klassSeminarId
     * @return
     */
    SeminarScore getSeminarScore(String teamId, String klassSeminarId);

    /**
     * @author Xinyu Shi
     * @param teamId
     * @param roundId
     * @return
     */
    RoundScore getRoundScore(String teamId, String roundId);

}
