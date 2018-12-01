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
    @Insert("insert into course(name, introduction, pre_percentage, report_percentage, ques_percentage, team_start_date, team_end_date, teacher_id) values(#{name}, #{introduction}, #{prePercentage}, #{reportPercentage}, #{quesPercentage}, #{teamStartDate}, #{teamEndDate}, #{teacherId})")
    void insertCourse(Course course);

    /**
     * Update a Course entity's information
     *
     * @param course the Course entity that will be updated via the private java.lang.String seminar.entity.Course.id
     */
    @Update("update course set name=#{name}, introduction=#{introduction}, pre_percentage=#{prePercentage}, report_percentage=#{reportPercentage}, ques_percentage=#{quesPercentage}, team_start_date=#{teamStartDate}, team_end_date=#{teamEndDate}, teacher_id=#{teacherId} where id=#{id}")
    void updateCourse(Course course);

    /**
     * Select all Course entities
     *
     * @return List<course> the selected Course entities list
     */
    @Select("select * from course")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id")
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
            @Result(property = "name", column = "name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id")
    })
    List<Course> selectCourseByTeacherId(String teacherId);

    /**
     * Select a Course entity via id
     *
     * @param id the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "prePercentage", column = "pre_percentage"),
            @Result(property = "reportPercentage", column = "report_percentage"),
            @Result(property = "quesPercentage", column = "ques_percentage"),
            @Result(property = "teamStartDate", column = "team_start_date"),
            @Result(property = "teamEndDate", column = "team_end_date"),
            @Result(property = "teacherId", column = "teacher_id")
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
     * Delete a Course entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from course where id=#{id}")
    void deleteCourseById(String id);

}
