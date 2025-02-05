package hw0123;

/**
 * 문제 17
 * 정수형 변수 다섯 개를 선언하고 임의의 값 할당
 * 다섯 값 중 2 또는 5 또는 6의 배수인 것들만 출력
 */
public class Prob17 {
	public static void main(String[] args) {

		int num1 = 4;
		int num2 = 5;
		int num3 = 7;
		int num4 = 40;
		int num5 = 60;
		
		if(num1 % 2 == 0 || num1 % 5 == 0 || num1 % 6 == 0) {
			System.out.println(num1);
		}
		if(num2 % 2 == 0 || num2 % 5 == 0 || num2 % 6 == 0) {
			System.out.println(num2);
		}
		if(num3 % 2 == 0 || num3 % 5 == 0 || num3 % 6 == 0) {
			System.out.println(num3);
		}
		if(num4 % 2 == 0 || num4 % 5 == 0 || num4 % 6 == 0) {
			System.out.println(num4);
		}
		if(num5 % 2 == 0 || num5 % 5 == 0 || num5 % 6 == 0) {
			System.out.println(num5);
		}
	}
}
