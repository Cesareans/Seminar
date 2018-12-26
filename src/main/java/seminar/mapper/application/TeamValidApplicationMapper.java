package seminar.mapper.application;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.application.TeamValidApplication;

import java.util.List;

/**
 * An automatic generated mapper for the entity TeamValidApplication.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface TeamValidApplicationMapper {
    /**
     * Insert a TeamValidApplication entity
     *
     * @param teamValidApplication the TeamValidApplication entity that will be inserted
     */
    @Insert("insert into team_valid_application(reason, teacher_id, team_id) values(#{content}, #{teacherId}, #{teamId})")
    @Options(useGeneratedKeys = true)
    void insertTeamValidApplication(TeamValidApplication teamValidApplication);

    /**
     * Update a TeamValidApplication entity's information
     *
     * @param teamValidApplication the TeamValidApplication entity that will be updated via the id
     */
    @Update("update team_valid_application set reason=#{content}, teacher_id=#{teacherId}, team_id=#{teamId} where id=#{id}")
    void updateTeamValidApplication(TeamValidApplication teamValidApplication);

    /**
     * Select all TeamValidApplication entities
     *
     * @return List<teamValidApplication> the selected TeamValidApplication entities list
     */
    @Select("select * from team_valid_application")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "reason"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.LAZY))
    })
    List<TeamValidApplication> selectAllTeamValidApplication();

    /**
     * Select a TeamValidApplication entity via teacherId
     *
     * @param teacherId the select gist
     * @return List<teamValidApplication> the selected TeamValidApplication entity as list
     */
    @Select("select * from team_valid_application where teacher_id=#{teacherId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "reason"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.LAZY))
    })
    List<TeamValidApplication> selectTeamValidApplicationByTeacherId(String teacherId);

    /**
     * Select a TeamValidApplication entity via teamId
     *
     * @param teamId the select gist
     * @return List<teamValidApplication> the selected TeamValidApplication entity as list
     */
    @Select("select * from team_valid_application where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "reason"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.LAZY))
    })
    List<TeamValidApplication> selectTeamValidApplicationByTeamId(String teamId);

    /**
     * Select a TeamValidApplication entity via id
     *
     * @param id the select gist
     * @return List<teamValidApplication> the selected TeamValidApplication entity as list
     */
    @Select("select * from team_valid_application where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "content", column = "reason"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.LAZY))
    })
    List<TeamValidApplication> selectTeamValidApplicationById(String id);

    /**
     * Delete a TeamValidApplication entity via teacherId
     *
     * @param teacherId the select gist
     */
    @Delete("delete from team_valid_application where teacher_id=#{teacherId}")
    void deleteTeamValidApplicationByTeacherId(String teacherId);

    /**
     * Delete a TeamValidApplication entity via teamId
     *
     * @param teamId the select gist
     */
    @Delete("delete from team_valid_application where team_id=#{teamId}")
    void deleteTeamValidApplicationByTeamId(String teamId);

    /**
     * Delete a TeamValidApplication entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from team_valid_application where id=#{id}")
    void deleteTeamValidApplicationById(String id);

}
