package seminar.entity.regulation;

import seminar.entity.Team;

import java.util.List;

/**
 * @author Xinyu Shi
 */
public class TeamOrStrategy implements Strategy {
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
    public boolean validate(Team team) {
        boolean validation = false;
        for (Strategy strategy : strategies) {
            if (strategy.validate(team)) {
                validation = true;
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