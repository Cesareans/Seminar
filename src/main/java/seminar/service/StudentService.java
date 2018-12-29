package seminar.service;

import seminar.entity.Klass;
import seminar.entity.Team;

import java.util.List;

/**
 * @author Cesare
 */
public interface StudentService {
    /**
     * Activate a student's account
     * @param studentId the student's account id
     * @param password  the student's new password
     * @param email     the student's new email
     * @return whether the operation is successful
     * @author cesare
     */
    boolean activate(String studentId, String password, String email);

    /**
     * Modify a student's email via student id
     * @param studentId the student's account id
     * @param email     the student's new email
     * @return whether the operation is successful
     * @author cesare
     */
    boolean modifyEmail(String studentId, String email);

    /**
     * Modify a student's password via student number
     * @param sn       the student num
     * @param password the new password
     * @return whether the operation is success
     * @author cesare
     */
    boolean modifyPasswordViaSn(String sn, String password);

    /**
     * Modify a student's password via student id
     * @param studentId the student's account id
     * @param password  the student's new password
     * @return whether the operation is successful
     * @author cesare
     */
    boolean modifyPasswordViaId(String studentId, String password);

    /**
     * Enroll a seminar
     * @param ksId the klass seminar's id
     * @param teamId the student team's id
     * @param sn the wanna register serial number
     * @return whether the operation is successful
     */
    boolean enrollSeminar(String ksId, String teamId, int sn);

    /**
     * Cancel seminar enroll
     * @param attendanceId refer gist of the target attendance to delete
     */
    void cancelEnroll(String attendanceId);

    /**
     * Upload preFile for attendance
     * @param attendanceId the refer gist
     * @param preFileName the file name
     */
    void uploadPreFile(String attendanceId, String preFileName);

    /**
     * Upload reportFile for attendance
     * @param attendanceId the refer gist
     * @param reportFileName the file name
     */
    void uploadReportFile(String attendanceId, String reportFileName);

    /**
     * create team
     * @author Xinyu Shi
     * @param team the new team
     * @return whether the operation is successful
     */
    boolean createTeam(Team team);

    /**
     * Update team
     * @author Cesare
     * @param team the new team
     * @return whether the operation is successful
     */
    boolean updateTeam(Team team);

    /**
     * Add member to team
     * @param studentId the student refer gist
     * @param teamId the team refer gist
     * @return whether the operation is successful
     */
    boolean addTeamMember(String studentId, String teamId);

    /**
     * Delete member from team
     * @param studentId the student refer gist
     * @param teamId the team refer gist
     * @return whether the operation is successful
     */
    boolean deleteTeamMember(String studentId, String teamId);

    /**
     * Dissolve a team
     * @param teamId the team refer gist
     */
    void dissolveTeam(String teamId);
}
