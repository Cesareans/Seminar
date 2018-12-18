package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.application.ShareSeminarApplication;
import seminar.mapper.application.ShareSeminarApplicationMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class SeminarShareMsgDAO {
    private final ShareSeminarApplicationMapper shareSeminarApplicationMapper;

    @Autowired
    public SeminarShareMsgDAO(ShareSeminarApplicationMapper shareSeminarApplicationMapper) {
        this.shareSeminarApplicationMapper = shareSeminarApplicationMapper;
    }

    /**
     * The course which is a subordinateCourse can't send a seminar share message
     * Two courses must have same name
     */
    public boolean create(ShareSeminarApplication shareSeminarApplication) {
        shareSeminarApplicationMapper.insertSeminarShareMsg(shareSeminarApplication);
        return true;
    }

    public boolean update(ShareSeminarApplication shareSeminarApplication) {
        if (!shareSeminarApplicationMapper.selectSeminarShareMsgById(shareSeminarApplication.getId()).isEmpty()) {
            shareSeminarApplicationMapper.updateSeminarShareMsg(shareSeminarApplication);
            return true;
        }
        return false;
    }

    public List<ShareSeminarApplication> getAll() {
        return shareSeminarApplicationMapper.selectAllSeminarShareMsg();
    }

    public List<ShareSeminarApplication> getById(String id) {
        return shareSeminarApplicationMapper.selectSeminarShareMsgById(id);
    }

    public List<ShareSeminarApplication> getByPCourseId(String principalCourseId) {
        return shareSeminarApplicationMapper.selectSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }

    public List<ShareSeminarApplication> getBySubCourseId(String subordinateCourseId) {
        return shareSeminarApplicationMapper.selectSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public List<ShareSeminarApplication> getByTeacherId(String teacherId) {
        return shareSeminarApplicationMapper.selectSeminarShareMsgByTeacherId(teacherId);
    }

    public void deleteById(String id) {
        shareSeminarApplicationMapper.deleteSeminarShareMsgById(id);
    }

    public void deleteByPCourseId(String principalCourseId) {
        shareSeminarApplicationMapper.deleteSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }

    public void deleteBySubCourseId(String subordinateCourseId) {
        shareSeminarApplicationMapper.deleteSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public void deleteByTeacherId(String teacherId) {
        shareSeminarApplicationMapper.deleteSeminarShareMsgByTeacherId(teacherId);
    }
}
