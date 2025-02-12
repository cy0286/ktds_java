package hw0211;

/**
 * 상품
 */
public class Product {

	private int number; // 상품 번호
	private String name; // 상품 이름
	private int price; // 상품 가격
	private int stock; // 상품 재고 수
	private int expirationDays; // 상품 소비 기한까지 남은 일 수
	
	public Product(int number, String name, int price, int stock, int expirationDays) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.expirationDays = expirationDays;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public int getExpirationDays() {
		return this.expirationDays;
	}
	
	public void decreaseStock() {
		this.stock--;
	}
	
	@Override
	public String toString() {
		return "상품번호: " + this.number + ", 상품 이름: " + this.name +
				", 상품 가격: " + this.price + ", 상품 재고 수: " + this.stock +
				", 상품 소비 기한까지 남은 일 수: " + this.expirationDays;
		
	}
	
}
