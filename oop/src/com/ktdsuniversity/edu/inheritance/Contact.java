package com.ktdsuniversity.edu.inheritance;

public class Contact {

	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void printContact() {
		System.out.println("이름: " + this.name + ", 연락처: " + this.phone);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Contact other) {
			boolean isEquals = this.name.equals(other.getName());
			isEquals &= this.phone.equals(other.getPhone());
			return isEquals;
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "이름: " + this.name + ", 연락처: " + this.phone;
	}
}
