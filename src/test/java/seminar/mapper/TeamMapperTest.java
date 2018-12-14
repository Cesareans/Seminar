package seminar.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.Team;
import seminar.logger.DebugLogger;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamMapperTest {
    @Autowired
    TeamMapper teamMapper;

    @Test
    public void selectTeamById() {
        Team team = teamMapper.selectTeamById("111").get(0);
        DebugLogger.logJson(team);
        DebugLogger.logJson(team.getStudents().size());
    }

    @Test
    public void selectTeamByCourseId() {
        List<Team> teams = teamMapper.selectTeamByCourseId("112");
        DebugLogger.logJson(teams);
        DebugLogger.logJson(teams.get(0).getStudents().size());
    }
}