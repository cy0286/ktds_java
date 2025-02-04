package com.ktdsuniversity.edu.staticexam;


public class AnimalMain {

	int numberOne = 10;
	int numberTwo = 20;
	
	// 이 코드는 static 에서 static 을 호출하지만 
	// static 을 지우고 실행하면 static 에서 인스턴스를 호출하고 있어서 메인에서 오류가 생김
	public static void calculator() {
		System.out.println("계산기 입니다.");
		
		// numberOne과 numberTwo에 static 을 붙이지 않고 쓰는 방법
		AnimalMain animalMain = new AnimalMain();
		System.out.println(animalMain.numberOne);
		System.out.println(animalMain.numberTwo);
	}
		
	public static void main(String[] args) {
		
		calculator();
		
		int number = NumberUtils.converToInt("3987123");
		System.out.println(number);
		
		boolean isDecimal = NumberUtils.isDecimalFormat("1238921");
		System.out.println(isDecimal);
		
		isDecimal = NumberUtils.isDecimalFormat("12a38921");
		System.out.println(isDecimal);
		
		Animal cat = new Animal("춘봉", "2015-01-01", 10);
		cat.printMyInformation(); // 인스턴스 메소드 호출
		
		Animal cat2 = Animal.createNewAnimal("첨지", "2016-01-01", 9); // 클래스 메소드 호출
		cat2.printMyInformation(); // 인스턴스 메소드 호출
		
		// System.out.println() 에서 println 은 인스턴스 메소드
		// out 은 클래스 메소드에 해당함
		
	}
}
