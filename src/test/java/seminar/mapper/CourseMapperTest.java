package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void selectCourseByTeacherNumTest(){
        System.out.println(courseMapper.selectCourseByTeacherId("123479"));
    }

}
