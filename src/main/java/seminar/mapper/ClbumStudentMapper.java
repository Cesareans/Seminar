package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.ClbumStudent;

import java.util.List;

/**
 * An automatic generated mapper for the entity ClbumStudent.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface ClbumStudentMapper {
    /**
     * Insert a ClbumStudent entity
     *
     * @param clbumStudent the ClbumStudent entity that will be inserted
     */
    @Insert("insert into clbum_student(clbum_id, student_id) values(#{clbumId}, #{studentId})")
    void insertClbumStudent(ClbumStudent clbumStudent);

    /**
     * Update a ClbumStudent entity's information
     *
     * @param clbumStudent the ClbumStudent entity that will be updated via the private java.lang.String seminar.entity.ClbumStudent.id
     */
    @Update("update clbum_student set clbum_id=#{clbumId}, student_id=#{studentId} where id=#{id}")
    void updateClbumStudent(ClbumStudent clbumStudent);

    /**
     * Select all ClbumStudent entities
     *
     * @return List<clbumStudent> the selected ClbumStudent entities list
     */
    @Select("select * from clbum_student")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<ClbumStudent> selectAllClbumStudent();

    /**
     * Select a ClbumStudent entity via clbumId
     *
     * @param clbumId the select gist
     * @return List<clbumStudent> the selected ClbumStudent entity as list
     */
    @Select("select * from clbum_student where clbum_id=#{clbumId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<ClbumStudent> selectClbumStudentByClbumId(String clbumId);

    /**
     * Select a ClbumStudent entity via studentId
     *
     * @param studentId the select gist
     * @return List<clbumStudent> the selected ClbumStudent entity as list
     */
    @Select("select * from clbum_student where student_id=#{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<ClbumStudent> selectClbumStudentByStudentId(String studentId);

    /**
     * Select a ClbumStudent entity via id
     *
     * @param id the select gist
     * @return List<clbumStudent> the selected ClbumStudent entity as list
     */
    @Select("select * from clbum_student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "clbumId", column = "clbum_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<ClbumStudent> selectClbumStudentById(String id);

    /**
     * Delete a ClbumStudent entity via private java.lang.String seminar.entity.ClbumStudent.clbumId
     *
     * @param clbumId the select gist
     */
    @Delete("delete from clbum_student where clbum_id=#{clbumId}")
    void deleteClbumStudentByClbumId(String clbumId);

    /**
     * Delete a ClbumStudent entity via private java.lang.String seminar.entity.ClbumStudent.studentId
     *
     * @param studentId the select gist
     */
    @Delete("delete from clbum_student where student_id=#{studentId}")
    void deleteClbumStudentByStudentId(String studentId);

    /**
     * Delete a ClbumStudent entity via private java.lang.String seminar.entity.ClbumStudent.id
     *
     * @param id the select gist
     */
    @Delete("delete from clbum_student where id=#{id}")
    void deleteClbumStudentById(String id);

}
