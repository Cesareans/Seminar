package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.KlassSeminar;
import seminar.mapper.KlassSeminarMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class KlassSeminarDAO {
    private final KlassSeminarMapper klassSeminarMapper;


    @Autowired
    public KlassSeminarDAO(KlassSeminarMapper klassSeminarMapper) {
        this.klassSeminarMapper = klassSeminarMapper;
    }

    /**
     * TODO: Delete here.
     */
    public List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(String klassId, String seminarId) {
        return klassSeminarMapper.selectKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
    }

    /**
     * TODO: Delete here.
     */
    public List<KlassSeminar> getKlassSeminarByKlassSeminarId(String klassSeminarId) {
        return klassSeminarMapper.selectKlassSeminarById(klassSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        klassSeminarMapper.deleteKlassSeminarById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteBySeminarId(String seminarId) {
        klassSeminarMapper.deleteKlassSeminarBySeminarId(seminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public void create(KlassSeminar klassSeminar) {
        klassSeminarMapper.insertKlassSeminar(klassSeminar);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(KlassSeminar klassSeminar) {
        klassSeminarMapper.updateKlassSeminar(klassSeminar);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getByKlassId(String klassId) {
        return klassSeminarMapper.selectKlassSeminarByKlassId(klassId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getAll() {
        return klassSeminarMapper.selectAllKlassSeminar();
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getById(String id) {
        return klassSeminarMapper.selectKlassSeminarById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getBySeminarId(String seminarId) {
        return klassSeminarMapper.selectKlassSeminarBySeminarId(seminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getByKlassIdAndSeminarId(String klassId, String seminarId) {
        return klassSeminarMapper.selectKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getByKlassSeminarId(String klassSeminarId) {
        return klassSeminarMapper.selectKlassSeminarById(klassSeminarId);
    }

}
