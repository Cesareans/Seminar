package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.TeamDAO;
import seminar.dao.application.ShareSeminarApplicationDAO;
import seminar.dao.application.ShareTeamApplicationDAO;
import seminar.dao.application.TeamValidApplicationDAO;
import seminar.entity.Team;
import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.application.ShareTeamApplication;
import seminar.entity.application.TeamValidApplication;
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
    private final TeamValidApplicationDAO teamValidApplicationDAO;
    private final CourseDAO courseDAO;
    private final TeamDAO teamDAO;
    private final static int REJECT = 0;
    private final static int ACCEPT = 1;

    @Autowired
    public ApplicationServiceImpl(ShareTeamApplicationDAO shareTeamApplicationDAO, ShareSeminarApplicationDAO shareSeminarApplicationDAO, TeamValidApplicationDAO teamValidApplicationDAO, CourseDAO courseDAO, TeamDAO teamDAO) {
        this.shareTeamApplicationDAO = shareTeamApplicationDAO;
        this.shareSeminarApplicationDAO = shareSeminarApplicationDAO;
        this.teamValidApplicationDAO = teamValidApplicationDAO;
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
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

    @Override
    public boolean createTeamValidApplication(TeamValidApplication teamValidApplication) {
        return teamValidApplicationDAO.create(teamValidApplication);
    }

    @Override
    public List<TeamValidApplication> getTeamValidApplicationByTeacherId(String teacherId) {
        return teamValidApplicationDAO.getByTeacherId(teacherId);
    }

    @Override
    public boolean handleTeamValidApplication(ApplicationHandleDTO applicationHandleDTO) {
        teamValidApplicationDAO.deleteById(applicationHandleDTO.getAppId());
        Team team = teamDAO.getById(applicationHandleDTO.getTeamId()).get(0);
        if(applicationHandleDTO.getOperationType() == ACCEPT){
            team.setStatus(1);
            teamDAO.update(team);
            return true;
        }else if(applicationHandleDTO.getOperationType() == REJECT){
            team.setStatus(0);
            teamDAO.update(team);
            return true;
        }
        return false;
    }
}
