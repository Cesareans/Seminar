package seminar.mapper;

import org.apache.ibatis.annotations.*;
import seminar.entity.regulation.MemberLimitStrategy;

import java.util.List;


/**
 * An automatic generated mapper for the entity MemberLimitStrategy.
 * This mapper is for a increment primary key table.
 *
 * @author Xinyu Shi
 */
@Mapper
public interface MemberLimitStrategyMapper {
    /**
     * Insert a MemberLimitStrategy entity
     *
     * @param memberLimitStrategy the MemberLimitStrategy entity that will be inserted
     */
    @Insert("insert into member_limit_strategy(min_member, max_member) values(#{min}, #{max})")
    void insertMemberLimitStrategy(MemberLimitStrategy memberLimitStrategy);

    /**
     * Update a MemberLimitStrategy entity's information
     *
     * @param memberLimitStrategy the MemberLimitStrategy entity that will be updated via the id
     */
    @Update("update member_limit_strategy set min_member=#{min}, max_member=#{max} where id=#{id}")
    void updateMemberLimitStrategy(MemberLimitStrategy memberLimitStrategy);

    /**
     * Select all MemberLimitStrategy entities
     *
     * @return List<memberLimitStrategy> the selected MemberLimitStrategy entities list
     */
    @Select("select * from member_limit_strategy")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "min", column = "min_member"),
            @Result(property = "max", column = "max_member")
    })
    List<MemberLimitStrategy> selectAllMemberLimitStrategy();


    /**
     * Select a MemberLimitStrategy entity via id
     *
     * @param id the select gist
     * @return List<memberLimitStrategy> the selected MemberLimitStrategy entity as list
     */
    @Select("select * from member_limit_strategy where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "min", column = "min_member"),
            @Result(property = "max", column = "max_member")
    })
    List<MemberLimitStrategy> selectMemberLimitStrategyById(String id);


    /**
     * Delete a MemberLimitStrategy entity via id
     *
     * @param id the select gist
     */
    @Delete("delete from member_limit_strategy where id=#{id}")
    void deleteMemberLimitStrategyById(String id);

}