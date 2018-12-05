package seminar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author Cesare
 */
public class SeminarConfig {
    public static final String DEFAULT_PASSWORD = "123456";

    public static ObjectMapper objectMapper = new ObjectMapper();
}
