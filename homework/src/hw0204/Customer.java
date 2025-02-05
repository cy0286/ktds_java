package hw0204;

/**
 * bar 의 고객 정보를 관리
 */
public class Customer {

	/**
	 * 고객의 나이
	 */
	private int age;
	/**
	 * 고객의 돈
	 */
	private int wallet;
	/**
	 * 고객의 취한 정도
	 */
	private double drunkenness;
	/**
	 * 고객의 배부른 정도
	 */
	private double fullness;
	
	public Customer(int age, int wallet) {
		this.age = age;
		this.wallet = wallet;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getWallet() {
		return this.wallet;
	}
	
	public double getDrunkenness() {
		return this.drunkenness;
	}

	public double getFullness() {
		return this.fullness;
	}
	
	/**
	 * 고객의 취한 정도 증가
	 * @param amount 증가할 취한 정도
	 */
	public void increaseDrunkenness(double amount) {
		this.drunkenness += amount;
	}
	
	/**
	 * 고객의 배부른 정도 증가
	 * @param amount 증가할 배부름 정도
	 */
	public void inrcreaseFullness(double amount) {
		this.fullness += amount;
	}
	
	/**
	 * 고객의 지갑 잔액 감소	
	 * @param amount 감소할 금액
	 */
	public void decreaseMoney(int amount) {
		this.wallet -= amount;
	}
}