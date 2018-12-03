package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.ClbumSeminar;

import java.util.List;

/**
 * An automatic generated mapper for the entity ClbumSeminar.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface ClbumSeminarMapper {
    /**
     * Insert a ClbumSeminar entity
     *
     * @param clbumSeminar the ClbumSeminar entity that will be inserted
     */
    @Insert("insert into clbum_seminar(state, clbum_id, seminar_id) values(#{state}, #{clbumId}, #{seminarId})")
    void insertClbumSeminar(ClbumSeminar clbumSeminar);

    /**
     * Update a ClbumSeminar entity's information
     *
     * @param clbumSeminar the ClbumSeminar entity that will be updated via the private java.lang.String seminar.entity.ClbumSeminar.id
     */
    @Update("update clbum_seminar set state=#{state}, clbum_id=#{clbumId}, seminar_id=#{seminarId} where id=#{id}")
    void updateClbumSeminar(ClbumSeminar clbumSeminar);

    /**
     * Select all ClbumSeminar entities
     *
     * @return List<clbumSeminar> the selected ClbumSeminar entities list
     */
    @Select("select * from clbum_seminar")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "state"),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.EAGER))
    })
    List<ClbumSeminar> selectAllClbumSeminar();

    /**
     * Select a ClbumSeminar entity via clbumId
     *
     * @param clbumId the select gist
     * @return List<clbumSeminar> the selected ClbumSeminar entity as list
     */
    @Select("select * from clbum_seminar where clbum_id=#{clbumId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "state"),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.EAGER))
    })
    List<ClbumSeminar> selectClbumSeminarByClbumId(String clbumId);

    /**
     * Select a ClbumSeminar entity via seminarId
     *
     * @param seminarId the select gist
     * @return List<clbumSeminar> the selected ClbumSeminar entity as list
     */
    @Select("select * from clbum_seminar where seminar_id=#{seminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "state"),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.EAGER))
    })
    List<ClbumSeminar> selectClbumSeminarBySeminarId(String seminarId);

    /**
     * Select a ClbumSeminar entity via id
     *
     * @param id the select gist
     * @return List<clbumSeminar> the selected ClbumSeminar entity as list
     */
    @Select("select * from clbum_seminar where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "state"),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.EAGER))
    })
    List<ClbumSeminar> selectClbumSeminarById(String id);

    /**
     * Select a ClbumSeminar entity via union
     *
     * @param clbumId   the select gist
     * @param seminarId the union gist
     * @return List<clbumSeminar> the selected ClbumSeminar entity as list
     */
    @Select("select * from clbum_seminar where clbum_id=#{clbumId} and seminar_id=#{seminarId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "state", column = "state"),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "seminarId", column = "seminar_id"),
            @Result(property = "seminar", column = "seminar_id", one = @One(select = "seminar.mapper.SeminarMapper.selectSeminarById", fetchType = FetchType.EAGER))
    })
    List<ClbumSeminar> selectClbumSeminarByClbumIdAndSeminarId(@Param("clbumId") String clbumId, @Param("seminarId") String seminarId);

    /**
     * Delete a ClbumSeminar entity via private java.lang.String seminar.entity.ClbumSeminar.clbumId
     *
     * @param clbumId the select gist
     */
    @Delete("delete from clbum_seminar where clbum_id=#{clbumId}")
    void deleteClbumSeminarByClbumId(String clbumId);

    /**
     * Delete a ClbumSeminar entity via private java.lang.String seminar.entity.ClbumSeminar.seminarId
     *
     * @param seminarId the select gist
     */
    @Delete("delete from clbum_seminar where seminar_id=#{seminarId}")
    void deleteClbumSeminarBySeminarId(String seminarId);

    /**
     * Delete a ClbumSeminar entity via private java.lang.String seminar.entity.ClbumSeminar.id
     *
     * @param id the select gist
     */
    @Delete("delete from clbum_seminar where id=#{id}")
    void deleteClbumSeminarById(String id);

}