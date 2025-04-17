package lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            int firstNumber;
            int secondNumber;
            char operator;

            //첫번째 피연산자
            while (true) {
                try {
                    System.out.print("첫번째 연산자(양의 정수)를 입력하세요: ");
                    firstNumber = Integer.parseInt(sc.nextLine());
                    if (firstNumber < 0) {
                        System.out.println("양의 정수만 입력해주세요.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("양의 정수만 입력해주세요.");
                }
            }

            //두번째 피연산자
            while (true) {
                try {
                    System.out.print("두번째 연산자(양의 정수)를 입력하세요: ");
                    secondNumber = Integer.parseInt(sc.nextLine());
                    if (secondNumber < 0) {
                        System.out.println("양의 정수만 입력해주세요.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("양의 정수만 입력해주세요.");
                }
            }


            //연산자
            while (true) {
                System.out.print("연산자를 입력해주세요 (+, -, x, /): ");
                String opInput = sc.nextLine();
                if (opInput.isEmpty()) {
                    continue;
                }
                operator = opInput.charAt(0);
                if ("+-x/".indexOf(operator) == -1) {
                    System.out.println("연산자를 정확히 입력해주세요.");
                    continue;
                }
                break;
            }


            //계산
            int result = calculator.calculate(firstNumber, secondNumber, operator);
            System.out.println("결과: " + result);

            System.out.println("저장된 연산 결과들: " + calculator.getResult());

            System.out.println("가장 오래된 결과를 삭제하시겠습니까? (y/n): ");
            String answer = sc.nextLine();
            if (answer.equals("y")) {
                calculator.removeResult();
                System.out.println("삭제 완료.");
                System.out.println("현재 결과 목록: " + calculator.getResult());
            }

            System.out.println("요소를 수정하시겠습니까? (y/n): ");
            String answer2 = sc.nextLine();
            if (answer2.equals("y")) {
                System.out.print("수정할 인덱스를 입력하세요: ");
                int index = Integer.parseInt(sc.nextLine());

                System.out.print("새로운 값을 입력하세요: ");
                int newValue = Integer.parseInt(sc.nextLine());

                calculator.setResult(index, newValue);
                System.out.println("수정 후 결과 목록: " + calculator.getResult());
            }

            //반복 여부 묻기
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String isExit = sc.nextLine();
            if (isExit.equals("exit")) {
                flag = false;
                System.out.println("종료합니다.");
            }

        }
        sc.close();

    }

}
