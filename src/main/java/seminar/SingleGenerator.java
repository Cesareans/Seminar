package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.*;
import seminar.entity.relation.KlassRound;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", KlassSeminar.class);
        generator.generateMapper();
    }
}
