package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //연산 결과 저장(캡슐화)
    private final List<Integer> result;

    //생성자
    public Calculator(){
        this.result = new ArrayList<>();
    }
    //사칙연산 수행, 결과 반환 및 저장
    public int calculate(int a, int b, char operator){
        int calcResult;

        switch (operator){
            case '+':
                calcResult = a + b;
                break;
            case '-':
                calcResult = a - b;
                break;
            case 'x':
                calcResult = a * b;
                break;
            case '/':
                if (b==0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                calcResult=a/b;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
        result.add(calcResult);//결과 저장
        return calcResult; //결과 반환
    }

    //getter
    public List<Integer> getResult(){
        return result;
    }

    //setter
    public void setResult(int index, int newValue){
        if(index>=0&&index<result.size()){
            result.set(index,newValue);
        }else{
            System.out.println("잘못된 인덱스입니다.");
        }
    }
    //가장 먼저 저장된 결과 제거
    public void removeResult(){
        if(!result.isEmpty()){
            result.remove(0);
        }
    }
}
