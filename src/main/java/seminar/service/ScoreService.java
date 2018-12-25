package seminar.service;

import seminar.entity.RoundScore;
import seminar.entity.SeminarScore;

import java.util.List;
import java.util.Map;


/**
 * @author Xinyu Shi
 */

public interface ScoreService {

    SeminarScore calculateScoreOfOneSeminar(String teamId, String klassSeminarId);

    RoundScore calculateScoreOfOneRound(String teamId, String roundId);

    Map<String, List<RoundScore>> calculateScoreOfOneCourse(String courseId);

}
