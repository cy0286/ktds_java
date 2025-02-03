package java_homework;

import java.util.Scanner;

/**
 * 문제 3
 * 계산기 만들기
 * 세 개의 파라미터(문자열, 숫자, 숫자)를 받아 결과 반환하는 메소드 만들어 호출
 * 문자열 파라미터 -> +, -, *, /
 * 숫자 파라미터 -> 정수 or 부동소수점
 * 문자열 파라미터에 따라 알맞은 결과 반환
 * 계산기는 무한히 반복하며 계산 가능함, 매 반복시 파라미터에 할당될 값을 입력
 * exit 문자열을 입력하면 반복이 종료되어 애플리케이션 종료됨
 */
public class Prob3 {

	public static int calculateResult(String operation, int num1, int num2) {	
		if (operation.equals("+")) {
			return num1 + num2;
		} 
		else if (operation.equals("-")) {
			return num1 - num2;
		} 
		else if (operation.equals("*")) {
			return num1 * num2;
		} 
		else if (operation.equals("/")) {
			return num1 / num2;
		}
		else {
			System.out.println(operation + "은 없는 operation 입니다.");
			return 0;
		}
	}

	
	public static void main(String[] args) {

		Scanner keybord = new Scanner(System.in);
		String operation = null;
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		while(true) {
	
			System.out.println("operation을 입력하세요.");
			operation = keybord.next();
			if (operation.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				return;
				// break;
			}

			System.out.println("첫 번째 숫자를 입력하세요.");
			num1 = keybord.nextInt();
			System.out.println("두 번째 숫자를 입력하세요.");
			num2 = keybord.nextInt();
			
			result = calculateResult(operation, num1, num2);	
			System.out.println(num1 + operation + num2 + " = " + result);
		}
		
	}
}
