package sushanth.dac.test;

import org.junit.Test;
import org.junit.*;
import sushanth.dac.StringCalculator;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void emptyStringTest()  {
        StringCalculator calculator = new StringCalculator();
        assertEquals("0", calculator.add());
        assertEquals("0", calculator.sub());
        assertEquals("0", calculator.mul());

    }

    @Test
    public void singleNumberTest() {
        StringCalculator calculator = new StringCalculator();
        calculator.input = "5";
        assertEquals("5", calculator.add());
        assertEquals("5", calculator.mul());
        assertEquals("5", calculator.sub());
    }

    @Test
    public void multipleNumbersTest()  {
        StringCalculator calculator = new StringCalculator();
        calculator.input = "1,2,3";
        assertEquals("6", calculator.add());
        assertEquals("6", calculator.mul());
        assertEquals("-4", calculator.sub());
    }

    @Test
    public void newLineTest() {
        StringCalculator calculator = new StringCalculator();
        calculator.input = "1,2\n3";
        assertEquals("6", calculator.add());
        assertEquals("6", calculator.mul());
        assertEquals("-4", calculator.sub());

    }

    @Test
    public void inavlidInputTest()  {
        StringCalculator calculator = new StringCalculator();
        //calculator.input = "1,2,";
        try {

            calculator.input = "1,2,";
            calculator.add();

        } catch (NumberFormatException e) {
            assertEquals("Number expected but EOF found", e.getMessage());
        }

        try {
            calculator.input = "1,\n2";
            calculator.sub();
        } catch (NumberFormatException e) {
            assertEquals("Number expected but '\\n' found", e.getMessage());
        }
    }

    @Test
    public void negativeNumberTest()  {
        StringCalculator calculator = new StringCalculator();
        try {
            calculator.input = "1,-2,3";
            calculator.mul();
        } catch (NumberFormatException e) {
            assertEquals("Negative numbers are not allowed: -2", e.getMessage());
        }
    }


    @Test
    public void customDelimiterTest()  {

        StringCalculator calculator = new StringCalculator();
        calculator.input = "//;\n1;2;3";
        assertEquals("6", calculator.add());
        assertEquals("6", calculator.mul());
        assertEquals("-4", calculator.sub());
    }


}
