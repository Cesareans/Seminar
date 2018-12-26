package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.KlassSeminar;

import java.util.List;

/**
 * An automatic generated mapper for the entity KlassSeminar.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface KlassSeminarMapper {
    /**
     * Insert a KlassSeminar entity
     *
     * @param klassSeminar the KlassSeminar entity that will be inserted
     */
    @Insert("insert into klass_seminar(status, klass_id, seminar_id) values(#{state}, #{klassId}, #{seminarId})")
    @Options(useGeneratedKeys = true)
    void insertKlassSeminar(KlassSeminar klassSeminar);

    /**
     * Update a KlassSeminar entity's information
     *
     * @param klassSeminar the KlassSeminar entity that will be updated via the id
     */
    @Update("update klass_seminar set status=#{state}, klass_id=#{klassId}, seminar_id=#{seminarId} where id=#{id}")
    void updateKlassSeminar(KlassSeminar klassSeminar);

    /**
     * Select all KlassSeminar entities
     *
     * @return List<klassSeminar> the selected KlassSeminar entities list
     */
    @Select("select * from klass_seminar")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "status"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "attendances", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.AttendanceMapper.selectAttendanceByKlassSeminarId", fetchType = FetchType.LAZY)),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.LAZY))
    })
    List<KlassSeminar> selectAllKlassSeminar();

    /**
     * Select a KlassSeminar entity via klassId
     *
     * @param klassId the select gist
     * @return List<klassSeminar> the selected KlassSeminar entity as list
     */
    @Select("select * from klass_seminar where klass_id=#{klassId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "status"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "attendances", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.AttendanceMapper.selectAttendanceByKlassSeminarId", fetchType = FetchType.LAZY)),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.LAZY))
    })
    List<KlassSeminar> selectKlassSeminarByKlassId(String klassId);

    /**
     * Select a KlassSeminar entity via seminarId
     *
     * @param seminarId the select gist
     * @return List<klassSeminar> the selected KlassSeminar entity as list
     */
    @Select("select * from klass_seminar where seminar_id=#{seminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "status"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "attendances", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.AttendanceMapper.selectAttendanceByKlassSeminarId", fetchType = FetchType.LAZY)),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.LAZY))
    })
    List<KlassSeminar> selectKlassSeminarBySeminarId(String seminarId);

    /**
     * Select a KlassSeminar entity via id
     *
     * @param id the select gist
     * @return List<klassSeminar> the selected KlassSeminar entity as list
     */
    @Select("select * from klass_seminar where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "status"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "attendances", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.AttendanceMapper.selectAttendanceByKlassSeminarId", fetchType = FetchType.LAZY)),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.LAZY))
    })
    List<KlassSeminar> selectKlassSeminarById(String id);

    /**
     * Select a KlassSeminar entity via union
     *
     * @param klassId   the select gist
     * @param seminarId the union gist
     * @return List<klassSeminar> the selected KlassSeminar entity as list
     */
    @Select("select * from klass_seminar where klass_id=#{klassId} and seminar_id=#{seminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "status"),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "attendances", column = "id", javaType = List.class, many = @Many(select = "seminar.mapper.AttendanceMapper.selectAttendanceByKlassSeminarId", fetchType = FetchType.LAZY)),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.LAZY))
    })
    List<KlassSeminar> selectKlassSeminarByKlassIdAndSeminarId(@Param("klassId") String klassId, @Param("seminarId") String seminarId);

    /**
     * Delete a KlassSeminar entity via klassId
     *
     * @param klassId the select gist
     */
    @Delete("delete from klass_seminar where klass_id=#{klassId}")
    void deleteKlassSeminarByKlassId(String klassId);

    /**
     * Delete a KlassSeminar entity via seminarId
     *
     * @param seminarId the select gist
     */
    @Delete("delete from klass_seminar where seminar_id=#{seminarId}")
    void deleteKlassSeminarBySeminarId(String seminarId);

    /**
     * Delete a KlassSeminar entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from klass_seminar where id=#{id}")
    void deleteKlassSeminarById(String id);

}
