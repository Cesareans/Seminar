package seminar;

import seminar.entity.Admin;
import seminar.entity.Student;
import seminar.entity.Teacher;
import util.mybatis.generator.MapperGenerator;

/**
 * @author Cesare
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        MapperGenerator generator = new MapperGenerator("Cesare", "seminar.mapper", Student.class,"id","name", "stuNum");
        generator.generate(true);
    }
}
