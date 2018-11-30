package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherMapperTest {
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void selectTeacherByBadgeNumTest(){
        Teacher teacher = teacherMapper.selectTeacherByTeacherNum("123479").get(0);
        System.out.println(teacher.getCourses());
    }
}
