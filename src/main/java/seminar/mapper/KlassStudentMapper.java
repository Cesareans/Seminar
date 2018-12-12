package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.relation.KlassStudent;

import java.util.List;

/**
 * An automatic generated mapper for the entity KlassStudent.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface KlassStudentMapper {
    /**
     * Insert a KlassStudent entity
     *
     * @param klassStudent the KlassStudent entity that will be inserted
     */
    @Insert("insert into klass_student(klass_id, student_id) values(#{klassId}, #{studentId})")
    void insertKlassStudent(KlassStudent klassStudent);

    /**
     * Update a KlassStudent entity's information
     *
     * @param klassStudent the KlassStudent entity that will be updated via the id
     */
    @Update("update klass_student set klass_id=#{klassId}, student_id=#{studentId} where id=#{id}")
    void updateKlassStudent(KlassStudent klassStudent);

    /**
     * Select all KlassStudent entities
     *
     * @return List<klassStudent> the selected KlassStudent entities list
     */
    @Select("select * from klass_student")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<KlassStudent> selectAllKlassStudent();

    /**
     * Select a KlassStudent entity via klassId
     *
     * @param klassId the select gist
     * @return List<klassStudent> the selected KlassStudent entity as list
     */
    @Select("select * from klass_student where klass_id=#{klassId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<KlassStudent> selectKlassStudentByKlassId(String klassId);

    /**
     * Select a KlassStudent entity via studentId
     *
     * @param studentId the select gist
     * @return List<klassStudent> the selected KlassStudent entity as list
     */
    @Select("select * from klass_student where student_id=#{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<KlassStudent> selectKlassStudentByStudentId(String studentId);

    /**
     * Select a KlassStudent entity via id
     *
     * @param id the select gist
     * @return List<klassStudent> the selected KlassStudent entity as list
     */
    @Select("select * from klass_student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "klassId", column = "klass_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<KlassStudent> selectKlassStudentById(String id);

    /**
     * Delete a KlassStudent entity via klassId
     *
     * @param klassId the select gist
     */
    @Delete("delete from klass_student where klass_id=#{klassId}")
    void deleteKlassStudentByKlassId(String klassId);

    /**
     * Delete a KlassStudent entity via studentId
     *
     * @param studentId the select gist
     */
    @Delete("delete from klass_student where student_id=#{studentId}")
    void deleteKlassStudentByStudentId(String studentId);

    /**
     * Delete a KlassStudent entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from klass_student where id=#{id}")
    void deleteKlassStudentById(String id);

}
