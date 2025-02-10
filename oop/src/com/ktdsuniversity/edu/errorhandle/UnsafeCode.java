package com.ktdsuniversity.edu.errorhandle;

import java.util.Scanner;

public class UnsafeCode {

	public static void throwNullPointerException() {
		String age = "40";
		boolean isSameAge = age.equals("40");
		System.out.println(isSameAge);
		
		// Null pointer access: The variable name can only be null at this location
		/*
		 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "name" is null
				at com.ktdsuniversity.edu.errorhandle.UnsafeCOde.throwNullPointerException(UnsafeCOde.java:18)
				at com.ktdsuniversity.edu.errorhandle.UnsafeCOde.main(UnsafeCOde.java:32)
		 */
		String name = null;
		boolean isSameName = name.equals("admin");
		System.out.println(isSameName);
	}
	
	public static void throwArrayIndexOutOfBoundsException() {
		/*
		 *	10
			20
			30
			Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
				at com.ktdsuniversity.edu.errorhandle.UnsafeCOde.throwArrayIndexOutOfBoundsException(UnsafeCOde.java:40)
				at com.ktdsuniversity.edu.errorhandle.UnsafeCOde.main(UnsafeCOde.java:54)
		 */
		int[] numbers = {10, 20, 30};
		int n = numbers[0];
		System.out.println(n);

		n = numbers[1];
		System.out.println(n);
		
		n = numbers[2];
		System.out.println(n);
	
		n = numbers[3]; // ArrayIndexOutOfBoundsException => app kill
		System.out.println(n);
		
		n = numbers[0];
		System.out.println(n);
	}
	
	public static void throwNumberFormatException() {
		/*
		 * 	5000
			Exception in thread "main" java.lang.NumberFormatException: For input string: "오천"
				at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
				at java.base/java.lang.Integer.parseInt(Integer.java:588)
				at java.base/java.lang.Integer.parseInt(Integer.java:685)
				at com.ktdsuniversity.edu.errorhandle.UnsafeCOde.throwNumberFormatException(UnsafeCOde.java:62)
				at com.ktdsuniversity.edu.errorhandle.UnsafeCOde.main(UnsafeCOde.java:72)
		 */
		String str = "5000";
		int number = Integer.parseInt(str);
		System.out.println(number);
		
		str = "오천";
		number = Integer.parseInt(str);
		System.out.println(number);
		
		System.out.println("변환이 종료되었습니다.");
	}
	
	public static void throwInputMismatchException() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int number = keyboard.nextInt(); // InputMissmatchException 발생
		System.out.println("입력한 숫자는 " + number + " 입니다.");
	}
	
	public static void main(String[] args) {

		// throwNullPointerException();
		// throwArrayIndexOutOfBoundsException();
		// throwNumberFormatException();
		// throwInputMismatchException();
	}
	
}
