package com.ktdsuniversity.edu.inheritance;

/**
 * 연락처 관리 프로그램
 */
public class Main {

	public static void main(String[] args) {
		
//		Contact contact = new Contact("송채영", "010-1234-1234");
//		Contact otherContact = new Contact("송채영", "010-1234-1234");
		
		// EmailConatact 에서도 모든 정보가 나오게 하려면 EmailContact 클래스에도 overriding 해야 함
		Contact contact = new EmailContact("송채영", "010-1234-1234", "gmail@gmail.com");
		Contact otherContact = new EmailContact("송채영", "010-1234-1234", "gmail@gmail.com");
		System.out.println(contact == otherContact); // false (메모리 주소가 다르기 때문)
		System.out.println(contact.equals(otherContact)); // Contact 에 equals 를 만들기 전 - false
		System.out.println(contact); // com.ktdsuniversity.edu.inheritance.Contact@5305068a
		System.out.println(otherContact); // com.ktdsuniversity.edu.inheritance.Contact@1f32e575
		// 두 개가 같게 나오게 하려면 contact 클래스에서 object 클래스의 equals 를 overriding 하면 됨
		// Object 의 toString이 위처럼 print 되게 함 -> toString을 overriding 하면 됨
		
		Contact contact1 = new Contact("홍길동", "010-1111-2222");
		Contact contact2 = new Contact("언년", "010-3333-4444");
		contact1.printContact();
		contact2.printContact();
		
		EmailContact emailContact1 = new EmailContact("친구1", "010-2222-3333", "friends1@gmail.com");
		EmailContact emailContact2 = new EmailContact("친구2", "010-4444-5555", "friends2@gmail.com");
		emailContact1.printContact();
		emailContact2.printContact();
		
		// (다형성) Sub class is a Super class
		// 서브클래스 인스턴스를 슈퍼클래스 타입의 인스턴스에 할당 가능함
		Contact emailContact3 =  new EmailContact("친구3", "010-6666-7777", "friends3@gmail.com");
		Contact emailContact4 =  new EmailContact("친구4", "010-8888-9999", "friends4@gmail.com");
		emailContact3.printContact();
		emailContact4.printContact();
	}
}
