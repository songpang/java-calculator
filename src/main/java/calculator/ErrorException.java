package calculator;

import java.util.InputMismatchException;

public class ErrorException {
    public int NumericalError(String number) {
        int numberConverted = 0;
        try {
            numberConverted = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 연산기호 입니다.");
            Calculator calculator = new Calculator();
            calculator.calculation();
        }
        return numberConverted;
    }
}
