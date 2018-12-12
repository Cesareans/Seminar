package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.relation.TeamStudent;
import seminar.mapper.TeamStudentMapper;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class TeamStudentDAO {
    private final TeamStudentMapper teamStudentMapper;
    private final TeamDAO teamDAO;

    /**
     * @author Xinyu Shi
     */
    @Autowired
    public TeamStudentDAO(TeamStudentMapper teamStudentMapper, TeamDAO teamDAO) {

        this.teamStudentMapper = teamStudentMapper;
        this.teamDAO = teamDAO;

    }

    /**
     * @author Xinyu Shi
     */

    public List<Student> getAllStudentByTeamId(String teamId)
    {
        return teamStudentMapper.selectStudentsByTeamId(teamId);
    }


    /**
     * @author Xinyu Shi
     */
    public List<TeamStudent> getAll() {
        return teamStudentMapper.selectAllTeamStudent();
    }

    /**
     * @author Xinyu Shi
     */
    public List<TeamStudent> getById(String id) {
        return teamStudentMapper.selectTeamStudentById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<TeamStudent> getByStudentId(String studentId) {
        return teamStudentMapper.selectTeamStudentByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<TeamStudent> getByTeamId(String teamId) {
        return teamStudentMapper.selectTeamStudentByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        teamStudentMapper.deleteTeamStudentById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByStudentId(String studentId) {
        teamStudentMapper.deleteTeamStudentByStudentId(studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public void create(TeamStudent teamStudent) {
        teamStudentMapper.insertTeamStudent(teamStudent);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(TeamStudent teamStudent) {

        teamStudentMapper.updateTeamStudent(teamStudent);
    }

    public void updateTeamByTeamStudent(TeamStudent teamStudent)
    {

    }

    /**
     * @author SWJ
     */
    public void deleteByTeamId(String teamId) {
        teamStudentMapper.deleteTeamStudentByTeamId(teamId);
    }

    public void getByTeamId(String teamId, Team team)
    {
        team.setStudents(teamStudentMapper.selectStudentsByTeamId(teamId));
    }
}
