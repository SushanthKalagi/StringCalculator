package sushanth.dac.test;

import org.junit.Test;
import org.junit.*;
import sushanth.dac.StringCalculator;

import static org.junit.Assert.assertEquals;
public class StringCalculatorTest {

    @Test
    public void emptyStringTest() throws Exception{
        StringCalculator calc = new StringCalulator();
        assertEquals(0,calc);
    }

}
