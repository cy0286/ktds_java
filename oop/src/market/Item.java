package market;

/**
 * 자판기의 상품 정보를 나타냄
 */
public class Item {

	// 멤버 변수
	/**
	 * 상품의 이름
	 */
	String name;
	
	/**
	 * 상품의 단가
	 */
	int price;
	
	/**
	 * 상품의 재고 수량
	 */
	int stock;
	
	// 생성자
	/**
	 * 자판기의 상품을 생성함
	 * @param name 판매할 상품의 이름
	 * @param price 판매할 상품의 단가
	 * @param stock 판매할 상품의 입고수량
	 */
	public Item(String name, int price, int stock) {
		
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
}
