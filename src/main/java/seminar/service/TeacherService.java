package seminar.service;

import seminar.entity.Klass;
import seminar.entity.Course;
import seminar.entity.Round;
import seminar.entity.Seminar;
import seminar.entity.message.GroupValidityMsg;
import seminar.entity.message.SeminarShareMsg;
import seminar.entity.message.TeamShareMsg;
import seminar.entity.regulation.MaxMinRegulation;

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
    List<Course> getCoursesByTeacherId(String teacherId);

    /**
     * @author lyf
     */
    boolean createCourse(Course course);

    /**
     * @author lyf
     */
    void deleteCourseById(String courseId);

    /**
     * @author lyf
     */
    boolean updateCourse(Course course);

    /**
     * @author lyf
     */
    boolean createKlass(Klass klass);

    /**
     * @author lyf
     */
    boolean updateKlass(Klass klass);

    /**
     * @author lyf
     */
    void deleteKlassById(String klassId);

    /**
     * Add a course's round.
     *modified by lyf
     * @author cesare
     */
    boolean addRound(Round round);

    /**
     * @author lyf
     */
    boolean createSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    boolean updateSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    void deleteSeminarById(String seminarId);

    /**
     * @author lyf
     */
    void deleteSeminarByRoundId(String courseId);

    /**
     * Create a new TeamShareMsg
     *
     * @param teamShareMsg refer gist
     * @return success or fail
     * @author SWJ
     */
    boolean createTeamShareMsg(TeamShareMsg teamShareMsg);

    /**
     * Check teacher's own groupValidityMsg
     *
     * @param teacherId refer gist.
     * @return This teacher's all groupValidityMsg
     * @author SWJ
     */
    List<GroupValidityMsg> getGroupValidityMsgByTeacherId(String teacherId);

    /**
     * Agree this team's invalid state, update this team's valid
     *
     * @param teamId refer gist.
     * @return success or fail
     * @author SWJ
     */
    boolean updateTeam(String teamId);

    /**
     * Create a new seminarShareMsg
     *
     * @param seminarShareMsg refer gist
     * @return success or fail
     * @author SWJ
     */
    boolean createSeminarShareMsg(SeminarShareMsg seminarShareMsg);

    /**
     * Updete the report score when teacher give score
     *
     * @param reportScore    refer gist.
     * @param klassSeminarId refer gist
     * @return success of fail
     * @author SWJ
     */
    boolean updateReportScore(int reportScore, String klassSeminarId);
}
