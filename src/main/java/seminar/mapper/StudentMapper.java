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
    @Insert("insert into Student(name, stu_num, password, is_activated, email) values(#{name}, #{stuNum}, #{password}, #{activated}, #{email})")
    void insertStudent(Student student);

    /**
     * Update a Student entity's information
     *
     * @param student the Student entity that will be updated via the id
     */
    @Update("update Student set name=#{name}, stu_num=#{stuNum}, password=#{password}, is_activated=#{activated}, email=#{email} where id=#{id}")
    void updateStudent(Student student);

    /**
     * Select allStudent entities
     *
     * @return List<Student> the selected Student entities list
     */
    @Select("select name, id, stu_num as stuNum, password, is_activated as activated, email from Student")
    List<Student> selectAllStudent();

    /**
     * Select a Student entity via name
     *
     * @param name the select gist
     * @return List<Student> the selected Student entity as list
     */
    @Select("select name, id, stu_num as stuNum, password, is_activated as activated, email from Student where name=#{name}")
    List<Student> selectStudentByName(String name);

    /**
     * Select a Student entity via stuNum
     *
     * @param stuNum the select gist
     * @return List<Student> the selected Student entity as list
     */
    @Select("select name, id, stu_num as stuNum, password, is_activated as activated, email from Student where stu_num=#{stuNum}")
    List<Student> selectStudentByStuNum(String stuNum);

    /**
     * Select a Student entity via id
     *
     * @param id the select gist
     * @return List<Student> the selected Student entity as list
     */
    @Select("select name, id, stu_num as stuNum, password, is_activated as activated, email from Student where id=#{id}")
    List<Student> selectStudentById(String id);

    /**
     * Delete a Student entity via name
     *
     * @param name the select gist
     */
    @Delete("delete from Student where name=#{name}")
    void deleteStudentByName(String name);

    /**
     * Delete a Student entity via stuNum
     *
     * @param stuNum the select gist
     */
    @Delete("delete from Student where stu_num=#{stuNum}")
    void deleteStudentByStuNum(String stuNum);

    /**
     * Delete a Student entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from Student where id=#{id}")
    void deleteStudentById(String id);

}
