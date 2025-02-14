package hw0213;

public class Contact {
	private int number;
	private String name;
	private String phoneNumber;
	private String profile;
	
	public Contact(int number, String name, String phoneNumber, String profile) {
		this.number = number;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.profile = profile;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getProfile() {
		return this.profile;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("No. " + this.number + "\n");
		sb.append("Name. " + this.name + "\n");
		sb.append("PhoneNumber. " + this.phoneNumber + "\n");
		sb.append("Profile. " + this.profile + "\n");
		return sb.toString();
	}
}
