package com.ktdsuniversity.edu.fp.stream.find.find;

import java.util.Optional;

import com.ktdsuniversity.edu.fp.stream.data.Dish;
import com.ktdsuniversity.edu.fp.stream.data.DishList;
import com.ktdsuniversity.edu.fp.stream.data.Type;

public class DishStream {

	public void findAny() {
		// 육류 음식 중 4개음식은 건너뛰고 5개를 가져와서 
		// 그 중 아무 음식만 가져온다
		Optional<Dish> anyDish = DishList.get() // List<Dish>
									  .stream() // Stream<Dish>
									  .filter(dish -> dish.getType() == Type.MEAT) // Stream<Dish>
									  .skip(4) // Stream<Dish>
									  .limit(5) // Stream<Dish>
									  .findAny(); // Optional<Dish>
		System.out.println(anyDish); // Optional.empty
		
		// 데이터가 없을 때 이렇게 하라는 코드
		if (anyDish.isPresent()) {

			String anyDishName = anyDish.get()
										.getName();
			System.out.println(anyDishName); // 데이터가 없어서 NoSuchElementException error 발생
		}
		
		// 데이터가 없으면 기본값으로 출력해라
		Dish anyDishOrDefault = anyDish.orElse( new Dish("그런거 없습니다.", false, 0, null) ); // 데이터가 있으면 있는 데이터를 주고 없으면 기본값을 만들어서 달라는 뜻
		System.out.println(anyDishOrDefault); // 그런거 없습니다.
		
		// findAny 를 할 경우 데이터가 있다 없다를 보장을 못 하기 때문에 Optional 을 무조건 주어야 함
		Optional<Dish> anyDish2 = DishList.get() // List<Dish> 
										  .stream() // Stream<Dish>
										  .findAny(); //Optional<Dish>
		System.out.println(anyDish2); // Optional[돼지고기]
		
		String dishName = anyDish2.get() // Dish
								  .getName(); // String
		System.out.println(dishName); // 돼지고기
		
		
		// 실무에서는 이렇게 합니다
		Dish anyDish3 = DishList.get() // List<Dish>
								.stream() // Stream<Dish>
								.filter(dish -> dish.getType() == Type.MEAT) // Stream<Dish>
								.skip(4) // Stream<Dish>
								.limit(5) // Stream<Dish>
								.findAny() // Optional<Dish>
								.orElse(null); // Dish -> 없으면 null 을 출력해라
		if (anyDish3 != null) {
			System.out.println(anyDish3); // null			
		}
	}	
	
	public void findFirst() {
		System.out.println("=".repeat(30));
		Dish firstDish =  DishList.get() // List<Dish>
				.stream() // Stream<Dish>
				.findFirst() //Optional<Dih>
				.orElse(null);
		System.out.println(firstDish);
	}
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		ds.findAny();
		ds.findFirst();
	}
}
