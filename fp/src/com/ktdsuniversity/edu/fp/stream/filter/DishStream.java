package com.ktdsuniversity.edu.fp.stream.filter;

import com.ktdsuniversity.edu.fp.stream.data.DishList;

public class DishStream {

	public void printVegetarian() {
		// . 단위로 enter 를 해주면 가독성이 좋음
		// Stream => 내부 반복자
		// 			 직접 반복을 시키지 않는다 => Stream 내부에서 반복을 진행한다
		DishList.get() // List<Dish>
				.stream() // Stream<Dish>
				// Stream<Dish> 지금 반복중인것이 무엇인지 관찰하는 디버깅용 함수
				// .peek( (ed) -> System.out.println("before filter: " + ed.getName() + " / " + ed.getisVegetarian()) ) 
				.filter( (ed) -> ed.getisVegetarian() ) // Stream<Dish>
				// .peek( (ed) -> System.out.println("after filter: " + ed.getName() + " / " + ed.getisVegetarian()) )
				.forEach( (ed) -> System.out.println(ed + " / " + ed.getisVegetarian() )); // void
				// peek 은 디버깅용 이므로 확인한 후 지워주어야 함
		
		/*
		 * 동작 순서
		 * 1. .stream() 돼지고기 => vegetarian : false
		 * 	  .filter() 돼지고기는 채식이냐?
		 * 	  .forEach() 실행안함
		 * 2. .stream() 소고기 => vegetarian : false
		 * 	  .filter() 소고기는 채식이냐?
		 * 	  .forEach() 실행안함
		 * 3. .stream() 치킨 => vegetarian : false
		 * 	  .filter() 치킨은 채식이냐?
		 * 	  .forEach() 실행안함
		 * 4. .stream() 프렌치 프라이 => vegetarian : true
		 * 	  .filter() 프렌치 프라이는 채식이냐?
		 * 	  .forEach() 실행 => 요리명 출력
		 * 5. .stream() 쌀밥 => vegetarian : true
		 * 	  .filter() 쌀밥은 채식이냐?
		 * 	  .forEach() 실행 => 요리명 출력
		 * 6. .stream() 계절 과일 => vegetarian : true
		 * 	  .filter() 계절 과일은 채식이냐?
		 * 	  .forEach() 실행 => 요리명 출력
		 * 7. .stream() 피자 => vegetarian : true
		 * 	  .filter() 피자는 채식이냐?
		 * 	  .forEach() 실행 => 요리명 출력
		 * 8. .stream() 새우 => vegetarian : false
		 * 	  .filter() 새우는 채식이냐?
		 * 	  .forEach() 실행안함
		 * 9. .stream() 연어 => vegetarian : false
		 * 	  .filter() 연어는 채식이냐?
		 * 	  .forEach() 실행안함
		 */
	}
	
	public void printLowCaloryVegetarian() {
		DishList.get() // List<Dish>
				.stream() // Stream<Dish>
				// .filter( (ed) -> ed.getisVegetarian() && ed.getCalories() <= 300) 이렇게 하는 방법도 있겠지만 filter 를 여러개 쓰는 방법이 있음
				.filter( (ed) -> ed.getisVegetarian() ) // Stream<Dish>
				// .peek( (ed) -> System.out.println("before filter: " + ed.getName() + " / " + ed.getCalories()) )
				.filter( (ed) -> ed.getCalories() < 300) // Stream<Dish> 300 칼로리 미만의 음식만 걸러낸다
				// .peek( (ed) -> System.out.println("after filter: " + ed.getName() + " / " + ed.getCalories()) )
				.forEach( (ed) -> System.out.println(ed + " / " + ed.getCalories()) ); // void
	}
		
	public static void main(String[] args) {
		
		DishStream ds = new DishStream();
		ds.printVegetarian();
		ds.printLowCaloryVegetarian();
	}
}
