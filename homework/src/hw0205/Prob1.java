package hw0205;

/**
 * 값 교환하기
 */
public class Prob1 {

	public static void main(String[] args) {
		int numberOne = 10;
		int numberTwo = 20;
		
		// 값 교환
		int temp = numberOne;
		numberOne = numberTwo;
		numberTwo = temp;
		
		System.out.println("numberOne: " + numberOne); 
		System.out.println("numberTwo: " + numberTwo);
	}
}
