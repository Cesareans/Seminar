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
     * Select a Team's all students via teamId
     *
     * @param teamId the select gist
     * @return List<Student> the selected Team's all students as list
     * @author Cesare
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
    List<Student> selectStudentsByTeamId(String teamId);

    /**
     * Get the team via studentId and teamId
     * @param klassId the refer gist
     * @param studentId the refer gist
     * @return the team id
     */
    @Select("select klass_team.team_id from klass_team left join team_student on klass_student.team_id = team.id  where student_id=#{studentId} and klass_student.klass_id=#{klassId}")
    String selectTeamByKlassIdAndStudentId(@Param("klassId") String klassId, @Param("studentId") String studentId);

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
     * Select a Team's all students via teamId
     *
     * @param
     * @return
     * @author Xinyu Shi
     */
    @Select("select * from klass_student where student_id=#{studentId} and course_id =#{courseId}")
    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
    })
    List<KlassStudent> selectByStudentIdAndCourseId(@Param("studentId") String studentId, @Param("courseId") String courseId);

    /**
     * @author Xinyu Shi
     * update team_id by studentId and courseId.
     */
    @Update("update klass_student set team_id=#{teamId} where student_id=#{studentId} and course_id=#{courseId}")
    void update(KlassStudent klassStudent);

    /**
     * TODO
     *
     * @param
     * @return
     * @author Xinyu Shi
     */
    @Select("select * from klass_student where student_id=#{studentId} and klass_id=#{klassId}")
    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
    })
    List<KlassStudent> selectByStudentIdAndKlassId(@Param("studentId") String studentId, @Param("klassId") String klassId);



    /**
     * Select a Team's all students via teamId
     *
     * @param
     * @return
     * @author Xinyu Shi
     */
    @Select("select * from klass_student where student_id=#{studentId} and team_id=#{teamId}")
    @Results({
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id"),
    })
    List<KlassStudent> selectByStudentIdAndTeamId(@Param("studentId") String studentId, @Param("teamId") String teamId);

}
