package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.SeminarScore;
import seminar.mapper.SeminarScoreMapper;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class SeminarScoreDAO {

    private final SeminarScoreMapper seminarScoreMapper;

    @Autowired
    public SeminarScoreDAO(SeminarScoreMapper seminarScoreMapper)
    {
        this.seminarScoreMapper = seminarScoreMapper;
    }

    public void createSeminarScore(SeminarScore seminarScore){
        seminarScoreMapper.insertSeminarScore(seminarScore);
    }
    public List<SeminarScore> getByTeamIdAndKlassSeminarId(String teamId, String klassSeminarId)
    {
        return seminarScoreMapper.selectSeminarScoreByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
    }

    public void update(SeminarScore seminarScore)
    {
        seminarScoreMapper.updateSeminarScore(seminarScore);
    }
}
