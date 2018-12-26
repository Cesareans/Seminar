package seminar.dao.strategy;

import org.springframework.stereotype.Component;
import seminar.entity.strategy.MemberLimitStrategy;
import seminar.mapper.strategy.MemberLimitStrategyMapper;

/**
 * @author Xinyu Shi
 */
@Component
public class MemberLimitStrategyDAO {

    private final MemberLimitStrategyMapper memberLimitStrategyMapper;

    public MemberLimitStrategyDAO(MemberLimitStrategyMapper memberLimitStrategyMapper)
    {
        this.memberLimitStrategyMapper = memberLimitStrategyMapper;
    }

    public MemberLimitStrategy getById(String strategyId)
    {
        return memberLimitStrategyMapper.selectMemberLimitStrategyById(strategyId).get(0);
    }


}
