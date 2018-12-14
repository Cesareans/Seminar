package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Attendance;
import seminar.entity.KlassSeminar;
import seminar.mapper.KlassSeminarMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

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

    /**
     * @author Cesare
     */
    public List<Attendance> getEnrollList(String ksId) {
        KlassSeminar klassSeminar = getByKlassSeminarId(ksId).get(0);
        List<Attendance> enrollList = new LinkedList<>();
        IntStream.range(1, klassSeminar.getSeminar().getMaxTeam() + 1).forEach(i -> {
            boolean isEnrolled = false;
            for (Attendance attendance : klassSeminar.getAttendances()) {
                if (attendance.getSn() == i) {
                    isEnrolled = true;
                    enrollList.add(attendance);
                    break;
                }
            }
            if (!isEnrolled) {
                enrollList.add(null);
            }
        });
        return enrollList;
    }
}
