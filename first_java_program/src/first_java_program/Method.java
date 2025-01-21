package first_java_program;

public class Method {
	
	public static int getTestNumber() {
		
		int num1 = (int) (Math.random() * 100);
		
		if (num1 > 90) {
			return 100;
		}
		else if (num1 > 50) {
			return 30;
		}
		return 0;
	}
	
	/**
	 * 파라미터는 없음
	 * 임의의 숫자 두개를 만들어서 값을 할당하고, 두 숫자의 합을 반환
	 */
	public static int getAdditionResult() {
		
		int num1 = (int) (Math.random() * 100);
		int num2 = (int) (Math.random() * 100);
		
		return num1 + num2; 
	}
	
	/**
	 * 숫자 두 개를 랜덤하게 생성을 하고 두 숫자를 더한 결과를 반환시키는데
	 * 숫자 중 하나라도 5 보다 작은 숫자가 있다면 -1을 반환
	 */
	public static int getConditionalAdditionResult() {
		
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);
		
		if (num1 < 5 || num2 < 5) {
			return -1;
		}
		
		return num1 + num2;
	}
	
	
	/**
	 * 1과 10 사이의 홀수만 출력
	 */
	public static void printNumber() {
		
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
				return; // 반환 타입이 void 일 때 printNumber 메소드를 즉시 종료시킴 
			}
		}
	}
	
	/**
	 * 정수 파라미터 두개를 받아서, 첫 번째 파라미터 정수에 두 번째 파라미터 정수만큼 곱해서
	 * 문자열 파라미터와 함께 출력
	 * @param number 정수
	 * @param time 제곱할 횟수
	 * @param message 결과와 함께 출력해주고 싶은 문자열
	 */
	public static void printPowerNumberWithMessage(int number, int time, String message) {
	
		long result = 1;
		
		for (int i = 0; i < time; i ++) {
			result *= number;
		}
		System.out.println(message + result);
	}
	
	
	// 소괄호 안에 있는 모든 변수(ex, int number) : 파라미터, Argument, 인자 -> 임시 변수
	public static void printPowerNumber(int number) {
		// 메소드 안쪽의 변수들 : 지역변수, 이 지역에서만 한정적으로 존재
		int result = (int) Math.pow(number, 2);
		System.out.println(number + "의 제곱수는 " + result + "입니다.");
	}
	
	/**
	 * 정해진 숫자 두 개를 더해 출력하는 메소드
	 * 숫자를 더하는 방법과 출력하는 방법 기술
	 */
	public static void add() {
		int number1 = 1;
		int number2 = 3;
		
		int addResult = number1 + number2;
		System.out.println(number1 + " + " + number2 + " = " + addResult);
	}
	
	/**
	 * 숫자(정수)를 담는 변수 두개에 임의의 값을 할당하고
	 * 두 숫자 중에서 더 큰 숫자만 출력
	 */
	public static void printMaxValue() {
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);
		
		if (num1 > num2) {
			System.out.println(num1 + "이" + num2 + "보다 큽니다.");
		}
		else if (num1 < num2) {
			System.out.println(num1 + "이 " + num2 + "보다 큽니다.");
		}
		else {
			System.out.println(num1 + "와 " + num2 + "는 같습니다.");
		}
	}
	
	/**
	 * 숫자(정수)를 담는 변수 두개에 임의의 값을 할당하고
	 * 두 숫자를 뺐을 때 음수가 나오는 경우만 출력
	 */
	public static void printNegativeValue() {
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);
		
		if (num1 > num2) {
			System.out.println(num1 - num2);
		}
		else if (num2 < num1) {
			System.out.println(num2 - num1);
		}
	}
	
	/**
	 * 1 부터 1000까지의 숫자중에 소수(Prime number: 자신과 1로만 나누어지는 수)를 찾아서 출력
	 * 
	 */
	public static void printPrimeNumber() {
		
		for (int i = 1; i < 1001; i++) {
			
			boolean isPrimeNumber = true;
			
			for (int j = 1; j <= i; j++) {
				// 1과 자신의 수로는 나누지 않음
				if (j != 1 && j != i) {
					if (i % j == 0) {
						isPrimeNumber = false;
						break; // 소수가 아님
					}
					// j for 가 끝까지 반복을 했을 떄, 0으로 나누어진 수가 존재했는가?
				}
			}
			// if 는 boolean / 식을 적을 수 있음
			// isPrimeNumber는 boolean type 임
			// if (true == true)는 불필요한 연산
			// isPrimeNumber == true -> isPrimeNumber
			if (isPrimeNumber) {
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Method 클래스를 실행시키기 위한 특별한 메소드
	 * 이 메소드는 JVM이 실행함
	 * @param args - main 메소드를 실행할 때 필요한 인자(파라미터)
	 */
	public static void main(String[] args) {
		System.out.println("add 메소드를 호출하는 코드입니다.");
		add();
		printMaxValue();
		printNegativeValue();
		printPrimeNumber();
		
		printPowerNumber(10);
		printPowerNumber(30);
		printPowerNumber(55);
		
		printPowerNumberWithMessage(10, 10, "1. 결과는 ");
		printPowerNumberWithMessage(30, 20, "2. 결과는 "); // -> overflow
		printPowerNumberWithMessage(55, 100, "3. 결과는 "); // -> overflow
			
		int addResult = getAdditionResult();
		System.out.println(addResult);
		
		int number = getConditionalAdditionResult();
		System.out.println(number);
		
		int number2 = getTestNumber();
		System.out.println(number2);
	}
}
