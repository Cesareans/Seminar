package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
    @Insert("insert into team(team_serial, team_name, status, course_id, klass_id, leader_id) values(#{serial}, #{teamName}, #{status}, #{courseId}, #{klassId}, #{leaderId})")
    @Options(useGeneratedKeys = true)
    void insertTeam(Team team);

    /**
     * Update a Team entity's information
     *
     * @param team the Team entity that will be updated via the id
     */
    @Update("update team set team_serial=#{serial}, team_name=#{teamName}, status=#{status}, course_id=#{courseId}, klass_id=#{klassId}, leader_id=#{leaderId} where id=#{id}")
    void updateTeam(Team team);

    /**
     * Select all Team entities
     *
     * @return List<team> the selected Team entities list
     */
    @Select("select * from team")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "team_serial"),
            @Result(property = "teamName", column = "team_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "leaderId", column = "leader_id"),
            @Result(property = "leader", column = "leader_id", one = @One(select = "seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
            @Result(property = "students", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassStudentMapper.selectStudentsFromTeam", fetchType = FetchType.LAZY)),
            @Result(property = "klass", column = "klass_id", one = @One(select = "seminar.mapper.KlassMapper.selectKlassById", fetchType = FetchType.LAZY))
    })
    List<Team> selectAllTeam();

    /**
     * Select a Team entity via courseId
     *
     * @param courseId the select gist
     * @return List<team> the selected Team entity as list
     */
    @Select("select * from team where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "team_serial"),
            @Result(property = "teamName", column = "team_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "leaderId", column = "leader_id"),
            @Result(property = "leader", column = "leader_id", one = @One(select = "seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
            @Result(property = "students", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassStudentMapper.selectStudentsFromTeam", fetchType = FetchType.LAZY)),
            @Result(property = "klass", column = "klass_id", one = @One(select = "seminar.mapper.KlassMapper.selectKlassById", fetchType = FetchType.LAZY))
    })
    List<Team> selectTeamByCourseId(String courseId);

    /**
     * Select a Team entity via klassId
     *
     * @param klassId the select gist
     * @return List<team> the selected Team entity as list
     */
    @Select("select * from team where klass_id=#{klassId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "team_serial"),
            @Result(property = "teamName", column = "team_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "leaderId", column = "leader_id"),
            @Result(property = "leader", column = "leader_id", one = @One(select = "seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
            @Result(property = "students", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassStudentMapper.selectStudentsFromTeam", fetchType = FetchType.LAZY)),
            @Result(property = "klass", column = "klass_id", one = @One(select = "seminar.mapper.KlassMapper.selectKlassById", fetchType = FetchType.LAZY))
    })
    List<Team> selectTeamByKlassId(String klassId);

    /**
     * Select a Team entity via id
     *
     * @param id the select gist
     * @return List<team> the selected Team entity as list
     */
    @Select("select * from team where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "serial", column = "team_serial"),
            @Result(property = "teamName", column = "team_name"),
            @Result(property = "status", column = "status"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "leaderId", column = "leader_id"),
            @Result(property = "leader", column = "leader_id", one = @One(select = "seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
            @Result(property = "students", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.relation.KlassStudentMapper.selectStudentsFromTeam", fetchType = FetchType.LAZY)),
            @Result(property = "klass", column = "klass_id", one = @One(select = "seminar.mapper.KlassMapper.selectKlassById", fetchType = FetchType.LAZY))
    })
    List<Team> selectTeamById(String id);

    /**
     * Delete a Team entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from team where course_id=#{courseId}")
    void deleteTeamByCourseId(String courseId);

    /**
     * Delete a Team entity via klassId
     *
     * @param klassId the select gist
     */
    @Delete("delete from team where klass_id=#{klassId}")
    void deleteTeamByKlassId(String klassId);

    /**
     * Delete a Team entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from team where id=#{id}")
    void deleteTeamById(String id);

    /**
     * Add a new team into table team
     * @author Xinyu Shi
     * @param team new team
     */
    @Insert("insert into team(team_serial, klass_id, course_id, leader_id, team_name, status) select max(team_serial) + 1, #{klassId}, #{courseId}, #{leaderId}, #{teamName}, #{status}  from team where klass_id = #{klassId}")
    @Options(useGeneratedKeys = true)
    void addTeam(Team team);

}
