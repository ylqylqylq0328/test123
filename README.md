## Description
Test Simple Calculator.
### Execution
    gradlew test
### Test Result and Reporting Folder
    reporting.baseDir = "my-reports"
    testResultsDirName = "$buildDir/my-test-results"
### Test cases
Totally there are 30 test cases: 24 are successful and 6 failed. Please see "Bug" section for bugs' analysis.

    Basic Operation
    Order Of Operation
    Decimal Operation
    Zero Operation
    Big Data Operation
    Del Operation
    Error Operation
    Multiple Equality Sign
    Expression Display

### Bug
1 Decimal Operation Abnormal.

    Case No | Expression | Expected Result   | Actual Result     | Result
    1       | 1/3*2=     | 0.6666666666666667| 0.6666666666666666| Failure
    2       | 1+1/3*2=   | 1.6666666666666667| 1.6666666666666665| Failure
    3       | 100+1/3*2= | 100.66666666666667| 100.66666666666667| Pass
 
2 Use of inappropriate error messages

    Case No | Expression | Expected Result   | Actual Result     | Result
    1       | 1/0  =     | Undefined         | Infinity          | Failure
    
3 Error Operation

    Case No | Expression | Expected Result   | Actual Result     | Result
    1       | 1+-=       | ERR               | ERR               | Pass
    2       | +-1=       | ERR               | -1                | Failure
    
4 Multiple Equality Sign

    Case No | Expression | Expected Result | Actual Result | Expected Expression |Actual Expression |Result
    1       | 1+1=2+2=   | 4               | 17            | 3+3                 |1+13+3            |Failure
    
The reason is that the input needs to be cleared after the result appears and before we can perform next operations.

5 Expression Display

    Case No | Expression | Expected Expression | Actual Expression | Result
    1       | 1+05=      | 1+5                 | 1+05              | Failure
    
We should change the input's formatting when the first digit of a number is zero.    

6 Other Bugs
  
<1> It should provide a "CLEAR" key to clear all input, otherwise the user has to click the "DEL" key multiple times.

<2> If the result of the equation is too long, the first digit of the answer overwrites the equality symbol.
 For example, this happens when the input is "1/3=". This can be fixed if we can decrease the maximum digits of the output by 1.





