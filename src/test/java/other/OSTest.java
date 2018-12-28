package other;

import org.junit.Test;
import seminar.logger.DebugLogger;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class OSTest {
    @Test
    public void getOSTest(){
        DebugLogger.log(new BigDecimal(4).divide(new BigDecimal(3), 2, BigDecimal.ROUND_HALF_UP));
    }
}
