package hw0204;

/**
 * Bar 에서 고객의 상태를 검사하기 위한 유틸리티 메소드
 */
public class BarUtils {

	/**
	 * 고객이 배부른 상태인지 확인
	 * @param customer 배부를 정도를 확인할 고객
	 * @return true 면 배부름 정도가 10 이상
	 */
	public static boolean checkFullness(Customer customer) {
		return customer.getFullness() >= 10;
	}
	
	/**
	 * 고객이 취한 상태인지 확인
	 * @param customer 취한 정도를 확인할 고객
	 * @return true 면 취함 정도가 20 이상
	 */
	public static boolean checkDrunkenness(Customer customer) {
		return customer.getDrunkenness() >= 20;
	}
}