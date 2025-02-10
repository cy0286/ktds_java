package hw0207;

public class ContactApp implements ContactAppInteface {

	/**
	 * 현재 연락처 개수
	 */
	private int size; // contacts 배열에 들어간 연락처의 개수	
	/**
	 * 연락처 배열
	 */
	private Contact[] contacts;
	
	public ContactApp(int contactMaxCount) {
		// contactMaxCount : contacts 배열에 들어갈 수 있는 최대 연락처 개수
		this.contacts = new Contact[contactMaxCount];
	}

	public int getSize() {
		return this.size;
	}
	
	@Override
	public void addNewContact(Contact contact) {
		if (this.size < this.contacts.length) {
			this.contacts[this.size++] = contact;
			System.out.println("새 연락처가 추가되었습니다: " + contact);
		}
		else {
			System.out.println("연락처 저장 공간이 가득 찼습니다.");
		}
	}
	
	@Override
	public Contact getContactAt(int contactIndex) {
		if (contactIndex >= 0 && contactIndex < size) {
			return this.contacts[contactIndex];
		}
		else {
			System.out.println("잘못된 인덱스입니다.");
			return null;
		}
	}
	
	@Override
	public void bubbleSort() {
		boolean swqapped;
		
		for (int i = 0; i < this.size - 1; i++) {
			swqapped = false;
			for (int j = 0; j < this.size - 1 - i; j++) {
				if (this.contacts[j].getId() > this.contacts[j + 1].getId()) {
					Contact temp = this.contacts[j];
					this.contacts[j] = this.contacts[j + 1];
					this.contacts[j + 1] = temp;
					swqapped = true;
				}
			}
			if (!swqapped) {
				break;
			}
		}
		System.out.println("연락처가 Bubble Sort로 정렬되었습니다.");
	}
	
	@Override
	public void selectionSort() {
		int minIndex;
		for (int i = 0; i < this.size - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < this.size; j++) {
				if (this.contacts[j].getId() < this.contacts[minIndex].getId()) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				Contact temp = this.contacts[i];
				this.contacts[i] = this.contacts[minIndex];
				this.contacts[minIndex] = temp;
			}
		}
		System.out.println("연락처가 Selection Sort로 정렬되었습니다.");
	}
}
