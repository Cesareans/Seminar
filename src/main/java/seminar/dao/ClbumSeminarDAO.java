package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.ClbumSeminar;
import seminar.mapper.ClbumSeminarMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class ClbumSeminarDAO {
    private final ClbumSeminarMapper clbumSeminarMapper;


    @Autowired
    public ClbumSeminarDAO(ClbumSeminarMapper clbumSeminarMapper) {
        this.clbumSeminarMapper = clbumSeminarMapper;
    }

    /**
     * TODO: Delete here.
     */
    public List<ClbumSeminar> getClbumSeminarByClbumIdAndSeminarId(String clbumId, String seminarId) {
        return clbumSeminarMapper.selectClbumSeminarByClbumIdAndSeminarId(clbumId, seminarId);
    }

    /**
     * TODO: Delete here.
     */
    public List<ClbumSeminar> getClbumSeminarByClbumSeminarId(String clbumSeminarId) {
        return clbumSeminarMapper.selectClbumSeminarById(clbumSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        clbumSeminarMapper.deleteClbumSeminarById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteBySeminarId(String seminarId) {
        clbumSeminarMapper.deleteClbumSeminarBySeminarId(seminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public void create(ClbumSeminar clbumSeminar) {
        clbumSeminarMapper.insertClbumSeminar(clbumSeminar);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(ClbumSeminar clbumSeminar) {
        clbumSeminarMapper.updateClbumSeminar(clbumSeminar);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumSeminar> getByClbumId(String clbumId) {
        return clbumSeminarMapper.selectClbumSeminarByClbumId(clbumId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumSeminar> getAll() {
        return clbumSeminarMapper.selectAllClbumSeminar();
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumSeminar> getById(String id) {
        return clbumSeminarMapper.selectClbumSeminarById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumSeminar> getBySeminarId(String seminarId) {
        return clbumSeminarMapper.selectClbumSeminarBySeminarId(seminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumSeminar> getByClbumIdAndSeminarId(String clbumId, String seminarId) {
        return clbumSeminarMapper.selectClbumSeminarByClbumIdAndSeminarId(clbumId, seminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumSeminar> getByClbumSeminarId(String clbumSeminarId) {
        return clbumSeminarMapper.selectClbumSeminarById(clbumSeminarId);
    }

}
