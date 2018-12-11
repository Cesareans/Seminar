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
    @Insert("insert into attendance(sn, pre_file, is_presenting, report_file, pre_score, report_score, team_id, klass_seminar_id) values(#{sn}, #{preFile}, #{presenting}, #{reportFile}, #{preScore}, #{reportScore}, #{teamId}, #{klassSeminarId})")
    void insertAttendance(Attendance attendance);

    /**
     * Update a Attendance entity's information
     *
     * @param attendance the Attendance entity that will be updated via the id
     */
    @Update("update attendance set sn=#{sn}, pre_file=#{preFile}, is_presenting=#{presenting}, report_file=#{reportFile}, pre_score=#{preScore}, report_score=#{reportScore}, team_id=#{teamId}, klass_seminar_id=#{klassSeminarId} where id=#{id}")
    void updateAttendance(Attendance attendance);

    /**
     * Select all Attendance entities
     *
     * @return List<attendance> the selected Attendance entities list
     */
    @Select("select * from attendance")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "sn", column = "sn"),
            @Result(property = "preFile", column = "pre_file"),
            @Result(property = "presenting", column = "is_presenting"),
            @Result(property = "reportFile", column = "report_file"),
            @Result(property = "preScore", column = "pre_score"),
            @Result(property = "reportScore", column = "report_score"),
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
            @Result(property = "sn", column = "sn"),
            @Result(property = "preFile", column = "pre_file"),
            @Result(property = "presenting", column = "is_presenting"),
            @Result(property = "reportFile", column = "report_file"),
            @Result(property = "preScore", column = "pre_score"),
            @Result(property = "reportScore", column = "report_score"),
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
            @Result(property = "sn", column = "sn"),
            @Result(property = "preFile", column = "pre_file"),
            @Result(property = "presenting", column = "is_presenting"),
            @Result(property = "reportFile", column = "report_file"),
            @Result(property = "preScore", column = "pre_score"),
            @Result(property = "reportScore", column = "report_score"),
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
            @Result(property = "sn", column = "sn"),
            @Result(property = "preFile", column = "pre_file"),
            @Result(property = "presenting", column = "is_presenting"),
            @Result(property = "reportFile", column = "report_file"),
            @Result(property = "preScore", column = "pre_score"),
            @Result(property = "reportScore", column = "report_score"),
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

}
