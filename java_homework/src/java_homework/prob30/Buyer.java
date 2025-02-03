package java_homework.prob30;

/**
 * 판매자에게 상품을 구매하는 구매자
 * 판매자에게 상품을 구매하면 상품만큼의 금액이 줄어야 함
 * 구매자의 장바구니에는 구매한 상품의 수 만큼 늘어남
 * 만약 구매자의 지갑에 충분한 돈이 없다면 판매자와 구매자는 아무런 변화가 없음
 */
public class Buyer {

	// 멤버변수
	private int cart; // 구매자가 가지고 있는 상품의 수
	private int wallet; // 구매자가 가지고 있는 금액
	
	// 생성자
	public Buyer(int wallet) {
		this.wallet = wallet;
	}
	
	// 상품 구매 메소드
	public void buyProduct(Seller seller, int quantity) {
		int pricePerProdut = seller.getPrice();
		int totalPrice = pricePerProdut * quantity;
		
		if (totalPrice > this.wallet) {
			System.out.println("구매자의 지갑에 돈이 부족합니다.");
			return;
		}
		int purchase = seller.sellProduct(quantity); // 상품 구매
		
		if (purchase > 0) {
			this.wallet -= purchase * pricePerProdut;
			this.cart += purchase;
			System.out.println("구매자가 상품 " + purchase + "개를 구매했습니다.");
		}
	}
	
	// 구매자의 상태 출력 메소드
	public void printStatus() {
		System.out.println("구매자의 상품 수: " + this.cart + "개");
		System.out.println("구매자의 지갑 현황: " + this.wallet + "원");
	}	
}