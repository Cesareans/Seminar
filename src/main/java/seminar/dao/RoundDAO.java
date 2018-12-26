package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Round;
import seminar.mapper.RoundMapper;
import seminar.mapper.SeminarMapper;
import seminar.mapper.relation.KlassRoundMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class RoundDAO {
    private final RoundMapper roundMapper;
    private final SeminarMapper seminarMapper;
    private final KlassRoundMapper klassRoundMapper;

    @Autowired
    public RoundDAO(RoundMapper roundMapper, SeminarMapper seminarMapper, KlassRoundMapper klassRoundMapper) {
        this.roundMapper = roundMapper;
        this.seminarMapper = seminarMapper;
        this.klassRoundMapper = klassRoundMapper;
    }

    /**
     * @author cesare
     */
    public List<Round> getByCourseId(String courseId) {
        return roundMapper.selectRoundByCourseId(courseId);
    }

    /**
     * @author cesare
     */
    public List<Round> getByRoundId(String roundId){
        return roundMapper.selectRoundById(roundId);
    }

    /**
     * @author cesare
     */
    public void addRound(Round round) {
        roundMapper.addRound(round);
    }

    /**
     * @author lyf
     */
    public boolean create(Round round) {
        List<Round> rounds = roundMapper.selectRoundByCourseId(round.getCourseId());
        for (Round r : rounds) {
            if (r.getRoundNum().equals(round.getRoundNum())) {
                return false;
            }
        }
        roundMapper.insertRound(round);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean update(Round round) {
        List<Round> rounds = roundMapper.selectRoundById(round.getId());
        if (rounds.isEmpty()) {
            return false;
        } else {
            roundMapper.updateRound(round);
            return true;
        }
    }

    /**
     * @author lyf
     */
    void deleteRoundsByCourseId(String courseId) {
        List<Round> rounds = roundMapper.selectRoundByCourseId(courseId);
        rounds.forEach(round -> seminarMapper.deleteSeminarByRoundId(round.getId()));
        klassRoundMapper.deleteKlassRoundByCourseId(courseId);
        roundMapper.deleteRoundByCourseId(courseId);
    }

    /**
     * @author cesare
     */
    void deleteKlassRoundByCourseId(String courseId){
        klassRoundMapper.deleteKlassRoundByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public void deleteById(String roundId) {
        roundMapper.deleteRoundById(roundId);
    }
}
