package com.ktdsuniversity.edu.fp.builtin;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExam {

	public static void main(String[] args) {
		// void 반환할 때는 {} 적어야 함!
		Consumer<String> printFn = (str) -> {
			System.out.println(str);
		};
		printFn.accept("반갑습니다!");
		
		// 한 줄로도 표현이 가능함
		Consumer<String> printFn2 = (str) -> System.out.println(str);
		printFn.accept("반갑습니다!");
		
		// 함수에서 consumer 의 output 타입과 println 의 반환 타입이 같음
		// 즉 void void 로 같으므로 void 를 반환 시킬 수 있음
		// Consumer<Integer> calAndPrintFn = (number) -> number * 2; -> 반환 타입이 다르므로 에러 발생 !
		
		List<Integer> numberArray = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// for 문 돌지 않더라도 forEach로 반복이 가능함
		numberArray.forEach( (number) -> System.out.println("반복중입니다. " + number));
	}
}
