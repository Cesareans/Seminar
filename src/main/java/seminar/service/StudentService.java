package seminar.service;

import seminar.entity.Student;
import seminar.entity.Team;

import java.util.List;

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
     * Create a team by a student who is without a team.
     * @author Xinyu Shi
     * @param studentId
     * @param courseId
     * @param klassId
     * @param teamName
     * @return
     */
    boolean createTeam(String studentId, String courseId, String klassId, String teamName);

    List<Team> getAllTeamInformation(String courseId);

    List<Student> getAllUnteamedStudentsByCourseId(String courseId);

    void exitTeam(String studentId, String teamId);

}
