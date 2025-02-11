package hw0207;

import hw0207.exceptions.ContactNotFoundException;
import hw0207.exceptions.ContactOutOfBoundsException;
import hw0207.exceptions.NullContactException;

public class OtherContactApp implements ContactAppInteface {

	/**
	 * 현재 연락처 개수
	 */
	private int size; // contacts 배열에 들어간 연락처의 개수	
	/**
	 * 연락처 배열
	 */
	private Contact[] contacts;
	
	public OtherContactApp(int contactMaxCount) {
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
	public void remove(int contactIndex) {
		if (contactIndex >= 0 && contactIndex < this.size) {
			this.contacts[contactIndex] = null;
		}
	}
	
	@Override
	public Contact getContactAt(int contactIndex) {
		
		// ContactNotFoundException 클래스 생성 
		// 	-> contactIndex가 this.contacts.length 보다 작지만 this.size 보다 크거나 같을 때 던지기
		// ContactOutOfBoundsException 클래스 생성
		//	-> contactIndex가 this.contacts.length 보다 크거나 같을 때 던지기
		// NullContactException 클래스 생성 
		//	-> contactIndex가 this.size 보다 작지만 contactIndex 에 저장된 값이 null 일 때 던지기
		
		// 연락처 배열에 데이터가 채워져있지 않은 상태
		// 아직 연락처가 채워져 있지 않은 인덱스를 요청
		if (contactIndex < this.contacts.length && contactIndex >= this.size) {
			throw new ContactNotFoundException("연락처가 아직 채워지지 않은 번호입니다.");
		}
		
		// 연락처 배열의 마지막 인덱스보다 큰 연락처를 요청했을 때
		if (contactIndex >= this.contacts.length) {
			throw new ContactOutOfBoundsException("연락처 크기를 벗어나는 인덱스입니다. 올바른 인덱스를 요청해주세요.");
		}
		
		// 삭제된 인덱스를 요청한 경우
		if (contactIndex < this.size && this.contacts[contactIndex] == null) {
			throw new NullContactException("삭제된 연락처입니다.");
		}
		
		//if (contactIndex >= 0 && contactIndex < this.size) {
		return this.contacts[contactIndex];
		// }
//		else {
//			System.out.println("잘못된 인덱스입니다.");
//			return null;
//		}
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
