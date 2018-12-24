package seminar.service;

import seminar.entity.RoundScore;
import seminar.entity.SeminarScore;


/**
 * @author Xinyu Shi
 */

public interface ScoreService {

    SeminarScore calculateScoreOfOneSeminar(String teamId, String klassSeminarId);

    RoundScore calculateScoreOfOneRound(String teamId, String roundId);

}
