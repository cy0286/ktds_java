package com.ktdsuniversity.edu.fp.stream.collect.tolist;

import java.util.List;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.fp.stream.data.Dish;
import com.ktdsuniversity.edu.fp.stream.data.DishList;
import com.ktdsuniversity.edu.fp.stream.data.Type;

public class DishStream {

	public List<String> getOtherDishes() {
		List<String> otherDishe = DishList.get() // List<Dish>
										  .stream() // Stream<Dish>
										  .filter( dish -> dish.getType() == Type.OTHER) // Stream<Dish>
										  .map( dish -> dish.getName()) // Stream<String>
										  // .collect( Collectors.toList() ); // List<String>
										  .toList();
		return otherDishe;
	}
	
	public List<Dish> getLowFatDishes() {
		List<Dish> lowFat = DishList.get() // List<Dish>
									.stream() // Stream<Dish>
							    	.filter( dish -> dish.getCalories() <= 400) // Stream<Dish>
									//.collect( Collectors.toList() ); // List<Dish>
							    	.toList();
									// toList() java 16 이상에서만 사용가능함
									// 사용중인 java 의 버전이 15 이하일 때는 .collect( Collectors.toList()) 를 사용
		return lowFat;
	}

	public List<Dish> getMenuWithougFIshType() {
		// FISH 타입의 요리만 제외하고 모두 리스트로 변환해 반환
		List<Dish> exceptFish = DishList.get() // List<Dish>
										.stream() // Stream<Dish>
										.filter( dish -> dish.getType() != Type.FISH) // Stream<Dish>
										.toList(); //List<Dish>
		return exceptFish;
	}
	
	public List<String> getVegetableAndMeatMenu() {
		// 채식요리와 육류요리의 이름을 리스트로 변환해 반환
		List<String> vegetableAndMeat = DishList.get() // List<Dish>
												.stream() // Stream<Dish>
												.filter( dish -> dish.getisVegetarian() || dish.getType() == Type.MEAT) // Stream<Dish>
												.map( dish -> dish.getName()) // Stream<String>
												.toList(); // List<String>
		return vegetableAndMeat;
	}
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		List<String> names = ds.getOtherDishes();
		// System.out.println(names);
		names.forEach( name -> System.out.print(name + " ") );
		System.out.println();
		System.out.println("=".repeat(30));
		
		List<Dish> lowFatNames = ds.getLowFatDishes();
		//System.out.println(lowFatNames);
		lowFatNames.forEach( dish -> {
			System.out.print(dish.getName() + " / ");
			System.out.print(dish.getCalories() + " / ");
			System.out.print(dish.getisVegetarian() + " / ");
			System.out.println(dish.getType());
		} );
		System.out.println("=".repeat(30));
		
		List<Dish> exceptFishName = ds.getMenuWithougFIshType();
		exceptFishName.forEach( dish  -> System.out.print(dish.getName() + " ") ) ;
		System.out.println();
		System.out.println("=".repeat(30));
		
		names = ds.getVegetableAndMeatMenu();
		names.forEach( name -> System.out.print(name + " ") );
	}
}
