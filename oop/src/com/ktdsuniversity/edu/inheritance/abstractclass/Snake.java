package com.ktdsuniversity.edu.inheritance.abstractclass;

public class Snake extends Animal{
	
	public Snake(String place) {
		super(place, 30);
	}
	
	@Override
	public void movement() {
		super.hungry += 1;
		if (super.hungry >= 99) {
			super.hungry = 99;
		}
		
		super.temperature += 1;
		
		if (super.temperature >= 40) {
			super.temperature = 40;
		}

		System.out.println("뱀이 " + super.place +"에서 스르륵 움직입니다.");
	}
	
	@Override
	public void breath() {
		super.hungry += 0.3;
		if (super.hungry >= 99) {
			super.hungry = 99;
		}
		
		super.temperature -= 0.1;
		if (super.temperature < 40) {
			super.temperature = 40;
		}
		
		System.out.println("뱀이" + super.place +"에서 숨을 쉽니다.");
	
	}
	
	@Override
	public void eat() {
		if (super.hungry == 99) {
			System.out.println("뱀이 매우 배가 고픕니다. 벌레를 허겁지겁 먹습니다." );
		}
		else {
			System.out.println("뱀이 배부릅니다." );
		}	
		
		System.out.println("배고픔 정도: " + super.hungry);
	}
}
