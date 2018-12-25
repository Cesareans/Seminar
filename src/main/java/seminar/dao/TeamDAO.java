package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.relation.KlassStudent;
import seminar.mapper.TeamMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class TeamDAO {
    private final KlassDao klassDao;
    private final TeamMapper teamMapper;
    private final KlassStudentMapper klassStudentMapper;

    @Autowired
    public TeamDAO(KlassDao klassDao, TeamMapper teamMapper, KlassStudentMapper klassStudentMapper) {
        this.klassDao = klassDao;
        this.teamMapper = teamMapper;
        this.klassStudentMapper = klassStudentMapper;
    }

    /**
     * @author SWJ
     */
    public List<Team> getById(String id) {
        return teamMapper.selectTeamById(id);
    }

    /**
     * @author Cesare
     */
    public List<Team> getCourseTeamsByCourseId(String courseId) {
        return teamMapper.selectTeamByCourseId(courseId);
    }

    /**
     * @author Xinyu Shi
     */
    public boolean create(Team team) {
        List<Team> teams = teamMapper.selectTeamById(team.getId());
        if (teams.isEmpty()) {
            teamMapper.addTeam(team);
            klassStudentMapper.insertStudentIntoTeam(team.getId(),team.getLeaderId());
            return true;
        } else {
            return false;
        }
    }

    /**
     * @author lyf
     */
    public void deleteById(String teamId) {
        teamMapper.deleteTeamById(teamId);
    }

    /**
     * @author lyf
     */
    public void deleteByKlassId(String klassId) {
        teamMapper.deleteTeamByKlassId(klassId);
    }

    /**
     * @author lyf
     */
    public boolean update(Team team) {
        List<Team> teams = teamMapper.selectTeamById(team.getId());
        if (teams.isEmpty()) {
            return false;
        } else {
            teamMapper.updateTeam(team);
            return true;
        }
    }

    /**
     * @author cesare
     */
    public Team getByCourseIdAndStudentId(String courseId, String studentId){
        return klassStudentMapper.selectTeamByCourseIdAndStudentId(courseId, studentId);
    }
    /**
     * @author Xinyu Shi
     */
    public List<Team> getByLeaderId(String leaderId)
    {
        return teamMapper.selectTeamByLeaderId(leaderId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Team> getByKlassIdAndTeamId(String klassId, String teamId)
    {
        return teamMapper.selectTeamByKlassIdAndTeamId(klassId,teamId);
    }

    public List<Student> getStudentsByTeamId(String teamId)
    {
        return klassStudentMapper.selectStudentsInTeamByTeamId(teamId);
    }

}
