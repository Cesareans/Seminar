package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.regulation.CourseMemberLimitStrategy;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Xinyu Shi", CourseMemberLimitStrategy.class);
        generator.generateMapper();
    }
}
