package com.ktdsuniversity.edu.fp.stream.map;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.fp.stream.data.DishList;

public class DishStream {

	public void printStringToInteger() {
		
		List<String> numberStringList = List.of("100", "200", "5", "11", "22", "7");
		// 각 문자들을 숫자로 바꿔서 출력
		numberStringList.stream() // Stream<String>
						// .peek( (str) -> System.out.println("before map: " + str.getClass()) ) // Stream<String>
						// stream 의 제네릭은 반환시키는 결과를 줬을 때 (데이터를 줄 때) 결정이 됨
						.map((str) -> Integer.parseInt(str)) // Stream<Integer>						
						// .peek( (number) -> System.out.println("after map: " + number.getClass()) ) // Stream<Integer>
						.forEach( (number) -> System.out.println(number) );
	}
	
	public void printStringToInteger2() {
		
		List<String> numberStringList = List.of("100", "20A0", "5", "1a1", "22", "7"); // -> NumberFormatException
		// 각 문자들을 숫자로 바꿔서 출력
		numberStringList.stream() // Stream<String>
						// .peek( (str) -> System.out.println("before map: " + str.getClass()) ) // Stream<String>
						.filter( (str) -> str.matches("^[0-9]+$"))
						// stream 의 제네릭은 반환시키는 결과를 줬을 때 (데이터를 줄 때) 결정이 됨
						.map((str) -> Integer.parseInt(str)) // Stream<Integer>						
						// .peek( (number) -> System.out.println("after map: " + number.getClass()) ) // Stream<Integer>
						.forEach( (number) -> System.out.println(number) );
	}
	
	public void printStringAppendLowerCase() {
		System.out.println("=".repeat(30));
		
		List<String> letterList = new ArrayList<>();
		// 65 ~ 90
		for (int i = 65; i < 91; i++) {
			letterList.add( ( (char) i ) + "");
		}
		System.out.println(letterList);
		// letterList[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
		// letterList[Aa, Bb, Cc, Dd, Ee, Ff, Gg, Hh, Ij, ... Zz]
		// 1. +
		// 2. toLowerCase: "A".toLowerCase() => "a"
		letterList.stream()
				  .map( (str) -> str + str.toLowerCase())
				  .forEach( (str) -> System.out.print( str + " "));
		System.out.println();
	}
	
	public void printOddLetters() {
		// A = 65
		// B = 66
		// C = 67
		// D = 68
		// ..
		// X = 88
		// Y = 89
		// Z = 90
		System.out.println("=".repeat(30));
		
		List<String> letterList = new ArrayList<>();
		// 65 ~ 90
		for (int i = 65; i < 91; i++) {
			// 'A' + "" => "A"
			letterList.add( ( (char) i ) + "");
		}
		
		// "A" => 65
		String a = "ABC";
		int ascii = a.charAt(0);
		System.out.println(ascii);
		
		// 65 => "A"
		int num = 65;
		String a2 = ((char) num) + " " ;
		System.out.println(a2);
		// letterList[A, B, C, D, E, F, G, H, I, J, ... Z]
		// 각 아스키코드가 홀수인것만 출력
		// 1. 각 문자열을 아스키코드로 변경
		// 2. 아스키코드가 홀수인것만 추려내서
		// 3. 아스키코드를 문자열로 바꾸고
		// 4. 출력
		letterList.stream() // Stream<String>
				  .map( (letter) -> letter.charAt(0) + 0) // Stream<Integer> 
				  .filter( (asciiCode) -> asciiCode % 2 == 1) // Stream<Integer>
				  .map( (asciiCode) -> ((char) asciiCode.intValue())+ " " ) //Integer -> int -> char -> String Stream<String>
				  .forEach( (letter) -> System.out.print(letter + " ") ); 
		System.out.println();
	}
	
	public void printDishesType() {
		System.out.println("=".repeat(30));
		/*
		 * Dish
		 * - name: String
		 * - vegetarian: boolean
		 * - calories: int
		 * - type: Type
		 * 
		 * Stream<Dish> -> Stream<Type> -> 출력
		 */
		DishList.get()
				.stream() // Stream<Dish>
				.map( (dish) -> (dish.getType())) // Stream<Type>
				.forEach( (type) -> System.out.println(type));
	}
	
	public void printDishesCalories() {
		System.out.println("=".repeat(30));
		/*
		 * Dish
		 * - name: String
		 * - vegetarian: boolean
		 * - calories: int
		 * - type: Type
		 * 
		 * Stream<Dish> -> Stream<Integer: 요리의 칼로리> -> 출력
		 */
		DishList.get()
				.stream() // Stream<Dish>
				// .map( dish -> dish.getCalories()) input 이 1개면 () 생략 가능
				.map( (dish) -> dish.getCalories() ) // Stream<Integer>
				.forEach( (calories) -> System.out.println(calories) );
	}

	public void printDishesTypeDistinct() {
		System.out.println("=".repeat(30));
		DishList.get()
				.stream() // Stream<Dish>
				.map( (dish) -> (dish.getType())) // Stream<Type>
				.distinct() // Stream<Type> 에서 중복된 거 전부 제거함
				.forEach( (type) -> System.out.println(type));
	}
	
	public void printDishesCaloriesDistinct() {
		System.out.println("=".repeat(30));
		// 요리들의 칼로리를 중복을 제거해서 출력
		DishList.get()
				.stream()
				.map( (dish) -> dish.getCalories() )
				.distinct()
				.forEach( (calories) -> System.out.println(calories) );
	}
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		ds.printStringToInteger();
		ds.printStringToInteger2();
		
		ds.printStringAppendLowerCase();
		ds.printOddLetters();
		
		ds.printDishesType();
		ds.printDishesCalories();
		ds.printDishesTypeDistinct();
		ds.printDishesCaloriesDistinct();
	}
}
