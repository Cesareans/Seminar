package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.relation.KlassStudent;
import seminar.mapper.KlassStudentMapper;

import java.util.List;

@Component
/**
 * @author Xinyu Shi
 */
public class KlassStudentDAO {

    private KlassStudentMapper klassStudentMapper;

    /**
     * @author Xinyu Shi
     */
    @Autowired
    public KlassStudentDAO(KlassStudentMapper klassStudentMapper) {
        this.klassStudentMapper = klassStudentMapper;
    }

    /**
     * @author Xinyu Shi
     */
    public void create(KlassStudent klassStudent) {
        klassStudentMapper.insertKlassStudent(klassStudent);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByKlassId(String klassId) {
        klassStudentMapper.deleteKlassStudentByKlassId(klassId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        klassStudentMapper.deleteKlassStudentById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByStudentId(String studentId) {
        klassStudentMapper.deleteKlassStudentByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(KlassStudent klassStudent) {
        klassStudentMapper.updateKlassStudent(klassStudent);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassStudent> getByKlassId(String klassId) {
        return klassStudentMapper.selectKlassStudentByKlassId(klassId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassStudent> getById(String id) {
        return klassStudentMapper.selectKlassStudentById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassStudent> getByStudentId(String studentId) {
        return klassStudentMapper.selectKlassStudentByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<KlassStudent> getAll() {
        return klassStudentMapper.selectAllKlassStudent();
    }

}
