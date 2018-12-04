package seminar.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.CourseShareMsg;
import seminar.entity.SeminarShareMsg;
import seminar.mapper.CourseShareMsgMapper;
import seminar.mapper.SeminarShareMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class CourseShareMsgDAO {
    private CourseShareMsgMapper courseShareMsgMapper;
    @Autowired
    private  CourseShareMsgDAO(CourseShareMsgMapper courseShareMsgMapper){
        this.courseShareMsgMapper=courseShareMsgMapper;
    }

    public void create(CourseShareMsg courseShareMsg){
        courseShareMsgMapper.insertCourseShareMsg(courseShareMsg);
    }
    public void update(CourseShareMsg courseShareMsg){
        courseShareMsgMapper.updateCourseShareMsg(courseShareMsg);
    }
    public List<CourseShareMsg> retrieveAll(){
        return courseShareMsgMapper.selectAllCourseShareMsg();
    }
    public List<CourseShareMsg> retrieveById(String id){
        return courseShareMsgMapper.selectCourseShareMsgById(id);
    }
    public List<CourseShareMsg> retrieveByPCourseId(String principalCourseId){
        return courseShareMsgMapper.selectCourseShareMsgByPrincipalCourseId(principalCourseId);
    }
    public List<CourseShareMsg> retrieveBySubCourseId(String subordinateCourseId){
        return courseShareMsgMapper.selectCourseShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public List<CourseShareMsg> retrieveByTeacherId(String teacherId){
        return courseShareMsgMapper.selectCourseShareMsgByTeacherId(teacherId);
    }
    public void deleteById(String id){
        courseShareMsgMapper.deleteCourseShareMsgById(id);
    }
    public void deleteByPCourseId(String principalCourseId){
        courseShareMsgMapper.deleteCourseShareMsgByPrincipalCourseId(principalCourseId);
    }
    public void deleteBySubCourseId(String subordinateCourseId){
        courseShareMsgMapper.deleteCourseShareMsgBySubordinateCourseId(subordinateCourseId);
    }
    public void deleteByTeacherId(String teacherId){
        courseShareMsgMapper.deleteCourseShareMsgByTeacherId(teacherId);
    }
}
