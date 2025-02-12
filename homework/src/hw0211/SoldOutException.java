package hw0211;

/**
 * 상품의 재고 수가 없는 예외
 */
public class SoldOutException extends RuntimeException {
	
	public SoldOutException(String message) {
		super(message);
	}
}
