package hw0123;

/**
 * 문제 5
 * 파라미터로 정수를 전달하면, 해당 숫자가 Prime Number 인지 확인
 * 소수라면 true, 아니라면 false 반환 시키는 메소드 만들고 실행 후 결과 출력
 */
public class Prob5 {

	public static boolean checkIsPrimeNumber(int num) {
		if (num <= 1) {
			return false; // 1 이하의 소수 처리
		}
		
		int i = 0;
		for (i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		boolean answer = checkIsPrimeNumber(2);
		System.out.println(answer);
		
	}
}
