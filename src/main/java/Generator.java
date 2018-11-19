import seminar.entity.Student;
import util.mybatis.generator.MapperGenerator;

public class Generator {
    public static void main(String[] args) throws Exception {
        MapperGenerator generator = new MapperGenerator("Cesare","seminar.mapper", Student.class,"id","name","stuNum");
        generator.generate(true);
    }
}
