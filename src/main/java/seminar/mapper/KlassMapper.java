package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import seminar.entity.Klass;

import java.util.List;

/**
 * An automatic generated mapper for the entity Klass.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface KlassMapper {
    /**
     * Insert a Klass entity
     *
     * @param klass the Klass entity that will be inserted
     */
    @Insert("insert into klass(grade, klass_serial, klass_time, klass_location, course_id) values(#{grade}, #{serial}, #{time}, #{location}, #{courseId})")
    @Options(useGeneratedKeys = true)
    void insertKlass(Klass klass);

    /**
     * Update a Klass entity's information
     *
     * @param klass the Klass entity that will be updated via the id
     */
    @Update("update klass set grade=#{grade}, klass_serial=#{serial}, klass_time=#{time}, klass_location=#{location}, course_id=#{courseId} where id=#{id}")
    void updateKlass(Klass klass);

    /**
     * Select all Klass entities
     *
     * @return List<klass> the selected Klass entities list
     */
    @Select("select * from klass")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "grade", column = "grade"),
            @Result(property = "serial", column = "klass_serial"),
            @Result(property = "time", column = "klass_time"),
            @Result(property = "location", column = "klass_location"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "course", column = "course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<Klass> selectAllKlass();

    /**
     * Select a Klass entity via courseId
     *
     * @param courseId the select gist
     * @return List<klass> the selected Klass entity as list
     */
    @Select("select * from klass where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "grade", column = "grade"),
            @Result(property = "serial", column = "klass_serial"),
            @Result(property = "time", column = "klass_time"),
            @Result(property = "location", column = "klass_location"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "course", column = "course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<Klass> selectKlassByCourseId(String courseId);

    /**
     * Select a Klass entity via id
     *
     * @param id the select gist
     * @return List<klass> the selected Klass entity as list
     */
    @Select("select * from klass where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "grade", column = "grade"),
            @Result(property = "serial", column = "klass_serial"),
            @Result(property = "time", column = "klass_time"),
            @Result(property = "location", column = "klass_location"),
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "course", column = "course_id", one = @One(select = "seminar.mapper.CourseMapper.selectCourseById", fetchType = FetchType.LAZY))
    })
    List<Klass> selectKlassById(String id);

    /**
     * Delete a Klass entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from klass where course_id=#{courseId}")
    void deleteKlassByCourseId(String courseId);

    /**
     * Delete a Klass entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from klass where id=#{id}")
    void deleteKlassById(String id);

}
