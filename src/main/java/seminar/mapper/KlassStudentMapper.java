package seminar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import seminar.entity.Student;

import java.util.List;

/**
 * @author Cesare
 */
@Mapper
public interface KlassStudentMapper {
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
