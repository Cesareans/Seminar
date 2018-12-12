package seminar.service;

import seminar.entity.Team;

/**
 * @author Cesare
 */
public interface StudentService {

    /**
     * Modify a student's password when he/she forget his/her password
     *
     * @param sn       the student num
     * @param password the new password
     * @return whether the operation is success
     * @author cesare
     */
    boolean modifyPasswordViaSn(String sn, String password);
    /**
     * Create a new team
     *
     * @param team refer gist
     * @param courseId the new team in which course
     * @return success or fail
     * @author SWJ
     */
    boolean createTeam(Team team,String courseId);

    /**
     * Leave from the team
     *
     * @param studentId refer gist
     * @param courseId the new team in which course
     * @author SWJ
     */
    void leaveTeam(String studentId, String courseId);
}
