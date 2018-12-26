package seminar.entity.regulation;
import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.TargetPackage;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class ConflictCourseStrategy implements Regulation{

    @Gist
    private String id;

    private List<String> conflictCourses;

    @Override
    public String getStrategyName()
    {
        return "ConflictCourseStrategy";
    }

    public List<String> getConflictCourses() {
        return conflictCourses;
    }

    public void setConflictCourses(List<String> conflictCourses) {
        this.conflictCourses = conflictCourses;
    }
}
