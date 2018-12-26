package seminar.mapper.relation;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.Course;
import seminar.entity.Klass;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.relation.KlassStudent;

import java.util.List;

/**
 * The mapper is for klass student relation mapper.
 * The relation table's fields is listed below.
 * {courseId, klassId, teamId, studentId}
 *
 * @author Cesare
 */
@Mapper
public interface KlassStudentMapper {
    //#############    Klass Student
    /**
     * Insert a student into klass without team
     *
     * @param klassStudent  the relation entity for transfer parameters
     */
    @Insert("insert into klass_student(course_id, klass_id, student_id) values(#{courseId}, #{klassId}, #{studentId})")
    void insertStudentIntoKlass(KlassStudent klassStudent);

    /**
     * Delete all students in a klass
     *
     * @param klassId the refer gist
     */
    @Delete("delete from klass_student where klass_id=#{klassId}")
    void deleteKlassStudents(String klassId);

    /**
     * Select courses of students via studentId
     *
     * @param studentId the refer gist
     * @return List<Course> list of course.
     */
    @Select("select course.* from klass_student left join course on klass_student.course_id = course.id where student_id = #{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCourseByStudentId(String studentId);

    /**
     * Select klasses of students via studentId
     *
     * @param studentId the refer gist
     * @return List<Klass> list of Klass.
     */
    @Select("select klass.* from klass_student left join klass on klass_student.klass_id = klass.id where student_id = #{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "grade", column = "grade"),
            @Result(property = "serial", column = "klass_serial"),
            @Result(property = "time", column = "klass_time"),
            @Result(property = "location", column = "klass_location"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "course", column = "course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<Klass> selectKlassByStudentId(String studentId);

    /**
     * Judge if the student is in the klass
     * @param klassId the klass refer gist
     * @param studentId the student refer gist
     * @return whether is in
     */
    @Select("select count(*) from klass_student where klass_id = #{klassId} and student_id= #{studentId}")
    Boolean isStudentInKlass(@Param("klassId") String klassId, @Param("studentId") String studentId);

    //#############    Team Student
    /**
     * Insert a student into klass without team
     * @author Xinyu Shi
     * @param teamId  the redundant courseId information
     * @param studentId the student's id
     */
    @Insert("insert into team_student(team_id, student_id) values(#{teamId}, #{studentId})")
    void insertStudentIntoTeam(@Param("teamId") String teamId, @Param("studentId") String studentId);

    /**
     * Delete a student in a team
     * @author Xinyu Shi
     * @param teamId the refer gist
     * @param studentId the refer gist
     */
    @Delete("delete from team_student where student_id=#{studentId} and team_id=#{teamId}")
    void deleteStudentFromTeam(@Param("teamId")String teamId, @Param("studentId") String studentId);

    /**
     * Delete students of team in the course
     * @param courseId the refer gist
     */
    @Delete("delete from team_student where team_id in (select id from team where course_id = #{courseId})")
    void deleteTeamStudentByCourseId(String courseId);

    /**
     * Select a Team's all students via teamId
     *
     * @param teamId the select gist
     * @return List<Student> the selected Team's all students as list
     * @author Xinyu Shi
     */
    @Select("select student.* from team_student left join student on team_student.student_id = student.id where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active")
    })
    List<Student> selectStudentsFromTeam(String teamId);

    /**
     * @author Xinyu Shi
     */
    @Select("select klass_id from klass_team where team_id=#{teamId}")
    List<String> selectKlassIdByTeamId(String teamId);

    //#############    Klass Team
    /**
     * Delete team occurrence from klass team
     * @param teamId the refer gist
     */
    @Delete("delete from klass_team where team_id=#{teamId}")
    void deleteTeamFromKlassTeamByTeamId(String teamId);


    /**
     * Delete team in a course that stored in the klass team table
     * @param courseId the refer gist
     */
    @Delete("delete from klass_team where klass_id in (select id from klass where course_id = #{courseId})")
    void deleteTeamFromKlassTeamByCourseId(String courseId);

    /**
     * Insert team record into klass team
     * @param teamId the team id
     * @param klassId the klass id
     */
    @Insert("insert into klass_team (klass_id, team_id) values(#{klassId}, #{teamId})")
    void insertTeamIntoKlassTeam(String teamId, String klassId);


    //#############    Union multi table
    /**
     * Select a Team's students under a course
     *
     * @param courseId the refer gist
     * @param teamId the select gist
     * @return List<Student> the selected Team's all students as list
     * @author Cesare
     */
    @Select("select student.* from klass_student left join student on klass_student.student_id = id where course_id = #{courseId} and id in(select student_id from team_student where team_student.team_id = #{teamId});")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active")
    })
    List<Student> selectStudentsFromTeamByCourseIdAndTeamId(@Param("courseId") String courseId, @Param("teamId") String teamId);

    /**
     * Get the team via courseId and studentId
     * @param courseId the refer gist
     * @param studentId the refer gist
     * @return the team id
     */
    @Select("select * from team where team.id in(select klass_team.team_id from klass left join klass_team on id = klass_team.klass_id left join team_student on klass_team.team_id = team_student.team_id  where student_id = #{studentId} and klass.course_id = #{courseId})")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "team_serial"),
            @Result(property = "teamName", column = "team_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "leaderId", column = "leader_id"),
            @Result(property = "leader", column = "leader_id", one = @One(select = "seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
            @Result(property = "klass", column = "klass_id", one = @One(select = "seminar.mapper.KlassMapper.selectKlassById", fetchType = FetchType.LAZY))
    })
    Team selectTeamByCourseIdAndStudentId(@Param("courseId") String courseId, @Param("studentId") String studentId);

    /**
     * Select Team by course id
     * @param courseId refer gist
     * @return the teams
     */
    @Select("select * from team where team.id in(select klass_team.team_id from klass left join klass_team on id = klass_team.klass_id where klass.course_id = #{courseId})")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "team_serial"),
            @Result(property = "teamName", column = "team_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "leaderId", column = "leader_id"),
            @Result(property = "leader", column = "leader_id", one = @One(select = "seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
            @Result(property = "klass", column = "klass_id", one = @One(select = "seminar.mapper.KlassMapper.selectKlassById", fetchType = FetchType.LAZY))
    })
    List<Team> selectTeamsByCourseId(String courseId);

    /**
     * Select all not teamed students in a course via course id
     *
     * @param courseId the select gist
     * @return List<Student> the not teamed students in the course
     * @author Cesare
     */
    @Select("select student.* from klass_student left join student on student_id = id where course_id=#{courseId} and student_id not in " +
            "(select distinct student_id from klass left join klass_team on id = klass_team.klass_id left join team_student on klass_team.team_id = team_student.team_id where student_id is not null and klass.course_id = #{courseId})")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active")
    })
    List<Student> selectNotTeamedStudentsByCourseId(String courseId);


    /**
     * Judge if the student has enter a team in the course
     * @param courseId the course refer gist
     * @param studentId the student refer gist
     * @return whether has teamed.
     */
    @Select("select count(*) from klass left join klass_team on id = klass_team.klass_id left join team_student on klass_team.team_id = team_student.team_id where student_id = #{studentId} and klass.course_id = #{courseId}")
    Boolean hasTeamed(String courseId, String studentId);
}
