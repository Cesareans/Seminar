package seminar.service.implement;

import org.springframework.stereotype.Service;
import seminar.service.CaptchaService;

import java.util.Random;

/**
 * @author Cesare
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    private final Random rd = new Random();

    @Override
    public String generateCaptcha() {
        StringBuilder builder = new StringBuilder();
        int size = 6;
        int origin = 0;
        int bound = 10;
        rd.ints(size, origin, bound).forEach(builder::append);
        return builder.toString();
    }
}
