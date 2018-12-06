package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.*;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("Xinyu Shi", TeamShare.class);
        generator.generateMapper();
    }
}
