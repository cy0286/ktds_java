package com.ktdsuniversity.edu.array.cartooncafe;

// 배운 개념을 적용해서 코드 줄이기
public class CartoonCafe {

	/**
	 * 만화책 대여비
	 */
	public static final int RENTAL_PRICE = 1000;
	public static final int VIP_RENTAL_FEE;
	static {
		VIP_RENTAL_FEE = 100;
	}
	
	/**
	 * 소지금 (만화카페)
	 */
	private int wallet;
	private Cartoon[] books;
	
	public CartoonCafe(int wallet, Cartoon[] books) {
		this.wallet = wallet;
		this.books = books;
	}
	
	public int getWallet() {
		return this.wallet;
	}
	
	public void rentBook(String bookName) {
		System.out.println("========== 만화책 대여 ==========");
		Cartoon book = null;
		for (int i = 0; i < this.books.length; i++) {
			book = this.books[i];
			if (bookName.equals(book.getName())) {
				if (book.getIsRental()) {
					System.out.println(book.getName() + "는 이미 대여중인 만화책입니다.");
				}
				else {
				System.out.println(book.getName() + "을 대여했습니다.");
				book.setisRental(true);
				this.wallet += (int) (Math.random() * 2) == 0 ? CartoonCafe.RENTAL_PRICE :CartoonCafe.VIP_RENTAL_FEE;
				}
				return;
			}
		}
		System.out.println(bookName + "은 보유중인 만화책이 아닙니다.");
	}
	
	public void returnBook(String bookName) {
		System.out.println("========== 만화책 반납 ==========");
		Cartoon book = null;
		for (int i = 0; i < this.books.length; i++) {
			book = this.books[i];
			if (bookName.equals(book.getName())) {
				if (book.getIsRental()) {
					System.out.println(book.getName() + "이 반납되었습니다.");
					book.setisRental(true);
				}
				return;
			}
		}
		System.out.println(bookName + "은 대여중인 만화책이 아닙니다.");
	}
	public void printAllBook( ) {
		System.out.println("====== 보유중인 만화책 목록 =======");
		Cartoon book = null;
		for (int i = 0; i < this.books.length; i++) {
			book = this.books[i];
			System.out.println(book.getName() + " > " + book.getIsRental());
		}
	}	
}
