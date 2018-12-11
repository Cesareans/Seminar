package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Student;

import java.util.List;

/**
 * An automatic generated mapper for the entity Student.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface StudentMapper {
    /**
     * Insert a Student entity
     *
     * @param student the Student entity that will be inserted
     */
    @Insert("insert into student(student_name, student_num, password, email, is_activated) values(#{studentName}, #{studentNum}, #{password}, #{email}, #{activated})")
    void insertStudent(Student student);

    /**
     * Update a Student entity's information
     *
     * @param student the Student entity that will be updated via the private java.lang.String seminar.entity.Student.id
     */
    @Update("update student set student_name=#{studentName}, student_num=#{studentNum}, password=#{password}, email=#{email}, is_activated=#{activated} where id=#{id}")
    void updateStudent(Student student);

    /**
     * Select all Student entities
     *
     * @return List<student> the selected Student entities list
     */
    @Select("select * from student")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "student_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_activated")
    })
    List<Student> selectAllStudent();

    /**
     * Select a Student entity via studentName
     *
     * @param studentName the select gist
     * @return List<student> the selected Student entity as list
     */
    @Select("select * from student where student_name=#{studentName}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "student_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_activated")
    })
    List<Student> selectStudentByStudentName(String studentName);

    /**
     * Select a Student entity via studentNum
     *
     * @param studentNum the select gist
     * @return List<student> the selected Student entity as list
     */
    @Select("select * from student where student_num=#{studentNum}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "student_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_activated")
    })
    List<Student> selectStudentByStudentNum(String studentNum);

    /**
     * Select a Student entity via id
     *
     * @param id the select gist
     * @return List<student> the selected Student entity as list
     */
    @Select("select * from student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "student_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_activated")
    })
    List<Student> selectStudentById(String id);

    /**
     * Delete a Student entity via private java.lang.String seminar.entity.Student.studentName
     *
     * @param studentName the select gist
     */
    @Delete("delete from student where student_name=#{studentName}")
    void deleteStudentByStudentName(String studentName);

    /**
     * Delete a Student entity via private java.lang.String seminar.entity.Student.studentNum
     *
     * @param studentNum the select gist
     */
    @Delete("delete from student where student_num=#{studentNum}")
    void deleteStudentByStudentNum(String studentNum);

    /**
     * Delete a Student entity via private java.lang.String seminar.entity.Student.id
     *
     * @param id the select gist
     */
    @Delete("delete from student where id=#{id}")
    void deleteStudentById(String id);

    /**
     * Select all student entities which not join in any teams of the course via courseId
     *
     * @param courseId the select gist
     * @return List<Student> the selected Student entity as list
     * @author SWJ
     */
    @Select("select * from student where id not in(select student_id from team_student where team_id in (select id from team where clbum_id in(select id from clbum where course_id=#{courseId}))) " +
            "union select * from student where id not in(select leader_id from team where clbum_id in(select id from clbum where course_id=#{courseId}))")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentNum", column = "student_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_activated")
    })
    List<Student> selectStudentWithoutTeamByCourseId(String courseId);
}
