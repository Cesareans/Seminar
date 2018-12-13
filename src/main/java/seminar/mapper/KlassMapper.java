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
@Insert("insert into klass(klass_name, time, location, course_id) values(#{klassName}, #{time}, #{location}, #{courseId})")
void insertKlass(Klass klass);

/**
* Update a Klass entity's information
*
* @param klass the Klass entity that will be updated via the id
*/
@Update("update klass set klass_name=#{klassName}, time=#{time}, location=#{location}, course_id=#{courseId} where id=#{id}")
void updateKlass(Klass klass);

/**
* Select all Klass entities
*
* @return List<klass> the selected Klass entities list
*/
@Select("select * from klass")
@Results({
@Result(property = "id", column = "id", id = true),
@Result(property = "klassName", column = "klass_name"),
@Result(property = "time", column = "time"),
@Result(property = "location", column = "location"),
@Result(property = "courseId", column = "course_id")
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
@Result(property = "klassName", column = "klass_name"),
@Result(property = "time", column = "time"),
@Result(property = "location", column = "location"),
@Result(property = "courseId", column = "course_id")
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
@Result(property = "klassName", column = "klass_name"),
@Result(property = "time", column = "time"),
@Result(property = "location", column = "location"),
@Result(property = "courseId", column = "course_id")
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
