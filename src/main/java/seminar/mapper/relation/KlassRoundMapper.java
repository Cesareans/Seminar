package seminar.mapper.relation;

import org.apache.ibatis.annotations.*;
import seminar.entity.relation.KlassRound;

import java.util.List;

/**
 * An automatic generated mapper for the entity KlassRound.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface KlassRoundMapper {
    /**
     * Insert a KlassRound entity
     *
     * @param klassRound the KlassRound entity that will be inserted
     */
    @Insert("insert into klass_round(klass_id, round_id, enroll_number) values(#{klassId}, #{roundId}, #{enrollLimit})")
    void insertKlassRound(KlassRound klassRound);

    /**
     * Update a KlassRound entity's information
     *
     * @param klassRound the KlassRound entity that will be updated via the id
     */
    @Update("update klass_round set enroll_number=#{enrollLimit} where klass_id=#{klassId} and round_id=#{roundId}")
    void updateKlassRound(KlassRound klassRound);

    /**
     * Select a KlassRound entity via klassId
     *
     * @param klassId the select gist
     * @return List<klassRound> the selected KlassRound entity as list
     */
    @Select("select * from klass_round where klass_id=#{klassId}")
    @Results({
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "enrollLimit", column = "enroll_number")
    })
    List<KlassRound> selectKlassRoundByKlassId(String klassId);

    /**
     * Select a KlassRound entity via roundId
     *
     * @param roundId the select gist
     * @return List<klassRound> the selected KlassRound entity as list
     */
    @Select("select * from klass_round where round_id=#{roundId}")
    @Results({
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "enrollLimit", column = "enroll_number")
    })
    List<KlassRound> selectKlassRoundByRoundId(String roundId);

    /**
     * Select a KlassRound entity via union
     *
     * @param klassId the select gist
     * @param roundId the union gist
     * @return List<klassRound> the selected KlassRound entity as list
     */
    @Select("select * from klass_round where klass_id=#{klassId} and round_id=#{roundId}")
    @Results({
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "roundId", column = "round_id"),
            @Result(property = "enrollLimit", column = "enroll_number")
    })
    List<KlassRound> selectKlassRoundByKlassIdAndRoundId(@Param("klassId") String klassId, @Param("roundId") String roundId);

    /**
     * Delete a KlassRound entity via klassId
     *
     * @param klassId the select gist
     */
    @Delete("delete from klass_round where klass_id=#{klassId}")
    void deleteKlassRoundByKlassId(String klassId);

    /**
     * Delete a KlassRound entity via roundId
     *
     * @param roundId the select gist
     */
    @Delete("delete from klass_round where round_id=#{roundId}")
    void deleteKlassRoundByRoundId(String roundId);

    /**
     * Delete klass rounds by courseId
     * @param courseId the delete refer gist
     */
    @Delete("delete from klass_round where klass_id in (select id from klass where course_id = #{courseId})")
    void deleteKlassRoundByCourseId(String courseId);
}
