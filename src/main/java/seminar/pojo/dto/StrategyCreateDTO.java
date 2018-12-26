package seminar.pojo.dto;

import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.entity.regulation.MemberLimitStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
public class StrategyCreateDTO {

    private Integer min;
    private Integer max;
    private List<String> courseMemberLimitCourseId;
    private List<Integer> courseMemberLimitMax;
    private List<Integer> courseMemberLimitMin;
    private List<String> conflictCourses;

    public MemberLimitStrategy getMemberLimitStrategy()
    {
        MemberLimitStrategy memberLimitStrategy = new MemberLimitStrategy();
        memberLimitStrategy.setMax(max);
        memberLimitStrategy.setMin(min);
        return memberLimitStrategy;
    }

    public List<CourseMemberLimitStrategy> getCourseMemberLimitStrategy()
    {
        List<CourseMemberLimitStrategy> strategies = new ArrayList<>();
        int items = courseMemberLimitCourseId.size();
        for(int i=0;i<items; i++)
        {
            CourseMemberLimitStrategy courseMemberLimitStrategy = new CourseMemberLimitStrategy();
            courseMemberLimitStrategy.setCourseId(courseMemberLimitCourseId.get(i));
            courseMemberLimitStrategy.setMax(courseMemberLimitMax.get(i));
            courseMemberLimitStrategy.setMin(courseMemberLimitMin.get(i));
            strategies.add(courseMemberLimitStrategy);
        }
        return strategies;
    }

    public ConflictCourseStrategy getConflictCourseStrategy()
    {
        ConflictCourseStrategy conflictCourseStrategy = new ConflictCourseStrategy();
        conflictCourseStrategy.setConflictCourses(conflictCourses);
        return conflictCourseStrategy;
    }

}
