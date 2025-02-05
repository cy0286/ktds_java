package hw0123.prob30;

/**
 * 문제 30
 */
public class Mart {
	
	public static void main(String[] args) {
		Seller seller = new Seller(100, 500);
		Buyer buyer = new Buyer(100_000);
		
		buyer.buyProduct(seller, 10);
		
		seller.printStatus();
		buyer.printStatus();
		
		buyer.buyProduct(seller, 100);
		
		seller.printStatus();
		buyer.printStatus();
		
		buyer.buyProduct(seller, 10_000);
		
		seller.printStatus();
		buyer.printStatus();
	}

}
