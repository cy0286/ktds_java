package java_homework.animal;

/**
 * 문제 27
 * Animal 클래스로 여러가지 인스턴스 만들기
 * 강아지 인스턴스 여러개
 * 고양이 인스턴스 여러개
 */
public class AnimalTest {
	public static void main(String[] args) {
		
		Animal dog1 = new Animal("멍멍이", "강아지", "멍멍");
		Animal cat1 = new Animal("야옹이", "고양이", "야옹");
		Animal dog2 = new Animal("띵똥이", "강아지", "멍멍");
		Animal cat2 = new Animal("삼식이", "고양이", "미야오");
		
		dog1.introduce();
		dog1.makeSound();
		System.out.println();
		
		dog2.introduce();
		dog2.makeSound();
		System.out.println();
		
		cat1.introduce();
		cat1.makeSound();
		System.out.println();
		
		cat2.introduce();
		cat2.makeSound();
		System.out.println();
		
		cat2.setName("치즈냥이");
		cat2.setSound("야~옹");
		System.out.println(cat2.getName() + "의 울음소리 " + cat2.getSound());
	}
}	