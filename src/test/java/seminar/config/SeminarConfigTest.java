package seminar.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarConfigTest {
    @Autowired
    JavaMailSender mailSender;

    @Test
    public void mailSendTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
        message.setTo("1357959025@qq.com");
        message.setSubject("Test email");
        message.setText("test");
        mailSender.send(message);
    }
}
