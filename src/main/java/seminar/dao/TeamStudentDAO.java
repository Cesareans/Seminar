package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.TeamStudent;
import seminar.mapper.TeamStudentMapper;

import java.util.List;
/**
 * @author  Xinyu Shi
 */
@Component
public class TeamStudentDAO {
    private final TeamStudentMapper teamStudentMapper;

    /**
     * @author  Xinyu Shi
     */
    @Autowired
    public TeamStudentDAO(TeamStudentMapper teamStudentMapper) {

        this.teamStudentMapper = teamStudentMapper;
    }

    /**
     * @author  Xinyu Shi
     */
    public List<TeamStudent> getAll()
    {
        return teamStudentMapper.selectAllTeamStudent();
    }

    /**
     * @author  Xinyu Shi
     */
    public List<TeamStudent> getById(String id)
    {
        return teamStudentMapper.selectTeamStudentById(id);
    }

    /**
     * @author  Xinyu Shi
     */
    public List<TeamStudent> getByStudentId(String studentId)
    {
        return teamStudentMapper.selectTeamStudentByStudentId(studentId);
    }

    /**
     * @author  Xinyu Shi
     */
    public List<TeamStudent> getByTeamId(String teamId)
    {
        return teamStudentMapper.selectTeamStudentByTeamId(teamId);
    }

    /**
     * @author  Xinyu Shi
     */
    public void deleteById(String id)
    {
        teamStudentMapper.deleteTeamStudentById(id);
    }

    /**
     * @author  Xinyu Shi
     */
    public void deleteByStudentId(String studentId)
    {
        teamStudentMapper.deleteTeamStudentByStudentId(studentId);
    }

    /**
     * @author  Xinyu Shi
     */
    public void create(TeamStudent teamStudent)
    {
        teamStudentMapper.insertTeamStudent(teamStudent);
    }

    /**
     * @author  Xinyu Shi
     */
    public void update(TeamStudent teamStudent)
    {

        teamStudentMapper.updateTeamStudent(teamStudent);
    }

}
