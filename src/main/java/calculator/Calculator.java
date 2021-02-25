package calculator;

import java.util.Scanner;


public class Calculator {
    public void calculation(){
        String[] equation_list = getEquation();
        ArithmeticExpressionStack arithmeticExpressionStack = new ArithmeticExpressionStack(equation_list, equation_list.length);
        OperatorSetting(arithmeticExpressionStack, equation_list.length);

    }

    public void OperatorSetting(ArithmeticExpressionStack arithmeticExpressionStack, int equationLength) {
        ErrorException exception = new ErrorException();
        String firstString = arithmeticExpressionStack.pop();
        int firstNumber = exception.NumericalError(firstString);

        for(int i = 0; i<(arithmeticExpressionStack.getStackSize())/2;i++){
            String operator = arithmeticExpressionStack.pop();
            String secondString = arithmeticExpressionStack.pop();
            int secondNumber = exception.NumericalError(secondString);
            firstNumber = chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        }
        arithmeticExpressionStack.clear();
        System.out.println("결과");
        System.out.println(firstNumber);
        init();
    }

    private int chooseOperatorAndCalculate(int firstNumber, String operator, int SecondNumber){
        AddOperation addOperation = new AddOperation();
        SubOperation subOperation = new SubOperation();
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        DivideOperation divideOperation = new DivideOperation();
        int result = 0;
        if (operator.equals(addOperation.operationName())){
            result = addOperation.calculation(firstNumber, SecondNumber);
        }
        if (operator.equals(subOperation.operationName())){
            result = subOperation.calculation(firstNumber, SecondNumber);
        }
        if (operator.equals(multiplyOperation.operationName())){
            result = multiplyOperation.calculation(firstNumber, SecondNumber);
        }
        if (operator.equals(divideOperation.operationName())){
            result = divideOperation.calculation(firstNumber, SecondNumber);
        }

        return result;
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산을 계속 진행하시려면 1, 멈추시려면 2를 눌러주세요");
        String value = scanner.nextLine();

        if(value.equals("1")){
            calculation();
        }
        else{
            System.exit(0);
        }
    }

    public String[] getEquation(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해주세요 : ");
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        return values;
    }
}
