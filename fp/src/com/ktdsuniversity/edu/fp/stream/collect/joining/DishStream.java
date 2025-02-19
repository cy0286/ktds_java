package com.ktdsuniversity.edu.fp.stream.collect.joining;

import java.util.stream.Collectors;

import com.ktdsuniversity.edu.fp.stream.data.DishList;
import com.ktdsuniversity.edu.fp.stream.data.Type;

public class DishStream {

	public String getOtherDishes() {
		// "프렌치 프라이, 쌀밥, 계절 과일, 피자" 반환시키기
		String otherDishe = DishList.get() // List<Dish>
				.stream() // Stream<Dish>
				.filter( dish -> dish.getType() == Type.OTHER) // Stream<Dish>
				.map( dish -> dish.getName()) // Stream<String>
				// joining -> Stream 안에 있는 문자열들을 하나로 합쳐라는 의미
				.collect( Collectors.joining(", ") ); // String
		return otherDishe;
	}
	
	public String getLowFatDishes() {
		// 400kcal 이하의 음식들의 이름들을 "-" 로 구분해서 하나의 문자열로 만든다
		String lowFat = DishList.get() // List<Dish>
										  .stream() // Stream<Dish>
										  .filter( dish -> dish.getCalories() <= 400) // Stream<Dish>
										  .map( dish -> dish.getName()) // Stream<String>
										  .collect( Collectors.joining(" - ")); // String
		return lowFat;
	}
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		String names = ds.getOtherDishes();
		System.out.println(names);
		
		names = ds.getLowFatDishes();
		System.out.println(names);
	}
}
