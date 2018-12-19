package seminar.service;

import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.application.ShareTeamApplication;
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
     * @param teacherId the refer gist
     * @return the shareTeamApplications of teacher
     * @author Cesare
     */
    List<ShareTeamApplication> getShareTeamApplicationByTeacherId(String teacherId);

    /**
     * Handle share seminar application
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
     * @param teacherId the refer gist
     * @return the shareSeminarApplication of teacher
     * @author Cesare
     */
    List<ShareSeminarApplication> getShareSeminarApplicationByTeacherId(String teacherId);

    /**
     * Handle share team application
     * @param applicationHandleDTO the dto
     * @return whether the operation is successful
     */
    boolean handleShareTeamApplication(ApplicationHandleDTO applicationHandleDTO);
}
