package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.RoundScore;
import seminar.entity.SeminarScore;
import seminar.mapper.RoundScoreMapper;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class RoundScoreDAO {
    private RoundScoreMapper roundScoreMapper;

    @Autowired
    public RoundScoreDAO(RoundScoreMapper roundScoreMapper)
    {
        this.roundScoreMapper = roundScoreMapper;
    }

    public void createRoundScore(RoundScore roundScore){
        roundScoreMapper.insertRoundScore(roundScore);
    }
    public List<RoundScore> getByTeamIdAndKlassSeminarId(String teamId, String roundId)
    {
        return roundScoreMapper.selectRoundScoreByTeamIdAndRoundId(teamId,roundId);
    }

    public void update(RoundScore roundScore)
    {
        roundScoreMapper.updateRoundScore(roundScore);
    }
}
