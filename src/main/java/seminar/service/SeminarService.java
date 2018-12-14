package seminar.service;

import seminar.entity.*;

import java.util.List;

/**
 * @author Cesare
 */
public interface SeminarService {
    /**
     * Get a course's klass via courseId
     *
     * @param courseId refer gist
     * @return list of course's klass
     * @author cesare
     */
    List<Klass> getKlassByCourseId(String courseId);

    /**
     * Get a course's teams via courseId
     *
     * @param courseId refer gist
     * @return list of course's teams
     * @author cesare
     */
    List<Team> getTeamsByCourseId(String courseId);

    /**
     * Get a course's rounds via courseId
     *
     * @param courseId refer gist
     * @return list of course's rounds
     * @author cesare
     */
    List<Round> getRoundsByCourseId(String courseId);

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

    List<Course> getCourseByCourseId(String courseId);

    /**
     * @author lyf
     */
    List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(String klassId, String seminarId);

    /**
     * @author lyf
     */
    List<Attendance> getAttendancesByKlassSeminarId(String klassSeminarId);
}
