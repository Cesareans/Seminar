package seminar.service;

import seminar.entity.*;

import java.util.List;

/**
 * @author Cesare
 */
public interface SeminarService {
    /**
     * Get a course's clbums via courseId
     *
     * @author cesare
     * @param courseId refer gist
     * @return list of course's clbums
     */
    public List<Clbum> getClbumByCourseId(String courseId);

    /**
     * Get a course's teams via courseId
     *
     * @author cesare
     * @param courseId refer gist
     * @return list of course's teams
     */
    public List<Team> getTeamsByCourseId(String courseId);

    /**
     * Get a course's rounds via courseId
     *
     * @author cesare
     * @param courseId refer gist
     * @return list of course's rounds
     */
    public List<Round> getRoundsByCourseId(String courseId);

    /**
     * @author Xinyu Shi
     * @param roundId
     * @return
     */
    public List<Seminar> getSeminarsByRoundId(String roundId);

    public List<Seminar> getSeminarBySeminarId(String clbumSeminarId);

    public List<ClbumSeminar> getClbumSeminarByClbumSeminarId(String clbumSeminarId);

    public List<Course> getCourseByCourseId(String courseId);

    /**
     * @author lyf
     */
    public List<ClbumSeminar> getClbumSeminarByClbumIdAndSeminarId(String clbumId, String seminarId);

    /**
     * @author lyf
     */
    public List<Attendance> getAttendancesByClbumSeminarId(String clbumSeminarId);




}
