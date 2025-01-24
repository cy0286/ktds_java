package cafe;

/**
 * 아이스 아메리카노와 따듯한 아메리카노만 판매하는 커피숍
 * 
 * 클래스를 작성하는 순서 
 * 멤버변수, 생성자, 메소드 -> 어떤 순서로 작성되어야 하는가?
 * 
 * 1. 상수
 * 2. 멤버변수
 * 3. 생성자 (필요시)
 * 4. 메소드
 */
public class CoffeeShop {

	int iceAmericano;
	int hotAmericano;
	
	// 생성자 == 메소드
	// 생성자 메소드는 반환타입이 없음
	// 생성자 메소드의 이름은 클래스의 이름과 완전하게 동일해야 함

	//	public CoffeeShop() {
//		System.out.println("커피숍 인스턴스를 만들었습니다.");
//		System.out.println("커피숍 인스턴스: " + this);
//		iceAmericano = 2500;
//		hotAmericano = 2000;
//	}
	
	public CoffeeShop(int iceAmericano, int hotAmericano) {
		System.out.println("커피숍 인스턴스를 만들었습니다.");
		System.out.println("커피숍 인스턴스: " + this);
		// 자기가 자기한테 할당 하고 있음 (색이 같은 건 같은 변수)
		// iceAmericano = iceAmericano;
		// hotAmericano = hotAmericano;
		this.iceAmericano = iceAmericano;
		this.hotAmericano = hotAmericano;
	}
	
	/**
	 * 커피숍에서 커피를 주문하기
	 * 
	 * @param menu 1번 : 아이스아메리카노, 2번: 핫아메리카노
	 * @param quantity 커피 주문 수량 (한 번에 하나의 커피 종류만 주문 가능)
	 * @return 결제해야하는 금액
	 */
	public int orderCoffee(int menu, int quantity) {
		
		if (menu == 1) {
			// 예) megaCoffee(or starbucks) 에 있는 iceAmericano 라는 것을 알려줌
			return this.iceAmericano * quantity;
		}
		else if (menu == 2) {
			return this.hotAmericano * quantity;
		}
		// 판매하지 않는 커피를 주문하면 결제할 금액은 0원
		return 0;
	}
	
}
