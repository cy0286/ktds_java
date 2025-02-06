package com.ktdsuniversity.edu.inheritance;

/**
 * 연락처 관리 프로그램
 */
public class Main {

	public static void main(String[] args) {
		
		Contact contact1 = new Contact("홍길동", "010-1111-2222");
		Contact contact2 = new Contact("언년", "010-3333-4444");
		
		contact1.printContact();
		contact2.printContact();
		
		EmailContact emailContact1 = new EmailContact("친구1", "010-2222-3333", "friends1@gmail.com");
		EmailContact emailContact2 = new EmailContact("친구2", "010-4444-5555", "friends2@gmail.com");
		
		emailContact1.printContact();
		emailContact2.printContact();
	}
}
