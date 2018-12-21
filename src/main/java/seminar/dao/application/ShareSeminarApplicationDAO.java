package seminar.dao.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.application.ShareSeminarApplication;
import seminar.mapper.TeacherMapper;
import seminar.mapper.application.ShareSeminarApplicationMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class ShareSeminarApplicationDAO {
    private final ShareSeminarApplicationMapper shareSeminarApplicationMapper;
    private final TeacherMapper teacherMapper;
    @Autowired
    public ShareSeminarApplicationDAO(ShareSeminarApplicationMapper shareSeminarApplicationMapper, TeacherMapper teacherMapper) {
        this.shareSeminarApplicationMapper = shareSeminarApplicationMapper;
        this.teacherMapper = teacherMapper;
    }

    /**
     * The course which is a subordinateCourse can't send a seminar share message
     * @author Cesare
     */
    public boolean create(ShareSeminarApplication shareSeminarApplication) {
        if(!shareSeminarApplicationMapper.selectShareSeminarApplicationByMainCourseIdAndSubCourseId(shareSeminarApplication.getMainCourseId(), shareSeminarApplication.getSubCourseId()).isEmpty()){
            return false;
        }
        shareSeminarApplicationMapper.insertShareSeminarApplication(shareSeminarApplication);
        return true;
    }

    /**
     * @author Cesare
     */
    public boolean update(ShareSeminarApplication shareSeminarApplication) {
        if (!shareSeminarApplicationMapper.selectShareSeminarApplicationById(shareSeminarApplication.getId()).isEmpty()) {
            shareSeminarApplicationMapper.updateShareSeminarApplication(shareSeminarApplication);
            return true;
        }
        return false;
    }

    /**
     * @author Cesare
     */
    public List<ShareSeminarApplication> getByTeacherId(String teacherId) {
        List<ShareSeminarApplication> shareSeminarApplications = shareSeminarApplicationMapper.selectShareSeminarApplicationByTeacherId(teacherId);
        shareSeminarApplications.forEach(shareSeminarApplication -> {
            shareSeminarApplication.setMainTeacher(teacherMapper.selectTeacherById(shareSeminarApplication.getMainCourse().getTeacherId()).get(0));
        });
        return shareSeminarApplications;
    }

    /**
     * @author Cesare
     */
    public void deleteById(String id){
        shareSeminarApplicationMapper.deleteShareSeminarApplicationById(id);
    }
}
