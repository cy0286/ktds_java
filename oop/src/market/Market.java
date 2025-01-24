package market;

/**
 * 자판기를 생성하고 판매/운영 수행
 */
public class Market {

	public static void main(String[] args) {
		
		// 자판기가 판매할 상품의 구체적인 정보를 가지고 있는 인스턴스들 생성
		Item item1 = new Item("박카스", 900, 15);
		Item item2 = new Item("몬스터", 1500, 20);
		Item item3 = new Item("핫식스", 1300, 10);
		Item item4 = new Item("밀키스", 1400, 5);
		
		// 자판기 인스턴스를 생성
		// 자판기가 판매할 상품의 구체적인 정보를 가지고 있는 상품 인스턴스도 함께 전달함
		VendingMachine lotte = new VendingMachine(item1, item2, item3, item4);
		
		// 자판기에서 상품 버튼을 눌러 구매
		// 반환된 정보는 구매자가 구매한 상품정보
		Item ordereditem = lotte.pressItemButton("박카스", 10);
		// orderedItem = ("박카스", 900, 10) : item(타입)
		System.out.println(ordereditem.name + " " + ordereditem.price + "원 짜리 " + ordereditem.stock + "개 구입.");
		
		ordereditem = lotte.pressItemButton("핫식스", 5);
		// orderedItem = ("핫식스", 1300, 5) : item(타입)
		System.out.println(ordereditem.name + " " + ordereditem.price + "원 짜리 " + ordereditem.stock + "개 구입.");
		
		ordereditem = lotte.pressItemButton("박카스", 6);
		// orderedItem = null, 메모리 없음 
		// Error! => NullPointerException
		// 에러 해결 방법 (null 체크)
		if (ordereditem != null) {
			System.out.println(ordereditem.name + " " + ordereditem.price + "원 짜리 " + ordereditem.stock + "개 구입.");
		}

		ordereditem = lotte.pressItemButton("갈아만든 배", 5);
		// orderedItem = null
		if (ordereditem != null) {
			System.out.println(ordereditem.name + " " + ordereditem.price + "원 짜리 " + ordereditem.stock + "개 구입.");
		}
				
		lotte.printItem();
		
		lotte.addItem("박카스", 100);
		lotte.addItem("몬스터", 100);
		lotte.addItem("핫식스", 100);
		lotte.addItem("밀키스", 100);
		lotte.printItem();
	}
}
