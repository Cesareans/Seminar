package seminar.mapper.relation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import seminar.logger.DebugLogger;
import seminar.mapper.relation.KlassStudentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
public class KlassStudentMapperTest {
    @Autowired
    KlassStudentMapper klassStudentMapper;

    @Test
    public void insertStudentIntoKlass() {
        klassStudentMapper.insertStudentIntoKlass("112","145","1240");
    }


    @Test
    public void selectStudentsByTeamId() {
        DebugLogger.logJson(klassStudentMapper.selectStudentsByTeamId("113"));
    }

    @Test
    public void selectNotTeamedStudentsByCourseId() {
        DebugLogger.logJson(klassStudentMapper.selectNotTeamedStudentsByCourseId("112"));
    }

    @Test
    public void deleteAllStudents() {
        klassStudentMapper.insertStudentIntoKlass("112","146","1240");
        klassStudentMapper.insertStudentIntoKlass("112","146","1241");
        klassStudentMapper.insertStudentIntoKlass("112","146","1242");
        DebugLogger.logJson(klassStudentMapper.selectNotTeamedStudentsByCourseId("112"));
        klassStudentMapper.deleteKlassStudents("146");
        DebugLogger.logJson(klassStudentMapper.selectNotTeamedStudentsByCourseId("112"));

    }

    @Test
    public void selectCourseByStudentId(){
        DebugLogger.logJson(klassStudentMapper.selectCourseByStudentId("1234"));
    }

    @Test
    public void selectKlassByStudentId(){
        DebugLogger.logJson(klassStudentMapper.selectKlassByStudentId("1234"));
    }
}