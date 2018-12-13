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
@Insert("insert into team(serial, team_name, is_valid, klass_id, leader_id) values(#{serial}, #{teamName}, #{valid}, #{klassId}, #{leaderId})")
void insertTeam(Team team);

/**
* Update a Team entity's information
*
* @param team the Team entity that will be updated via the id
*/
@Update("update team set serial=#{serial}, team_name=#{teamName}, is_valid=#{valid}, klass_id=#{klassId}, leader_id=#{leaderId} where id=#{id}")
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
@Result(property = "teamName", column = "team_name"),
@Result(property = "valid", column = "is_valid"),
@Result(property = "klassId", column = "klass_id"),
@Result(property = "leaderId", column = "leader_id"),
@Result(property = "leader", column = "leader_id", one=@One(select="seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
@Result(property = "students", column = "id", javaType = List.class, many=@Many(select="seminar.mapper.TeamStudentMapper.selectStudentsByTeamId", fetchType = FetchType.LAZY))
})
List<Team> selectAllTeam();

/**
* Select a Team entity via klassId
*
* @param klassId the select gist
* @return List<team> the selected Team entity as list
*/
@Select("select * from team where klass_id=#{klassId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "serial", column = "serial"),
@Result(property = "teamName", column = "team_name"),
@Result(property = "valid", column = "is_valid"),
@Result(property = "klassId", column = "klass_id"),
@Result(property = "leaderId", column = "leader_id"),
@Result(property = "leader", column = "leader_id", one=@One(select="seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
@Result(property = "students", column = "id", javaType = List.class, many=@Many(select="seminar.mapper.TeamStudentMapper.selectStudentsByTeamId", fetchType = FetchType.LAZY))
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
@Result(property = "serial", column = "serial"),
@Result(property = "teamName", column = "team_name"),
@Result(property = "valid", column = "is_valid"),
@Result(property = "klassId", column = "klass_id"),
@Result(property = "leaderId", column = "leader_id"),
@Result(property = "leader", column = "leader_id", one=@One(select="seminar.mapper.StudentMapper.selectStudentById", fetchType = FetchType.LAZY)),
@Result(property = "students", column = "id", javaType = List.class, many=@Many(select="seminar.mapper.TeamStudentMapper.selectStudentsByTeamId", fetchType = FetchType.LAZY))
})
List<Team> selectTeamById(String id);

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

}
