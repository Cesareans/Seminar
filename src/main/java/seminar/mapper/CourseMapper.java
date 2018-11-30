package seminar.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Insert("insert into course(teacher_num, name) values(#{teacherNum}, #{name})")
    void insertCourse(Course course);

    /**
     * Update a Course entity's information
     *
     * @param course the Course entity that will be updated via the private java.lang.String seminar.entity.Course.id
     */
    @Update("update course set teacher_num=#{teacherNum}, name=#{name} where id=#{id}")
    void updateCourse(Course course);

    /**
     * Select all Course entities
     *
     * @return List<course> the selected Course entities list
     */
    @Select("select * from course")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "name", column = "name")
    })
    List<Course> selectAllCourse();

    /**
     * Select a Course entity via teacherNum
     *
     * @param teacherNum the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where teacher_num=#{teacherNum}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "name", column = "name")
    })
    List<Course> selectCourseByTeacherNum(String teacherNum);

    /**
     * Select a Course entity via id
     *
     * @param id the select gist
     * @return List<course> the selected Course entity as list
     */
    @Select("select * from course where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "teacherNum", column = "teacher_num"),
            @Result(property = "name", column = "name")
    })
    List<Course> selectCourseById(String id);

    /**
     * Delete a Course entity via private java.lang.String seminar.entity.Course.teacherNum
     *
     * @param teacherNum the select gist
     */
    @Delete("delete from course where teacher_num=#{teacherNum}")
    void deleteCourseByTeacherNum(String teacherNum);

    /**
     * Delete a Course entity via private java.lang.String seminar.entity.Course.id
     *
     * @param id the select gist
     */
    @Delete("delete from course where id=#{id}")
    void deleteCourseById(String id);

}
