package seminar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * An automatic generated mapper for the entity ConflictCourseStrategy.
 * This mapper is for a increment primary key table.
 *
 * @author Xinyu Shi
 */
@Mapper
public interface ConflictCourseStrategyMapper {

    /**
     * Select a ConflictCourseStrategy entity via id
     *
     * @param id the select gist
     * @return List<conflictCourseStrategy> the selected ConflictCourseStrategy entity as list
     */
    @Select("select course_id from conflict_course_strategy where id=#{id}")
    List<String> selectConflictCoursesById(String id);

    /**
     * insert single record into conflict course strategy table.
     *
     * @param id       the refer gist
     * @param courseId the refer gist
     * @author Xinyu Shi
     */
    @Insert("insert into conflict_course_strategy(id, course_id) values(#{id}, #{courseId})")
    void insertSingleCourseMemberLimitStrategy(@Param("id") String id, @Param("courseId") String courseId);

    /**
     * allocate one id
     *
     * @return
     * @author Xinyu Shi
     */
    @Select("select ifnull(max(id)+1,1) from conflict_course_strategy")
    String allocateId();
}