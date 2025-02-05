package com.ktdsuniversity.edu.array;

import java.util.Scanner;

import com.ktdsuniversity.edu.cartooncafe.Cartoon;

public class Garage {

	public static void main(String[] args) {
		
		// == 은 primitive 타입에서만 쓰이는 연산자
		// primitive 입장에서는 값 == 값이 됨
		// reference 입장에서는 주소 == 주소가 됨 
		// 직접 코딩한 데이터는 상수이기 때문에 상수의 메모리는 같음
		// 따라서 메모리와 메모리를 대입해서 true 가 나옴
		String a = "abc";
		String b = "abc";
		System.out.println(a == b);
		
		// 어딘가에서 전달 받아서 온 값이기 때문에 주소가 다름
		Scanner keyboard = new Scanner(System.in);
		String c = keyboard.nextLine();
		
		System.out.println(c);
		System.out.println(c == a);
		System.out.println(c == b);
		System.out.println(c.equals(a));
		System.out.println(c.equals(b));		
		
		
		// 정수형 배열 => int[], long[]
		// 실수형 배열 => float[], doublep[]
		// 불린형 배열 => boolean[];
		// 문자열형 배열 => String[]
		// String[] stringArr = new String[4]
		// STringArr[0] = "장민창";
		
		Cartoon[] bookGarage = new Cartoon[4]; 
		bookGarage[0] = new Cartoon("만화책1", false);
		bookGarage[1] = new Cartoon("만화책2", false);
		bookGarage[2] = new Cartoon("만화책3", false);
		bookGarage[3] = new Cartoon("만화책4", false);
		
		// 모든 만화책의 이름을 출력
		for (int i = 0; i < bookGarage.length; i++) {
			Cartoon book = bookGarage[i];
			System.out.println(book.getName());
			book.setisRental(true);
		}
		
		// 반복이 끝난 이후에 book[0], book[1], book[2], book[3] 의 isRental 값은 무엇일까요?
		// 전부다 true!
		
		// bookGrarage 배열에서 만화책 이름이 "만화책2" 인것과 "만화책3" 인것의 이름만 출력
		for (int i = 0; i < bookGarage.length; i++) {
			Cartoon book = bookGarage[i];
			if (book.getName() == "만화책2" || book.getName() == "만화책3") {
				System.out.println(book.getName());
				System.out.println(book.getIsRental());
			}
		}
	}
}
