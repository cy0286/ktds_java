package com.ktdsuniversity.edu.fp.builtin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionExam {

	// Ctrl + shift + t -> java.util.function 패키지에 있는 Function 찾기 
	public static void main(String[] args) {
		
		/**
		 * Input 데이터로 "안녕하세요" 를 주면 
		 * "안녕하세요?" 가 output 으로 나오게 함수 만들기
		 * 
		 * Input 데이터에 ? 붙여서 반환시키기
		 */
		
		Function<String, String> concat = (str) -> str + "?";

		String result = concat.apply("안녕하세요");
		System.out.println(result); // 안녕하세요?

		result = concat.apply("반갑습니다");
		System.out.println(result); // 반갑습니다?
		
		// "안녕하세요, 지금은 함수형프로그래밍을 배우고 있습니다." -> 30
		// "반갑습니다. 안녕하세요?" -> 13
		// 문자열을 보내면 정수형으로 문자열의 길이를 반환하는 함수 만들기
		Function<String, Integer> fn = (str) -> str.length();
		
		int result1 = fn.apply("안녕하세요, 지금은 함수형프로그래밍을 배우고 있습니다.");
		System.out.println(result1);
		result1 = fn.apply("반갑습니다. 안녕하세요?");
		System.out.println(result1);
		
		// "안녕하세요, 지금은 함수형프로그래밍을 배우고 있습니다." ->
		// 	["안녕하세요,", "지금은", "함수형프로그래밍을", "배우고", "있습니다."]
		// "반갑습니다. 안녕하세요?" ->
		// 	["반갑습니다." "안녕하세요?"]
		// 문자열을 보내면 " " 로 문자열을 잘라 문자열배열을 반환하는 함수 만들기
		Function<String, String[]> fn2 = (value) -> value.split(" ");
		String[] result3 = fn2.apply("안녕하세요, 지금은 함수형프로그래밍을 배우고 있습니다.");
		System.out.println(Arrays.toString(result3));
		
		result3 = fn2.apply("반갑습니다. 안녕하세요?");
		System.out.println(Arrays.toString(result3));
		
		Map<String, Integer> valueMap = new HashMap<>();
		// 아스키코드
		valueMap.put("A", (int) 'A');
		valueMap.put("B", (int) 'B');
		valueMap.put("C", (int) 'C');
		valueMap.put("D", (int) 'D');
		valueMap.put("E", (int) 'E');
		System.out.println(valueMap);
		
		valueMap.replaceAll((key, value) -> value * 2);
		System.out.println(valueMap);
	}
}
