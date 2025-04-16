package lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            int firstNumber = 0;
            int secondNumber = 0;

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

            char operator;
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
            if (operator == '/' && secondNumber == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }
            if (operator == '/') {
                double result = (double) firstNumber / secondNumber;
                System.out.println("결과: " + result);
            } else {
                int result = 0;
                switch (operator) {
                    case '+':
                        result = firstNumber + secondNumber;
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        break;
                    case 'x':
                        result = firstNumber * secondNumber;
                        break;
                }
                System.out.println("결과: " + result);
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
