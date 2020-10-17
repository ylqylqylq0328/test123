package com.testCalculator.TestCase;

import com.testCalculator.Page.CalculatorPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends AbstractTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/TC1_KeyResponse.csv", numLinesToSkip = 1)
    public void testTC1_KeyResponse(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC2_BasicOperation.csv", numLinesToSkip = 1)
    public void testTC2_BasicOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC3_NegativeNumber.csv", numLinesToSkip = 1)
    public void testTC3_NegativeNumber(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC4_OrderOfOperation.csv", numLinesToSkip = 1)
    public void testTC4_OrderOfOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC5_DecimalResult.csv", numLinesToSkip = 1)
    public void testTC5_DecimalResult(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC6_RoundingResult.csv", numLinesToSkip = 1)
    public void testTC6_RoundingResult(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC7_ZeroOperation.csv", numLinesToSkip = 1)
    public void testTC7_ZeroOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC8_BigDataOperation.csv", numLinesToSkip = 1)
    public void testTC8_BigDataOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC9_DelKeyOperation.csv", numLinesToSkip = 1)
    public void testTC9_DelKeyOperation(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC10_InvalidOperation.csv", numLinesToSkip = 1)
    public void testTC10_InvalidOperation(String input, String result) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertEquals(result, calculatorPage.getOutput());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC11_MultipleEqualitySign.csv", numLinesToSkip = 1)
    public void testTC11_MultipleEqualitySign(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TC12_ExpressionDisplay.csv", numLinesToSkip = 1)
    public void testTC12_ExpressionDisplay(String input, String result, String input_expression) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.Actions(input);
        assertAll(
                () -> assertEquals(result, calculatorPage.getOutput()),
                () -> assertEquals(input_expression, calculatorPage.getInputExpression())
        );
    }

}
