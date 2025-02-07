package com.ktdsuniversity.edu.inheritance.abstractclass;

public class RealWorld {
	
	public static void behavior(Animal animal) {
		
		for (int i = 0; i < 10; i++) {
			animal.movement();
			animal.movement();
			animal.breath();
			animal.eat();
		}
	}
	
	public static void main(String[] args) {
		
		// Animal 이 추상 클래스기 때문에 인스턴스로 만들 수 없음
		// Animal dog = new Dog("house");
		
		Animal dog = new Dog("두치 집", "뿌꾸");
		// 매번 이렇게 호출하는 것이 번거로움 -> behavior method 만듦
//		dog.movement();
//		dog.breath();
//		dog.eat();
		behavior(dog);
		
		Animal human = new Human("송채영", 24, "집");
		behavior(human);
		
		Animal snake = new Snake("야산");
		behavior(snake);

	}
}
