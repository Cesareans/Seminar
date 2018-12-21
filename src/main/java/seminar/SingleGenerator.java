package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.Klass;
import seminar.entity.Round;
import seminar.entity.Team;
import seminar.entity.relation.KlassRound;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", Team.class);
        generator.generateMapper();
    }
}
