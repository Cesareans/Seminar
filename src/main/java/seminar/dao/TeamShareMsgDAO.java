package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.message.TeamShareMsg;
import seminar.mapper.TeamShareMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class TeamShareMsgDAO {
    private final TeamShareMsgMapper teamShareMsgMapper;

    @Autowired
    private TeamShareMsgDAO(TeamShareMsgMapper teamShareMsgMapper) {
        this.teamShareMsgMapper = teamShareMsgMapper;
    }

    /**
     * The course which is a subordinateCourse can't send and receive a seminar share message
     */
    public boolean create(TeamShareMsg teamShareMsg) {
        teamShareMsgMapper.insertTeamShareMsg(teamShareMsg);
        return true;
    }

    public boolean update(TeamShareMsg teamShareMsg) {
        if (!teamShareMsgMapper.selectTeamShareMsgById(teamShareMsg.getId()).isEmpty()) {
            teamShareMsgMapper.updateTeamShareMsg(teamShareMsg);
            return true;
        }
        return false;
    }

    public List<TeamShareMsg> getAll() {
        return teamShareMsgMapper.selectAllTeamShareMsg();
    }

    public List<TeamShareMsg> getById(String id) {
        return teamShareMsgMapper.selectTeamShareMsgById(id);
    }

    public List<TeamShareMsg> getByPCourseId(String principalCourseId) {
        return teamShareMsgMapper.selectTeamShareMsgByPrincipalCourseId(principalCourseId);
    }

    public List<TeamShareMsg> getBySubCourseId(String subordinateCourseId) {
        return teamShareMsgMapper.selectTeamShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public List<TeamShareMsg> getByTeacherId(String teacherId) {
        return teamShareMsgMapper.selectTeamShareMsgByTeacherId(teacherId);
    }

    public void deleteById(String id) {
        teamShareMsgMapper.deleteTeamShareMsgById(id);
    }

    public void deleteByPCourseId(String principalCourseId) {
        teamShareMsgMapper.deleteTeamShareMsgByPrincipalCourseId(principalCourseId);
    }

    public void deleteBySubCourseId(String subordinateCourseId) {
        teamShareMsgMapper.deleteTeamShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public void deleteByTeacherId(String teacherId) {
        teamShareMsgMapper.deleteTeamShareMsgByTeacherId(teacherId);
    }
}
