package com.ktdsuniversity.edu.fp.stream.data;

import java.util.Arrays;
import java.util.List;

public class DishList {

	public static List<Dish> get() {
		List<Dish> menu = Arrays.asList( 
				  new Dish("돼지고기", false, 800, Type.MEAT), 
				  new Dish("소고기", false, 700, Type.MEAT), 
				  new Dish("치킨", false, 400, Type.MEAT), 
				  new Dish("프렌치 프라이", true, 530, Type.OTHER), 
				  new Dish("쌀밥", true, 350, Type.OTHER), 
				  new Dish("계절 과일", true, 120, Type.OTHER), 
				  new Dish("피자", true, 550, Type.OTHER), 
				  new Dish("새우", false, 300, Type.FISH), 
				  new Dish("연어", false, 450, Type.FISH));
		return menu;
	}
}
