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
    @Insert("insert into Teacher(name, password, is_activated, email, badge_num) values(#{name}, #{password}, #{activated}, #{email}, #{badgeNum})")
    void insertTeacher(Teacher teacher);

    /**
     * Update a Teacher entity's information
     *
     * @param teacher the Teacher entity that will be updated via the id
     */
    @Update("update Teacher set name=#{name}, password=#{password}, is_activated=#{activated}, email=#{email}, badge_num=#{badgeNum} where id=#{id}")
    void updateTeacher(Teacher teacher);

    /**
     * Select allTeacher entities
     *
     * @return List<Teacher> the selected Teacher entities list
     */
    @Select("select * from Teacher")
    List<Teacher> selectAllTeacher();

    /**
     * Select a Teacher entity via badgeNum
     *
     * @param badgeNum the select gist
     * @return List<Teacher> the selected Teacher entity as list
     */
    @Select("select * from Teacher where badgeNum=#{badgeNum}")
    List<Teacher> selectTeacherByBadgeNum(String badgeNum);

    /**
     * Select a Teacher entity via id
     *
     * @param id the select gist
     * @return List<Teacher> the selected Teacher entity as list
     */
    @Select("select * from Teacher where id=#{id}")
    List<Teacher> selectTeacherById(String id);

    /**
     * Delete a Teacher entity via badgeNum
     *
     * @param badgeNum the select gist
     */
    @Delete("delete * from Teacher where badgeNum=#{badgeNum}")
    void deleteTeacherByBadgeNum(String badgeNum);

    /**
     * Delete a Teacher entity via id
     *
     * @param id the select gist
     */
    @Delete("delete * from Teacher where id=#{id}")
    void deleteTeacherById(String id);

}
