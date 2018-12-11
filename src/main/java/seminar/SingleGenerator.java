package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.Klass;
import seminar.entity.KlassSeminar;
import seminar.entity.Round;
import seminar.entity.relation.TeamStudent;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", Round.class);
        generator.generateMapper();
    }
}
