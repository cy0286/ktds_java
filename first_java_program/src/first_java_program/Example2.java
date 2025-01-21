package first_java_program;

public class Example2 {

	// 1. 1부터 100까지의 합 구해 출력
	public static int printSummation() {
		
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
		}
		return sum;
	}
	
	// 2. 1부터 100 중 홀수의 합을 구해 출력
	public static int printOddSummation() {
		int sum = 0;
		for (int i = 1; i < 101; i +=2) {
			sum += i;
		}
		return sum;
	}
	
	// 3. 1부터 100 중 3, 5, 6의 배수만 출력
	public static void getMultiple() {
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0 && i % 5 == 0 && i % 6 == 0) {
				System.out.println(i);
			}
		}
	}
	
	// 4. * 출력
	public static void printAsterisk​​() {         
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	// 5. 연습문제1 - 초로 변환
	public static int getSeconds(int minutes, int seconds) {
		return minutes * 60 + seconds;
	}
	
	// 6. 연습문제2 - 초로 변환 2
	public static int getMinutes(int processTime) {
		return  processTime / 60;
	}
	public static int getRemainSeconds(int processTime) {
		return processTime % 60;
	}
	
	// 7. 연습문제 3 - 화씨온도로 변환
	public static int convertCelsiusToFahrenheit(int celsius) {
		return celsius * 9 / 5 + 32;
	}
	
	// 8. 연습문제 4 - 등급 반환
	public static int getSum(int korScore, int engScore, int mathScore, int progScore) {
		return korScore + engScore + mathScore + progScore;
	}
	public static int getAverage(int sum, int subjectCount)
	{
		return sum / subjectCount;
	}
	public static String getScore(int average) {
		if (average >= 95) {
			return "A+";
		}
		else if (average >= 90) {
			return "A";
		}
		else if (average >= 85) {
			return "B+";
		}
		else if (average >= 80) {
			return "B+";
		}
		else if (average >= 70) {
			return "C";
		}
		else {
			return "F";
		}
	}
	
	// 8. 연습문제 4 - 여행 여부
	public static int getAbleTravle(int age) {
		if (age >= 19) {
			return 300_000;
		}
		return 120_000;
	}
	
	public static void main(String[] args) {
	
		int sum = printSummation();
		System.out.println(sum);
		
		int odd_sum = printOddSummation();
		System.out.println(odd_sum);
		
		getMultiple();
		
		printAsterisk​​();
		
		int time = getSeconds(5, 50);
		System.out.println(time + "초");
		
		int minutes = getMinutes(145);
		int seconds = getRemainSeconds(145);
		System.out.println(minutes + "분 " + seconds + "초");
		
		int celsius = convertCelsiusToFahrenheit(30);
		System.out.println(celsius);
		
		int korScore = 90;
		int engScore = 88;
		int mathScore = 70;
		int progScore = 80;
		int sum2 = getSum(korScore, engScore, mathScore, progScore);
		int average = getAverage(sum2, 4);;
		String score = getScore(average);
		System.out.println(score);
		
		int father_cost = getAbleTravle(40);
		int mother_cost = getAbleTravle(36);
		int daughter_cost = getAbleTravle(11);
		int total_cost = father_cost + mother_cost + daughter_cost;
		System.out.println(total_cost);
		int moeny = 1_000_000;
		if (moeny - total_cost > 0) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자");
		}
	}
}
