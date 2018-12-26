package seminar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.Objects;

/**
 * @author Cesare
 */
public class SeminarConfig {
    public static final String DEFAULT_PASSWORD = "123456";
    public static final Integer MAX_MEMBER = 6;

    @Bean
    public JavaMailSender mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.mail.port"))));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
        return mailSender;
    }

    public enum WorkBookType {
        /**
         * HSSF: For xls
         * XSSF: For xlsx
         */
        HSSF("xls"), XSSF("xlsx");
        String type;

        WorkBookType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
