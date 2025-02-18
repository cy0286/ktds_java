package com.ktdsuniversity.edu.fp.stream.slice;

import com.ktdsuniversity.edu.fp.stream.data.DishList;
import com.ktdsuniversity.edu.fp.stream.data.Type;

public class DishStream {

	public void printMenuSkip(int skip) {
		// 프렌치 프라이, 쌀밥, 계절 과일, 피자, 새우, 연어 출력
		// 전체 스트림에서 skip 만큼 건너뛰고 나머지를 모두 출력
		DishList.get()
				.stream()
				//.peek( (ed) -> System.out.println("before skip: " + ed) )
				.skip(skip)
				//.peek( (ed) -> System.out.println("after skip: " + ed) )
				.forEach( (ed) -> System.out.println(ed) );
	}

	public void printMenuLimit(int limit) {
		System.out.println("=".repeat(30));
		// 돼지고기, 소고기, 치킨, 프렌치 프라이 출력 
		// 전체 스트림에서 limit 만큼만 가져와 출력
		DishList.get()
				.stream()
				// .peek( (ed) -> System.out.println("before limit: " + ed) )
				.limit(limit)
				// .peek( (ed) -> System.out.println("after limit: " + ed) )
				.forEach( (ed) -> System.out.println(ed) );
	}

	public void printMenuLimitAndSkip(int limit, int skip) {
		System.out.println("=".repeat(30));
		// 치킨, 프렌치 프라이, 쌀밥 출력
		DishList.get()
				.stream()
				.limit(limit)
				.skip(skip)
				.forEach( (ed) -> System.out.println(ed) );
		
	}
	
	public void printMenuSkipAndLimit(int skip, int limit) {
		System.out.println("=".repeat(30));
		// 치킨, 프렌치 프라이, 쌀밥, 계절 과일, 피자, 새우 출력
		DishList.get()
				.stream()
				.skip(skip)
				.limit(limit)
				.forEach( (ed) -> System.out.println(ed) );
	}
	
	public void printMeatDishesLimit(int limit) {		
		System.out.println("=".repeat(30));
		// 육류 음식을 limit 개만 출력
		DishList.get()
				.stream()
				.filter( (ed) -> ed.getType() == Type.MEAT )
				.limit(limit)
				.forEach( (ed) -> System.out.println(ed) );
	}
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		// 프렌치 프라이, 쌀밥, 계절 과일, 피자, 새우, 연어 출력
		ds.printMenuSkip(3);
		
		// 돼지고기, 소고기, 치킨, 프렌치 프라이 출력 
		ds.printMenuLimit(4);
		
		// 치킨, 프렌치 프라이, 쌀밥 출력
		ds.printMenuLimitAndSkip(5, 2);
		
		// 치킨, 프렌치 프라이, 쌀밥, 계절 과일, 피자, 새우 출력
		ds.printMenuSkipAndLimit(2, 6);
		
		// 돼지고기 출력
		ds.printMeatDishesLimit(1);
		
		// 돼지고기, 소고기 출력
		ds.printMeatDishesLimit(2);
		
		// 돼지고기, 소고기, 치킨 출력
		ds.printMeatDishesLimit(3);
 
		// 돼지고기, 소고기, 치킨 출력
		ds.printMeatDishesLimit(5);
	}
}
