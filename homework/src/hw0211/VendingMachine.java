package hw0211;

/**
 * 자판기
 */
public class VendingMachine {

	Product[] products; // 상품 배열
	private int moneyBox; // 돈통
	private int customerMoney; // 상품을 구매하기 위해 고객이 넣은 돈
	
	public VendingMachine(Product[] products) {
		this.products = products;
	}
	
	/**
	 * 판매하기
	 * @param number 상품번호
	 * @param insertMoney 자판기에 넣을 돈
	 * @param customer 고객
	 */
	public void sell(int number, int insertMoney, Customer customer) {
		Product product = null;
		
		for (int i = 0; i < this.products.length; i++) {
			if (this.products[i].getNumber() == number) {
				product = this.products[i];
				break;				
			}
		}
		
		if (product == null) {
			System.out.println("상품 번호에 해당하는 상품이 없습니다.");
			return;
		}
		
		if (product.getExpirationDays() < 0) {
			customer.paybackMoney(insertMoney);
			throw new ExpiredProductException("죄송합니다. 소비기한이 지난 상품입니다.");
		}
		if (product.getStock() <= 0) {
			customer.paybackMoney(insertMoney);
			throw new SoldOutException("죄송합니다. 상품 번호에 해당하는 재고가 없습니다.");
		}
		if (product.getPrice() > insertMoney) {
			customer.paybackMoney(insertMoney);
			throw new NeedMoreMoneyException("금액이 부족합니다.");
		}
		
		customer.pay(product.getPrice());
		customer.receiveProduct(product);
		
		this.moneyBox += product.getPrice();
		
		int change = insertMoney - product.getPrice();	
		if (change > 0) {
			customer.paybackMoney(change);
		}
		
		product.decreaseStock();
	    this.customerMoney = 0;
	}
	
	/**
	 * 환불하기
	 * @param customer 고객
	 */
	public void refund(Customer customer) {
		customer.paybackMoney(this.customerMoney);
		this.customerMoney = 0;
	}
	
	/**
	 * 자판기 재고 출력하기
	 */
	public void printStock() {
		System.out.println("자판기 재고: ");
		for (int i = 0; i < this.products.length; i++) {
			System.out.println(this.products[i]);
		}
		System.out.println("돈통의 돈 : " + this.moneyBox);
	}
}
