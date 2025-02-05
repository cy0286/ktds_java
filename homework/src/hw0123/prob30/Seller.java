package hw0123.prob30;

/**
 * 어떤 상품을 판매하는 판매자
 * 구매자가 판매자에게서 상품을 1개 구매한다면 판매자의 상품 재고는 1개가 줆
 * 판매자의 금고에는 상품 1개에 대한 금액만큼 증가해야 함
 * 구매자가 판매자에게 구매하려는 상품의 개수가 더 크다면, 판매자는 남은 모든 상품을 판매함 
 */
public class Seller {

	// 멤버변수
	private int inventory; // 상품 재고
	private int price; // 상품 가격
	private int cash = 0; // 금고
	
	// 생성자
	public Seller(int inventory, int price) {
		this.inventory = inventory;
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
	
	// 상품 판매 메소드
	public int sellProduct(int quantity) {
		int sell = Math.min(quantity, this.inventory);
		this.inventory -= sell; // 재고 감소
		this.cash += sell * this.price; // 금고에 금액 추가
		return sell; // 판매된 상품 수량 반환
	}
	
	// 판매자의 상태 출력 메소드
	public void printStatus() {
		System.out.println("판매자의 상품 수: " + this.inventory + "개");
		System.out.println("판매자의 상품 가격: " + this.price + "원");
		System.out.println("판매자의 금고 현황: " + this.cash + "원");
	}
}
