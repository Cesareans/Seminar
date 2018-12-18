package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.application.ShareTeamApplication;
import seminar.mapper.application.ShareTeamApplicationMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class TeamShareMsgDAO {
    private final ShareTeamApplicationMapper shareTeamApplicationMapper;

    @Autowired
    private TeamShareMsgDAO(ShareTeamApplicationMapper shareTeamApplicationMapper) {
        this.shareTeamApplicationMapper = shareTeamApplicationMapper;
    }

    /**
     * The course which is a subordinateCourse can't send and receive a seminar share message
     */
    public boolean create(ShareTeamApplication shareTeamApplication) {
        shareTeamApplicationMapper.insertTeamShareMsg(shareTeamApplication);
        return true;
    }

    public boolean update(ShareTeamApplication shareTeamApplication) {
        if (!shareTeamApplicationMapper.selectTeamShareMsgById(shareTeamApplication.getId()).isEmpty()) {
            shareTeamApplicationMapper.updateTeamShareMsg(shareTeamApplication);
            return true;
        }
        return false;
    }

    public List<ShareTeamApplication> getAll() {
        return shareTeamApplicationMapper.selectAllTeamShareMsg();
    }

    public List<ShareTeamApplication> getById(String id) {
        return shareTeamApplicationMapper.selectTeamShareMsgById(id);
    }

    public List<ShareTeamApplication> getByPCourseId(String principalCourseId) {
        return shareTeamApplicationMapper.selectTeamShareMsgByPrincipalCourseId(principalCourseId);
    }

    public List<ShareTeamApplication> getBySubCourseId(String subordinateCourseId) {
        return shareTeamApplicationMapper.selectTeamShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public List<ShareTeamApplication> getByTeacherId(String teacherId) {
        return shareTeamApplicationMapper.selectTeamShareMsgByTeacherId(teacherId);
    }

    public void deleteById(String id) {
        shareTeamApplicationMapper.deleteTeamShareMsgById(id);
    }

    public void deleteByPCourseId(String principalCourseId) {
        shareTeamApplicationMapper.deleteTeamShareMsgByPrincipalCourseId(principalCourseId);
    }

    public void deleteBySubCourseId(String subordinateCourseId) {
        shareTeamApplicationMapper.deleteTeamShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public void deleteByTeacherId(String teacherId) {
        shareTeamApplicationMapper.deleteTeamShareMsgByTeacherId(teacherId);
    }
}
