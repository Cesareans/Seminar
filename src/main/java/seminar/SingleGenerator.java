package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.Round;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", Round.class);
        generator.generateMapper();
    }
}
