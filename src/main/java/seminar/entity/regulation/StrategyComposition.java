package seminar.entity.regulation;

import seminar.entity.Team;

import java.util.List;

/**
 * @author Xinyu Shi
 */
public class StrategyComposition implements Strategy{

    private List<Strategy> strategies;

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }

    @Override
    public boolean validate(Team team){
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
