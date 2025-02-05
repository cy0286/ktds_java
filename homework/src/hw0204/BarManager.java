package hw0204;

public class BarManager {

	public static void main(String[] args) {
		
		Customer customer = new Customer(24, 40_000_000);
		
		Bar.sellDrink(customer, false);
		Bar.sellDrink(customer, true);
		
		System.out.println("남은 돈 : " + customer.getWallet());
		System.out.println("배부름 정도 : " + customer.getFullness());
		System.out.println("취한 정도 : " + customer.getDrunkenness());
		System.out.println();
		
		for (int i = 1; i <= 40; i++) {
			Bar.sellDrink(customer, true);
		}

		System.out.println("남은 돈 : " + customer.getWallet());
		System.out.println("배부름 정도 : " + customer.getFullness());
		System.out.println("취한 정도 : " + customer.getDrunkenness());
		System.out.println();
		
		Customer customer2 = new Customer(15, 40_000_000);
		Bar.sellDrink(customer2, true);
		System.out.println("남은 돈 : " + customer2.getWallet());
		System.out.println("배부름 정도 : " + customer2.getFullness());
		System.out.println("취한 정도 : " + customer2.getDrunkenness());
	}
}