package seminar.entity.strategy;

import cesare.mybatis.annotations.TargetPackage;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class TeamAndStrategy{

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
}
