package hw0123.cat;

/**
 * 문제 28
 * Cat 클래스 만들기
 * 속성 - 이름, 종류(코리안 숏헤어, 노르웨이 숲, 메인쿤, 렉돌 등), 크기(대형, 중형, 소형 등)
 * 기능 - 생성자, 소개하기, 울기
 */
public class Cat {

	// 멤버변수
	private String name;
	private String species;
	private String size;
	
	// 생성자
	public Cat(String name, String species, String size) {
	
		this.name = name;
		this.species = species;
		this.size = size;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	// 소개하기 메소드
	public void introduce() {
		System.out.println("이름 : " + this.name);
		System.out.println("종류 : " + this.species);
		System.out.println("크기 : " + this.size);
	}
	
	// 울기 메소드
	public void makeSound() {
		System.out.println(this.name + "의 울음소리 : 미야옹");
	}
}