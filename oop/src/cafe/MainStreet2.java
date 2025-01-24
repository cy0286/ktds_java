package cafe;

public class MainStreet2 {

	public static void main(String[] args) {

		// 생성자 호출 (파라미터 추가)
		Coffee ice = new Coffee("아이스아메리카노", 2500);
		Coffee hot = new Coffee("따뜻한아메리카노", 2000);
		CoffeeShop2 cs2 = new CoffeeShop2(ice, hot);
		int price = cs2.orderCoffee(1, 5); // 커피 5잔 주문
		
		// 커피 가격 출력
		System.out.println(price);
	}
}
