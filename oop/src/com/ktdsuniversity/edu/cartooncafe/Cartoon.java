package com.ktdsuniversity.edu.cartooncafe;

public class Cartoon {

	/**
	 * 만화책 이름
	 */
	private String name;
	
	/**
	 * 만화책 대여 상태
	 */
	private Boolean isRental;
	
	public Cartoon(String name, Boolean rentalState) {
		this.name = name;
		this.isRental = rentalState;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Boolean getRentalState() {
		return isRental;
	}

	public void setRentalState(Boolean rentalState) {
		this.isRental = rentalState;
	}
}
