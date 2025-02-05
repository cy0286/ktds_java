package com.ktdsuniversity.edu.array.cartooncafe;

public class Cartoon {

	/**
	 * 만화책 이름
	 */
	private String name;
	
	/**
	 * 만화책 대여 상태
	 */
	private Boolean isRental;
	
	public Cartoon(String name, Boolean isRental) {
		this.name = name;
		this.isRental = isRental;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Boolean getIsRental() {
		return isRental;
	}

	public void setisRental(Boolean isRental) {
		this.isRental = isRental;
	}
}
