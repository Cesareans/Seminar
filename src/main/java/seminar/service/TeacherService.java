package seminar.service;

import seminar.entity.Clbum;
import seminar.entity.Course;
import seminar.entity.Seminar;
import seminar.entity.message.GroupValidityMsg;
import seminar.entity.message.SeminarShareMsg;
import seminar.entity.message.TeamShareMsg;
import seminar.entity.regulation.MaxMinRegulation;
import seminar.entity.share.SeminarShare;
import seminar.entity.share.TeamShare;

import java.util.List;

/**
 * @author Cesare
 */
public interface TeacherService {
    /**
     * Activate a teacher's account
     *
     * @param teacherId the teacher's account id
     * @param password  the teacher's new password
     * @param email     the teacher's new email
     * @return whether the operation is successful
     * @author cesare
     */
    boolean activate(String teacherId, String password, String email);

    /**
     * Modify a teacher's email
     *
     * @param teacherId the teacher's account id
     * @param email     the teacher's new email
     * @return whether the operation is successful
     * @author cesare
     */
    boolean modifyEmail(String teacherId, String email);


    /**
     * Modify a teacher's password when he/she forget his/her password
     *
     * @param tn       the teacher num
     * @param password the new password
     * @return whether the operation is success
     * @author cesare
     */
    boolean modifyPasswordViaTn(String tn, String password);

    /**
     * Modify a teacher's password
     *
     * @param teacherId the teacher's account id
     * @param password  the teacher's new password
     * @return whether the operation is successful
     * @author cesare
     */
    boolean modifyPasswordViaId(String teacherId, String password);

    /**
     * Get a teacher's courses via teacherId
     *
     * @param teacherId refer gist
     * @return list of teacher's courses
     * @author cesare
     */
    public List<Course> getCoursesByTeacherId(String teacherId);

    /**
     * @author lyf
     */
    public boolean createCourse(Course course);

    /**
     * @author lyf
     */
    public void deleteCourseById(String courseId);

    /**
     * @author lyf
     */
    public boolean updateCourse(Course course, MaxMinRegulation maxMinRegulation);

    /**
     * @author lyf
     */
    public boolean createClbum(Clbum clbum);

    /**
     * @author lyf
     */
    public boolean updateClbum(Clbum clbum);

    /**
     * @author lyf
     */
    public void deleteClbumById(String clbumId);

    /**
     * @author lyf
     */
    public boolean createSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    public boolean updateSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    public void deleteSeminarByRoundId(String courseId);

    /**
     * Create a new TeamShareMsg
     *
     * @param teamShareMsg refer gist
     * @return success or fail
     * @author SWJ
     */
    public boolean createTeamShareMsg(TeamShareMsg teamShareMsg);

    /**
     * Create a new teamShare when accept TeamShareMsg
     *
     * @param teamShare refer gist
     * @return success or fail
     * @author SWJ
     */
    public boolean createTeamShare(TeamShare teamShare);

    /**
     * Delete the teamShare when cancel a teamShare
     *
     * @param id refer gist. principal_course_id or subordinate_course_id
     * @author SWJ
     */
    public void deleteTeamShare(String id);

    /**
     * Check teacher's own groupValidityMsg
     *
     * @param teacherId refer gist.
     * @return This teacher's all groupValidityMsg
     * @author SWJ
     */
    public List<GroupValidityMsg> getGroupValidityMsgByTeacherId(String teacherId);

    /**
     * Agree this team's invalid state, update this team's valid
     *
     * @param teamId refer gist.
     * @return success or fail
     * @author SWJ
     */
    public boolean updateTeam(String teamId);

    /**
     * Create a new seminarShareMsg
     *
     * @param seminarShareMsg refer gist
     * @return success or fail
     * @author SWJ
     */
    public boolean createSeminarShareMsg(SeminarShareMsg seminarShareMsg);

    /**
     * Create a new seminarShare when accept seminarShareMsg
     *
     * @param seminarShare refer gist
     * @return success or fail
     * @author SWJ
     */
    public boolean createSeminarShare(SeminarShare seminarShare);

    /**
     * Delete the seminarShare when cancel a seminarShare
     *
     * @param courseId refer gist. principal_course_id or subordinate_course_id
     * @author SWJ
     */
    public void deleteSeminarShare(String courseId);

    /**
     * Updete the report score when teacher give score
     *
     * @param reportScore    refer gist.
     * @param clbumSeminarId refer gist
     * @return success of fail
     * @author SWJ
     */
    public boolean updateReportScore(int reportScore, String clbumSeminarId);
}
