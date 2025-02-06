package com.ktdsuniversity.edu.array;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
	
		int[] numbers = { 56, 12, 58, 80, 1, 2 };
		
		// 반복하지 않고 배열 출력하기
		// [56, 12, 58, 80, 1, 2]
		System.out.println(Arrays.toString(numbers));
		
		// [1, 2, 12, 56, 58, 80]
		
		// 아이템 개수만큼 반복
		for (int i = 0; i < numbers.length; i++) {

			// 대/소비교를 위한 반복
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				System.out.println(numbers[j] + ">" + numbers[j + 1]);
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}

			System.out.println(i + "=>" + Arrays.toString(numbers));
		}
		
		System.out.println(Arrays.toString(numbers));
		
		/** 
		 * bubble sort
		 * 시작 [56, 12, 58, 80, 1, 2]
		 * 반복 1, 0과 1 비교, (56 > 12)
		 * 		56과 12의 자리를 교환
		 * 결과 [12, 56, 58, 80, 1, 2] 
		 * 반복 2, 1과 2 비교 (56 > 58)
		 * 		아무런 일도 하지 않음
		 * 결과 [12, 56, 58, 80, 1, 2] 
		 * 반복 3, 2와 3을 비교 (58 > 80)
		 * 		아무런 일도 하지 않음
		 * 결과 [12, 56, 58, 80, 1, 2] 
		 * 반복 4, 3과 4를 비교 (80 > 1)
		 * 		80과 1의 자리를 교환
		 * 결과 [12, 56, 58, 1, 80, 2] 
		 * 반복 5, 4와 5를 비교 (80 > 2)
		 * 		80과 2의 자리를 교환
		 * 결과 [12, 56, 58, 1, 2, 80] 
		 * 반복 6, 0과 1 비교 (12 > 56)
		 * 		아무런 일도 하지 않음
		 * 결과 [12, 56, 58, 1, 2, 80] 
		 * 반복 7, 1과 2 비교 (56 > 58)
		 *      아무런 일도 하지 않음
		 * 결과 [12, 56, 58, 1, 2, 80] 
		 * 반복 8, 2와 3 비교 (58 > 1)
		 * 		58과 1의 자리를 교환
		 * 결과 [12, 56, 1, 58, 2, 80] 
		 * 반복 9, 3과 4를 비교 (58 > 2)
		 * 		58과 2의 자리를 교환
		 * 결과 [12, 56, 1, 2, 58, 80] 
		 * 반복 9, 4와 5를 비교 (58 > 80)
		 * 		아무런 일도 하지 않음
		 * 결과 [12, 56, 1, 2, 58, 80]
		 * [12, 56, 1, 2, 58, 80]
		 * [12, 1, 56, 2, 58, 80]
		 * [12, 1, 2, 56, 58, 80]
		 * [1, 12, 2, 56, 58, 80]
		 * [1, 2, 12, 56, 58, 80]
		 */
	}
}
