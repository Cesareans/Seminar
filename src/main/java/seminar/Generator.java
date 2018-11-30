package seminar;

import cesare.mybatis.PackageGenerator;

/**
 * @author Cesare
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        PackageGenerator generator = new PackageGenerator("Cesare", "seminar.entity");
        generator.generateMapper();
    }
}
