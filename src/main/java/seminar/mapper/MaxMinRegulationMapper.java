package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.MaxMinRegulation;

import java.util.List;

/**
 * An automatic generated mapper for the entity MaxMinRegulation.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface MaxMinRegulationMapper {
    /**
     * Insert a MaxMinRegulation entity
     *
     * @param maxMinRegulation the MaxMinRegulation entity that will be inserted
     */
    @Insert("insert into max_min_regulation(min, max, course_id) values(#{min}, #{max}, #{courseId})")
    void insertMaxMinRegulation(MaxMinRegulation maxMinRegulation);

    /**
     * Update a MaxMinRegulation entity's information
     *
     * @param maxMinRegulation the MaxMinRegulation entity that will be updated via the private java.lang.String seminar.entity.MaxMinRegulation.id
     */
    @Update("update max_min_regulation set min=#{min}, max=#{max}, course_id=#{courseId} where id=#{id}")
    void updateMaxMinRegulation(MaxMinRegulation maxMinRegulation);

    /**
     * Select all MaxMinRegulation entities
     *
     * @return List<maxMinRegulation> the selected MaxMinRegulation entities list
     */
    @Select("select * from max_min_regulation")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "min", column = "min"),
            @Result(property = "max", column = "max"),
            @Result(property = "courseId", column = "course_id")
    })
    List<MaxMinRegulation> selectAllMaxMinRegulation();

    /**
     * Select a MaxMinRegulation entity via courseId
     *
     * @param courseId the select gist
     * @return List<maxMinRegulation> the selected MaxMinRegulation entity as list
     */
    @Select("select * from max_min_regulation where course_id=#{courseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "min", column = "min"),
            @Result(property = "max", column = "max"),
            @Result(property = "courseId", column = "course_id")
    })
    List<MaxMinRegulation> selectMaxMinRegulationByCourseId(String courseId);

    /**
     * Select a MaxMinRegulation entity via id
     *
     * @param id the select gist
     * @return List<maxMinRegulation> the selected MaxMinRegulation entity as list
     */
    @Select("select * from max_min_regulation where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "min", column = "min"),
            @Result(property = "max", column = "max"),
            @Result(property = "courseId", column = "course_id")
    })
    List<MaxMinRegulation> selectMaxMinRegulationById(String id);

    /**
     * Delete a MaxMinRegulation entity via courseId
     *
     * @param courseId the select gist
     */
    @Delete("delete from max_min_regulation where course_id=#{courseId}")
    void deleteMaxMinRegulationByCourseId(String courseId);

    /**
     * Delete a MaxMinRegulation entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from max_min_regulation where id=#{id}")
    void deleteMaxMinRegulationById(String id);

}
