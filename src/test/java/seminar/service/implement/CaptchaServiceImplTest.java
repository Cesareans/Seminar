package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;
import seminar.service.CaptchaService;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaptchaServiceImplTest {
    @Autowired
    CaptchaService captchaService;

    @Test
    public void generateCaptcha() {
        IntStream.range(0,100).forEach(i->{
            assertEquals(captchaService.generateCaptcha().length(),6);
        });
    }
}