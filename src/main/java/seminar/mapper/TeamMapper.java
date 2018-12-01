package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Team;

import java.util.List;

/**
 * An automatic generated mapper for the entity Team.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface TeamMapper {
    /**
     * Insert a Team entity
     *
     * @param team the Team entity that will be inserted
     */
    @Insert("insert into team(serial, name, is_valid, clbum_id) values(#{serial}, #{name}, #{valid}, #{clbumId})")
    void insertTeam(Team team);

    /**
     * Update a Team entity's information
     *
     * @param team the Team entity that will be updated via the private java.lang.String seminar.entity.Team.id
     */
    @Update("update team set serial=#{serial}, name=#{name}, is_valid=#{valid}, clbum_id=#{clbumId} where id=#{id}")
    void updateTeam(Team team);

    /**
     * Select all Team entities
     *
     * @return List<team> the selected Team entities list
     */
    @Select("select * from team")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "serial"),
            @Result(property = "name", column = "name"),
            @Result(property = "valid", column = "is_valid"),
            @Result(property = "clbumId", column = "clbum_id")
    })
    List<Team> selectAllTeam();

    /**
     * Select a Team entity via clbumId
     *
     * @param clbumId the select gist
     * @return List<team> the selected Team entity as list
     */
    @Select("select * from team where clbum_id=#{clbumId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "serial"),
            @Result(property = "name", column = "name"),
            @Result(property = "valid", column = "is_valid"),
            @Result(property = "clbumId", column = "clbum_id")
    })
    List<Team> selectTeamByClbumId(String clbumId);

    /**
     * Select a Team entity via id
     *
     * @param id the select gist
     * @return List<team> the selected Team entity as list
     */
    @Select("select * from team where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "serial"),
            @Result(property = "name", column = "name"),
            @Result(property = "valid", column = "is_valid"),
            @Result(property = "clbumId", column = "clbum_id")
    })
    List<Team> selectTeamById(String id);

    /**
     * Delete a Team entity via clbumId
     *
     * @param clbumId the select gist
     */
    @Delete("delete from team where clbum_id=#{clbumId}")
    void deleteTeamByClbumId(String clbumId);

    /**
     * Delete a Team entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from team where id=#{id}")
    void deleteTeamById(String id);

}
