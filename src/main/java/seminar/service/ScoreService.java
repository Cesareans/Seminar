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
     * @param teamId the team refer gist
     * @param klassSeminarId the klassSeminar refer gist
     * @return the calculated seminar score
     */
    SeminarScore calculateScoreOfOneSeminar(String teamId, String klassSeminarId);

    /**
     * Calculate score of a team in one round
     * @param teamId the team refer gist
     * @param roundId the round refer gist
     * @return the calculated seminar score
     */
    RoundScore calculateScoreOfOneRound(String teamId, String roundId);

    /**
     * Calculate score of course score
     * @param rounds the rounds
     * @param teams the teams
     * @return the calculated course score
     */
    Map<String, List<RoundScore>> calculateScoreOfOneCourse(List<Round> rounds, List<Team> teams);

    /**
     * Calculate score of course score
     */
    List<Map<String,RoundScore>> calculateCourseScore(String courseId);

}
