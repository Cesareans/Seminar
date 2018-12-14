package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
    @Insert("insert into teacher(teacher_name, account, password, email, is_active) values(#{teacherName}, #{teacherNum}, #{password}, #{email}, #{activated})")
    void insertTeacher(Teacher teacher);

    /**
     * Update a Teacher entity's information
     *
     * @param teacher the Teacher entity that will be updated via the id
     */
    @Update("update teacher set teacher_name=#{teacherName}, account=#{teacherNum}, password=#{password}, email=#{email}, is_active=#{activated} where id=#{id}")
    void updateTeacher(Teacher teacher);

    /**
     * Select all Teacher entities
     *
     * @return List<teacher> the selected Teacher entities list
     */
    @Select("select * from teacher")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "teacherNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active"),
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
            @Result(property = "teacherNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active"),
            @Result(property = "courses", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.CourseMapper.selectCourseByTeacherId", fetchType = FetchType.LAZY))
    })
    List<Teacher> selectTeacherByTeacherName(String teacherName);

    /**
     * Select a Teacher entity via teacherNum
     *
     * @param teacherNum the select gist
     * @return List<teacher> the selected Teacher entity as list
     */
    @Select("select * from teacher where account=#{teacherNum}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherName", column = "teacher_name"),
            @Result(property = "teacherNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active"),
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
            @Result(property = "teacherNum", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "activated", column = "is_active"),
            @Result(property = "courses", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.CourseMapper.selectCourseByTeacherId", fetchType = FetchType.LAZY))
    })
    List<Teacher> selectTeacherById(String id);

    /**
     * Delete a Teacher entity via teacherName
     *
     * @param teacherName the select gist
     */
    @Delete("delete from teacher where teacher_name=#{teacherName}")
    void deleteTeacherByTeacherName(String teacherName);

    /**
     * Delete a Teacher entity via teacherNum
     *
     * @param teacherNum the select gist
     */
    @Delete("delete from teacher where account=#{teacherNum}")
    void deleteTeacherByTeacherNum(String teacherNum);

    /**
     * Delete a Teacher entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from teacher where id=#{id}")
    void deleteTeacherById(String id);

}
