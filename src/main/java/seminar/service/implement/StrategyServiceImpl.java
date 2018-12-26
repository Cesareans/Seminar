package seminar.service.implement;

import org.springframework.stereotype.Service;
import seminar.service.StrategyService;

/**
 * @author Xinyu Shi
 */
@Service
public class StrategyServiceImpl implements StrategyService {

    @Override
    public boolean validate(String teamId, String courseId)
    {
        return true;
    }

}
