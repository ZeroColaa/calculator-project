package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//T -> Number 하위 타입만 허용(int,double,long 등)
public class ArithmeticCalculator<T extends Number> {
    private final List<Double> resultList = new ArrayList<>();
    // final로 선언함으로 리스트 참조를 다른 객체로 바꾸지 않겠다고 선언

    //연산+ 결과 저장+ 결과 반환
    public double calculate(T a, T b, OperatorType op) {
        double x = a.doubleValue(); // Number -> double
        double y = b.doubleValue(); // Number -> double

        double result = switch (op) {
            case PLUS -> x + y;
            case MINUS -> x - y;
            case MULTIPLY -> x * y;
            case DIVIDE -> {
                if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                yield x / y;
            }
        };
        resultList.add(result); //계산 결과 저장
        return result; //결과 반환

    }

    //전체 읽기
    public List<Double> getResultList() {
        return resultList;
    }

    //요소 수정하기
    public void updateResult(int index, double newValue) {
        resultList.set(index, newValue);
    }

    //가장 오래된 결과 삭제하기
    public void removeFirstResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }

    //입력값보다 큰 결과만 반환하기
    public List<Double> getResultsAbove(double threshold) {
        return resultList.stream() //1. 스트림 생성
                .filter(r -> r > threshold)//중간 연산
                .collect(Collectors.toList());//최종 정리
    }
}