package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    private int result;
    Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        result = 0;
        //BeforeEach에 변수 선언, 객체 생성해도 적용이 안되는 이유?
    }

    @Test
    void operatorSetting() {
    }

    @ParameterizedTest
    @MethodSource("paramproviderforadd")
    @DisplayName("TESTFORADD")
    void TESTFORADD(int firstNumber, String operator, int secondNumber) {
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(5, result);
    }

    static Stream<Arguments> paramproviderforadd() {
        return Stream.of(
                arguments(1, "+", 4),
                arguments(5, "+", 0),
                arguments(9, "0", -4),    //case for failure
                arguments(10, "+", -100) //case for failure
        );
    }

    @ParameterizedTest
    @MethodSource("paramproviderforsub")
    @DisplayName("TESTFORSUB")
    void TESTFORSUB(int firstNumber, String operator, int secondNumber) {
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(-1, result);
    }

    static Stream<Arguments> paramproviderforsub() {
        return Stream.of(
                arguments(2, "-", 3),
                arguments(5, "-", 6),
                arguments(0, "뜬금", 1), //case for failure
                arguments(12, "-", 15)  //case for failure
        );
    }

    @ParameterizedTest
    @MethodSource("paramproviderformul")
    @DisplayName("TESTFORMUL")
    void TESTFORMUL(int firstNumber, String operator, int secondNumber) {
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(6, result);
    }

    static Stream<Arguments> paramproviderformul() {
        return Stream.of(
                arguments(2, "*", 3),
                arguments(1, "*", 6),
                arguments(3, "^", 2), //case for failure
                arguments(6, "*", 0)  //case for failure
        );
    }

    @ParameterizedTest
    @MethodSource("paramproviderfordiv")
    @DisplayName("TESTFORDIV")
    void TESTFORDIV(int firstNumber, String operator, int secondNumber) {
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(3, result);
    }

    static Stream<Arguments> paramproviderfordiv() {
        return Stream.of(
                arguments(9, "/", 3),
                arguments(3, "/", 1),
                arguments(27, "/", 0), //case for failure (devide by zero)
                arguments(81, "/", 9)  //case for failure
        );
    }


//    @Test
//    void test() {
//
//        assertThrows(NumberFormatException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                Calculator calculator = new Calculator();
//
//                String[] equation_list = {"+", "+", "+"};
//                ArithmeticExpressionStack arithmeticExpressionStack = new ArithmeticExpressionStack(equation_list, equation_list.length);
//
//                calculator.OperatorSetting(arithmeticExpressionStack);
//            }
//        });
//    }
}