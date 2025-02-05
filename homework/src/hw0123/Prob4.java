package hw0123;

/**
 * 문제 4
 * 1부터 10_000 사이에 몇 개의 Prime Number 가 있는지 세어 출력하는 메소드 만들고 호출
 */
public class Prob4 {

	public static void countPrimeNumber() {
		
		int count = 0;
		boolean isPrime = true;
		int i = 0;
		int j = 0;
		
		for (i = 2; i <= 10_000; i++) {
			for (j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				count ++;	
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		countPrimeNumber();
	}
	
}
