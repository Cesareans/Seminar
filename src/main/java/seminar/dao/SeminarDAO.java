package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Seminar;
import seminar.mapper.RoundMapper;
import seminar.mapper.SeminarMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class SeminarDAO {
    private final SeminarMapper seminarMapper;
    private final RoundMapper roundMapper;

    @Autowired
    public SeminarDAO(SeminarMapper seminarMapper, RoundMapper roundMapper) {
        this.seminarMapper = seminarMapper;
        this.roundMapper = roundMapper;
    }

    public List<Seminar> getByRoundId(String roundId) {
        return seminarMapper.selectSeminarByRoundId(roundId);
    }

    public List<Seminar> getBySeminarId(String seminarId) {
        return seminarMapper.selectSeminarById(seminarId);
    }

    /**
     * @author lyf
     */
    public boolean create(Seminar seminar) {
        seminarMapper.insertSeminar(seminar);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean update(Seminar seminar) {
        if (seminarMapper.selectSeminarById(seminar.getId()).isEmpty()) {
            return false;
        } else {
            seminarMapper.updateSeminar(seminar);
            return true;
        }
    }

    /**
     * @author lyf
     */
    public void deleteById(String seminarId) {
        seminarMapper.deleteSeminarById(seminarId);
    }

    /**
     * @author lyf
     */
    public void deleteByRoundId(String roundId) {
        seminarMapper.deleteSeminarByRoundId(roundId);
    }


}
