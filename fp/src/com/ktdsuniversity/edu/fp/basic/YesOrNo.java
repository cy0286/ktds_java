package com.ktdsuniversity.edu.fp.basic;

/**
 * 함수로 대체될 인터페이스
 */
@FunctionalInterface // 함수로 사용할 수 있는 인터페이스임을 명시
					 // 제약사항: 반드시 단 1개의 추상메소드만 존재해야 함
public interface YesOrNo {
	
	public boolean test(int value);
}