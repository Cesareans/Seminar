package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.strategy.ConflictCourseStrategy;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Xinyu Shi", ConflictCourseStrategy.class);
        generator.generateMapper();
    }
}
