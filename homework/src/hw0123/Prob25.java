package hw0123;

/**
 * 문제 25
 * 1부터 1000 중 소수(1과 자신으로만 나눌 수 있는 수)만 출력
 */
public class Prob25 {
	
	public static void main(String[] args) {
		
		boolean isPrime = true;
		int i = 0;
		int j = 0;
		
		for (i = 2; i <= 1000; i++) {
			isPrime = true;
			for (j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(i);
			}
		}
	}
}
