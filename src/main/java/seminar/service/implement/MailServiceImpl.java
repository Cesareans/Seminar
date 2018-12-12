package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import seminar.service.MailService;

/**
 * @author Cesare
 */
@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    /**
     * TODO: refine captcha sending content. [Inferiority]
     */
    @Override
    public void sendCaptcha(String captcha, String targetEmail) {
        sendMail(captcha, targetEmail);
    }

    @Override
    public void sendMail(String content, String targetEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
        message.setTo(targetEmail);
        message.setSubject("Verification captcha");
        message.setText(content);
        mailSender.send(message);
    }
}
