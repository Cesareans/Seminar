package seminar.service;

import seminar.entity.*;

import java.util.List;

public interface SeminarService {

    /**
     * Get a course's clbums via courseId
     *
     * @param courseId refer gist
     * @return list of course's clbums
     */
    public List<Clbum> getClbumByCourseId(String courseId);

    /**
     * TODO:Write Javadoc
     *
     * @param courseId
     * @return
     */
    public List<Team> getTeamsByCourseId(String courseId);

    public List<Round> getRoundsByCourseId(String courseId);

    public List<Seminar> getSeminarsByRoundId(String roundId);

    public List<ClbumSeminar> getClbumSeminarByClbumIdAndSeminarId(String clbumId, String seminarId);

    public List<Seminar> getSeminarBySeminarId(String clbumSeminarId);

    public List<Attendance> getAttendancesByClbumSeminarId(String clbumSeminarId);

}
