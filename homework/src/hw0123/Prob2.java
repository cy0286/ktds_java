package hw0123;

import java.util.Scanner;

/**
 * 문제 2
 * 무한 구구단 출력
 * 사용자가 입력한 구구단의 결과를 출력함
 * -1을 입력하면, 구구단 출력 프로그램 종료
 */
public class Prob2 {
	
	public static void main(String[] args) {
	
		Scanner keybord = new Scanner(System.in);
		
		int answer  = 0;
		int i = 0;
		while (true) {
			System.out.println("숫자를 입력하세요.");
			answer = keybord.nextInt();
			
			if (answer == -1) {
				System.out.println("구구단 출력 프로그램을 종료합니다.");
				return;
				// break;
			}
			
			for (i = 1; i < 10; i++) {
				System.out.println(answer + " X " + i + " = "  + answer * i);
			}
		}
	}
}
