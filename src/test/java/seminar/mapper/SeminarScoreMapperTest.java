package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.SeminarScore;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarScoreMapperTest {
    @Autowired
    SeminarScoreMapper seminarScoreMapper;

    @Test
    public void updateSeminarScore(){
        SeminarScore seminarScore = new SeminarScore();
        seminarScore.setTeamId("22");
        seminarScore.setKlassSeminarId("11");
        seminarScore.setTotalScore(new BigDecimal(4.6));
        seminarScore.setPresentationScore(new BigDecimal(4));
        seminarScore.setQuestionScore(new BigDecimal(5));
        seminarScore.setReportScore(new BigDecimal(5));
        seminarScoreMapper.updateSeminarScore(seminarScore);
    }

}