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

    public List<Round> getRoundsByCourseId(String courseId){
        return roundMapper.selectRoundByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public void createRound(Round round){
        roundMapper.insertRound(round);
    }

    /**
     * @author lyf
     */
    public void updateRound(Round round){
        roundMapper.updateRound(round);
    }

    /**
     * @author lyf
     */
    public void deleteRound(String courseId){
        roundMapper.deleteRoundByCourseId(courseId);
    }
}
