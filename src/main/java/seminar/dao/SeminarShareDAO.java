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
    private SeminarShareMapper seminarShareMapper;
    @Autowired
    public SeminarShareDAO(SeminarShareMapper seminarShareMapper){
        this.seminarShareMapper = seminarShareMapper;
    }

    public void create(SeminarShare seminarShare){
        seminarShareMapper.insertSeminarShare(seminarShare);
    }
    public void update(SeminarShare seminarShare){
        seminarShareMapper.updateSeminarShare(seminarShare);
    }
    public List<SeminarShare> getAllSeminarShare(){
        return seminarShareMapper.selectAllSeminarShare();
    }
    public List<SeminarShare> retrieveById(String id){
        return seminarShareMapper.selectSeminarShareById(id);
    }
    public List<SeminarShare> retrieveByPCourseId(String principalCourseId){
        return seminarShareMapper.selectSeminarShareByPrincipalCourseId(principalCourseId);
    }
    public List<SeminarShare> retrieveBySubCourseId(String subordinateCourseId){
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
