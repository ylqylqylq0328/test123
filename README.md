## Description
Test Simple Calculator.
### Execution
    gradlew test
### Test Result and Reporting Folder
    reporting.baseDir = "my-reports"
    testResultsDirName = "$buildDir/my-test-results"
### Test cases
Totally there are 43 test cases: 34 are successful and 9 failed. Please see "Bug" section for bugs' analysis.

    TC1 Key Response
    TC2 Basic Operation
    TC3 Order Of Operation
    TC4 Negative Number
    TC5 Decimal Result
    TC6 Repeating Decimal Result
    TC7 Zero Operation
    TC8 Big Data Operation
    TC9 Del Key Operation
    TC10 Invalid Operation
    TC11 Multiple Equality Sign
    TC12 Expression Display

### Bug
1 Repeating Decimal Operation Abnormality.

    Case No | Expression | Expected Result   | Actual Result     | Result
    1       | 1/3*2=     | 0.6666666666666667| 0.6666666666666666| Failure
    2       | 1+1/3*2=   | 1.6666666666666667| 1.6666666666666665| Failure
    3       | 100+1/3*2= | 100.66666666666667| 100.66666666666667| Pass

The same rule should be used when we round a repeating decimal.

2 Use of inappropriate error messages

    Case No | Expression | Expected Result   | Actual Result     | Result
    1       | 1/0  =     | Undefined         | Infinity          | Failure
    
3 Big Data Operation

    Case No | Expression            | Expected Result    | Actual Result      | Result
    1       | 123456789012345*2=    | 246913578024690    | 246913578024690    | Pass
    2       | 1234567890123456*2=   | 2469135780246912   | 2469135780246912   | Pass
    3       | 12345678901234567*2=  | 24691357802469134  | 24691357802469136  | Failure
    4       | 123456789012345678*2= | 246913578024691356 | 246913578024691360 | Failure

The answer is incorrect when it contains more than 16 digits. To fix this issue, we should use 
the scientific notation to round the number.

4 Invalid Operation

    Case No | Expression | Expected Result   | Actual Result     | Result
    1       | 1+-=       | ERR               | ERR               | Pass
    2       | +-1=       | ERR               | -1                | Failure
    
5 Multiple Equality Sign

    Case No | Expression | Expected Result | Actual Result | Expected Expression |Actual Expression |Result
    1       | 1+1=2+2=   | 4               | 17            | 3+3                 |1+13+3            |Failure
    
The reason is that the input needs to be cleared after the result appears and before we can perform next operations.

6 Expression Display

    Case No | Expression | Expected Expression | Actual Expression | Result
    1       | 1+05=      | 1+5                 | 1+05              | Failure
    1       | 05+1=      | 5+1                 | 05+1              | Failure
    
We should change the input's formatting when the first digit of a number is zero.    

7 Other Bugs
  
<1> It should provide a "CLEAR" key to clear all input, otherwise the user has to click the "DEL" key multiple times.

<2> If the result of the equation is too long, the first digit of the answer overwrites the equality symbol.
 For example, this happens when the input is "1/3=". This can be fixed if we can decrease the maximum digits of the output by 1.

<3> If the input expression is more than 18 digits and symbols, the next digits and symbols cannot be seen. To fix this issue,
we should set the maximum input to 18 digits and symbols, or to decrease the size of each digit or symbol 
when there are more than 18 of them.



