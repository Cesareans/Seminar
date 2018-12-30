package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.relation.KlassRound;
import seminar.mapper.relation.KlassRoundMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class KlassRoundDAO {
    private final KlassRoundMapper klassRoundMapper;

    @Autowired
    public KlassRoundDAO(KlassRoundMapper klassRoundMapper) {
        this.klassRoundMapper = klassRoundMapper;
    }

    /**
     * This method is not directly touched by the users.
     *
     * @author cesare
     */
    public void insert(KlassRound klassRound) {
        klassRoundMapper.insertKlassRound(klassRound);
    }

    /**
     * @author cesare
     */
    public void update(KlassRound klassRound) {
        if (klassRoundMapper.selectKlassRoundByKlassIdAndRoundId(klassRound.getKlassId(), klassRound.getRoundId()).isEmpty()) {
            klassRoundMapper.insertKlassRound(klassRound);
        } else {
            klassRoundMapper.updateKlassRound(klassRound);
        }
    }

    /**
     * @author cesare
     */
    public List<KlassRound> getByKlassId(String klassId) {
        return klassRoundMapper.selectKlassRoundByKlassId(klassId);
    }

    /**
     * @author cesare
     */
    public List<KlassRound> getByKlassIdAndRoundId(String klassId, String roundId) {
        return klassRoundMapper.selectKlassRoundByKlassIdAndRoundId(klassId, roundId);
    }

    /**
     * @author cesare
     */
    public void deleteByKlassId(String klassId) {
        klassRoundMapper.deleteKlassRoundByKlassId(klassId);
    }

    /**
     * @author cesare
     */
    public void deleteByRoundId(String roundId) {
        klassRoundMapper.deleteKlassRoundByRoundId(roundId);
    }

    /**
     * @author cesare
     */
    public void deleteByCourseId(String courseId) {
        klassRoundMapper.deleteKlassRoundByCourseId(courseId);
    }
}
