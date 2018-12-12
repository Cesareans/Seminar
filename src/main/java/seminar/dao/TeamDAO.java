package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Klass;
import seminar.entity.Team;
import seminar.mapper.TeamMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
@Component
public class TeamDAO {
    private final KlassDao klassDao;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamDAO(KlassDao klassDao, TeamMapper teamMapper) {
        this.klassDao = klassDao;
        this.teamMapper = teamMapper;
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
     * @author lyf
     */
    public boolean create(Team team) {
        List<Team> teams = teamMapper.selectTeamById(team.getId());
        if (teams.isEmpty()) {
            teamMapper.insertTeam(team);
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

}
