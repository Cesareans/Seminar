package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.SeminarShare;
import seminar.entity.SeminarShareMsg;
import seminar.mapper.SeminarShareMapper;
import seminar.mapper.SeminarShareMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class SeminarShareMsgDAO {
    private final SeminarShareMsgMapper seminarShareMsgMapper;
    private final SeminarShareMapper seminarShareMapper;
    @Autowired
    public SeminarShareMsgDAO(SeminarShareMsgMapper seminarShareMsgMapper, SeminarShareMapper seminarShareMapper){
        this.seminarShareMsgMapper=seminarShareMsgMapper;
        this.seminarShareMapper=seminarShareMapper;
    }
    /**
     * The course which is a subordinateCourse can't send a seminar share message
     *
     */
    public boolean create(SeminarShareMsg seminarShareMsg){
        List<SeminarShare> seminarShares =seminarShareMapper.selectAllSeminarShare();
        for(SeminarShare s:seminarShares){
            if(s.getSubordinateCourseId().equals(seminarShareMsg.getPrincipalCourseId())){
                return false;
            }
        }
        seminarShareMsgMapper.insertSeminarShareMsg(seminarShareMsg);
        return true;
    }
    public boolean update(SeminarShareMsg seminarShareMsg){
        if(!seminarShareMsgMapper.selectSeminarShareMsgById(seminarShareMsg.getId()).isEmpty()){
            seminarShareMsgMapper.updateSeminarShareMsg(seminarShareMsg);
            return true;
        }
        return false;
    }
    public List<SeminarShareMsg> getAll(){
        return seminarShareMsgMapper.selectAllSeminarShareMsg();
    }
    public List<SeminarShareMsg> getById(String id){
        return seminarShareMsgMapper.selectSeminarShareMsgById(id);
    }
    public List<SeminarShareMsg> getByPCourseId(String principalCourseId){
        return seminarShareMsgMapper.selectSeminarShareMsgByPrincipalCourseId(principalCourseId);
    }
    public List<SeminarShareMsg> getBySubCourseId(String subordinateCourseId){
        return seminarShareMsgMapper.selectSeminarShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public List<SeminarShareMsg> getByTeacherId(String teacherId){
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
