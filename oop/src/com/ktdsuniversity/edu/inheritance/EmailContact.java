package com.ktdsuniversity.edu.inheritance;

public class EmailContact extends Contact {
	
	private String email;

	public EmailContact(String name, String phone, String email) {
		super(name, phone);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public void printContact() {
		super.printContact();
		System.out.println("이메일: " + this.email);
	}
	
	@Override
	public String toString() {
		return "이름: " + super.getName() + ", 연락처: " + super.getPhone() + ", 이메일: " + this.email;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Contact other) {
			boolean isEquals = super.getName().equals(other.getName());
			isEquals &= super.getPhone().equals(other.getPhone());
			
			if(other instanceof EmailContact emailOther) {
				isEquals &= this.email.equals(emailOther.getEmail());
			}
			return isEquals;
		}
		return super.equals(obj);
	}
}
