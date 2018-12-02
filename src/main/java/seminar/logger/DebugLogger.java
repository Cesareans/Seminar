package seminar.logger;

/**
 * @author Cesare
 */
public class DebugLogger {
    public static void log(String message) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName()+":"+ste.getLineNumber()+"]:"+ message);
    }
}
