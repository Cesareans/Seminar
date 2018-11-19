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
     * Select allAdmin entities
     *
     * @return List<Admin> the selected Admin entities list
     */
    @Select("select * from Admin")
    List<Admin> selectAllAdmin();

    /**
     * Select a Admin entity via name
     *
     * @param name the select gist
     * @return List<Admin> the selected Admin entity as list
     */
    @Select("select * from Admin where name=#{name}")
    List<Admin> selectAdminByName(String name);

    /**
     * Select a Admin entity via id
     *
     * @param id the select gist
     * @return List<Admin> the selected Admin entity as list
     */
    @Select("select * from Admin where id=#{id}")
    List<Admin> selectAdminById(String id);
}
