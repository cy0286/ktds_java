package com.ktdsuniversity.edu.staticexam;

public class Car {

	// 클래스 변수 (스태틱 변수)
	// OOP 프로젝트 내부 어디서나 접근가능한 클래스 변수
	// com.ktdsuniversity.edu.staticexam.Car.instanceCount = 11; -> 어디서나 접근 가능함
	// public static int instanceCount = 0;
	
	// 클래스 상수 (스태틱 상수)
	// OOP 프로젝트 내부 어디서나 접근가능한 클래스 상수
	public static final int INSTANCE_COUNT = 0;
	
	// 멤버변수 (인스턴스 변수) 
	private String name;
	
	public Car(String name) {
		// 1. 클래스 변수의 값을 1 증가시킴
		//    Car 타입의 인스턴스가 만들어질 때마다 값이 1씩 증가함
		// Car.instanceCount += 1;
		// this.instanceCount += 1; -> The static field Car.instanceCount should be accessed in a static way
		// 접근이 잘못되어서 값이 잘못 될 수도 있기 때문에 생기는 Warning
	
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
