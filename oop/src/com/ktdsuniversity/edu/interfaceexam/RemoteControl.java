package com.ktdsuniversity.edu.interfaceexam;

public interface RemoteControl {
	
	// interface 에는 상수만 정의가 가능하다
	public String MANUFACTOR = "1";
	
	// interface 에서 정의하는 모든 메소드들은 추상메소드이다
	// abstract 를 생략하더라도 추상메소드가 됨
	public void powerOn();
	public void powerOff();
	
	// interface 에만 만들 수 있음
	// default 를 사용해서 추상 메소드지만 기본적으로 이런 역할을 해! 라고 process 를 만들 수 있음
	public default void process() {
		this.powerOn();
		this.powerOff();
	}
}
