package seminar.mapper;

import org.apache.ibatis.annotations.*;

import seminar.entity.Teacher;

import java.util.List;

/**
 * An automatic generated mapper for the entity teacher.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface TeacherMapper {
    /**
     * Insert a teacher entity
     *
     * @param teacher the teacher entity that will be inserted
     */
    @Insert("insert into teacher(name, badge_num, password, email, is_activated) values(#{name}, #{badgeNum}, #{password}, #{email}, #{activated})")
    void insertTeacher(Teacher teacher);

    /**
     * Update a teacher entity's information
     *
     * @param teacher the teacher entity that will be updated via the id
     */
    @Update("update teacher set name=#{name}, badge_num=#{badgeNum}, password=#{password}, email=#{email}, is_activated=#{activated} where id=#{id}")
    void updateTeacher(Teacher teacher);

    /**
     * Select allTeacher entities
     *
     * @return List<teacher> the selected teacher entities list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from teacher")
    List<Teacher> selectAllTeacher();

    /**
     * Select a teacher entity via name
     *
     * @param name the select gist
     * @return List<teacher> the selected teacher entity as list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from teacher where name=#{name}")
    List<Teacher> selectTeacherByName(String name);

    /**
     * Select a teacher entity via badgeNum
     *
     * @param badgeNum the select gist
     * @return List<teacher> the selected teacher entity as list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from teacher where badge_num=#{badgeNum}")
    List<Teacher> selectTeacherByBadgeNum(String badgeNum);

    /**
     * Select a teacher entity via id
     *
     * @param id the select gist
     * @return List<teacher> the selected teacher entity as list
     */
    @Select("select name, id, badge_num as badgeNum, password, email, is_activated as activated from teacher where id=#{id}")
    List<Teacher> selectTeacherById(String id);

    /**
     * Delete a teacher entity via name
     *
     * @param name the select gist
     */
    @Delete("delete from teacher where name=#{name}")
    void deleteTeacherByName(String name);

    /**
     * Delete a teacher entity via badgeNum
     *
     * @param badgeNum the select gist
     */
    @Delete("delete from teacher where badge_num=#{badgeNum}")
    void deleteTeacherByBadgeNum(String badgeNum);

    /**
     * Delete a teacher entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from teacher where id=#{id}")
    void deleteTeacherById(String id);

}
