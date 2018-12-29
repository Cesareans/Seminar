package seminar.entity.regulation;

import cesare.mybatis.annotations.TargetPackage;
import seminar.entity.Team;
import seminar.logger.DebugLogger;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class TeamAndStrategy implements Strategy {

    private String id;
    private List<Strategy> strategies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean validate(Team team)
    {
        boolean validation = true;
        for(Strategy strategy:strategies)
        {
            if(!strategy.validate(team)){
                validation = false;
                break;
            }
        }
        return validation;
    }

    @Override
    public String getErrorMsg()
    {
        return "";
    }
}
