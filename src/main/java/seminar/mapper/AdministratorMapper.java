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
    @Insert("insert into admin(account, password) values(#{adminName}, #{password})")
    void insertAdministrator(Administrator administrator);

    /**
     * Update a Administrator entity's information
     *
     * @param administrator the Administrator entity that will be updated via the id
     */
    @Update("update admin set account=#{adminName}, password=#{password} where id=#{id}")
    void updateAdministrator(Administrator administrator);

    /**
     * Select all Administrator entities
     *
     * @return List<administrator> the selected Administrator entities list
     */
    @Select("select * from admin")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminName", column = "account"),
            @Result(property = "password", column = "password")
    })
    List<Administrator> selectAllAdministrator();

    /**
     * Select a Administrator entity via adminName
     *
     * @param adminName the select gist
     * @return List<administrator> the selected Administrator entity as list
     */
    @Select("select * from admin where account=#{adminName}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminName", column = "account"),
            @Result(property = "password", column = "password")
    })
    List<Administrator> selectAdministratorByAdminName(String adminName);

    /**
     * Select a Administrator entity via id
     *
     * @param id the select gist
     * @return List<administrator> the selected Administrator entity as list
     */
    @Select("select * from admin where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "adminName", column = "account"),
            @Result(property = "password", column = "password")
    })
    List<Administrator> selectAdministratorById(String id);

    /**
     * Delete a Administrator entity via adminName
     *
     * @param adminName the select gist
     */
    @Delete("delete from admin where account=#{adminName}")
    void deleteAdministratorByAdminName(String adminName);

    /**
     * Delete a Administrator entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from admin where id=#{id}")
    void deleteAdministratorById(String id);

}
