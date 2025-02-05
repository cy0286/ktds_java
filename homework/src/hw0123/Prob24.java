package hw0123;

/**
 * 문제 24
 * 구구단 2 ~ 9 단을 출력
 */
public class Prob24 {

	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		for (i = 2; i <= 9; i++) {
			System.out.println(i + "단");
			for (j = 2; j <= 9; j++){
				System.out.println(i + " X " + j + " = " + (i * j));	
			}
			System.out.println();
		}
	}
}
