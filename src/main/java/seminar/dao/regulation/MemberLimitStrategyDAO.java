package seminar.dao.regulation;

import seminar.entity.Team;
import seminar.entity.regulation.MemberLimitStrategy;
import seminar.mapper.MemberLimitStrategyMapper;

public class MemberLimitStrategyDAO implements RegulationDAO {

    private final MemberLimitStrategyMapper memberLimitStrategyMapper;
    private MemberLimitStrategy memberLimitStrategy;
    private String regulationId;

    public MemberLimitStrategyDAO(MemberLimitStrategyMapper memberLimitStrategyMapper)
    {
        this.memberLimitStrategyMapper = memberLimitStrategyMapper;
    }

    @Override
    public void setRegulation(String regulationId)
    {
        this.regulationId = regulationId;
    }

    @Override
    public boolean validate(Team team)
    {
        memberLimitStrategy = memberLimitStrategyMapper.selectMemberLimitStrategyById(regulationId).get(0);
        int count = team.getStudents().size();
        if(count<=memberLimitStrategy.getMax() && count>=memberLimitStrategy.getMin()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String getErrorMsg()
    {
        return "小组人数应在"+memberLimitStrategy.getMin() + "到" + memberLimitStrategy.getMax() + "之间";
    }
}
