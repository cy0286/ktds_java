package cafe;

public class CoffeeShop2 {

	// 멤버 변수
	// 클래스가 클래스를 가지고 있음 -> Has A 관계
	Coffee iceAmericano; // Coffeeshop2 has a coffee
	Coffee hotAmericano;
	
	// 파라미터 있는 생성자
	public CoffeeShop2(Coffee iceAmericano, Coffee hotAmericano) {
		
		// 멤버변수에 초기값 할당
		this.iceAmericano = iceAmericano;
		this.hotAmericano = hotAmericano;
	}
	
	// 커피를 주문하는 메소드
	public int orderCoffee(int menu, int quantity) {
		
		// menu 가 1이라면
		if(menu == 1) {
			// name 을 호출하는 iceAmericano를 호출하는 CoffeShop2의 this 임  
			// cs2 가 가지고 있는 ice instance 의 name 을 출력
			System.out.println(this.iceAmericano.name);
			return this.iceAmericano.price * quantity;
		}
		System.out.println(this.hotAmericano.name);
		return this.hotAmericano.price * quantity;
	}
}
