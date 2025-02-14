package hw0213;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import hw0213.exceptions.ContactNotFoundException;

public class OtherContactApp implements ContactAppInterface {

	private List<Contact> contacts;

	public OtherContactApp(String fileDirectoryPath, String filename) {
		this.contacts = new ArrayList<>();
		this.loadData(fileDirectoryPath, filename);
	}

	@Override
	public void loadData(String fileDirectoryPath, String filename) {
		// 파일을 읽어서 this.contacts 에 연락처 목록을 할당한다.
		File file = new File(fileDirectoryPath, filename);

		if (!file.exists()) {
			System.out.println("파일이 존재하지 않습니다: " + file.getAbsolutePath());
			return;
		}

		try {
			List<String> fileLines = Files.readAllLines(file.toPath());

			for (String line : fileLines) {
				String[] parts = line.split(",");
				if (parts.length == 4) {
					int numbr = Integer.parseInt(parts[0].trim());
					String name = parts[1].trim();
					String phoneNumber = parts[2].trim();
					String profile = parts[3].trim();
					this.contacts.add(new Contact(numbr, name, phoneNumber, profile));
				}
			}
			System.out.println("연락처 데이터가 로드되었습니다.");
		} 
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	@Override
	public void writeData(String fileDirectoryPath, String filename) {
		// this.contact에 있는 연락처 정보를 파일에 쓴다.
		File writeFile = new File(fileDirectoryPath, filename);

		if (!writeFile.getParentFile().exists()) {
			writeFile.getParentFile().mkdirs();
		}

		int index = 2;
		while (writeFile.exists()) { 
			String newFileName = filename.substring(0, filename.lastIndexOf("."));
			newFileName +="(" + (index++) + ").";
			newFileName += filename.substring(filename.lastIndexOf(".") + 1); 
			
			writeFile = new File(fileDirectoryPath, newFileName);
		}

		try {
			List<String> data = new ArrayList<String>();
			for (Contact contact : this.contacts) {
				data.add(contact.getNumber() + "," + contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getProfile());
			}

			Files.write(writeFile.toPath(), data);
			System.out.println("연락처 데이터가 저장되었습니다.");
		} 
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	@Override
	public void clean() {
		this.contacts.clear();
	}

	@Override
	public void addNewContact(Contact newContact) {
		this.contacts.add(newContact);
	}

	@Override
	public void remove(int contactIndex) {
		if (contactIndex >= 0 && contactIndex < this.contacts.size()) {
			this.contacts.remove(contactIndex);
		}
	}

	@Override
	public Contact getContactAt(int contactIndex) {
		if (contactIndex < this.contacts.size() && contactIndex >= this.contacts.size()) {
			throw new ContactNotFoundException(contactIndex + " 연락처가 아직 채워지지 않은 인덱스입니다.");
		}
		return this.contacts.get(contactIndex);
	}

	@Override
	public void sort() {
		// Bubble Sort
		for (int i = 0; i < this.contacts.size(); i++) {
			for (int j = 0; j < this.contacts.size() - 1 - i; j++) {
				if (this.contacts.get(j-1).getNumber() < this.contacts.get(j).getNumber()) {
					Contact temp = this.contacts.get(j);
					this.contacts.set(j, this.contacts.get(j+1));
					this.contacts.set(j+1, temp);
				}
			}
		}
	}
}