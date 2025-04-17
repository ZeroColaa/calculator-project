package lv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Number> calc = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            double firstNumber;
            double secondNumber;
            OperatorType op;

            //첫번째 피연산자
            while (true) {
                try {
                    System.out.print("첫 번째 숫자 입력: ");
                    firstNumber = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 정확히 입력해주세요.");
                }
            }

            //두번째 피연산자
            while (true) {
                try {
                    System.out.print("두 번째 숫자 입력: ");
                    secondNumber = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 정확히 입력해주세요.");
                }
            }


            //연산자
            while (true) {
                try {
                    System.out.print("연산자 입력 (+, -, x, /): ");
                    op = OperatorType.fromChar(sc.nextLine().charAt(0));
                    break;
                } catch (Exception e) {
                    System.out.println("지원하지 않는 연산자입니다.");
                }
            }


            //계산
            double result = calc.calculate(firstNumber, secondNumber, op);
            System.out.println("결과: " + result);

            System.out.println("저장된 연산 결과들: " + calc.getResultList());

            //가장 오래된 결과 삭제
            System.out.print("가장 오래된 결과를 삭제하시겠습니까? (y/n): ");
            String answer = sc.nextLine();
            if (answer.equals("y")) {
                calc.removeFirstResult();
                System.out.println("삭제 완료.");
                System.out.println("현재 결과 목록: " + calc.getResultList());
            }

            //요소 수정
            System.out.print("요소를 수정하시겠습니까? (y/n): ");
            String answer2 = sc.nextLine();
            if (answer2.equals("y")) {
                try {
                    int index;
                    while (true) {
                        try {
                            System.out.print("수정할 인덱스를 입력하세요: ");
                            index = Integer.parseInt(sc.nextLine());

                            // 올바른 범위인지 체크
                            if (index < 0 || index >= calc.getResultList().size()) {
                                System.out.println("잘못된 인덱스입니다.");
                                continue; // 다시 입력 받음
                            }

                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력해주세요.");
                        }
                    }

                    double newValue = 0;
                    while (true) {
                        try {
                            System.out.print("새로운 값을 입력하세요: ");
                            newValue = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("숫자를 입력해주세요.");
                        }
                    }
                    calc.updateResult(index, newValue);
                    System.out.println("수정 완료. 현재 목록: " + calc.getResultList());

                } catch (Exception e) {
                    System.out.println("수정 중 오류 발생: " + e.getMessage());
                }
            }

            // 결과 필터링
            System.out.print("기준값보다 큰 결과만 보고 싶으면 숫자 입력: ");
            String line = sc.nextLine();
            if (!line.isBlank()) {
                try {
                    double threshold = Double.parseDouble(line);
                    System.out.println(threshold + "보다 큰 값 -> " + calc.getResultsAbove(threshold));
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 정확히 입력해주세요.");
                }
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
