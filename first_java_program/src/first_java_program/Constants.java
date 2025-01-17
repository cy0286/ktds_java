package first_java_program;

/**
 * 상수를 정의하는 방법과 네이밍 규칙에 대한 설명
 */
public class Constants {
	
	// 대문자로 시작하면 class, 소문자로 시작하면 변수, 모든 글자가 대문자면 상수
	public static void main(String args[]) {
		
		int speedOFLight = 299_792_458; 
		
		// 상수명의 규칙은 모두 대문자로 작성하고 단어와 단어는 _로 구분함
		final int SPEED_OF_LIGHT = 299_792_458;
		
		// 상수의 값이 이미 할당되어 있는 경우 값의 재할당이 불가능함
		// Error! SPEED_OF_LIGHT = 90;
		
		final int LIMIT_AGE; // 값이 비어있는 상수 정의
		LIMIT_AGE = 20;
		// 값이 비어있는 상수인 경우는 최초 할당만 가능함
		// Error! LIMIT_AGE = 30;
	}
}
