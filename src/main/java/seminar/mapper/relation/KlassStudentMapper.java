package seminar.mapper.relation;

import org.apache.ibatis.annotations.*;
import seminar.entity.Student;

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
     * @param courseId  the redundant courseId information
     * @param klassId   the klass's id, which the student will be inserted into
     * @param studentId the student's id
     */
    @Insert("insert into klass_student(course_id, klass_id, team_id, student_id) values(#{courseId}, #{klassId}, 0, #{studentId})")
    void insertStudentIntoKlass(@Param("courseId") String courseId,
                                @Param("klassId") String klassId,
                                @Param("studentId") String studentId);

    /**
     * Delete all students in a klass
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
    @Select("select student.id,student_name,account,password,email,is_active from klass_student left join student on klass_student.student_id = student.id where team_id=#{teamId}")
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
     * Select all not teamed students in a course via course id
     *
     * @param courseId the select gist
     * @return List<Student> the not teamed students in the course
     * @author Cesare
     */
    @Select("select student.id,student_name,account,password,email,is_active from klass_student left join student on klass_student.student_id = student.id where course_id=#{courseId} and team_id = 0")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active")
    })
    List<Student> selectNotTeamedStudentsByCourseId(String courseId);

}
