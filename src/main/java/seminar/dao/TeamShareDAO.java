package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.TeamShare;
import seminar.mapper.TeamShareMapper;

import javax.xml.ws.Action;
import java.util.List;

/**
 * @author SWJ
 */
@Component
public class TeamShareDAO {
    private TeamShareMapper teamShareMapper;
    @Autowired
    public TeamShareDAO(TeamShareMapper teamShareMapper){
        this.teamShareMapper=teamShareMapper;
    }

    public void create(TeamShare teamShare){
        teamShareMapper.insertTeamShare(teamShare);
    }
    public void update(TeamShare teamShare){
        teamShareMapper.updateTeamShare(teamShare);
    }
    public List<TeamShare> getAll() {
        return teamShareMapper.selectAllTeamShare();
    }
    public List<TeamShare> getById(String id){
        return teamShareMapper.selectTeamShareById(id);
    }
    public List<TeamShare> getByPCourseId(String principalCourseId){
        return teamShareMapper.selectTeamShareByPrincipalCourseId(principalCourseId);
    }
    public List<TeamShare> getBySubCourseId(String subordinateCourseId){
        return teamShareMapper.selectTeamShareBySubordinateCourseId(subordinateCourseId);
    }
    public void deleteById(String id){
        teamShareMapper.deleteTeamShareById(id);
    }
    public void deleteByPCourseId(String principalCourseId){
        teamShareMapper.deleteTeamShareByPrincipalCourseId(principalCourseId);
    }
    public void deleteBySubCourseId(String subordinateCourseId){
        teamShareMapper.deleteTeamShareBySubordinateCourseId(subordinateCourseId);
    }
}
