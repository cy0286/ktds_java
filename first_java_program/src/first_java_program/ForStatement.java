package first_java_program;

public class ForStatement {

	public static void main(String[] args) {
		
		// 1. 1 부터 10 까지를 출력하기
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 2. 1부터 10 사이에 있는 홀수만 출력하기
		for (int i = 1; i <= 10; i+=2) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 3. 2부터 100_000 사이에 있는 짝수만 출력하기
		for (int i = 2; i <= 100_000; i+=2) {
			System.out.println(i);
		}
		
		// 구구단 출력
		for (int i =2; i < 10; i++) {
			System.out.println(i + "X" + 1 + "=" + i * 1);
			System.out.println(i + "X" + 2 + "=" + i * 2);
			System.out.println(i + "X" + 3 + "=" + i * 3);
			System.out.println(i + "X" + 4 + "=" + i * 4);
			System.out.println(i + "X" + 5 + "=" + i * 5);
			System.out.println(i + "X" + 6 + "=" + i * 6);
			System.out.println(i + "X" + 7 + "=" + i * 7);
			System.out.println(i + "X" + 8 + "=" + i * 8);
			System.out.println(i + "X" + 9 + "=" + i * 9);
		}

		// 이중 반복문으로 구구단 출력
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "X" + j + "=" + i * j);
			}
		}
	}
}
