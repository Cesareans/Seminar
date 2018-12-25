package seminar.service;

import seminar.entity.*;

import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public interface SeminarService {
    /**
     * Get a course via course ID
     *
     * @param courseId the refer gist
     * @return the course
     */
    List<Course> getCourseByCourseId(String courseId);

    /**
     * Get a teacher's courses via teacherId
     *
     * @param teacherId the refer gist
     * @return list of teacher's courses
     * @author cesare
     */
    List<Course> getCoursesByTeacherId(String teacherId);

    /**
     * Get a course's other course via course id
     *
     * @param courseId the refer gist
     * @return the other course of the course.
     */
    List<Course> getOtherCoursesByCourseId(String courseId);

    /**
     * Get the main courses of a course via its courseId
     *
     * @param courseId the refer gist
     * @return the main courses' map
     * - team:team share main courses
     * - seminar:seminar share main courses.
     */
    Map<String, List<Course>> getMainCoursesByCourseId(String courseId);

    /**
     * Get the sub courses of a course via its courseId
     *
     * @param courseId the refer gist
     * @return the main courses' map
     * - team:team share sub courses
     * - seminar:seminar share sub courses.
     */
    Map<String, List<Course>> getSubCoursesByCourseId(String courseId);


    /**
     * [Shared]
     * Get a course's rounds via courseId
     *
     * @param courseId refer gist
     * @return list of course's rounds
     * @author cesare
     */
    List<Round> getRoundsByCourseId(String courseId);

    /**
     * Get a round via roundId
     *
     * @param roundId the refer gist
     * @return the round with the roundId
     * @author cesare
     */
    List<Round> getRoundByRoundId(String roundId);



    /**
     * Get the max seminar serial of a course
     *
     * @param courseId the refer gist
     * @return the max seminar serial
     */
    int getMaxSeminarSerialByCourseId(String courseId);

    /**
     * Get a klass seminar's enroll list, which means that if a position do not has corresponding attendance, the enroll will be regarded as null.
     *
     * @param ksId the refer gist
     * @return the class seminar's enroll list.
     * @author cesare
     */
    List<Attendance> getEnrollListByKsId(String ksId);

    /**
     * [Shared]
     * Get a course's teams via courseId
     *
     * @param courseId refer gist
     * @return list of course's teams
     * @author cesare
     */
    List<Team> getTeamsByCourseId(String courseId);

    /**
     * Get the team via studentId and courseId
     * @param courseId the refer gist
     * @param studentId the refer gist
     * @return the team
     */
    Team getTeamByCourseIdAndStudentId(String courseId, String studentId);

    /**
     * Get the team via team id
     * @param teamId the refer gist
     * @return the team
     */
    Team getTeamByTeamId(String teamId);
    /**
     * Get a course's klass via courseId
     *
     * @param courseId refer gist
     * @return list of course's klass
     * @author cesare
     */
    List<Klass> getKlassByCourseId(String courseId);

    /**
     * Get a course's klass via klassId
     *
     * @param klassId refer gist
     * @return list of course's klass
     * @author cesare
     */
    List<Klass> getKlassById(String klassId);


    /**
     * Get the seminar via seminar id
     *
     * @param seminarId the refer gist
     * @return the seminar with the seminar id
     * @author cesare
     */
    List<Seminar> getSeminarBySeminarId(String seminarId);

    /**
     * Get the klassSeminar via klassSeminar id
     *
     * @param klassSeminarId the refer gist
     * @return the klassSeminar with the id
     * @author cesare
     */
    List<KlassSeminar> getKlassSeminarByKlassSeminarId(String klassSeminarId);


    /**
     * Get the klass seminar via klass id and seminar id.
     *
     * @param klassId   the first refer gist
     * @param seminarId the second refer gist
     * @return the klassSeminar with the union gist.
     * @author lyf
     */
    List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(String klassId, String seminarId);

}
