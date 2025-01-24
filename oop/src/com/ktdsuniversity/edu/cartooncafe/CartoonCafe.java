package com.ktdsuniversity.edu.cartooncafe;

public class CartoonCafe {

	/**
	 * 만화책 대여비
	 */
	private final int RENTAL_PRICE = 1000;
	
	/**
	 * 소지금 (만화카페)
	 */
	private int wallet;
	
	private Cartoon name1;
	private Cartoon name2;
	private Cartoon name3;
	private Cartoon name4;
	
	public CartoonCafe(int wallet, Cartoon name1, Cartoon name2, Cartoon name3, Cartoon name4) {
		this.wallet = wallet;
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
	}
	
	public int getWallet() {
		return this.wallet;
	}
	
	public void rentBook(String bookName) {
		
		System.out.println("========== 만화책 대여 ==========");
		if (bookName == this.name1.getName()) {
			if(this.name1.getRentalState()) {
				System.out.println(this.name1.getName() + "는 이미 대여중인 만화책입니다.");
			}
			else {
				System.out.println(this.name1.getName() + "를 대여했습니다.");
				name1.setRentalState(true);
				this.wallet += this.RENTAL_PRICE;
			}
		}
		else if (bookName == this.name2.getName()) {
			if(this.name2.getRentalState()) {
				System.out.println(this.name2.getName() + "는 이미 대여중인 만화책입니다.");
			}
			else {
				System.out.println(this.name2.getName() + "를 대여했습니다.");
				name2.setRentalState(true);
				this.wallet += this.RENTAL_PRICE;
			}
		}
		else if (bookName == this.name3.getName()) {
			if(this.name3.getRentalState()) {
				System.out.println(this.name3.getName() + "는 이미 대여중인 만화책입니다.");
			}
			else {
				System.out.println(this.name3.getName() + "를 대여했습니다.");
				name3.setRentalState(true);
				this.wallet += this.RENTAL_PRICE;
			}
		}
		else if (bookName == this.name4.getName()) {
			if(this.name4.getRentalState()) {
				System.out.println(this.name4.getName() + "는 이미 대여중인 만화책입니다.");
			}
			else {
				System.out.println(this.name4.getName() + "를 대여했습니다.");
				name4.setRentalState(true);
				this.wallet += this.RENTAL_PRICE;
			}
		}
		else {
			System.out.println(bookName + "은 보유중인 만화책이 아닙니다.");
		}
	}
	
	public void returnBook(String bookName) {
		System.out.println("========== 만화책 반납 ==========");
		if (bookName == this.name1.getName()) {
			if(this.name1.getRentalState()) {
				System.out.println(this.name1.getName() + "이 반납되었습니다.");
				name1.setRentalState(true);
			}
			else {
				System.out.println(bookName + "은 대여중인 만화책이 아닙니다.");
			}
		}
		else if (bookName == this.name2.getName()) {
			if(this.name2.getRentalState()) {
				System.out.println(this.name2.getName() + "이 반납되었습니다.");
				name2.setRentalState(true);
			}
			else {
				System.out.println(bookName + "은 대여중인 만화책이 아닙니다.");
			}
		}
		else if (bookName == this.name3.getName()) {
			if(this.name3.getRentalState()) {
				System.out.println(this.name3.getName() + "이 반납되었습니다.");
				name3.setRentalState(true);
			}
			else {
				System.out.println(bookName + "은 대여중인 만화책이 아닙니다.");
			}
		}
		else if (bookName == this.name4.getName()) {
			if(this.name4.getRentalState()) {
				System.out.println(this.name4.getName() + "이 반납되었습니다.");
				name4.setRentalState(true);
			}
			else {
				System.out.println(this.name1.getName() + "은 대여중인 만화책이 아닙니다.");
			}
		}
		else{
			System.out.println(bookName + "은 보유중인 만화책이 아닙니다.");
		}
		
	}
	public void printAllBook( ) {
		System.out.println("====== 보유중인 만화책 목록 =======");
		System.out.println(this.name1.getName() + " > " + this.name1.getRentalState());
		System.out.println(this.name2.getName() + " > " + this.name2.getRentalState());
		System.out.println(this.name3.getName() + " > " + this.name3.getRentalState());
		System.out.println(this.name4.getName() + " > " + this.name4.getRentalState());
	}
	
}
