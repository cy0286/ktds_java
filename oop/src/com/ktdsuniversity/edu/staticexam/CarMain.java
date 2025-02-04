package com.ktdsuniversity.edu.staticexam;

// 클래스 변수/상수/메소드에 간편히 접근하기 위한 static import
// import static com.ktdsuniversity.edu.staticexam.Car.INSTANCE_COUNT;

public class CarMain {

	public static void main(String[] args) {
		
//		System.out.println( Car.instanceCount ); // 0
//		
//		Car car1 = new Car("경차");
//		System.out.println( Car.instanceCount ); // 1
//		
//		Car car2 = new Car("소형차");
//		System.out.println( Car.instanceCount ); // 2
		
		System.out.println( Car.INSTANCE_COUNT ); // 0
		
		Car car1 = new Car("경차");
		System.out.println( Car.INSTANCE_COUNT ); // 0
		
		Car car2 = new Car("소형차");
		System.out.println( Car.INSTANCE_COUNT ); // 0
		
		// static import 해서 사용할 수 있지만
		// Car 클래스에 있는 클래스 상수라는 것을 표기해주는 것이 좋음
//		System.out.println( INSTANCE_COUNT ); // 0
//		
//		Car car1 = new Car("경차");
//		System.out.println( INSTANCE_COUNT ); // 0
//		
//		Car car2 = new Car("소형차");
//		System.out.println( INSTANCE_COUNT ); // 0
	}
}
