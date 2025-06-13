package sushanth.dac.test;

import org.junit.Test;
import org.junit.*;
import sushanth.dac.StringCalculator;

import static org.junit.Assert.assertEquals;
public class StringCalculatorTest {

    @Test
    public void emptyStringTest() throws Exception{
        StringCalculator calculator = new StringCalculator();
        assertEquals("0",calculator.add());
    }

    @Test
    public  void singleNumberTest() throws Exception{
        StringCalculator calculator = new StringCalculator();
        calculator.input = "5";
        assertEquals("5",calculator.add());
    }

    @Test
    public void multipleNumbersTest() throws Exception{
        StringCalculator calculator = new StringCalculator();
        calculator.input = "1,2,3";
        assertEquals("6",calculator.add());
    }
    @Test
    public void newLineTest() throws Exception{
        StringCalculator calculator = new StringCalculator();
        calculator.input = "1,2\n3";
        assertEquals("6",calculator.add());
    }
    @Test
    public void inavlidInputTest() throws Exception{
        StringCalculator calculator = new StringCalculator();
        //calculator.input = "1,2,";
        try {

            calculator.input = "1,2,";
            calculator.add();
        } catch (NumberFormatException e) {
            assertEquals("Number expected but EOF found", e.getMessage());
        }

       try{
           calculator.input ="1,\n2";
              calculator.add();
       } catch (NumberFormatException e) {
           assertEquals("Number expected but '\\n' found", e.getMessage());
       }
    }

    @Test
    public void negativeNumberTest() throws Exception{
        StringCalculator calculator = new StringCalculator();
        try {
            calculator.input = "1,-2,3";
            calculator.add();
        } catch (NumberFormatException e) {
            assertEquals("Negative numbers are not allowed: -2", e.getMessage());
        }
    }



}
