package calculator;

public class DivideOperation implements OperationInterface {
    @Override
    public int operationPriority() {
        return 1;
    }

    @Override
    public String operationName() {
        return "/";
    }

    @Override
    public int calculation(int beforeNumber, int afterNumber) {
        try{
            int Result = beforeNumber / afterNumber;
            return Result;
        }
        catch (ArithmeticException e){
            System.out.println("0으로 나눌수가 없습니다.");
        }
        return 0;
    }
}
