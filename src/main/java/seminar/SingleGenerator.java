package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.*;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.entity.regulation.MemberLimitStrategy;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Xinyu Shi", CourseMemberLimitStrategy.class);
        generator.generateMapper();
    }
}
