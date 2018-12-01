package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.TeamStudent;

import java.util.List;

/**
 * An automatic generated mapper for the entity TeamStudent.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface TeamStudentMapper {
    /**
     * Insert a TeamStudent entity
     *
     * @param teamStudent the TeamStudent entity that will be inserted
     */
    @Insert("insert into team_student(identity, team_id, student_id) values(#{identity}, #{teamId}, #{studentId})")
    void insertTeamStudent(TeamStudent teamStudent);

    /**
     * Update a TeamStudent entity's information
     *
     * @param teamStudent the TeamStudent entity that will be updated via the java.lang.String seminar.entity.TeamStudent.id
     */
    @Update("update team_student set identity=#{identity}, team_id=#{teamId}, student_id=#{studentId} where id=#{id}")
    void updateTeamStudent(TeamStudent teamStudent);

    /**
     * Select all TeamStudent entities
     *
     * @return List<teamStudent> the selected TeamStudent entities list
     */
    @Select("select * from team_student")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "identity", column = "identity"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<TeamStudent> selectAllTeamStudent();

    /**
     * Select a TeamStudent entity via teamId
     *
     * @param teamId the select gist
     * @return List<teamStudent> the selected TeamStudent entity as list
     */
    @Select("select * from team_student where team_id=#{teamId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "identity", column = "identity"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<TeamStudent> selectTeamStudentByTeamId(String teamId);

    /**
     * Select a TeamStudent entity via studentId
     *
     * @param studentId the select gist
     * @return List<teamStudent> the selected TeamStudent entity as list
     */
    @Select("select * from team_student where student_id=#{studentId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "identity", column = "identity"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<TeamStudent> selectTeamStudentByStudentId(String studentId);

    /**
     * Select a TeamStudent entity via id
     *
     * @param id the select gist
     * @return List<teamStudent> the selected TeamStudent entity as list
     */
    @Select("select * from team_student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "identity", column = "identity"),
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "studentId", column = "student_id")
    })
    List<TeamStudent> selectTeamStudentById(String id);

    /**
     * Delete a TeamStudent entity via private java.lang.String seminar.entity.TeamStudent.teamId
     *
     * @param teamId the select gist
     */
    @Delete("delete from team_student where team_id=#{teamId}")
    void deleteTeamStudentByTeamId(String teamId);

    /**
     * Delete a TeamStudent entity via private java.lang.String seminar.entity.TeamStudent.studentId
     *
     * @param studentId the select gist
     */
    @Delete("delete from team_student where student_id=#{studentId}")
    void deleteTeamStudentByStudentId(String studentId);

    /**
     * Delete a TeamStudent entity via java.lang.String seminar.entity.TeamStudent.id
     *
     * @param id the select gist
     */
    @Delete("delete from team_student where id=#{id}")
    void deleteTeamStudentById(String id);

}
