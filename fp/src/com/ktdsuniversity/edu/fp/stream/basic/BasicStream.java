package com.ktdsuniversity.edu.fp.stream.basic;

import java.nio.file.DirectoryStream.Filter;
import java.util.List;
import java.util.stream.Stream;

import com.ktdsuniversity.edu.fp.stream.data.Dish;
import com.ktdsuniversity.edu.fp.stream.data.DishList;

public class BasicStream {

	public void run() {
		// Stream 은 최종연산 없이는 동작되지 않는다
		DishList.get()	
				.stream()
				.peek(dish -> System.out.println("최종연산 없는 스트림: " + dish)) // 결과 나오지 않음
				.filter(dish -> dish.getisVegetarian());
		
	 	long count = DishList.get()	
	 						 .stream()
	 						 .peek(dish -> System.out.println("최종연산 있는 스트림: " + dish))
	 						 .filter(dish -> dish.getisVegetarian())
	 						 .count(); // 최종연산 long 반환
	 	System.out.println(count);
	}
	
	public void printMenuStream() {
		// 1. 요리 목록 가져온다.
		List<Dish> menuList = DishList.get();
		
		// 2. Stream 을 이용해서 출력한다.
		// 2-1. List<Dish> 를 Stream<Dish> 로 변경한다.
		//		Stream = 내부 반복자 / Stream 내부에서 모든 반복이 이루어진다.
		//							 Stream 외부에서는 반복을 할때마다 처리해야하는 함수만 전달한다.
		Stream<Dish> menuStream = menuList.stream();
		// Stream 을 통해서 Predicate, Function, Consumer 함수를 사용할 수 있음
		
		// 2-2 	Stream 의 내용을 반복하면서 출력한다.
		// foreach 가 void 를 반환시킴 -> 타입을 무시할 수 있어서 아래처럼 쓸 수 있음
		menuStream.forEach( (eachDish) -> System.out.println("In stream: " + eachDish));
		
		// stream 을 위처럼 쓰지 않음
		// TO-BE 
		menuList.stream() // -> Stream<Dish>
				.forEach( (ed) -> System.out.println("In stream2: " + ed)); 
	}
	
	public void printMenuNotStream() {
		// 1.  요리 목록 가져온다
		List<Dish> menuList = DishList.get();
		
		// 2. for-each 를 이용해서 출력한다.
		for (Dish eachMenu : menuList) {
			System.out.println(eachMenu);
		}
	}
	
	public static void main(String[] args) {
		BasicStream bs = new BasicStream();
		bs.printMenuNotStream();
		bs.printMenuStream();
		bs.run();
	}
}
