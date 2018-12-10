package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.relation.TeamStudent;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", TeamStudent.class);
        generator.generateMapper();
    }
}
