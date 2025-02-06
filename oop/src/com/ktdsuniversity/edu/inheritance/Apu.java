package com.ktdsuniversity.edu.inheritance;

/**
 * Cpu 클래스를 확장시켜서 새롭게 만든 클래스
 * Classname extends SupserClass
 * 
 * SuperClass 에 생성자가 하나라도 존재한다면
 * SubClass 에서는 생성자 중 하나 이상을 반드시 구현해야 한다
 * 	구현 생성자 내부에서는 SuperClass의 (같은 형태의) 생성자를 반드시 호출해야 한다 (상속(확장)의 규칙)
 */
public class Apu extends Cpu{
	
	public Apu(String menufactor, String seriesNumber) {
		// super <-- SuperClass의 instance (정확하게는 Super Class 원본)
		// 즉 super() <-- Super Class(Cpu)의 기본 생성자를 호출하는 코드
		super(menufactor, seriesNumber);
	}
	
	public void draw() {
		System.out.println("그림을 그립니다....................");
	}

	/**
	 * Method Overriding
	 * 부모가 가진 특정한 기능을 다시 덮어 쓴다
	 * Cpu.calculate()의 기능을 다시 뜯어고치기
	 * Cpu.calculate()의 원래 기능도 그대로 실행시키고 싶음
	 */
	@Override // Super class 의 calculate() 메소드를 재정의한다 ~ 라고 정의하는 것
	public void calculate() {
		// 상속된 클래스에서는 웬만하면 Override 를 사용하지 않음
		// super class가 원래 method가 가지고 있던 의도를 subclass에서 바꾸면 훼손될 수 있음
		// super.calculate();
		System.out.println("그림을 그리면서 2진수 계산도 합니다.");
	}
}