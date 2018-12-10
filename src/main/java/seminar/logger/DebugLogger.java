package seminar.logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Cesare
 */
public class DebugLogger {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
    public static void log(String message) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName() + ":" + ste.getLineNumber() + "]:" + message);
    }

    public static void log(Object object) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName() + ":" + ste.getLineNumber() + "]:" + object.toString());
    }

    public static void log(int i) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName() + ":" + ste.getLineNumber() + "]:" + i);
    }

    public static void log(boolean b) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName() + ":" + ste.getLineNumber() + "]:" + (b ? "True" : "False"));
    }

    public static void logJson(Object object) throws JsonProcessingException {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName() + ":" + ste.getLineNumber() + "]:" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
    }
}
