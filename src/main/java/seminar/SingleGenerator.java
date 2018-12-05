package seminar;

import cesare.mybatis.EntityGenerator;
import seminar.entity.*;

/**
 * @author Cesare
 */
public class SingleGenerator {
    public static void main(String[] args) {
        EntityGenerator generator = new EntityGenerator("SWJ", TeamShareMsg.class);
        generator.generateMapper();
    }
}
