package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Round;
import seminar.mapper.RoundMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class RoundDAO {
    private final RoundMapper roundMapper;

    @Autowired
    public RoundDAO(RoundMapper roundMapper) {
        this.roundMapper = roundMapper;
    }

    public List<Round> getByCourseId(String courseId){
        return roundMapper.selectRoundByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public boolean create(Round round){
        List<Round> rounds = roundMapper.selectRoundByCourseId(round.getCourseId());
        if(rounds.isEmpty()) {
            roundMapper.insertRound(round);
            return true;
        }

        for(Round r:rounds){
            if(r.getRoundNum().equals(round.getRoundNum()))
                return false;
        }
        roundMapper.insertRound(round);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean update(Round round){
        List<Round> rounds = roundMapper.selectRoundById(round.getId());
        if(rounds.isEmpty()) return false;
        else{
            roundMapper.updateRound(round);
            return true;
        }
    }

    /**
     * @author lyf
     */
    public void deleteByCourseId(String courseId){
        roundMapper.deleteRoundByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public void deleteById(String roundId){
        roundMapper.deleteRoundById(roundId);
    }
}
