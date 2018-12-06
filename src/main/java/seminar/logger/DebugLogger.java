package seminar.logger;

/**
 * @author Cesare
 */
public class DebugLogger {
    public static void log(String message) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName()+":"+ste.getLineNumber()+"]:"+ message);
    }
    public static void log(Object object){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName()+":"+ste.getLineNumber()+"]:"+ object.toString());
    }
    public static void log(int i){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName()+":"+ste.getLineNumber()+"]:"+ i);
    }
    public static void log(boolean b){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(ste.getMethodName() + "() at [" + ste.getClassName()+":"+ste.getLineNumber()+"]:"+ (b?"True":"False"));
    }
}
