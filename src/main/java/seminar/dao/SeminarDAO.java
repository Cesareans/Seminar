package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Seminar;
import seminar.mapper.SeminarMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class SeminarDAO {
    private final SeminarMapper seminarMapper;

    @Autowired
    public SeminarDAO(SeminarMapper seminarMapper) {
        this.seminarMapper = seminarMapper;
    }

    public List<Seminar> getSeminarsByRoundId(String roundId){
        return seminarMapper.selectSeminarByRoundId(roundId);
    }
}
