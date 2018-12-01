package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Admin;

import java.util.List;

/**
 * An automatic generated mapper for the entity Admin.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface AdminMapper {
    /**
     * Insert a Admin entity
     *
     * @param admin the Admin entity that will be inserted
     */
    @Insert("insert into admin(name, password) values(#{name}, #{password})")
    void insertAdmin(Admin admin);

    /**
     * Update a Admin entity's information
     *
     * @param admin the Admin entity that will be updated via the private java.lang.String seminar.entity.Admin.id
     */
    @Update("update admin set name=#{name}, password=#{password} where id=#{id}")
    void updateAdmin(Admin admin);

    /**
     * Select all Admin entities
     *
     * @return List<admin> the selected Admin entities list
     */
    @Select("select * from admin")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    List<Admin> selectAllAdmin();

    /**
     * Select a Admin entity via name
     *
     * @param name the select gist
     * @return List<admin> the selected Admin entity as list
     */
    @Select("select * from admin where name=#{name}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    List<Admin> selectAdminByName(String name);

    /**
     * Select a Admin entity via id
     *
     * @param id the select gist
     * @return List<admin> the selected Admin entity as list
     */
    @Select("select * from admin where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    List<Admin> selectAdminById(String id);

    /**
     * Delete a Admin entity via name
     *
     * @param name the select gist
     */
    @Delete("delete from admin where name=#{name}")
    void deleteAdminByName(String name);

    /**
     * Delete a Admin entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from admin where id=#{id}")
    void deleteAdminById(String id);

}
