package seminar.entity.regulation;

import seminar.entity.Team;
import seminar.logger.DebugLogger;

import java.util.List;

/**
 * @author Xinyu Shi
 */
public class StrategyComposition implements Strategy {
    private List<Strategy> strategies;

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean validate(Team team) {
        boolean validation = true;
        for (Strategy strategy : strategies) {
            if (!strategy.validate(team)) {
                DebugLogger.logJson(strategy);
                validation = false;
                break;
            }
        }
        return validation;
    }

    @Override
    public String getErrorMsg() {
        return "";
    }
}
