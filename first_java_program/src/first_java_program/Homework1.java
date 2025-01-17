package first_java_program;

public class Homework1 {

	public static void main(String[] args) {
		
		System.out.println("산술 연산자 연습 문제 1");
		int minutes = 5;
		int secondes = 50;
		int time = 0;
		time = minutes * 60 + secondes;
		System.out.println(time + "초");
		
		System.out.println("산술 연산자 연습 문제 2");
		int processTime = 145;
		minutes = processTime / 60;
		secondes = processTime % 60;
		System.out.println(minutes + "분" + secondes + "초");

		System.out.println("산술 연산자 연습 문제 3");
		int celsius = 30; // 섭씨온도
		int fahrenheit = 0; // 화씨온도
		fahrenheit = (celsius * 9/5) + 32;
		System.out.println(fahrenheit);
	}
}
