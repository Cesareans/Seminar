package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.message.SeminarShareMsg;
import seminar.mapper.SeminarShareMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class SeminarShareMsgDAO {
    private final SeminarShareMsgMapper seminarShareMsgMapper;

    @Autowired
    public SeminarShareMsgDAO(SeminarShareMsgMapper seminarShareMsgMapper) {
        this.seminarShareMsgMapper = seminarShareMsgMapper;
    }

    /**
     * The course which is a subordinateCourse can't send a seminar share message
     * Two courses must have same name
     */
    public boolean create(SeminarShareMsg seminarShareMsg) {
        seminarShareMsgMapper.insertSeminarShareMsg(seminarShareMsg);
        return true;
    }

    public boolean update(SeminarShareMsg seminarShareMsg) {
        if (!seminarShareMsgMapper.selectSeminarShareMsgById(seminarShareMsg.getId()).isEmpty()) {
            seminarShareMsgMapper.updateSeminarShareMsg(seminarShareMsg);
            return true;
        }
        return false;
    }

    public List<SeminarShareMsg> getAll() {
        return seminarShareMsgMapper.selectAllSeminarShareMsg();
    }

    public List<SeminarShareMsg> getById(String id) {
        return seminarShareMsgMapper.selectSeminarShareMsgById(id);
    }

    public List<SeminarShareMsg> getByPCourseId(String principalCourseId) {
        return seminarShareMsgMapper.selectSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }

    public List<SeminarShareMsg> getBySubCourseId(String subordinateCourseId) {
        return seminarShareMsgMapper.selectSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public List<SeminarShareMsg> getByTeacherId(String teacherId) {
        return seminarShareMsgMapper.selectSeminarShareMsgByTeacherId(teacherId);
    }

    public void deleteById(String id) {
        seminarShareMsgMapper.deleteSeminarShareMsgById(id);
    }

    public void deleteByPCourseId(String principalCourseId) {
        seminarShareMsgMapper.deleteSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }

    public void deleteBySubCourseId(String subordinateCourseId) {
        seminarShareMsgMapper.deleteSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }

    public void deleteByTeacherId(String teacherId) {
        seminarShareMsgMapper.deleteSeminarShareMsgByTeacherId(teacherId);
    }
}
