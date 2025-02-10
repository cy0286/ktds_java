package hw0207;

/**
 * 추가 연락처
 */
public class AdditionalContact extends Contact {
	
	/**
	 * 생년월일
	 */
	private int birthDate;
	/**
	 * 회사명
	 */
	private String companyName;
	/**
	 * 직급
	 */
	private String position;
	/**
	 * 주소
	 */
	private String address;
	
	public AdditionalContact(int id, String name, String phoneNumber, String photo, int birthDate, String companyName, String position, String address) {
		super(id, name, phoneNumber, photo);
		this.birthDate = birthDate;
		this.companyName = companyName;
		this.position = position;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 생년월일: " + this.birthDate + ", 회사명: " + this.companyName + ", 직급: " + this.position + ", 주소: " + this.address;
	}
}
