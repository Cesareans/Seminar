package seminar;

import cesare.mybatis.PackageGenerator;

/**
 * @author Cesare
 */
public class MultiGenerator {
    public static void main(String[] args) {
        PackageGenerator generator = new PackageGenerator("Cesare", "seminar.entity.application");
        generator.generateMapper();
    }
}
