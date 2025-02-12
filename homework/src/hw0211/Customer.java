package hw0211;

public class Customer {

	private int wallet; // 지갑
	Product[] products; // 구매한 상품
	
	public Customer(int wallet, Product[] products) {
		this.wallet = wallet;
		this.products = products;
	}
	
	/**
	 * 지불하기
	 * @param money 지불할 돈
	 */
	public void pay(int money) {
		if (this.wallet < money) {
			System.out.println("지갑에 돈이 부족합니다. 고객이 가진 모든 돈을 지불합니다.");
			money = this.wallet;
		}
		this.wallet -= money;
	}
	
	/**
	 * 상품받기
	 * @param product 받은 상품
	 */
	public void receiveProduct(Product product) {
		boolean alreadyPurchased = false;
		
		for (int i = 0; i < this.products.length; i++) {
			if (this.products[i] != null && this.products[i].getNumber() == product.getNumber()) {
				alreadyPurchased = true;
				break;
			}
		}
		
		if (!alreadyPurchased) {
			for (int i = 0; i < this.products.length; i++) {
				if (this.products[i] == null) {
					this.products[i] = product;
					break;
				}
			}
		}
	}
	
	/**
	 * 지급받기
	 * @param money 지급받을 돈
	 */
	public void paybackMoney(int money) {
		this.wallet += money;
	}
	
	/**
	 * 고객상황 출력하기
	 */
	public void printCustomerStatus() {
		System.out.println("=== 고객 정보 ===");
		System.out.println("지갑의 잔액: " + this.wallet);
		System.out.println("구매한 상품 목록: ");
		for (int i = 0; i < this.products.length; i++) {
			if (products[i] != null) {
				System.out.println(products[i]);
			}
		}
	}
}
