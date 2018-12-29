package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.Attendance;

import java.util.List;

/**
 * An automatic generated mapper for the entity Attendance.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface AttendanceMapper {
    /**
     * Insert a Attendance entity
     *
     * @param attendance the Attendance entity that will be inserted
     */
    @Insert("insert into attendance(team_order, is_present, ppt_name, report_name, team_id, klass_seminar_id) values(#{sn}, #{presenting}, #{preFile}, #{reportFile}, #{teamId}, #{klassSeminarId})")
    @Options(useGeneratedKeys = true)
    void insertAttendance(Attendance attendance);

    /**
     * Update a Attendance entity's information
     *
     * @param attendance the Attendance entity that will be updated via the id
     */
    @Update("update attendance set team_order=#{sn}, is_present=#{presenting}, ppt_name=#{preFile}, report_name=#{reportFile}, team_id=#{teamId}, klass_seminar_id=#{klassSeminarId} where id=#{id}")
    void updateAttendance(Attendance attendance);

    /**
     * Select all Attendance entities
     *
     * @return List<attendance> the selected Attendance entities list
     */
    @Select("select * from attendance")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sn", column = "team_order"),
            @Result(property = "presenting", column = "is_present"),
            @Result(property = "preFile", column = "ppt_name"),
            @Result(property = "reportFile", column = "report_name"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.EAGER))
    })
    List<Attendance> selectAllAttendance();

    /**
     * Select a Attendance entity via teamId
     *
     * @param teamId the select gist
     * @return List<attendance> the selected Attendance entity as list
     */
    @Select("select * from attendance where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sn", column = "team_order"),
            @Result(property = "presenting", column = "is_present"),
            @Result(property = "preFile", column = "ppt_name"),
            @Result(property = "reportFile", column = "report_name"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.EAGER))
    })
    List<Attendance> selectAttendanceByTeamId(String teamId);

    /**
     * Select a Attendance entity via klassSeminarId
     *
     * @param klassSeminarId the select gist
     * @return List<attendance> the selected Attendance entity as list
     */
    @Select("select * from attendance where klass_seminar_id=#{klassSeminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sn", column = "team_order"),
            @Result(property = "presenting", column = "is_present"),
            @Result(property = "preFile", column = "ppt_name"),
            @Result(property = "reportFile", column = "report_name"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.EAGER))
    })
    List<Attendance> selectAttendanceByKlassSeminarId(String klassSeminarId);

    /**
     * Select a Attendance entity via id
     *
     * @param id the select gist
     * @return List<attendance> the selected Attendance entity as list
     */
    @Select("select * from attendance where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sn", column = "team_order"),
            @Result(property = "presenting", column = "is_present"),
            @Result(property = "preFile", column = "ppt_name"),
            @Result(property = "reportFile", column = "report_name"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.EAGER))
    })
    List<Attendance> selectAttendanceById(String id);

    /**
     * Delete a Attendance entity via teamId
     *
     * @param teamId the select gist
     */
    @Delete("delete from attendance where team_id=#{teamId}")
    void deleteAttendanceByTeamId(String teamId);

    /**
     * Delete a Attendance entity via klassSeminarId
     *
     * @param klassSeminarId the select gist
     */
    @Delete("delete from attendance where klass_seminar_id=#{klassSeminarId}")
    void deleteAttendanceByKlassSeminarId(String klassSeminarId);

    /**
     * Delete a Attendance entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from attendance where id=#{id}")
    void deleteAttendanceById(String id);

    /**
     * Select a Attendance entity via teamId
     * @author Xinyu Shi
     * @param teamId the select gist
     * @param klassSeminarId the refer gist
     * @return List<attendance> the selected Attendance entity as list
     */
    @Select("select * from attendance where team_id=#{teamId} and klass_seminar_id=#{klassSeminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sn", column = "team_order"),
            @Result(property = "presenting", column = "is_present"),
            @Result(property = "preFile", column = "ppt_name"),
            @Result(property = "reportFile", column = "report_name"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "klassSeminarId", column = "klass_seminar_id"),
            @Result(property = "team", column = "team_id", one = @One(select = "seminar.mapper.TeamMapper.selectTeamById", fetchType = FetchType.EAGER))
    })
    List<Attendance> selectAttendanceByTeamIdAndKlassSeminarId(@Param("teamId") String teamId, @Param("klassSeminarId") String klassSeminarId);

}
