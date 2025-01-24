package com.ktdsuniversity.edu.fruitseller;

public class Mart {

	public static void main(String[] args) {
		
		FruitSeller coupang = new FruitSeller(100, 1000);
		
		coupang.sell(10); // money, fruitStock이 변경
		coupang.sell(5); // money, fruitStock이 변경
		coupang.sell(7); // money, fruitStock이 변경
		coupang.sell(20); // money, fruitStock이 변경
		coupang.sell(1); // money, fruitStock이 변경
		coupang.sell(30); // money, fruitStock이 변경
		
		System.out.println(coupang.getMoney());
		System.out.println(coupang.getFruitStock());
	}
}