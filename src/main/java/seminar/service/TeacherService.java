package seminar.service;

import org.apache.poi.ss.usermodel.Workbook;
import seminar.entity.Course;
import seminar.entity.Klass;
import seminar.entity.Round;
import seminar.entity.Seminar;
import seminar.entity.application.ShareTeamApplication;
import seminar.entity.application.TeamValidApplication;
import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.relation.KlassRound;

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
     * @return whether the operation is successful
     * @author cesare
     */
    boolean activate(String teacherId, String password);

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
     * Create a course
     *
     * @param course the Course entity
     * @return whether creating course successfully
     * @author lyf
     */
    boolean createCourse(Course course);

    /**
     * Delete a course by courseId
     * @param courseId the refer gist
     * @author lyf
     */
    void deleteCourseById(String courseId);

    /**
     * Update the information of a course
     * @param course the Course entity
     * @return whether updating course successfully
     * @author lyf
     */
    boolean updateCourse(Course course);

    /**
     * Create a klass with given klass info.
     * @param klass the klass entity
     * @return whether creating klass successfully
     * @author lyf
     */
    boolean createKlass(Klass klass);

    /**
     * Insert students into klass with given workbook.
     * The klass's property-id is required.
     *
     * @param klass    The klass that we will insert students into
     * @param workbook the students workbook.
     * @author cesare
     */
    void insertKlassStudent(Klass klass, Workbook workbook);

    /**
     * Delete a klass by its id
     * @param klassId the refer gist
     * @author lyf
     */
    void deleteKlassById(String klassId);

    /**
     * Direct add a new round to a course
     * Only the courseId is used.
     *
     * @param round the round
     * @author cesare
     */
    void addRound(Round round);

    /**
     * Create a seminar
     *
     * @param seminar the Seminar entity
     * @author lyf
     */
    void createSeminar(Seminar seminar);

    /**
     * Update the information of a seminar
     *
     * @param seminar the Seminar entity
     * @return whether updating seminar successfully
     * @author lyf
     */
    boolean updateSeminar(Seminar seminar);

    /**
     * Update score types of a round
     * @param typeRound the new round. Round id and three score type is required.
     * @return whether the operation is successful.
     * @author cesare
     */
    boolean updateRoundScoreType(Round typeRound);

    /**
     * Update enroll limit of a round
     * @param klassRound the new klassRound. Klass id and round id is referred. And new enroll limit is required.
     * @return whether the operation is successful.
     * @author cesare
     */
    boolean updateKlassRound(KlassRound klassRound);

    /**
     * Delete a seminar via seminarId

     * @param seminarId the refer gist
     * @author lyf
     */
    void deleteSeminarById(String seminarId);

    /**
     * Update the report score when teacher give score
     *
     * @param reportScore    refer gist.
     * @param klassSeminarId refer gist
     * @return success of fail
     * @author SWJ
     */
    boolean updateReportScore(int reportScore, String klassSeminarId);

}
