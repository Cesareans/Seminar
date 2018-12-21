package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.relation.KlassStudent;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

@Component
public class KlassStudentDAO {
    /**
     * @author Xinyu Shi
     */

    private KlassStudentMapper klassStudentMapper;

    @Autowired
    public KlassStudentDAO(KlassStudentMapper klassStudentMapper)
    {
        this.klassStudentMapper = klassStudentMapper;
    }

    public void update(KlassStudent klassStudent)
    {

            klassStudentMapper.update(klassStudent);

    }

    public List<KlassStudent> getByStudentId(String studentId)
    {
        return klassStudentMapper.selectByStudentId(studentId);
    }
}
