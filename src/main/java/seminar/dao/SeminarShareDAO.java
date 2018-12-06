package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.SeminarShare;
import seminar.mapper.SeminarShareMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class SeminarShareDAO {
    private final SeminarShareMapper seminarShareMapper;
    @Autowired
    public SeminarShareDAO(SeminarShareMapper seminarShareMapper){
        this.seminarShareMapper = seminarShareMapper;
    }
    /**
     * The course which is a subordinateCourse can't be a new principalCourse
     *
     */
    public boolean create(SeminarShare seminarShare){
        List<SeminarShare> seminarShares = seminarShareMapper.selectAllSeminarShare();
        for(SeminarShare s:seminarShares){
            if(s.getSubordinateCourseId().equals(seminarShare.getPrincipalCourseId())){
                return false;
            }
        }
        seminarShareMapper.insertSeminarShare(seminarShare);
        return true;
    }
    public boolean update(SeminarShare seminarShare){
        if(!seminarShareMapper.selectSeminarShareById(seminarShare.getId()).isEmpty()) {
            seminarShareMapper.updateSeminarShare(seminarShare);
            return true;
        }
        return false;
    }
    public List<SeminarShare> getAllSeminarShare(){
        return seminarShareMapper.selectAllSeminarShare();
    }
    public List<SeminarShare> getById(String id){
        return seminarShareMapper.selectSeminarShareById(id);
    }
    public List<SeminarShare> getByPCourseId(String principalCourseId){
        return seminarShareMapper.selectSeminarShareByPrincipalCourseId(principalCourseId);
    }
    public List<SeminarShare> getBySubCourseId(String subordinateCourseId){
        return seminarShareMapper.selectSeminarShareBySubordinateCourseId(subordinateCourseId);
    }
    public void deleteById(String id){
        seminarShareMapper.deleteSeminarShareById(id);
    }
    public void deleteByPCourseId(String principalCourseId){
        seminarShareMapper.deleteSeminarShareByPrincipalCourseId(principalCourseId);
    }
    public void deleteBySubCourseId(String subordinateCourseId){
        seminarShareMapper.deleteSeminarShareBySubordinateCourseId(subordinateCourseId);
    }

}
