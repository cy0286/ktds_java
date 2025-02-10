package hw0207;

public class Phone {

	public static void main(String[] args) {
		
		ContactApp contactApp = new ContactApp(10);
		
		Contact contact1 = new Contact(3, "민지", "010-1234-5678", "photo1.jpg");
		Contact contact2 = new Contact(1, "하니", "010-2345-6789", "photo2.jpg");
		Contact contact3 = new Contact(4, "다니엘", "010-3456-7890", "photo3.jpg");
		Contact contact4 = new Contact(2, "혜린", "010-4567-8901", "photo4.jpg");

		Contact addcontact1 = new AdditionalContact(5, "혜인", "010-5678-2345", "photo5.jpg", 20080421, "NYZ", "member","Seoul");
		
		contactApp.addNewContact(addcontact1);
		contactApp.addNewContact(contact1);
		contactApp.addNewContact(contact2);
		contactApp.addNewContact(contact3);
		contactApp.addNewContact(contact4);

		contactApp.bubbleSort();
		System.out.println("Bublle Sort 후 연락처 목록");
		for (int i = 0; i < contactApp.getSize(); i++) {
			System.out.println(contactApp.getContactAt(i).getId() + ": " + contactApp.getContactAt(i).getName());
		}
	
		contactApp.selectionSort();
		System.out.println("Selection Sort 후 연락처 목록");
		for (int i = 0; i < contactApp.getSize(); i++) {
			System.out.println(contactApp.getContactAt(i).getId() + ": " + contactApp.getContactAt(i).getName());
		}
	}
}
