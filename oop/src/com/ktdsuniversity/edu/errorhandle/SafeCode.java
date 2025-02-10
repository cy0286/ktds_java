package com.ktdsuniversity.edu.errorhandle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeCode {
	
	public static String makeString() {
		String[] strArray = new String[] {null, "40", null, "90", "70", "장민창", "마흔", "ABC"};
		return strArray[ (int) (Math.random() * strArray.length)];
	}

	public static void throwNullPointerException() {
		String age = makeString();
		if (age != null) {
			boolean isSameAge = age.equals("40");
			System.out.println(isSameAge);
		}

		String name = makeString();
		if (name != null) {
			boolean isSameName = name.equals("admin");
			System.out.println(isSameName);
		}
	}
	
	public static int[] makeNumbersArrays() {
		int[][] numbers = {
				null,
				{0, 1, 2},
				{},
				{1, 7,8, 4, 3}
		};
		
		return numbers[(int) (Math.random() * numbers.length)];
	}
	
		
	public static void throwArrayIndexOutOfBoundsException() {
		
		int[] numbers = makeNumbersArrays();

		if (numbers != null) {
			
			int n = 0;
			if (numbers.length > 0) {
				n = numbers[0];
				System.out.println(n);
			}
			
			if (numbers.length > 1) {
				n = numbers[1];
				System.out.println(n);
			}
			
			if (numbers.length > 2) {
				n = numbers[2];
				System.out.println(n);
			}
			
			if (numbers.length > 3) {
				n = numbers[3];
				System.out.println(n);
			}
			
			if (numbers.length > 0) {
				n = numbers[0];
				System.out.println(n);
			}
		}
		
	}
	 
	public static void throwNumberFormatException() {
		String str = makeString();
		
		if (str != null && str.matches("^[0-9]+$")) {
			int number = Integer.parseInt(str);
			System.out.println(number);
		}
		
		str = makeString();
		if (str != null && str.matches("^[0-9]+$")) {
			int number = Integer.parseInt(str);
			System.out.println(number);
		}
		
		System.out.println("변환이 종료되었습니다.");
	}
	
	public static void throwInputMismatchException() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		
		// if 로 예외 방어가 불가능한 코드를 예외처리 할경우
		// 예외 가능성이 조금이라도 있는 코드는 try 블럭으로 감싼다
		// try 블럭에서 발생된 예외는 자동으로 catch 블럭으로 보내진다
		try {
			int number = keyboard.nextInt();		
			System.out.println("입력한 숫자는 " + number + " 입니다.");
		}
		// try 블럭에서 발생한 InputMismatchException 정보가 catch 로 전달
		catch (InputMismatchException ime) {
			System.out.println("숫자만 입력할 수 있습니다!!!");
			System.out.println("에러가 발생한 원인은 다음과 같습니다.");
			System.out.println(ime.getMessage());
			
			System.out.println("에러가 발생한 과정은 다음과 같습니다.");
			ime.printStackTrace();
		}
		System.out.println("입력이 완료되었습니다!");	
	}
	
	public static int inputNumber() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		
		int number = 0;
		while (true) {
			try {
				number = keyboard.nextInt();
				return number;	
			}
			catch (InputMismatchException ime) {
				System.out.println("숫자만 입력하세요.");
				System.out.println("다시 숫자를 입력하세요.");
				keyboard.nextLine();
			}
		}
	}
	
	// try catch 안 쓰고 if 로 바꿔쓰는 법
	public static int getNumber() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		
		String value = keyboard.nextLine();
		
		if (value.matches("^[0-9] + $")) {
			return Integer.parseInt(value);
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {

		throwNullPointerException();
		throwArrayIndexOutOfBoundsException();
		throwNumberFormatException();
		// throwInputMismatchException();
		
		int number = inputNumber();
		System.out.println("입력한 숫자는: " + number + " 입니다.");
	}
}
