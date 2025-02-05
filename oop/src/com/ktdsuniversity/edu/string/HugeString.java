package com.ktdsuniversity.edu.string;

public class HugeString {

	public static String makeString() {
		String str = "";
		
		for ( int i = 0; i < Short.MAX_VALUE * 100; i++) { // 약 21억번 반복
			str += "A";
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		
		System.out.println("1. 문자열을 생성합니다.");
		String one = makeString();
		
		System.out.println("2. 문자열을 생성합니다.");
		String two = makeString();
		
		System.out.println("3. 문자열을 합쳐봅니다.");
		String thiree = one + two;
		
		System.out.println(thiree);
	}
}
