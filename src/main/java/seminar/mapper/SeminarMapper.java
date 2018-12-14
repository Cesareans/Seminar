package seminar.mapper;

import org.apache.ibatis.annotations.*;
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
    @Insert("insert into seminar(seminar_name, introduction, seminar_serial, max_team, is_visible, enroll_start_time, enroll_end_time, round_id, course_id) values(#{theme}, #{content}, #{serial}, #{maxTeam}, #{visible}, #{enrollStartDate}, #{enrollEndDate}, #{roundId}, #{courseId})")
    void insertSeminar(Seminar seminar);

    /**
     * Update a Seminar entity's information
     *
     * @param seminar the Seminar entity that will be updated via the id
     */
    @Update("update seminar set seminar_name=#{theme}, introduction=#{content}, seminar_serial=#{serial}, max_team=#{maxTeam}, is_visible=#{visible}, enroll_start_time=#{enrollStartDate}, enroll_end_time=#{enrollEndDate}, round_id=#{roundId}, course_id=#{courseId} where id=#{id}")
    void updateSeminar(Seminar seminar);

    /**
     * Select all Seminar entities
     *
     * @return List<seminar> the selected Seminar entities list
     */
    @Select("select * from seminar")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "theme", column = "seminar_name"),
            @Result(property = "content", column = "introduction"),
            @Result(property = "serial", column = "seminar_serial"),
            @Result(property = "maxTeam", column = "max_team"),
            @Result(property = "visible", column = "is_visible"),
            @Result(property = "enrollStartDate", column = "enroll_start_time"),
            @Result(property = "enrollEndDate", column = "enroll_end_time"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "courseId", column = "course_id")
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
            @Result(property = "theme", column = "seminar_name"),
            @Result(property = "content", column = "introduction"),
            @Result(property = "serial", column = "seminar_serial"),
            @Result(property = "maxTeam", column = "max_team"),
            @Result(property = "visible", column = "is_visible"),
            @Result(property = "enrollStartDate", column = "enroll_start_time"),
            @Result(property = "enrollEndDate", column = "enroll_end_time"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "courseId", column = "course_id")
    })
    List<Seminar> selectSeminarByRoundId(String roundId);

    /**
     * Select a Seminar entity via courseId
     *
     * @param courseId the select gist
     * @return List<seminar> the selected Seminar entity as list
     */
    @Select("select * from seminar where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "theme", column = "seminar_name"),
            @Result(property = "content", column = "introduction"),
            @Result(property = "serial", column = "seminar_serial"),
            @Result(property = "maxTeam", column = "max_team"),
            @Result(property = "visible", column = "is_visible"),
            @Result(property = "enrollStartDate", column = "enroll_start_time"),
            @Result(property = "enrollEndDate", column = "enroll_end_time"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "courseId", column = "course_id")
    })
    List<Seminar> selectSeminarByCourseId(String courseId);

    /**
     * Select a Seminar entity via id
     *
     * @param id the select gist
     * @return List<seminar> the selected Seminar entity as list
     */
    @Select("select * from seminar where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "theme", column = "seminar_name"),
            @Result(property = "content", column = "introduction"),
            @Result(property = "serial", column = "seminar_serial"),
            @Result(property = "maxTeam", column = "max_team"),
            @Result(property = "visible", column = "is_visible"),
            @Result(property = "enrollStartDate", column = "enroll_start_time"),
            @Result(property = "enrollEndDate", column = "enroll_end_time"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "courseId", column = "course_id")
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
     * Delete a Seminar entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from seminar where course_id=#{courseId}")
    void deleteSeminarByCourseId(String courseId);

    /**
     * Delete a Seminar entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from seminar where id=#{id}")
    void deleteSeminarById(String id);

}
