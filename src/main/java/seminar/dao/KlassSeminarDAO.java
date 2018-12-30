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

    public void createByKlassIdAndSeminarId(String klassId, String seminarId) {
        KlassSeminar klassSeminar = new KlassSeminar();
        klassSeminar.setSeminarId(seminarId);
        klassSeminar.setKlassId(klassId);
        klassSeminar.setState(0);
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
        List<KlassSeminar> klassSeminars = klassSeminarMapper.selectKlassSeminarByKlassIdAndSeminarId(klassId, seminarId);
        if (klassSeminars.size() == 0) {
            KlassSeminar klassSeminar = new KlassSeminar();
            klassSeminar.setKlassId(klassId);
            klassSeminar.setSeminarId(seminarId);
            klassSeminar.setState(0);
            klassSeminars.add(klassSeminar);
        }
        return klassSeminars;
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassSeminar> getByKlassSeminarId(String klassSeminarId) {
        return klassSeminarMapper.selectKlassSeminarById(klassSeminarId);
    }

}
