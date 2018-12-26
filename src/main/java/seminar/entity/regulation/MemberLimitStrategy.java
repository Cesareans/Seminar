package seminar.entity.regulation;

import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class MemberLimitStrategy implements Regulation{

    @ID(isIncrement = true)
    private String id;

    private int min;

    private int max;

    @Override
    public String getStrategyName()
    {
        return "MemberLimitStrategy";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


}
