package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.SeminarShareMsg;
import seminar.mapper.SeminarShareMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class SeminarShareMsgDAO {
    private SeminarShareMsgMapper seminarShareMsgMapper;
    @Autowired
    public SeminarShareMsgDAO(SeminarShareMsgMapper seminarShareMsgMapper){
        this.seminarShareMsgMapper=seminarShareMsgMapper;
    }

    public void create(SeminarShareMsg seminarShareMsg){
        seminarShareMsgMapper.insertSeminarShareMsg(seminarShareMsg);
    }
    public void update(SeminarShareMsg seminarShareMsg){
        seminarShareMsgMapper.updateSeminarShareMsg(seminarShareMsg);
    }
    public List<SeminarShareMsg> retrieveAll(){
        return seminarShareMsgMapper.selectAllSeminarShareMsg();
    }
    public List<SeminarShareMsg> retrieveById(String id){
        return seminarShareMsgMapper.selectSeminarShareMsgById(id);
    }
    public List<SeminarShareMsg> retrieveByPCourseId(String principalCourseId){
        return seminarShareMsgMapper.selectSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }
    public List<SeminarShareMsg> retrieveBySubCourseId(String subordinateCourseId){
        return seminarShareMsgMapper.selectSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public List<SeminarShareMsg> retrieveByTeacherId(String teacherId){
        return seminarShareMsgMapper.selectSeminarShareMsgByTeacherId(teacherId);
    }
    public void deleteById(String id){
        seminarShareMsgMapper.deleteSeminarShareMsgById(id);
    }
    public void deleteByPCourseId(String principalCourseId){
        seminarShareMsgMapper.deleteSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }
    public void deleteBySubCourseId(String subordinateCourseId){
        seminarShareMsgMapper.deleteSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public void deleteByTeacherId(String teacherId){
        seminarShareMsgMapper.deleteSeminarShareMsgByTeacherId(teacherId);
    }
}
