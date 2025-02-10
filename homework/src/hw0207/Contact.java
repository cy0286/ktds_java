package hw0207;

/**
 * 기본 연락처 정보
 */
public class Contact {
	
	/**
	 * 순번
	 */
	private int id;
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 연락처
	 */
	private String phoneNumber;
	/**
	 * 사진
	 */
	private String photo;
	
	public Contact(int id, String name, String phoneNumber, String photo) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.photo = photo;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + ", 이름: " + this.name + ", 전화번호: " + this.phoneNumber + ", 사진: " + this.photo;
	}
}
