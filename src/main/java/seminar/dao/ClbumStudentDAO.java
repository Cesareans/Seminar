package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.relation.ClbumStudent;
import seminar.mapper.ClbumStudentMapper;

import java.util.List;

@Component
/**
 * @author Xinyu Shi
 */
public class ClbumStudentDAO {

    private ClbumStudentMapper clbumStudentMapper;

    /**
     * @author Xinyu Shi
     */
    @Autowired
    public ClbumStudentDAO(ClbumStudentMapper clbumStudentMapper) {
        this.clbumStudentMapper = clbumStudentMapper;
    }

    /**
     * @author Xinyu Shi
     */
    public void create(ClbumStudent clbumStudent) {
        clbumStudentMapper.insertClbumStudent(clbumStudent);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByClbumId(String clbumId) {
        clbumStudentMapper.deleteClbumStudentByClbumId(clbumId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        clbumStudentMapper.deleteClbumStudentById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByStudentId(String studentId) {
        clbumStudentMapper.deleteClbumStudentByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(ClbumStudent clbumStudent) {
        clbumStudentMapper.updateClbumStudent(clbumStudent);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumStudent> getByClbumId(String clbumId) {
        return clbumStudentMapper.selectClbumStudentByClbumId(clbumId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumStudent> getById(String id) {
        return clbumStudentMapper.selectClbumStudentById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumStudent> getByStudentId(String studentId) {
        return clbumStudentMapper.selectClbumStudentByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<ClbumStudent> getAll() {
        return clbumStudentMapper.selectAllClbumStudent();
    }

}
