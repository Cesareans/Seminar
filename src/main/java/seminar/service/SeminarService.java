package seminar.service;

import seminar.entity.*;
import seminar.entity.regulation.Strategy;
import seminar.entity.regulation.StrategyComposition;
import seminar.entity.relation.KlassRound;

import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public interface SeminarService {
    /**
     * Get teacher via teacher num
     *
     * @param tn refer gist
     * @return a list that contains the teacher with the teacher num
     * @author cesare
     */
    List<Teacher> getTeacherByTN(String tn);

    /**
     * Get student via student num
     *
     * @param sn student num
     * @return a list that contains the student with the student num
     * @author cesare
     */
    List<Student> getStudentBySN(String sn);

    /**
     * Get all courses
     * @return all course in the system
     */
    List<Course> getAllCourses();
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
     * get strategies of a course by course id
     * @param courseId the refer gist
     * @return StrategyComposition
     */
    StrategyComposition getStrategiesByCourseId(String courseId);


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
     * Get attendance by id
     * @param id the refer gist
     * @return the attendance
     */
    List<Attendance> getAttendanceById(String id);
    /**
     * Get the attendance via id
     * @param teamId the refer gist
     * @param ksId the refer gist
     * @return the attendance
     */
    List<Attendance> getAttendanceByTeamIdAndKlassSeminarId(String teamId, String ksId);

    /**
     * Get the attendance in the klassSeminar
     * @param ksId the klassSeminar refer gist
     * @return the list of attendance
     */
    List<Attendance> getAttendanceByKsId(String ksId);

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
     * @param klassId the refer gist
     * @param studentId the refer gist
     * @return the team
     */
    Team getTeamByCourseIdAndStudentId(String klassId, String studentId);

    /**
     * Get the team via team id
     * @param teamId the refer gist
     * @return the team
     */
    Team getTeamByTeamId(String teamId);

    Team getTeamByCourseIdAndTeamId(String courseId, String teamId);


    /**
     * Get not teamed students by course id
     * @param courseId the refer gist
     * @return the not teamed students.
     */
    List<Student> getNotTeamedStudentsByCourseId(String courseId);

    /**
     * Get a course's klass via courseId
     *
     * @param courseId refer gist
     * @return list of course's klass
     * @author cesare
     */
    List<Klass> getKlassByCourseId(String courseId);


    /**
     * Get a student's klasses via teacherId
     *
     * @param studentId refer gist
     * @return list of student's klasses
     * @author cesare
     */
    List<Klass> getKlassesByStudentId(String studentId);

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

    /**
     * get klass rounds by klass id and round id
     * @param klassId the refer gist
     * @param roundId the refer gist
     * @return the klass round
     */
    List<KlassRound> getKlassRoundsByKlassIdAndRoundId(String klassId, String roundId);


}
