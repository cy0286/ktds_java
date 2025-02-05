package hw0123;

/**
 * 문제 23
 * 구구단 2, 3단을 출력
 */
public class Prob23 {

	public static void main(String[] args) {
		int i = 0;
		
		System.out.println("2단");
		for(i = 1; i <= 9; i++) {
			System.out.println("2 X " + i + " = " + (2 * i));
		}
		
		System.out.println("3단");
		for(i = 1; i <= 9; i++) {
			System.out.println("3 X " + i + " = " + (3 * i));
		}
	}
}
