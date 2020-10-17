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
    public void testKeyResponse(String input, String result, String input_expression) {
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
    public void testBasicOperation(String input, String result) {
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

    })
    public void testOrderOfOperation(String input, String result) {
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
    public void testDecimal(String input, String result) {
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
    public void testZero(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "123456789*987654321=, 121932631112635260",
            "123456789/987654321=, 0.1249999988609375",
    })
    public void testBigData(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}, input_expression={2}")
    @CsvSource({
            "1+1D1=, 2, 1+1"
    })
    public void testDelOperation(String input, String result, String input_expression) {
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
    public void testErrorOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest(name = "{index} => input={0}, result={1}")
    @CsvSource({
            "1+1=3+3=, 6, 3+3",
    })
    public void testMultipleEqualitySign(String input, String result, String input_expression) {
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
    })
    public void testExpression(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

}
