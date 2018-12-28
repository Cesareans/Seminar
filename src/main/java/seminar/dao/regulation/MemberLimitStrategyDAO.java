package seminar.dao.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.regulation.MemberLimitStrategy;
import seminar.mapper.MemberLimitStrategyMapper;

/**
 * @author Xinyu Shi
 */
@Component
public class MemberLimitStrategyDAO {

    private final MemberLimitStrategyMapper memberLimitStrategyMapper;

    @Autowired
    public MemberLimitStrategyDAO(MemberLimitStrategyMapper memberLimitStrategyMapper)
    {
        this.memberLimitStrategyMapper = memberLimitStrategyMapper;
    }

    public MemberLimitStrategy getById(String strategyId)
    {
        return memberLimitStrategyMapper.selectMemberLimitStrategyById(strategyId).get(0);
    }

    public void createMemberLimitStrategy(MemberLimitStrategy memberLimitStrategy)
    {
        memberLimitStrategyMapper.insertMemberLimitStrategy(memberLimitStrategy);
    }


}