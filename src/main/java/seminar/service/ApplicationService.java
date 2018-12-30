package seminar.service;

import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.application.ShareTeamApplication;
import seminar.entity.application.TeamValidApplication;
import seminar.pojo.dto.ApplicationHandleDTO;

import java.util.List;

/**
 * @author Cesare
 */
public interface ApplicationService {

    /**
     * Create a new ShareTeamApplication
     *
     * @param shareTeamApplication the new share team application
     * @return whether the operation is successful
     * @author Cesare
     */
    boolean createShareTeamApplication(ShareTeamApplication shareTeamApplication);


    /**
     * Get the shareTeamApplications of teacher via teacherId
     *
     * @param teacherId the refer gist
     * @return the shareTeamApplications of teacher
     * @author Cesare
     */
    List<ShareTeamApplication> getShareTeamApplicationByTeacherId(String teacherId);

    /**
     * Handle share seminar application
     *
     * @param applicationHandleDTO the dto
     * @return whether the operation is successful
     */
    boolean handleShareSeminarApplication(ApplicationHandleDTO applicationHandleDTO);

    /**
     * Create a new ShareSeminarApplication
     *
     * @param shareSeminarApplication the shareSeminarApplication
     * @return whether the operation is successful
     * @author Cesare
     */
    boolean createShareSeminarApplication(ShareSeminarApplication shareSeminarApplication);

    /**
     * Get the shareSeminarApplication of teacher via teacherId
     *
     * @param teacherId the refer gist
     * @return the shareSeminarApplication of teacher
     * @author Cesare
     */
    List<ShareSeminarApplication> getShareSeminarApplicationByTeacherId(String teacherId);

    /**
     * Handle share team application
     *
     * @param applicationHandleDTO the dto
     * @return whether the operation is successful
     */
    boolean handleShareTeamApplication(ApplicationHandleDTO applicationHandleDTO);

    /**
     * Create a new TeamValidApplication
     *
     * @param teamValidApplication the new TeamValidApplication
     * @return whether the operation is successful
     */
    boolean createTeamValidApplication(TeamValidApplication teamValidApplication);

    /**
     * Get teamValidApplications of a teacher
     *
     * @param teacherId the teacher refer gist
     * @return the teamValidApplications
     */
    List<TeamValidApplication> getTeamValidApplicationByTeacherId(String teacherId);

    /**
     * Handle team valid application
     *
     * @param applicationHandleDTO the dto
     * @return whether the operation is successful
     */
    boolean handleTeamValidApplication(ApplicationHandleDTO applicationHandleDTO);
}
