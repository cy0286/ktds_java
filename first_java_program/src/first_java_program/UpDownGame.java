package first_java_program;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		double randomNumber = Math.random();
		int quiz = (int) (randomNumber * 100);
		//	int myAnswer = 60;
		
		// Ctrl + shift + O -> Scanner 오류 사라짐
		System.out.println("숫자를 입력하세요.");
		int myAnswer = new Scanner(System.in).nextInt();
		
		if (quiz == myAnswer) {
			System.out.println("정답입니다!");
		}
		else if (quiz > myAnswer) {
			System.out.println("UP");
		}
		else if (quiz < myAnswer) {
			System.out.println("Down");
		}
		System.out.println("정답은 " + quiz + "입니다. ");
	}
}
