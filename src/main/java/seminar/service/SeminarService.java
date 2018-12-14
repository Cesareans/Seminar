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
    public List<Klass> getKlassByCourseId(String courseId);

    /**
     * Get a course's teams via courseId
     *
     * @param courseId refer gist
     * @return list of course's teams
     * @author cesare
     */
    public List<Team> getTeamsByCourseId(String courseId);

    /**
     * Get a course's rounds via courseId
     *
     * @param courseId refer gist
     * @return list of course's rounds
     * @author cesare
     */
    public List<Round> getRoundsByCourseId(String courseId);

    /**
     * @param roundId
     * @return
     * @author Xinyu Shi
     */
    public List<Seminar> getSeminarsByRoundId(String roundId);

    public List<Seminar> getSeminarBySeminarId(String klassSeminarId);

    public List<KlassSeminar> getKlassSeminarByKlassSeminarId(String klassSeminarId);

    public List<Course> getCourseByCourseId(String courseId);

    /**
     * @author lyf
     */
    public List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(String klassId, String seminarId);

    /**
     * @author lyf
     */
    public List<Attendance> getAttendancesByKlassSeminarId(String klassSeminarId);

    /**
     * Get all student without team in the same course which belong to same teacher
     *
     * @param courseId refer gist
     * @return List of student entity
     * @author SWJ
     */
    public List<Student> getStudentWithoutTeam(String courseId);


}
