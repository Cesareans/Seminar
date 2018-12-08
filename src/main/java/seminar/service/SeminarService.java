package seminar.service;

import seminar.entity.*;

import java.util.List;

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
     * TODO:Write Javadoc
     *
     * @param courseId
     * @return
     */
    public List<Team> getTeamsByCourseId(String courseId);

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

    /**
     * Get all student without team in the same course which belong to same teacher
     * @author SWJ
     * @param  courseId refer gist
     * @return List of student entity
     */
    public List<Student> getStudentWithoutTeam(String courseId);


}
