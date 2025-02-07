package com.ktdsuniversity.edu.inheritance.abstractclass;

// abstract class
/**
 * 추상 클래스의 제약사항
 *  - 어떻게 행동해야 할지 모르는 것을 표현하는 추상 메소드가 존재하는 추상 클래스는
 *    인스턴스로 만들 수 없다!!!
 *    -> 추상 클래스를 상속받아서 모든 추상 메소드가 구현되어 있는 클래스만 인스턴스로 만들 수 있다
 *  - 인스턴스로 만들 수 있는 것은 모든 것이 구현되어 있는 클래스 밖에 없다
 */
public abstract class Animal {

	protected boolean isLive;
	protected String place;
	protected boolean haveEgo;
	
	protected double temperature;
	protected double hungry;
	
	public Animal(String place, double temperature) {
		this.isLive = true;
		this.haveEgo = true;
		this.place = place;
		this.temperature = temperature;
		this.hungry = (int) (Math.random() * 100);
	}
	
	// abstract method
	public abstract void movement();
	
	public abstract void breath();
	
	public abstract void eat();

}
