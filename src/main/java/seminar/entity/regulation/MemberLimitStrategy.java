package seminar.entity.regulation;

import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;
import seminar.entity.Team;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class MemberLimitStrategy implements Strategy {

    @ID(isIncrement = true)
    private String id;

    private int min;

    private int max;

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

    @Override
    public boolean validate(Team team)
    {
        int studentNumber = team.getStudents().size();
        if(studentNumber >= min && studentNumber <= max){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String getErrorMsg()
    {
        return "小组人数应在" + min + "到" + max + "之间";
    }

}