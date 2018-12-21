package seminar.service.implement;

import org.springframework.stereotype.Service;
import seminar.service.LeaderService;

import java.util.Date;

/**
 * @author Cesare
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    @Override
    public boolean addGroupMember(String studentId, String courseId, String teamId)
    {

        Date today = new Date();
        today.getTime();
        return true;

    }

}
