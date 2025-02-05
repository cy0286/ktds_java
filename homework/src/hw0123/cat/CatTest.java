package hw0123.cat;

/**
 * 문제 29
 * Cat 클래스로 여러가지 인스턴스 만들기
 */
public class CatTest {

	public static void main(String[] args) {
		
		Cat cat1 = new Cat("도", "코리안 숏헤어", "중형");
		Cat cat2 = new Cat("레", "메인쿤", "대형");
		Cat cat3 = new Cat("미", "노르웨이 숲", "소형");
		Cat cat4 = new Cat("파", "렉돌", "중형");
		
		cat1.introduce();
		cat1.makeSound();
		System.out.println();
		
		cat2.introduce();
		cat2.makeSound();
		System.out.println();
		
		cat3.introduce();
		cat3.makeSound();
		System.out.println();
		
		cat4.introduce();
		cat4.makeSound();
		System.out.println();
		
		cat1.setName("뽀삐");
		System.out.println(cat1.getName());
	}
}