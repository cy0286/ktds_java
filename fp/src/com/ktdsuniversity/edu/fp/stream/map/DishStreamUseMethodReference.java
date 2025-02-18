package com.ktdsuniversity.edu.fp.stream.map;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.fp.stream.data.Dish;
import com.ktdsuniversity.edu.fp.stream.data.DishList;

public class DishStreamUseMethodReference {

	public void printStringToInteger() {
		
		List<String> numberStringList = List.of("100", "200", "5", "11", "22", "7");
		numberStringList.stream()
						.map( Integer :: parseInt)
						.forEach( System.out :: println);
	}
	
	public void printStringToInteger2() {
		
		List<String> numberStringList = List.of("100", "20A0", "5", "1a1", "22", "7"); // -> NumberFormatException
		numberStringList.stream()
						.filter( (str) -> str.matches("^[0-9]+$"))
											
						// 메소드 레퍼런스
						// parseInt라는 메소드 자체를 보내고 싶은 경우 ()를 생략함
						// 메소드를 함수로 전달해라 라는 뜻
						// 함수보다 간결해서 사용함
						.map( Integer :: parseInt ) 
						//.map((str) -> Integer.parseInt(str)) 	

						.forEach( System.out :: println );
						// .forEach( (number) -> System.out.println(number) );
	}
	
	public void printStringAppendLowerCase() {
		System.out.println("=".repeat(30));
		
		List<String> letterList = new ArrayList<>();
		// 65 ~ 90
		for (int i = 65; i < 91; i++) {
			letterList.add( ( (char) i ) + "");
		}
		letterList.stream()
				  .map( (str) -> str + str.toLowerCase())
				  .forEach( System.out :: println );
	}
	
	public void printOddLetters() {
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

		letterList.stream()
				  .map( (letter) -> letter.charAt(0) + 0) 
				  .filter( (asciiCode) -> asciiCode % 2 == 1) 
				  .map( (asciiCode) -> ((char) asciiCode.intValue())+ " " ) 
				  .forEach( System.out :: println);
	}
	
	public void printDishesType() {
		System.out.println("=".repeat(30));

		DishList.get()
				.stream() 
				.map( Dish :: getType )
				.forEach( System.out :: println );
		}
	
	public void printDishesCalories() {
		System.out.println("=".repeat(30));
		DishList.get()
				.stream()
				.map( Dish :: getCalories)
				.forEach( System.out :: println);
	}

	public void printDishesTypeDistinct() {
		System.out.println("=".repeat(30));
		DishList.get()
				.stream() 
				.map( Dish :: getType )
				.distinct()
				.forEach( System.out :: println );
	}
	
	public void printDishesCaloriesDistinct() {
		System.out.println("=".repeat(30));
		DishList.get()
				.stream()
				.map( Dish :: getCalories)
				.distinct()
				.forEach( System.out :: println);
	}
	
	public static void main(String[] args) {
		DishStreamUseMethodReference ds = new DishStreamUseMethodReference();
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
