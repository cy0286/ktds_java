package hw0204;

/**
 * 음료 및 주류 판매
 */
public class Bar {

	/**
	 * 음료 가격
	 */
	public static final int BEVERAGE_PRICE = 3_000;
	/**
	 * 주류 가격
	 */
	public static final int ALCOHOL_PRICE = 5_000;
	
	/**
	 * 고객에게 음료 및 주류를 판매함
	 * @param customer 구매하는 고객
	 * @param isAlcohal true 면 주류
	 */
	public static void sellDrink(Customer customer, Boolean isAlcohal) {
		
		if (isAlcohal) {
			if (customer.getAge() < 19) {
				System.out.println("19세 미만의 고객에게는 주류를 팔 수 없습니다.");
				return;
			}
			if (customer.getWallet() < ALCOHOL_PRICE) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			if (BarUtils.checkDrunkenness(customer)) {
				System.out.println("잔뜩 취한 손님에게는 판매하지 않습니다.");
				return;
			}
			customer.decreaseMoney(ALCOHOL_PRICE);
			customer.increaseDrunkenness(0.5);
			System.out.println("술을 판매했습니다.");
		}
		else {
			if (customer.getWallet() < BEVERAGE_PRICE) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			if (BarUtils.checkFullness(customer)) {
				System.out.println("배가 매우 부른 손님에게는 판매하지 않습니다.");
				return;
			}
			customer.decreaseMoney(BEVERAGE_PRICE);
			customer.inrcreaseFullness(0.2);
			System.out.println("음료를 판매했습니다.");
		}
	}
}