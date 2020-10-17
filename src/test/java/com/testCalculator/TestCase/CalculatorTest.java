package com.testCalculator.TestCase;

import com.testCalculator.Page.CalculatorPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends AbstractTest {

    @ParameterizedTest(name = "{index} => input={0}, result={1}, input_expression={2}")
    @CsvSource({

            "1,               '', 1",
            "1+1=,            2 , 1+1",
            "1234567890+-*/,  '', 1234567890+-×/",
            "1234567890+-*/D, '', 1234567890+-×",
    })
    public void testTC1_KeyResponse(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1+1=, 2",
            "1-1=, 0",
            "1*1=, 1",
            "1/1=, 1"
    })
    public void testTC2_BasicOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "-5+3=, -2",
            "-5*3=, -15",
            "-6/3=, -2",
            "-6-3=, -9",
    })
    public void testTC3_NegativeNumber(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1+1-1=, 1",
            "1-1+1=, 1",
            "1+2*3=, 7",
            "1-2*3=, -5",
            "1+6/3=, 3",
            "1-6/3=, -1",
            "6/3/2=, 1",
            "2*3*6=, 36",
            "6/3*2=, 4",
            "6*2/3=, 4",
    })
    public void testTC4_OrderOfOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1/2=,   0.5",
            "1+1/4=, 1.25",
            "1/4*4=, 1",
    })
    public void testTC5_DecimalResult(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1/3*2=,     0.6666666666666667",
            "1+1/3*2=,   1.6666666666666667",
            "100+1/3*2=, 100.66666666666667",
    })
    public void testTC6_RepeatingDecimalResult(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1/0=, Undefined",
            "0/1=, 0",
            "1*0=, 0",
    })
    public void testTC7_ZeroOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "123456789012345*2=, 246913578024690",
            "1234567890123456*2=, 2469135780246912",
            "12345678901234567*2=, 24691357802469134",
            "123456789012345678*2=, 246913578024691356",
    })
    public void testTC8_BigDataOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}, input_expression={2}")
    @CsvSource({
            "1+1D1=, 2, 1+1"
    })
    public void testTC9_DelKeyOperation(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1+-=, ERR",
            "+-1=, ERR",
            "*/1=, ERR",
            "*/1=, ERR",
    })
    public void testTC10_InvalidOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1+1=3+3=, 6, 3+3",
    })
    public void testTC11_MultipleEqualitySign(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1+05=, 6, 1+5",
            "05+1=, 6, 1+5"
    })
    public void testTC12_ExpressionDisplay(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

}
