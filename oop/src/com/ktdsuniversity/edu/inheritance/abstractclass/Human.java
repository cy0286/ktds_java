package com.ktdsuniversity.edu.inheritance.abstractclass;

public class Human extends Animal {
	
	private String name;
	private int age;
	
	public Human(String name, int age, String place) {
		super(place, 36.5);
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void movement() {
		super.hungry += 10;
		if (super.hungry >= 99) {
			super.hungry = 99;
		}
		
		super.temperature += 0.3;
		
		if (super.temperature >= 42) {
			super.temperature = 42;
		}
		
		System.out.println(this.age + "세 사람 " + this.name + "이 " + super.place +"에서 두 발로 걸어갑니다.");
		System.out.println(this.age + "세 사람 " + this.name + " 생존여부: " + super.isLive);
		System.out.println(this.age + "세 사람 " + this.name + " 자아여부: " + super.haveEgo);
	}
	
	@Override
	public void breath() {
		super.hungry += 5;
		if (super.hungry >= 99) {
			super.hungry = 99;
		}
	
		super.temperature -= 0.1;
		if (super.temperature < 36.5) {
			super.temperature = 36.5;
		}
		
		if(super.temperature > 40) {
			System.out.println("사람 " + this.name + "이 매우 아픕니다.");
		}
		else {
			System.out.println("사람 " + this.name + "이 조금 열이 납니다.");
		}
		
		System.out.println("현재 체온은 " + super.temperature +"도 입니다.");
	}
	
	@Override
	public void eat() {
		super.hungry -= 5;
		if (super.hungry < 0) {
			super.hungry = 0;
		}
		
		if (super.hungry > 80) {
			System.out.println("사람 " + this.name + "이 매우 배가 고픕니다. 밥을 허겁지겁 먹습니다." );
		}
		else if (super.hungry > 70) {
			System.out.println("사람 " + this.name + "이 배고픔을 느낍니다. 밥을 먹습니다." );
		}		
		else if (super.hungry > 50) {
			System.out.println("사람 " + this.name + "이 출출함을 느낍니다. 밥을 먹습니다." );
		}	
		else {
			System.out.println("사람 " + this.name + "이 입이 심심함을 느낍니다. 간식을 먹습니다." );
		}	
		
		System.out.println("배고픔 정도: " + super.hungry);
		

	}
}
