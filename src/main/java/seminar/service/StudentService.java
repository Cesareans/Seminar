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
     * Enroll a seminar
     * @param ksId the klass seminar's id
     * @param teamId the student team's id
     * @param sn the wanna register serial number
     * @return whether the operation is successful
     */
    boolean seminarEnroll(String ksId, String teamId, int sn);

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

    List<Team> getAllTeamInformation(String courseId);

    List<Student> getAllUnTeamedStudentsByCourseId(String courseId);

    void exitTeam(String studentId, String teamId);

}
