package java_homework;

/**
 * 문제 14
 * 실수형 변수 세 개를 선언하고 임의의 값 할당
 * 세 값 중 가장 작은 수만 출력
 */
public class Prob14 {
	public static void main(String[] args) {
		
		double num1 = 1.3;
		double num2 = 3.4;
		double num3 = 6.8;
		double min = Math.min(num1, Math.min(num2, num3));
		System.out.println(min);
	}
}
