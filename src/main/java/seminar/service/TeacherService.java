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
     * Create a klass with given klass info.
     *
     * @param klass the klass entity
     * @return whether the create is successful.
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
     * @author lyf
     */
    boolean updateKlass(Klass klass);

    /**
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
     * @author lyf
     */
    boolean createSeminar(Seminar seminar);

    /**
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
     * @author lyf
     */
    void deleteSeminarById(String seminarId);

    /**
     * @author lyf
     */
    void deleteSeminarByRoundId(String courseId);

    /**
     * Create a new ShareTeamApplication
     *
     * @param shareTeamApplication refer gist
     * @return success or fail
     * @author SWJ
     */
    boolean createTeamShareMsg(ShareTeamApplication shareTeamApplication);

    /**
     * Check teacher's own groupValidityMsg
     *
     * @param teacherId refer gist.
     * @return This teacher's all groupValidityMsg
     * @author SWJ
     */
    List<TeamValidApplication> getGroupValidityMsgByTeacherId(String teacherId);

    /**
     * Agree this team's invalid state, update this team's valid
     *
     * @param teamId refer gist.
     * @return success or fail
     * @author SWJ
     */
    boolean updateTeam(String teamId);

    /**
     * Create a new shareSeminarApplication
     *
     * @param shareSeminarApplication refer gist
     * @return success or fail
     * @author SWJ
     */
    boolean createSeminarShareMsg(ShareSeminarApplication shareSeminarApplication);

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
