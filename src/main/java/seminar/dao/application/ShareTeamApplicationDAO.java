package seminar.dao.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.application.ShareTeamApplication;
import seminar.mapper.TeacherMapper;
import seminar.mapper.application.ShareTeamApplicationMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class ShareTeamApplicationDAO {
    private final ShareTeamApplicationMapper shareTeamApplicationMapper;
    private final TeacherMapper teacherMapper;

    @Autowired
    private ShareTeamApplicationDAO(ShareTeamApplicationMapper shareTeamApplicationMapper, TeacherMapper teacherMapper) {
        this.shareTeamApplicationMapper = shareTeamApplicationMapper;
        this.teacherMapper = teacherMapper;
    }

    /**
     * The course which is a subordinateCourse can't send and receive a seminar share handler
     */
    public boolean create(ShareTeamApplication shareTeamApplication) {
        if (!shareTeamApplicationMapper.selectShareTeamApplicationByMainCourseIdAndSubCourseId(shareTeamApplication.getMainCourseId(), shareTeamApplication.getSubCourseId()).isEmpty()) {
            return false;
        }
        shareTeamApplicationMapper.insertShareTeamApplication(shareTeamApplication);
        return true;
    }

    public List<ShareTeamApplication> getByTeacherId(String teacherId) {
        List<ShareTeamApplication> shareTeamApplications = shareTeamApplicationMapper.selectShareTeamApplicationByTeacherId(teacherId);
        shareTeamApplications.forEach(shareTeamApplication -> {
            shareTeamApplication.setMainTeacher(teacherMapper.selectTeacherById(shareTeamApplication.getMainCourse().getTeacherId()).get(0));
        });
        return shareTeamApplications;
    }

    public void deleteById(String id) {
        shareTeamApplicationMapper.deleteShareTeamApplicationById(id);
    }
}
