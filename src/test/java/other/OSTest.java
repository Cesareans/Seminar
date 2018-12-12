package other;

import org.junit.Test;
import seminar.logger.DebugLogger;

public class OSTest {
    @Test
    public void getOSTest(){
        DebugLogger.log(System.getProperty("os.name"));
    }
}
