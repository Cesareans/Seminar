package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Clbum;

import java.util.List;

/**
 * An automatic generated mapper for the entity Clbum.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface ClbumMapper {
    /**
     * Insert a Clbum entity
     *
     * @param clbum the Clbum entity that will be inserted
     */
    @Insert("insert into clbum(name, time, location, course_id) values(#{name}, #{time}, #{location}, #{courseId})")
    void insertClbum(Clbum clbum);

    /**
     * Update a Clbum entity's information
     *
     * @param clbum the Clbum entity that will be updated via the private java.lang.String seminar.entity.Clbum.id
     */
    @Update("update clbum set name=#{name}, time=#{time}, location=#{location}, course_id=#{courseId} where id=#{id}")
    void updateClbum(Clbum clbum);

    /**
     * Select all Clbum entities
     *
     * @return List<clbum> the selected Clbum entities list
     */
    @Select("select * from clbum")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "time", column = "time"),
            @Result(property = "location", column = "location"),
            @Result(property = "courseId", column = "course_id")
    })
    List<Clbum> selectAllClbum();

    /**
     * Select a Clbum entity via courseId
     *
     * @param courseId the select gist
     * @return List<clbum> the selected Clbum entity as list
     */
    @Select("select * from clbum where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "time", column = "time"),
            @Result(property = "location", column = "location"),
            @Result(property = "courseId", column = "course_id")
    })
    List<Clbum> selectClbumByCourseId(String courseId);

    /**
     * Select a Clbum entity via id
     *
     * @param id the select gist
     * @return List<clbum> the selected Clbum entity as list
     */
    @Select("select * from clbum where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "time", column = "time"),
            @Result(property = "location", column = "location"),
            @Result(property = "courseId", column = "course_id")
    })
    List<Clbum> selectClbumById(String id);

    /**
     * Delete a Clbum entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from clbum where course_id=#{courseId}")
    void deleteClbumByCourseId(String courseId);

    /**
     * Delete a Clbum entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from clbum where id=#{id}")
    void deleteClbumById(String id);

}
