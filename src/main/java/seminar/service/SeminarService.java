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
     * @param courseId the refer gist
     * @return the course
     */
    List<Course> getCourseByCourseId(String courseId);

    /**
     * Get the main courses of a course via its courseId
     * @param courseId the refer gist
     * @return the main courses' map
     * - team:team share main courses
     * - seminar:seminar share main courses.
     */
    Map<String, List<Course>> getMainCourses(String courseId);

    /**
     * Get the sub courses of a course via its courseId
     * @param courseId the refer gist
     * @return the main courses' map
     * - team:team share sub courses
     * - seminar:seminar share sub courses.
     */
    Map<String, List<Course>> getSubCourses(String courseId);

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
     * [Shared]
     * Get a course's rounds via courseId
     *
     * @param courseId refer gist
     * @return list of course's rounds
     * @author cesare
     */
    List<Round> getRoundsByCourseId(String courseId);

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
     * Get a klass seminar's enroll list, which means that if a position do not has corresponding attendance, the enroll will be regarded as null.
     *
     * @param ksId the refer gist
     * @return the class seminar's enroll list.
     * @author cesare
     */
    List<Attendance> getEnrollListByKsId(String ksId);

    /**
     * @param roundId
     * @return
     * @author Xinyu Shi
     */
    List<Seminar> getSeminarsByRoundId(String roundId);

    List<Seminar> getSeminarBySeminarId(String klassSeminarId);

    List<KlassSeminar> getKlassSeminarByKlassSeminarId(String klassSeminarId);


    /**
     * @author lyf
     */
    List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(String klassId, String seminarId);

    /**
     * @author lyf
     */
    List<Attendance> getAttendancesByKlassSeminarId(String klassSeminarId);
}
