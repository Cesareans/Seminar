package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.application.ShareSeminarApplicationDAO;
import seminar.dao.application.ShareTeamApplicationDAO;
import seminar.entity.Course;
import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.application.ShareTeamApplication;
import seminar.pojo.dto.ApplicationHandleDTO;
import seminar.service.ApplicationService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ShareTeamApplicationDAO shareTeamApplicationDAO;
    private final ShareSeminarApplicationDAO shareSeminarApplicationDAO;
    private final CourseDAO courseDAO;
    private final static int REJECT = 0;
    private final static int ACCEPT = 1;

    @Autowired
    public ApplicationServiceImpl(ShareTeamApplicationDAO shareTeamApplicationDAO, ShareSeminarApplicationDAO shareSeminarApplicationDAO, CourseDAO courseDAO) {
        this.shareTeamApplicationDAO = shareTeamApplicationDAO;
        this.shareSeminarApplicationDAO = shareSeminarApplicationDAO;
        this.courseDAO = courseDAO;
    }

    /**
     * @author Cesare
     */
    @Override
    public boolean createShareTeamApplication(ShareTeamApplication shareTeamApplication) {
        return shareTeamApplicationDAO.create(shareTeamApplication);
    }

    /**
     * @author Cesare
     */
    @Override
    public List<ShareTeamApplication> getShareTeamApplicationByTeacherId(String teacherId) {
        return shareTeamApplicationDAO.getByTeacherId(teacherId);
    }

    /**
     * @author Cesare
     */
    @Override
    public boolean handleShareTeamApplication(ApplicationHandleDTO applicationHandleDTO) {
        shareTeamApplicationDAO.deleteById(applicationHandleDTO.getAppId());
        if (applicationHandleDTO.getOperationType() == ACCEPT) {
            return courseDAO.buildTeamShare(applicationHandleDTO.getMainCourseId(),applicationHandleDTO.getSubCourseId());
        }
        return applicationHandleDTO.getOperationType() == REJECT;
    }

    /**
     * @author Cesare
     */
    @Override
    public boolean createShareSeminarApplication(ShareSeminarApplication shareSeminarApplication) {
        return shareSeminarApplicationDAO.create(shareSeminarApplication);
    }

    /**
     * @author Cesare
     */
    @Override
    public List<ShareSeminarApplication> getShareSeminarApplicationByTeacherId(String teacherId) {
        return shareSeminarApplicationDAO.getByTeacherId(teacherId);
    }

    @Override
    public boolean handleShareSeminarApplication(ApplicationHandleDTO applicationHandleDTO) {
        shareSeminarApplicationDAO.deleteById(applicationHandleDTO.getAppId());
        if(applicationHandleDTO.getOperationType() == ACCEPT){
            return courseDAO.buildSeminarShare(applicationHandleDTO.getMainCourseId(),applicationHandleDTO.getSubCourseId());
        }
        return applicationHandleDTO.getOperationType() == REJECT;
    }
}
