package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import seminar.entity.Seminar;
import java.util.List;

/**
* An automatic generated mapper for the entity Seminar. 
* This mapper is for a increment primary key table.
*
* @author Cesare
*/
@Mapper
public interface SeminarMapper {
/**
* Insert a Seminar entity
*
* @param seminar the Seminar entity that will be inserted
*/
@Insert("insert into seminar(theme, content, serial, max_team, is_ordered, is_visible, enroll_start_date, enroll_end_date, round_id) values(#{theme}, #{content}, #{serial}, #{maxTeam}, #{ordered}, #{visible}, #{enrollStartDate}, #{enrollEndDate}, #{roundId})")
void insertSeminar(Seminar seminar);

/**
* Update a Seminar entity's information
*
* @param seminar the Seminar entity that will be updated via the id
*/
@Update("update seminar set theme=#{theme}, content=#{content}, serial=#{serial}, max_team=#{maxTeam}, is_ordered=#{ordered}, is_visible=#{visible}, enroll_start_date=#{enrollStartDate}, enroll_end_date=#{enrollEndDate}, round_id=#{roundId} where id=#{id}")
void updateSeminar(Seminar seminar);

/**
* Select all Seminar entities
*
* @return List<seminar> the selected Seminar entities list
*/
@Select("select * from seminar")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "theme", column = "theme"),
@Result(property = "content", column = "content"),
@Result(property = "serial", column = "serial"),
@Result(property = "maxTeam", column = "max_team"),
@Result(property = "ordered", column = "is_ordered"),
@Result(property = "visible", column = "is_visible"),
@Result(property = "enrollStartDate", column = "enroll_start_date"),
@Result(property = "enrollEndDate", column = "enroll_end_date"),
@Result(property = "roundId", column = "round_id")
})
List<Seminar> selectAllSeminar();

/**
* Select a Seminar entity via roundId
*
* @param roundId the select gist
* @return List<seminar> the selected Seminar entity as list
*/
@Select("select * from seminar where round_id=#{roundId}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "theme", column = "theme"),
@Result(property = "content", column = "content"),
@Result(property = "serial", column = "serial"),
@Result(property = "maxTeam", column = "max_team"),
@Result(property = "ordered", column = "is_ordered"),
@Result(property = "visible", column = "is_visible"),
@Result(property = "enrollStartDate", column = "enroll_start_date"),
@Result(property = "enrollEndDate", column = "enroll_end_date"),
@Result(property = "roundId", column = "round_id")
})
List<Seminar> selectSeminarByRoundId(String roundId);

/**
* Select a Seminar entity via id
*
* @param id the select gist
* @return List<seminar> the selected Seminar entity as list
*/
@Select("select * from seminar where id=#{id}")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "theme", column = "theme"),
@Result(property = "content", column = "content"),
@Result(property = "serial", column = "serial"),
@Result(property = "maxTeam", column = "max_team"),
@Result(property = "ordered", column = "is_ordered"),
@Result(property = "visible", column = "is_visible"),
@Result(property = "enrollStartDate", column = "enroll_start_date"),
@Result(property = "enrollEndDate", column = "enroll_end_date"),
@Result(property = "roundId", column = "round_id")
})
List<Seminar> selectSeminarById(String id);

/**
* Delete a Seminar entity via roundId
*
* @param roundId the select gist
*/
@Delete("delete from seminar where round_id=#{roundId}")
void deleteSeminarByRoundId(String roundId);

/**
* Delete a Seminar entity via id
*
* @param id the select gist
*/
@Delete("delete from seminar where id=#{id}")
void deleteSeminarById(String id);

}
