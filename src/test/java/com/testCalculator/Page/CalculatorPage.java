package com.testCalculator.Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends PageObject {

    @FindBy(xpath = "//button[@value='1']")
    private WebElement One;
    @FindBy(xpath = "//button[@value='2']")
    private WebElement Two;
    @FindBy(xpath = "//button[@value='3']")
    private WebElement Three;
    @FindBy(xpath = "//button[@value='4']")
    private WebElement Four;
    @FindBy(xpath = "//button[@value='5']")
    private WebElement Five;
    @FindBy(xpath = "//button[@value='6']")
    private WebElement Six;
    @FindBy(xpath = "//button[@value='7']")
    private WebElement Seven;
    @FindBy(xpath = "//button[@value='8']")
    private WebElement Eight;
    @FindBy(xpath = "//button[@value='9']")
    private WebElement Nine;
    @FindBy(xpath = "//button[@value='0']")
    private WebElement Zero;
    @FindBy(xpath = "//button[@value='+']")
    private WebElement Plus;
    @FindBy(xpath = "//button[@value='-']")
    private WebElement Minus;
    @FindBy(xpath = "//html/body/div/div[3]/button[15]")
    private WebElement Mult;
    @FindBy(xpath = "//button[@value='/']")
    private WebElement Div;
    @FindBy(xpath = "//button[@value='=']")
    private WebElement Eq;
    @FindBy(xpath = "//button[@value='DEL']")
    private WebElement Del;
    //@FindBy(id = "expression")
    @FindBy(xpath = "//input[@id='expression']")
    private WebElement InputExpression;
    @FindBy(id = "output")
    private WebElement Output;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }


    public void Actions(String input){
        for (char ch : input.toCharArray()) {
            switch(ch) {
                case '0':
                    Zero.click();
                    break;
                case '1':
                    One.click();
                    break;
                case '2':
                    Two.click();
                    break;
                case '3':
                    Three.click();
                    break;
                case '4':
                    Four.click();
                    break;
                case '5':
                    Five.click();
                    break;
                case '6':
                    Six.click();
                    break;
                case '7':
                    Seven.click();
                    break;
                case '8':
                    Eight.click();
                    break;
                case '9':
                    Nine.click();
                    break;
                case '+':
                    Plus.click();
                    break;
                case '-':
                    Minus.click();
                    break;
                case '*':
                    Mult.click();
                    break;
                case '/':
                    Div.click();
                    break;
                case '=':
                    Eq.click();
                    break;
                case 'D':
                    Del.click();
                    break;
                default:
                    break;
            }
        }

    }

    public String getOutput() {
        return Output.getText();
    }

    public String getInputExpression() {
        return InputExpression.getAttribute("value");
    }

}
