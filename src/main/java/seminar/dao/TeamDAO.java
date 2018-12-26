package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.mapper.AttendanceMapper;
import seminar.mapper.TeamMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class TeamDAO {
    private final TeamMapper teamMapper;
    private final KlassStudentMapper klassStudentMapper;
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public TeamDAO(TeamMapper teamMapper, KlassStudentMapper klassStudentMapper, AttendanceMapper attendanceMapper) {
        this.teamMapper = teamMapper;
        this.klassStudentMapper = klassStudentMapper;
        this.attendanceMapper = attendanceMapper;
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
        return teamMapper.selectTeamByMainCourseId(courseId);
    }

    /**
     * @author Xinyu Shi
     */
    public boolean create(Team team) {
        teamMapper.addTeam(team);
        klassStudentMapper.insertTeamIntoKlassTeam(team.getId(),team.getKlassId());
        klassStudentMapper.insertStudentIntoTeam(team.getId(),team.getLeaderId());
        return true;
    }

    /**
     * @author lyf
     */
    public void deleteById(String teamId) {
        teamMapper.deleteTeamById(teamId);
        klassStudentMapper.deleteTeamFromKlassTeamByTeamId(teamId);
        attendanceMapper.deleteAttendanceByTeamId(teamId);
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
     * @author cesare
     */
    public List<Student> getStudentsByTeamId(String teamId)
    {
        return klassStudentMapper.selectStudentsFromTeam(teamId);
    }

    /**
     * @author cesare
     */
    public void deleteByCourseId(String courseId){
        //Team table
        teamMapper.deleteTeamByCourseId(courseId);

    }
}
