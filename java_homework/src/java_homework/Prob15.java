package java_homework;

/**
 * 문제 15
 * 실수형 변수 다섯 개를 선언하고 임의의 값을 할당
 * 다섯 값의 평균보다 큰 수들을 출력
 */
public class Prob15 {

	public static void main(String[] args) {

		double num1 = 1.5;
		double num2 = 2.3;
		double num3 = 4.9;
		double num4 = 9.4;
		double num5 = 3.2;
		
		double average =  (num1 + num2 + num3 + num4 + num5) / 5;
		
		System.out.println("average : " + average);
		if (num1 > average) {
			System.out.println(num1);
		}
		if (num2 > average) {
			System.out.println(num2);
		}
		if (num3 > average) {
			System.out.println(num3);
		}
		if (num4 > average) {
			System.out.println(num4);
		}
		if (num5 > average) {
			System.out.println(num5);
		}
	}
}
