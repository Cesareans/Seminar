package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.Round;

import java.util.List;

/**
 * An automatic generated mapper for the entity Round.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface RoundMapper {
    /**
     * Insert a Round entity
     *
     * @param round the Round entity that will be inserted
     */
    @Insert("insert into round(round_num, course_id) values(#{roundNum}, #{courseId})")
    void insertRound(Round round);

    /**
     * Insert a new Round into a course.
     *
     * @param courseId the Course refer gist
     */
    @Insert("insert into round(round_num, course_id) select max(round_num) + 1,course_id from round where course_id = #{courseId}")
    void addRound(String courseId);


    /**
     * Update a Round entity's information
     *
     * @param round the Round entity that will be updated via the id
     */
    @Update("update round set round_num=#{roundNum}, course_id=#{courseId} where id=#{id}")
    void updateRound(Round round);

    /**
     * Select all Round entities
     *
     * @return List<round> the selected Round entities list
     */
    @Select("select * from round")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roundNum", column = "round_num"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "seminars", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", fetchType = FetchType.EAGER))
    })
    List<Round> selectAllRound();

    /**
     * Select a Round entity via courseId
     *
     * @param courseId the select gist
     * @return List<round> the selected Round entity as list
     */
    @Select("select * from round where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roundNum", column = "round_num"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "seminars", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", fetchType = FetchType.EAGER))
    })
    List<Round> selectRoundByCourseId(String courseId);

    /**
     * Select a Round entity via id
     *
     * @param id the select gist
     * @return List<round> the selected Round entity as list
     */
    @Select("select * from round where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roundNum", column = "round_num"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "seminars", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", fetchType = FetchType.EAGER))
    })
    List<Round> selectRoundById(String id);

    /**
     * Delete a Round entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from round where course_id=#{courseId}")
    void deleteRoundByCourseId(String courseId);

    /**
     * Delete a Round entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from round where id=#{id}")
    void deleteRoundById(String id);

}
