package java_homework;

/**
 * 문제 13
 * 실수형 변수 두 개를 선언하고 임의의 값 할당
 * 두 값 중 큰 수만 출력
 */
public class Prob13 {

	public static void main(String[] args) {
		
		double num1 = 10.5;
		double num2 = 2.3;
		
		//( 비교 혹은 논리연산 ) ? 비교 혹은 논리 연산의 결과가 true 일때의 값 : 비교 혹은 논리 연산의 결과가 false 일때의 값
		// 1. 삼항연산자가 컴파일되면 if ~ else 로 재 작성.
		// 2. if ~ else if ~ else 케이스로 작성하기가 매우매우 복잡.
		double max = (num1 > num2) ? num1 : num2;
		System.out.println(max);
//		if (num1 > num2) {
//			System.out.println(num1);
//		}
//		else {
//			System.out.println(num2);
//		}
	}
}
