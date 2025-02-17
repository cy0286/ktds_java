package com.ktdsuniversity.edu.fp.builtin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExam {

	// Ctrl + shift + t -> java.util.function 패키지에 있는 Predicate 찾기 
	public static void main(String[] args) {
		
		// import java.util.function.Predicate 하기
		// number 를 받아서 number 가 홀수인지 확인하기
		Predicate<Integer> isOdd = (number) -> number % 2 == 1;
		// boolean 인 이유는 test 할 함수의 output 이 boolean 이기때문
		boolean result = isOdd.test(12309281);
		System.out.println(result);
		
		List<Integer> numberArray = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> mutableArray = new ArrayList<Integer>(numberArray);
		
		System.out.println(numberArray);
		
		// 반복문을 사용하지 않고 함수를 사용할 수 있음
		// 각 엘리먼트의 값이 5보다 작거나 같으면 지워라!
		mutableArray.removeIf( (element) -> element <= 5);
		System.out.println(mutableArray);
	}
}
