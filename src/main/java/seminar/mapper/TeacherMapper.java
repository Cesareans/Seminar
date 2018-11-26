package seminar.mapper;

import org.apache.ibatis.annotations.*;

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
    @Insert("insert into Teacher(name, badge_num, password, email, is_activated) values(#{name}, #{badgeNum}, #{password}, #{email}, #{activated})")
    void insertTeacher(Teacher teacher);

    /**
     * Update a Teacher entity's information
     *
     * @param teacher the Teacher entity that will be updated via the id
     */
    @Update("update Teacher set name=#{name}, badge_num=#{badgeNum}, password=#{password}, email=#{email}, is_activated=#{activated} where id=#{id}")
    void updateTeacher(Teacher teacher);

    /**
     * Select allTeacher entities
     *
     * @return List<Teacher> the selected Teacher entities list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from Teacher")
    List<Teacher> selectAllTeacher();

    /**
     * Select a Teacher entity via name
     *
     * @param name the select gist
     * @return List<Teacher> the selected Teacher entity as list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from Teacher where name=#{name}")
    List<Teacher> selectTeacherByName(String name);

    /**
     * Select a Teacher entity via badgeNum
     *
     * @param badgeNum the select gist
     * @return List<Teacher> the selected Teacher entity as list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from Teacher where badge_num=#{badgeNum}")
    List<Teacher> selectTeacherByBadgeNum(String badgeNum);

    /**
     * Select a Teacher entity via id
     *
     * @param id the select gist
     * @return List<Teacher> the selected Teacher entity as list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from Teacher where id=#{id}")
    List<Teacher> selectTeacherById(String id);

    /**
     * Delete a Teacher entity via name
     *
     * @param name the select gist
     */
    @Delete("delete from Teacher where name=#{name}")
    void deleteTeacherByName(String name);

    /**
     * Delete a Teacher entity via badgeNum
     *
     * @param badgeNum the select gist
     */
    @Delete("delete from Teacher where badge_num=#{badgeNum}")
    void deleteTeacherByBadgeNum(String badgeNum);

    /**
     * Delete a Teacher entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from Teacher where id=#{id}")
    void deleteTeacherById(String id);

}
