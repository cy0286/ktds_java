package com.ktdsuniversity.edu.fp.stream.find.match;

import com.ktdsuniversity.edu.fp.stream.data.DishList;
import com.ktdsuniversity.edu.fp.stream.data.Type;

public class DishStream {

	public void anyMatch() {
		// 채식요리가 하나라도 있는지 확인해보자
		boolean hasVegetarian = DishList.get() // List<Dish>
										.stream() // Stream<Dish>
										.anyMatch( dish -> dish.getisVegetarian() ); // boolean
		if (hasVegetarian) {
			System.out.println("채식요리가 있는 식당입니다.");			
		}
		
		// 육류요리 중에 칼로리가 300 미만인것이 있는지 확인해보자
		boolean haveLowCaloryMeat = DishList.get() // List<Dish>
											.stream() // Stream<Dish>
											.filter(dish -> dish.getType() == Type.MEAT) // Stream<Dish>
											.anyMatch(dish -> dish.getCalories() < 300); // booelan
		if (haveLowCaloryMeat) {
			System.out.println("저칼로리 육류요리가 있는 식당입니다.");
		}
	}
	
	public void allMatch() {
		// 모든 요리가 채식요리인지 확인해보자
		boolean isAllVegetarian = DishList.get()
										.stream()
										.allMatch( dish -> dish.getisVegetarian() );
		if (isAllVegetarian) {
			System.out.println("모든 요리가 채식요리인 식당입니다.");
		}
		
		// 모든 어류 요리의 칼로리가 500 미만인지 확인해보자
		boolean isAllLowFish = DishList.get()
											.stream()
											.filter(dish -> dish.getType() == Type.FISH)
											.allMatch(dish -> dish.getCalories() < 500);
		if (isAllLowFish) {
			System.out.println("모든 어류요리는 500kcal 미만입니다.");
		}
		
		// 모든 어류 요리의 칼로리가 500 이상인지 확인해보자
		boolean isAllFatFish = DishList.get()
										.stream()
										.filter(dish -> dish.getType() == Type.FISH)
										.allMatch(dish -> dish.getCalories() < 500);
		if (isAllFatFish) {
			System.out.println("모든 어류요리는 500kcal 이상입니다.");
		}
	}
	
	public void noneMatch() {
		// 육류 요리중에 채식 요리가 없는지 확인해보자
		boolean haveNotWeiredFood = DishList.get()
										.stream()
										.filter(dish -> dish.getType() == Type.MEAT)
										.noneMatch(dish -> dish.getisVegetarian());
		if (haveNotWeiredFood) {
			System.out.println("이상한 음식은 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		ds.anyMatch();
		ds.allMatch();
		ds.noneMatch();
	}
}
