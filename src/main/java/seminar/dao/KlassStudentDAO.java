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

    public List<KlassStudent> getByStudentIdAndKlassId(String studentId, String klassId)
    {
        return klassStudentMapper.selectByStudentIdAndKlassId(studentId,klassId);
    }

    public List<KlassStudent> getByStudentIdAndTeamId(String studentId, String teamId)
    {
        return klassStudentMapper.selectByStudentIdAndTeamId(studentId, teamId);
    }

    public List<KlassStudent> getByStudentIdAndCourseId(String studentId, String courseId)
    {
        return klassStudentMapper.selectByStudentIdAndCourseId(studentId,courseId);
    }
}
