package seminar.service;

import seminar.entity.*;

import java.util.List;

/**
 * @author Cesare
 */
public interface TeacherService {
    /**
     * Get the teacher entity via teacherNum
     *
     * @param teacherNum refer gist
     * @return teacher entity
     */
    public List<Teacher> getTeacherByTN(String teacherNum);

    /**
     * TODO:May not be useful. Can be deleted afterwards
     * Get a teacher's courses via teacherId
     *
     * @param teacherId refer gist
     * @return list of teacher's courses
     */
    public List<Course> getCoursesByTeacherId(String teacherId);

    /**
     * @author lyf
     */
    public boolean createCourse(Course course, MaxMinRegulation maxminregulation);

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
     * @author SWJ
     * @param  teamShareMsg refer gist
     * @return success or fail
     */
    public boolean createTeamShareMsg(TeamShareMsg teamShareMsg);

    /**
     * Create a new teamShare when accept TeamShareMsg
     * @author SWJ
     * @param  teamShare refer gist
     * @return success or fail
     */
    public boolean createTeamShare(TeamShare teamShare);

    /**
     * Delete the teamShare when cancel a teamShare
     * @author SWJ
     * @param  id refer gist. principal_course_id or subordinate_course_id
     * @return void
     */
    public void deleteTeamShare(String id);

    /**
     * Check teacher's own groupValidityMsg
     * @author SWJ
     * @param  teacherId refer gist.
     * @return This teacher's all groupValidityMsg
     */
    public List<GroupValidityMsg> getGroupValidityMsgByTeacherId(String teacherId);

    /**
     * Agree this team's invalid state, update this team's valid
     * @author SWJ
     * @param  teamId refer gist.
     * @return success or fail
     */
    public boolean updateTeam(String teamId);

    /**
     * Check all teams which in current course
     * @author SWJ
     * @param  courseId refer gist.
     * @return Team entity
     */
    public List<Team> getTeamByTeacherId(String courseId);
}
