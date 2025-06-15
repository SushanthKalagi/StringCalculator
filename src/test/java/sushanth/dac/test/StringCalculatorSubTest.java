package sushanth.dac.test;

import org.junit.Test;
import sushanth.dac.StringCalculator;

import static org.junit.Assert.assertEquals;

public class StringCalculatorSubTest {

    @Test
    public void emptyStringTest() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals("0", calculator.sub());
    }

    @Test
    public void singleNumberTest() throws Exception {
        StringCalculator calculator = new StringCalculator();
        calculator.input = "5";
        assertEquals("5", calculator.sub());
    }

    @Test
    public void multipleNumbersTest() throws Exception {
        StringCalculator calculator = new StringCalculator();
        calculator.input = "1,2,3";
        assertEquals("-4", calculator.sub());
    }

    @Test
    public void newLineTest() throws Exception {
        StringCalculator calculator = new StringCalculator();
        calculator.input = "1,2\n3";
        assertEquals("-4", calculator.sub());
    }

    @Test
    public void inavlidInputTest() throws Exception {
        StringCalculator calculator = new StringCalculator();
        //calculator.input = "1,2,";
        try {

            calculator.input = "1,2,";
            calculator.sub();
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
    public void negativeNumberTest() throws Exception {
        StringCalculator calculator = new StringCalculator();
        try {
            calculator.input = "1,-2,3";
            calculator.sub();
        } catch (NumberFormatException e) {
            assertEquals("Negative numbers are not allowed: -2", e.getMessage());
        }
    }


    @Test
    public void customDelimiterTest() throws Exception {

        StringCalculator calculator = new StringCalculator();
        calculator.input = "//;\n1;2;3";
        assertEquals("-4", calculator.sub());
    }
}
