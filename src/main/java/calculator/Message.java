package calculator;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Message {
    HashMap<String, String> exceptionMessageList = new HashMap<String, String>();
    public void calculationResult(int result){
        System.out.print("결과 : ");
        System.out.println(result);
    }
    private void exceptionMessageList(){
        exceptionMessageList.put("NOT_OPERATOR", "사칙연산 기호에 해당하지 않는 기호가 존재합니다.");
        exceptionMessageList.put("INVALID_EQUATION", "잘못된 연산식입니다.");
    }

    public void exceptionResult(String exceptionKeyword){
        exceptionMessageList();
        System.out.println(exceptionMessageList.get(exceptionKeyword));
    }
}
