package hw0207;

import hw0207.exceptions.ContactAppException;
import hw0207.exceptions.ContactNotFoundException;
import hw0207.exceptions.ContactOutOfBoundsException;
import hw0207.exceptions.NullContactException;

public class Phone {

	public static void run() {

		ContactAppInteface app = new OtherContactApp(30);

		// 0
		app.addNewContact(new Contact(3, "장민창", "010-1234-1234", "me1.jpg"));
		// 1
		app.addNewContact(new Contact(5, "홍길동", "010-2234-1234", "me2.jpg"));
		// 2
		app.addNewContact(new Contact(1, "임꺽정", "010-3234-1234", "me3.jpg"));

		// 3
		app.addNewContact(new Contact(2, "김준수", "010-4234-1234", "me4.jpg"));
		// 4
		app.addNewContact(new AdditionalContact(4, "최창민", "010-4234-1234", "me5.jpg", 19800101, "없음", "없음", "서울 어딘가"));

		System.out.println("정렬되기 전");
		for (int i = 0; i < 40; i++) {
			try {
				Contact contact = app.getContactAt(i);
				System.out.println(contact);
			} catch (ContactOutOfBoundsException cooe) {
				System.out.println("조회 실패! " + cooe.getMessage());
			} catch (ContactNotFoundException cnfe) {
				System.out.println("조회 실패! " + cnfe.getMessage());
			} catch (NullContactException nce) {
				System.out.println("조회 실패! " + nce.getMessage());
			}
		}

		app.bubbleSort();

		// 3 번 인덱스 연락처 삭제
		app.remove(3);

		System.out.println("정렬 후");
		for (int i = 0; i < 40; i++) {

			try {
				Contact contact = app.getContactAt(i);
				System.out.println(contact);
			}
//				catch (Throwable cooe) { // 절대 사용 금지.
//					System.out.println("조회 실패! " + cooe.getMessage());
//				}
//				catch (Exception cooe) { // 절대 사용 금지.
//					System.out.println("조회 실패! " + cooe.getMessage());
//				}
//				catch (RuntimeException cooe) { // 절대 사용 금지.
//					System.out.println("조회 실패! " + cooe.getMessage());
//				}
			catch (ContactOutOfBoundsException | ContactNotFoundException | NullContactException exception) {
				// System.out.println("조회 실패! " + exception.getMessage());
				throw new ContactAppException(exception.getMessage(), exception);
			}
//				catch (ContactNotFoundException cnfe) {
//					System.out.println("조회 실패! " + cnfe.getMessage());
//				}
//				catch (NullContactException nce) {
//					System.out.println("조회 실패! " + nce.getMessage());
//				}
		}

	}

	public static void throwException() {
		
		try{
			throw new Exception("예외 받아랏!");
		}
		catch (Exception e) {
			// System.out.println("예외 발생!");
			throw new RuntimeException(e.getMessage(),e);
		}
		
	}
	
	public static void main(String[] args) {
		
//		ContactApp contactApp = new ContactApp(5);
//		
//		Contact contact1 = new Contact(3, "민지", "010-1234-5678", "photo1.jpg");
//		Contact contact2 = new Contact(1, "하니", "010-2345-6789", "photo2.jpg");
//		Contact contact3 = new Contact(4, "다니엘", "010-3456-7890", "photo3.jpg");
//		Contact contact4 = new Contact(2, "혜린", "010-4567-8901", "photo4.jpg");
//		
//		contactApp.addNewContact(contact1);
//		contactApp.addNewContact(contact2);
//		contactApp.addNewContact(contact3);
//		contactApp.addNewContact(contact4);
//		
//		Contact addcontact1 = new AdditionalContact(5, "혜인", "010-5678-2345", "photo5.jpg", 20080421, "NYZ", "member","Seoul");
//		contactApp.addNewContact(addcontact1);
//		Contact addcontact2 = new AdditionalContact(6, "뉴진스", "010-2222-2222", "photo6.jpg", 20000505, "NYZ", "Group","Seoul");
//		contactApp.addNewContact(addcontact2);
//
//		contactApp.bubbleSort();
//		System.out.println("Bublle Sort 후 연락처 목록");
//		for (int i = 0; i < contactApp.getSize(); i++) {
//			System.out.println(contactApp.getContactAt(i).getId() + ": " + contactApp.getContactAt(i).getName());
//		}
//	
//		contactApp.selectionSort();
//		System.out.println("Selection Sort 후 연락처 목록");
//		for (int i = 0; i < contactApp.getSize(); i++) {
//			System.out.println(contactApp.getContactAt(i).getId() + ": " + contactApp.getContactAt(i).getName());
//		}
//		
//		contact1 = contactApp.getContactAt(0);
//		if (contact1 != null) {
//			System.out.println(contact1);
//		}	
//		contact2 = contactApp.getContactAt(1);
//		if (contact2 != null) {
//			System.out.println(contact2);
//		}
//		contact3 = contactApp.getContactAt(2);
//		if (contact3 != null) {
//			System.out.println(contact3);
//		}
//		contact4 = contactApp.getContactAt(3);
//		if (contact4 != null) {
//			System.out.println(contact4);
//		}
//		addcontact1 = contactApp.getContactAt(4);
//		if (addcontact1 != null) {
//			System.out.println(addcontact1);
//		}
//		addcontact2 = contactApp.getContactAt(6);
//		if (addcontact2 != null) {
//			System.out.println(addcontact2.getId());	
//		}
		
		throwException();
		
		// catch 한 Exception 예외를 RuntimeException 으로 변환해서 던지기
		// 위 코드를 호출하는 코드에서는 try ~ catch 불필요
		try {
			run();
		}
		catch (ContactAppException cae) {
			System.out.println(cae.getMessage());
			Throwable cause = cae.getCause();
			cause.printStackTrace();
		}
	}
}
