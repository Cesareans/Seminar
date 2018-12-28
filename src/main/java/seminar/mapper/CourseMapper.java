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
    @Insert("insert into course(course_name, introduction, presentation_percentage, report_percentage, question_percentage, team_start_time, team_end_time, teacher_id, team_main_course_id, seminar_main_course_id) values(#{courseName}, #{introduction}, #{prePercentage}, #{reportPercentage}, #{quesPercentage}, #{teamStartDate}, #{teamEndDate}, #{teacherId}, #{teamMainCourseId}, #{seminarMainCourseId})")
    @Options(useGeneratedKeys = true)
    void insertCourse(Course course);

    /**
     * Update a Course entity's information
     *
     * @param course the Course entity that will be updated via the id
     */
    @Update("update course set course_name=#{courseName}, introduction=#{introduction}, presentation_percentage=#{prePercentage}, report_percentage=#{reportPercentage}, question_percentage=#{quesPercentage}, team_start_time=#{teamStartDate}, team_end_time=#{teamEndDate}, teacher_id=#{teacherId}, team_main_course_id=#{teamMainCourseId}, seminar_main_course_id=#{seminarMainCourseId} where id=#{id}")
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
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
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
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCourseByTeacherId(String teacherId);

    /**
     * Select a Course entity via teamMainCourseId
     *
     * @param teamMainCourseId the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where team_main_course_id=#{teamMainCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCourseByTeamMainCourseId(String teamMainCourseId);

    /**
     * Select a Course entity via seminarMainCourseId
     *
     * @param seminarMainCourseId the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where seminar_main_course_id=#{seminarMainCourseId}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCourseBySeminarMainCourseId(String seminarMainCourseId);

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
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
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
     * Delete a Course entity via teamMainCourseId
     *
     * @param teamMainCourseId the select gist
     */
    @Delete("delete from course where team_main_course_id=#{teamMainCourseId}")
    void deleteCourseByTeamMainCourseId(String teamMainCourseId);

    /**
     * Delete a Course entity via seminarMainCourseId
     *
     * @param seminarMainCourseId the select gist
     */
    @Delete("delete from course where seminar_main_course_id=#{seminarMainCourseId}")
    void deleteCourseBySeminarMainCourseId(String seminarMainCourseId);

    /**
     * Delete a Course entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from course where id=#{id}")
    void deleteCourseById(String id);

    /**
     * Get a course's other course via course id
     *
     * @param id the select gist
     * @param teamMainCourseId the select gist
     * @param seminarMainCourseId the  select gist
     * @return List<course> the selected Course's other courses as list
     */
    @Select("select * from course where id != #{id} and (#{tmId} is null or id!=#{tmId}) and (#{smId} is null or id!=#{smId}) and (team_main_course_id is null or seminar_main_course_id is null)")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCanShareCoursesById(@Param("id")String id, @Param("tmId")String teamMainCourseId, @Param("smId")String seminarMainCourseId);

    /**
     * Get all course can share team with
     * @return the courses.
     */
    @Select("select * from course where team_main_course_id is null")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCanShareTeamCourse();

    /**
     * Get all course can share seminar with
     * @return the courses.
     */
    @Select("select * from course where seminar_main_course_id is null")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "presentation_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "question_percentage"),
            @Result(property = "teamStartDate", column = "team_start_time"),
            @Result(property = "teamEndDate", column = "team_end_time"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teamMainCourseId", column = "team_main_course_id"),
            @Result(property = "seminarMainCourseId", column = "seminar_main_course_id")
    })
    List<Course> selectCanShareSeminarCourse();
}
