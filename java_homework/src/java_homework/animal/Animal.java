package java_homework.animal;

/**
 * 문제 26
 * Animal 클래스 만들기
 * 멤버변수 - 이름, 종류(강아지, 고양이 등등), 울음소리
 * 메소드 - 생성자, 소개하기, 울기
 */
public class Animal {

	// 멤버변수
	private String name;
	private String species;
	private String sound;
	
	// 생성자
	public Animal(String name, String species, String sound) {
	
		this.name = name;
		this.species = species;
		this.sound = sound;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public String getSound() {
		return this.sound;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	// 소개하기 메소드
	public void introduce() {
	
		System.out.println("이름 : " + this.name);
		System.out.println("종류 : " + this.species);
	}
	
	// 울기 메소드
	public void makeSound() {
		System.out.println(this.name + "의 울음소리 " + this.sound);
	}
}