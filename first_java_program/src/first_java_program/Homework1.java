package first_java_program;

public class Homework1 {

	public static void main(String[] args) {
		
		/**
		 * 산술 연산자를 이용해 minutes와 seconds의 값을 초로 변환해 time 변수에 할당하고 출려
		 */
		System.out.println("산술 연산자 연습 문제 1");
		int minutes = 5;
		int seconds = 50;
		int time = 0;
		time = minutes * 60 + seconds;
		System.out.println(minutes + "분 " + seconds + "초는 " + time + "초 입니다.");
		
		/**
		 * 산술 연산자를 이용해 processTime으로 분과 초를 구한 다음 minutes, seconds 변수에 할당하고 출력		 
		 * */
		System.out.println("산술 연산자 연습 문제 2");
		int processTime = 145;
		minutes = processTime / 60;
		seconds = processTime % 60;
		System.out.println(processTime + "초는 " + minutes + "분 " + seconds + "초 입니다.");

		/**
		 * 섭씨온도(celsius)를 화씨온도(fahrenheit)변수로 변환해 출력 
		 */
		System.out.println("산술 연산자 연습 문제 3");
		int celsius = 30; // 섭씨온도
		int fahrenheit = 0; // 화씨온도
		fahrenheit = (celsius * 9 / 5) + 32;
		System.out.println("섭씨 " + celsius + " 도는 화씨" + fahrenheit + "도 입니다.");
	}
}
