package com.ktdsuniversity.edu.enumexam;

public enum OperType {
	ADD, SUB, MUL, DIV;
	
	// 괄호 안에 값을 줄 수도 있지만 잘 쓰지 않음
	// ADD(1), SUB(2), MUL(3), DIV(4);
	
//	enum 마다 값을 부여시키기 위한 생성자로 외부에서 사용할 수 없음
//	public int value;
//	OverType(int value) {
//	this.value = value;
//	}
}
