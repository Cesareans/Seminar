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
    @Insert("insert into Admin(name, password) values(#{name}, #{password})")
    void insertAdmin(Admin admin);

    /**
     * Update a Admin entity's information
     *
     * @param admin the Admin entity that will be updated via the id
     */
    @Update("update Admin set name=#{name}, password=#{password} where id=#{id}")
    void updateAdmin(Admin admin);

    /**
     * Select allAdmin entities
     *
     * @return List<Admin> the selected Admin entities list
     */
    @Select("select name, id, password from Admin")
    List<Admin> selectAllAdmin();

    /**
     * Select a Admin entity via name
     *
     * @param name the select gist
     * @return List<Admin> the selected Admin entity as list
     */
    @Select("select name, id, password from Admin where name=#{name}")
    List<Admin> selectAdminByName(String name);

    /**
     * Select a Admin entity via id
     *
     * @param id the select gist
     * @return List<Admin> the selected Admin entity as list
     */
    @Select("select name, id, password from Admin where id=#{id}")
    List<Admin> selectAdminById(String id);

    /**
     * Delete a Admin entity via name
     *
     * @param name the select gist
     */
    @Delete("delete from Admin where name=#{name}")
    void deleteAdminByName(String name);

    /**
     * Delete a Admin entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from Admin where id=#{id}")
    void deleteAdminById(String id);

}
