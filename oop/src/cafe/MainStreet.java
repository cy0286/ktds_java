package cafe;

public class MainStreet {
	
	public static void main(String[] args) {

//		CoffeeShop megaCoffee = new CoffeeShop();
//		// 인스턴스가 만들어진 이후에도 값 변경이 가능함
//		megaCoffee.iceAmericano += 500;
//		megaCoffee.hotAmericano += 500;
		
		CoffeeShop megaCoffee = new CoffeeShop(2500, 2000);
		System.out.println(megaCoffee);
		System.out.println(megaCoffee.hotAmericano);
		System.out.println(megaCoffee.iceAmericano);
		
		// this 는 메가커피임 megaCoffee.orderCoffee 는 메가커피가 가지고 있는 orderCoffee 호출
		// 
		int megaOrderPrice = megaCoffee.orderCoffee(1, 5);
		System.out.println("메가커피에서 주문한 커피의 총 주문금액은 " + megaOrderPrice + "원 입니다.");
		
//		CoffeeShop starbucks = new CoffeeShop();
//		starbucks.iceAmericano = 6000;
//		starbucks.hotAmericano = 6000;
		// -> 이렇게 할거면 생성자를 왜 써?
		// -> 생성자 호출할 때 각 커피의 가격을 전달해서 해결
		CoffeeShop starbucks = new CoffeeShop(6000, 6000);	
		System.out.println(starbucks);
		System.out.println(starbucks.hotAmericano);
		System.out.println(starbucks.iceAmericano);
		
		int starbucksOrderPrice = starbucks.orderCoffee(2, 2);
		System.out.println("스타벅스에서 주문한 커피의 총 주문금액은 " + starbucksOrderPrice + "원 입니다.");
		
		starbucksOrderPrice = starbucks.orderCoffee(99, 2);
		System.out.println("스타벅스에서 주문한 커피의 총 주문금액은 " + starbucksOrderPrice + "원 입니다.");
	}
}
