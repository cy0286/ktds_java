package com.ktdsuniversity.edu.staticexam;

public class Animal {

	// 멤버변수 = 인스턴스 변수 = 인스턴스로만 접근가능한 변수
	private String name;
	private String birthdate;
	private int age;
	
	// 생성자 = 인스턴스 생성자 = 인스턴스를 만들어주는 메소드
	public Animal(String name, String birthdate, int age) {
		this.name = name;
		this.birthdate = birthdate;
		this.age = age;
	}
	
	// 메소드 = 인스턴스 메소드 = 인스턴스로만 호출할 수 있는 메소드
	public void printMyInformation() {
		System.out.println("Name: " + this.name);
		System.out.println("Birthdate: " + this.birthdate);
		System.out.println("Age: " + this.age);
	}
	
	//  Factory Pattern
	public static Animal createNewAnimal(String name, String birthdate, int age) {
//		Animal newAnimal = new Animal(name, birthdate, age);
//		return newAnimal;
//		위 두 줄을 줄여서 아래의 한 줄로 나타낼 수 있음
		return new Animal(name, birthdate, age);
	}
}
