package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.Student;
import seminar.entity.Teacher;

import java.util.List;

/**
 * An automatic generated mapper for the entity Teacher.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface TeacherMapper {
    /**
     * Insert a Teacher entity
     *
     * @param teacher the Teacher entity that will be inserted
     */
    @Insert("insert into teacher(teacher_name, teacher_num, password, email, msg_interval, is_activated) values(#{teacherName}, #{teacherNum}, #{password}, #{email}, #{msgInterval}, #{activated})")
    void insertTeacher(Teacher teacher);

    /**
     * Update a Teacher entity's information
     *
     * @param teacher the Teacher entity that will be updated via the private java.lang.String seminar.entity.Teacher.id
     */
    @Update("update teacher set teacher_name=#{teacherName}, teacher_num=#{teacherNum}, password=#{password}, email=#{email}, msg_interval=#{msgInterval}, is_activated=#{activated} where id=#{id}")
    void updateTeacher(Teacher teacher);

    /**
     * Update a Teacher entity's password
     *
     * @param teacher the Teacher entity's password that will be updated via the private java.lang.String seminar.entity.Student.id
     */
    @Update("update teacher set password=#{password} where id=#{id}")
    void updatePasswordByTeacherId(Teacher teacher, String password, String id);

    /**
     * Select all Teacher entities
     *
     * @return List<teacher> the selected Teacher entities list
     */
    @Select("select * from teacher")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "msgInterval", column = "msg_interval"),
            @Result(property = "activated", column = "is_activated"),
            @Result(property = "courses", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.CourseMapper.selectCourseByTeacherId", fetchType = FetchType.LAZY))
    })
    List<Teacher> selectAllTeacher();

    /**
     * Select a Teacher entity via teacherName
     *
     * @param teacherName the select gist
     * @return List<teacher> the selected Teacher entity as list
     */
    @Select("select * from teacher where teacher_name=#{teacherName}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "msgInterval", column = "msg_interval"),
            @Result(property = "activated", column = "is_activated"),
            @Result(property = "courses", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.CourseMapper.selectCourseByTeacherId", fetchType = FetchType.LAZY))
    })
    List<Teacher> selectTeacherByTeacherName(String teacherName);

    /**
     * Select a Teacher entity via teacherNum
     *
     * @param teacherNum the select gist
     * @return List<teacher> the selected Teacher entity as list
     */
    @Select("select * from teacher where teacher_num=#{teacherNum}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "msgInterval", column = "msg_interval"),
            @Result(property = "activated", column = "is_activated"),
            @Result(property = "courses", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.CourseMapper.selectCourseByTeacherId", fetchType = FetchType.LAZY))
    })
    List<Teacher> selectTeacherByTeacherNum(String teacherNum);

    /**
     * Select a Teacher entity via id
     *
     * @param id the select gist
     * @return List<teacher> the selected Teacher entity as list
     */
    @Select("select * from teacher where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "msgInterval", column = "msg_interval"),
            @Result(property = "activated", column = "is_activated"),
            @Result(property = "courses", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.CourseMapper.selectCourseByTeacherId", fetchType = FetchType.LAZY))
    })
    List<Teacher> selectTeacherById(String id);

    /**
     * Delete a Teacher entity via private java.lang.String seminar.entity.Teacher.teacherName
     *
     * @param teacherName the select gist
     */
    @Delete("delete from teacher where teacher_name=#{teacherName}")
    void deleteTeacherByTeacherName(String teacherName);

    /**
     * Delete a Teacher entity via private java.lang.String seminar.entity.Teacher.teacherNum
     *
     * @param teacherNum the select gist
     */
    @Delete("delete from teacher where teacher_num=#{teacherNum}")
    void deleteTeacherByTeacherNum(String teacherNum);

    /**
     * Delete a Teacher entity via private java.lang.String seminar.entity.Teacher.id
     *
     * @param id the select gist
     */
    @Delete("delete from teacher where id=#{id}")
    void deleteTeacherById(String id);

}
