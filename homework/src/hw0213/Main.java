package hw0213;

public class Main {

	public static void run() {
		String fileDirectoryPath = "C:\\Users\\cy028\\바탕 화면\\fileexam\\contact_data\\";
		String loadFileName = "contacts.txt";
		String writeFileName = "store_contacts.txt";
		ContactAppInterface app1 = new OtherContactApp(fileDirectoryPath, loadFileName);
		app1.writeData(fileDirectoryPath, writeFileName);
		
		ContactAppInterface app2 = new ContactApp(fileDirectoryPath, loadFileName);
		Contact newContact = new Contact(10, "송송송", "010-0000-0000", "photo");
		app2.addNewContact(newContact);
		app2.writeData(fileDirectoryPath, writeFileName);
	}

	public static void main(String[] args) {
		run();
	}
}