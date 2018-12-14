package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.Teacher;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", Teacher.class);
        generator.generateMapper();
    }
}
