package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Administrator;

import java.util.List;

/**
 * An automatic generated mapper for the entity Administrator.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface AdministratorMapper {
    /**
     * Insert a Administrator entity
     *
     * @param administrator the Administrator entity that will be inserted
     */
    @Insert("insert into administrator(admin_name, password) values(#{adminName}, #{password})")
    void insertAdministrator(Administrator administrator);

    /**
     * Update a Administrator entity's information
     *
     * @param administrator the Administrator entity that will be updated via the id
     */
    @Update("update administrator set admin_name=#{adminName}, password=#{password} where id=#{id}")
    void updateAdministrator(Administrator administrator);

    /**
     * Select all Administrator entities
     *
     * @return List<administrator> the selected Administrator entities list
     */
    @Select("select * from administrator")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminName", column = "admin_name"),
            @Result(property = "password", column = "password")
    })
    List<Administrator> selectAllAdministrator();

    /**
     * Select a Administrator entity via adminName
     *
     * @param adminName the select gist
     * @return List<administrator> the selected Administrator entity as list
     */
    @Select("select * from administrator where admin_name=#{adminName}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminName", column = "admin_name"),
            @Result(property = "password", column = "password")
    })
    List<Administrator> selectAdministratorByAdminName(String adminName);

    /**
     * Select a Administrator entity via id
     *
     * @param id the select gist
     * @return List<administrator> the selected Administrator entity as list
     */
    @Select("select * from administrator where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminName", column = "admin_name"),
            @Result(property = "password", column = "password")
    })
    List<Administrator> selectAdministratorById(String id);

    /**
     * Delete a Administrator entity via adminName
     *
     * @param adminName the select gist
     */
    @Delete("delete from administrator where admin_name=#{adminName}")
    void deleteAdministratorByAdminName(String adminName);

    /**
     * Delete a Administrator entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from administrator where id=#{id}")
    void deleteAdministratorById(String id);

}
