package seminar;

import cesare.mybatis.EntityGenerator;
import cesare.mybatis.PackageGenerator;
import seminar.entity.Attendance;
import seminar.entity.ClbumSeminar;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Cesare", ClbumSeminar.class);
        generator.generateMapper();
    }
}
