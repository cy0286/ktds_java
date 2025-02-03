package java_homework;

import java.util.Scanner;

/**
 * 문제 19
 * Scanner 이용
 * 2의 배수만 입력하는 문제 만들기
 * 만약 2의 배수가 아니거나 0 또는 음수를 입력하면
 * "게임을 마칩니다"를 출력하며 반복문 종료
 */
public class Prob19 {

	public static void main(String[] args) {
		Scanner keybord = new Scanner(System.in);
		int input = 0;
		
		while (true) {
			System.out.println("2의 배수를 입력하세요: ");
			 input= keybord.nextInt();
			if (input % 2 != 0 || input <= 0) {
				System.out.println("게임을 마칩니다.");
				// break;
				return;
			}
		}
	}
}
