package hw0123;

/**
 * 문제 12
 * 정수형 변수 2개 선언 후 값 할당
 * 값이 할당된 정수형 변수 2개의 나누기 결과를 구해 새로운 실수형 변수에 할당
 * 나누기 결과가 할당된 변수 값 출력
 * 단 소수점 이하의 자리수는 2자리만 저장해 출력
 */
public class Prob12 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 3;
		double rest = ((double) num1 / num2) * 100;
		System.out.println((int) rest / 100.0);
		// System.out.printf("%.2f", rest);
	}
}
