package seminar.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.TeamShareMsg;
import seminar.entity.TeamShare;
import seminar.mapper.TeamShareMsgMapper;
import seminar.mapper.TeamShareMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class TeamShareMsgDAO {
    private final TeamShareMsgMapper teamShareMsgMapper;
    private final TeamShareMapper teamShareMapper;
    @Autowired
    private TeamShareMsgDAO(TeamShareMsgMapper teamShareMsgMapper, TeamShareMapper teamShareMapper){
        this.teamShareMsgMapper=teamShareMsgMapper;
        this.teamShareMapper=teamShareMapper;
    }

    /**
     * The course which is a subordinateCourse can't send and receive a seminar share message
     *
     */
    public boolean create(TeamShareMsg teamShareMsg){
        List<TeamShare> teamShares = teamShareMapper.selectAllTeamShare();
        for(TeamShare t:teamShares){
            if(t.getSubordinateCourseId().equals(teamShareMsg.getPrincipalCourseId())) {
                return false;
            }
            else if(t.getSubordinateCourseId().equals(teamShareMsg.getSubordinateCourseId())) {
                return false;
            }
        }
        teamShareMsgMapper.insertTeamShareMsg(teamShareMsg);
        return true;
    }
    public boolean update(TeamShareMsg teamShareMsg){
        if(!teamShareMsgMapper.selectTeamShareMsgById(teamShareMsg.getId()).isEmpty()) {
            teamShareMsgMapper.updateTeamShareMsg(teamShareMsg);
            return true;
        }
        return false;
    }
    public List<TeamShareMsg> getAll(){
        return teamShareMsgMapper.selectAllTeamShareMsg();
    }
    public List<TeamShareMsg> getById(String id){
        return teamShareMsgMapper.selectTeamShareMsgById(id);
    }
    public List<TeamShareMsg> getByPCourseId(String principalCourseId){
        return teamShareMsgMapper.selectTeamShareMsgByPrincipalCourseId(principalCourseId);
    }
    public List<TeamShareMsg> getBySubCourseId(String subordinateCourseId){
        return teamShareMsgMapper.selectTeamShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public List<TeamShareMsg> getByTeacherId(String teacherId){
        return teamShareMsgMapper.selectTeamShareMsgByTeacherId(teacherId);
    }
    public void deleteById(String id){
        teamShareMsgMapper.deleteTeamShareMsgById(id);
    }
    public void deleteByPCourseId(String principalCourseId){
        teamShareMsgMapper.deleteTeamShareMsgByPrincipalCourseId(principalCourseId);
    }
    public void deleteBySubCourseId(String subordinateCourseId){
        teamShareMsgMapper.deleteTeamShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public void deleteByTeacherId(String teacherId){
        teamShareMsgMapper.deleteTeamShareMsgByTeacherId(teacherId);
    }
}
