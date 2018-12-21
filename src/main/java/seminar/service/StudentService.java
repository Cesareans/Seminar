package seminar.service;

import seminar.entity.Course;
import seminar.entity.Klass;

import java.util.List;

import seminar.entity.Student;
import seminar.entity.Team;

import java.util.List;

/**
 * @author Cesare
 */
public interface StudentService {
    /**
     * Activate a student's account
     *
     * @param studentId the student's account id
     * @param password  the student's new password
     * @param email     the student's new email
     * @return whether the operation is successful
     * @author cesare
     */
    boolean activate(String studentId, String password, String email);

    /**
     * Modify a student's email
     *
     * @param studentId the student's account id
     * @param email     the student's new email
     * @return whether the operation is successful
     * @author cesare
     */
    boolean modifyEmail(String studentId, String email);

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
     * Modify a student's password
     *
     * @param studentId the student's account id
     * @param password  the student's new password
     * @return whether the operation is successful
     * @author cesare
     */
    boolean modifyPasswordViaId(String studentId, String password);

    /**
     * Get a student's courses via teacherId
     *
     * @param studentId refer gist
     * @return list of student's courses
     * @author cesare
     */
    List<Course> getCoursesByStudentId(String studentId);

    /**
     * Get a student's klasses via teacherId
     *
     * @param studentId refer gist
     * @return list of student's klasses
     * @author cesare
     */
    List<Klass> getKlassesByStudentId(String studentId);

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

    List<Student> getAllUnTeamedStudentsByCourseId(String courseId);

    void exitTeam(String studentId, String teamId);

}
