package com.ktdsuniversity.edu.fp.basic;

public class Main {

	public static void main(String[] args) {

		// 1. 함수 (인스턴스)를 변수에 할당할 수 있다.
		// YesOrNo 익명클래스 만들기
		YesOrNo yn = new YesOrNo() {
			@Override
			public boolean test(int value) {
				// value 가 짝수이면 true, 아니면 false
				return value % 2 == 0;
			}
		};

		System.out.println(yn.test(9));
		System.out.println(yn.test(8));
		System.out.println(yn.test(1));
		System.out.println(yn.test(6));

		// 람다 적용
		YesOrNo ynFunction = (int value) -> {
			return value % 2 == 0;
		};

		// 함수의 input 타입을 생략할 수 있음
		// interface 에 함수의 원형이 명시되어 있으니까 생략해서 사용이 가능함
		YesOrNo ynFunction2 = (value) -> {
			return value % 2 == 0;
		};

		// 함수의 output 을 생략할 수 있음
		YesOrNo ynFunction3 = (value) -> value % 2 == 0;

		// 실행은 익명클래스와 동일함
		System.out.println(ynFunction.test(9));
		System.out.println(ynFunction.test(8));
		System.out.println(ynFunction2.test(7));
		System.out.println(ynFunction2.test(6));
		System.out.println(ynFunction3.test(5));
		System.out.println(ynFunction3.test(4));

		// Java Built-in Functions
		// 1. Predicate : input -> boolean
		// 2. Function : input -> Anything
		// 3. Consumer : input -> void

		// 2. 함수를 파라미터에 전달할 수 있다.
		// 함수에 익숙해지고 나서의 문제 -> 디버깅 쉽지 않다
		// 디버깅 하기 위해 아래 코드처럼 나눠줌
		FunctionParameter fp = new FunctionParameter();
		boolean isEven = fp.isEven(12, 
								(value) -> 
								value % 2 == 0);
		System.out.println(isEven);
		
		boolean isValidAge = fp.isValidAge(300, 
							(value) -> 
							value >= 0 && value <= 100); // 300 이란 나이에 대한 검증 코드를 적어줌
		System.out.println(isValidAge);

		// 3. 함수가 함수를 반환할 수 있다.
		// 함수의 결과가 아닌 함수를 줌
		YesOrNo enoughFunction = fp.enoughMoney();
		boolean enough = enoughFunction.test(10000);
		System.out.println(enough);
		// 전달된 함수를 여러번 사용하는 것도 가능함
		enough = enoughFunction.test(20000);
		System.out.println(enough);
		 enough = enoughFunction.test(30000);
		System.out.println(enough);

		// 4. 함수가 함수를 가질 수 있다.
		// numberOne -> n1, numberTwo -> n2
		// 함수의 output 이 void 일 때는 {}를 열었다가 닫아야 함 -> 아무것도 반환시키지 않는다는 의미
		Calculator simpleCalc = (n1, n2) -> {
			int result = n1 + n2;
			// result 의 값이 10000보다 큰가? (YesOrNo 를 통해 확인하고 싶음)
			YesOrNo calcValidator = (value) -> value > 10_000;
			boolean isValid = calcValidator.test(result);
			
			System.out.println(isValid);
		};
		
		// 10000 -> numberOne -> n1, 100000 -> numberTwo -> n2
		// 즉 10000 -> n1, 100000 -> n2
		simpleCalc.calc(10_000, 100_000);
	}
}