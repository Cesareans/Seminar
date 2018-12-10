package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.share.TeamShare;
import seminar.mapper.TeamShareMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class TeamShareDAO {
    private final TeamShareMapper teamShareMapper;

    @Autowired
    public TeamShareDAO(TeamShareMapper teamShareMapper) {
        this.teamShareMapper = teamShareMapper;
    }

    /**
     * The course which is a subordinateCourse can't be a new principalCourse and can't be another subordinateCourse
     */
    public boolean create(TeamShare teamShare) {
        List<TeamShare> teamShares = teamShareMapper.selectAllTeamShare();
        for (TeamShare t : teamShares) {
            if (t.getSubordinateCourseId().equals(teamShare.getPrincipalCourseId())) {
                return false;
            }
            if (t.getSubordinateCourseId().equals(teamShare.getSubordinateCourseId()) && !t.getPrincipalCourseId().equals(teamShare.getPrincipalCourseId())) {
                return false;
            }
        }
        teamShareMapper.insertTeamShare(teamShare);
        return true;
    }

    public boolean update(TeamShare teamShare) {
        if (!teamShareMapper.selectTeamShareById(teamShare.getId()).isEmpty()) {
            teamShareMapper.updateTeamShare(teamShare);
            return true;
        }
        return false;
    }

    public List<TeamShare> getAll() {
        return teamShareMapper.selectAllTeamShare();
    }

    public List<TeamShare> getById(String id) {
        return teamShareMapper.selectTeamShareById(id);
    }

    public List<TeamShare> getByPCourseId(String principalCourseId) {
        return teamShareMapper.selectTeamShareByPrincipalCourseId(principalCourseId);
    }

    public List<TeamShare> getBySubCourseId(String subordinateCourseId) {
        return teamShareMapper.selectTeamShareBySubordinateCourseId(subordinateCourseId);
    }

    public void deleteById(String id) {
        teamShareMapper.deleteTeamShareById(id);
    }

    public void deleteByPCourseId(String principalCourseId) {
        teamShareMapper.deleteTeamShareByPrincipalCourseId(principalCourseId);
    }

    public void deleteBySubCourseId(String subordinateCourseId) {
        teamShareMapper.deleteTeamShareBySubordinateCourseId(subordinateCourseId);
    }
}
