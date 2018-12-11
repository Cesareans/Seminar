package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.Course;

import java.util.List;

/**
 * An automatic generated mapper for the entity Course.
 * This mapper is for a increment primary key table.
 *
 * @author Cesare
 */
@Mapper
public interface CourseMapper {
    /**
     * Insert a Course entity
     *
     * @param course the Course entity that will be inserted
     */
    @Insert("insert into course(course_name, introduction, pre_percentage, report_percentage, ques_percentage, team_start_date, team_end_date, teacher_id, main_team_course_id, main_seminar_course_id) values(#{courseName}, #{introduction}, #{prePercentage}, #{reportPercentage}, #{quesPercentage}, #{teamStartDate}, #{teamEndDate}, #{teacherId}, #{mainTeamCourseId}, #{mainSeminarCourseId})")
    void insertCourse(Course course);

    /**
     * Update a Course entity's information
     *
     * @param course the Course entity that will be updated via the id
     */
    @Update("update course set course_name=#{courseName}, introduction=#{introduction}, pre_percentage=#{prePercentage}, report_percentage=#{reportPercentage}, ques_percentage=#{quesPercentage}, team_start_date=#{teamStartDate}, team_end_date=#{teamEndDate}, teacher_id=#{teacherId}, main_team_course_id=#{mainTeamCourseId}, main_seminar_course_id=#{mainSeminarCourseId} where id=#{id}")
    void updateCourse(Course course);

    /**
     * Select all Course entities
     *
     * @return List<course> the selected Course entities list
     */
    @Select("select * from course")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "mainTeamCourseId", column = "main_team_course_id"),
            @Result(property = "mainSeminarCourseId", column = "main_seminar_course_id")
    })
    List<Course> selectAllCourse();

    /**
     * Select a Course entity via teacherId
     *
     * @param teacherId the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where teacher_id=#{teacherId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "mainTeamCourseId", column = "main_team_course_id"),
            @Result(property = "mainSeminarCourseId", column = "main_seminar_course_id")
    })
    List<Course> selectCourseByTeacherId(String teacherId);

    /**
     * Select a Course entity via mainTeamCourseId
     *
     * @param mainTeamCourseId the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where main_team_course_id=#{mainTeamCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "mainTeamCourseId", column = "main_team_course_id"),
            @Result(property = "mainSeminarCourseId", column = "main_seminar_course_id")
    })
    List<Course> selectCourseByMainTeamCourseId(String mainTeamCourseId);

    /**
     * Select a Course entity via id
     *
     * @param id the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "mainTeamCourseId", column = "main_team_course_id"),
            @Result(property = "mainSeminarCourseId", column = "main_seminar_course_id")
    })
    List<Course> selectCourseById(String id);

    /**
     * Delete a Course entity via teacherId
     *
     * @param teacherId the select gist
     */
    @Delete("delete from course where teacher_id=#{teacherId}")
    void deleteCourseByTeacherId(String teacherId);

    /**
     * Delete a Course entity via mainTeamCourseId
     *
     * @param mainTeamCourseId the select gist
     */
    @Delete("delete from course where main_team_course_id=#{mainTeamCourseId}")
    void deleteCourseByMainTeamCourseId(String mainTeamCourseId);

    /**
     * Delete a Course entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from course where id=#{id}")
    void deleteCourseById(String id);

}
