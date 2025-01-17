package first_java_program;

public class ArithmeticOperator {
	public static void main(String[] args) {
		
		int number = 1_500_000_000;
		int number2 = 1_500_000_000;
		long number3 = number + (long)number2;
		System.out.println(number3); // -1294967296
		
		int number4 = 10;
		int number5 = 3;
		int number6 = number4 / number5;
		System.out.println(number6); // 3
		
		double number7 = (double) number4 / number5;
		System.out.println(number7); // 3.3333333333333335
		
		double number71 = (number4 * 1.0) / number5;
		System.out.println(number71); // 3.3333333333333335
		
		int number8 = 9;
		int remain = number8 % 2;  // % 나누기 나머지를 구하는 연산자
		System.out.println(remain); // 1 
		
		// 셀프 연산 - 스스로에게 연산하기
		int count = 0;
		count = count + 1; // 1
		count = count + 1; // 2
		count = count + 1; // 3
		System.out.println(count);
		
		int count2 = 0;
		count2 += 1; // 1
		count2 += 1; // 2
		count2 += 1; // 3
		System.out.println(count2);
		
		int count3 = 0;
		count3++; // 1
		count3++; // 2
		count3++; // 3
		System.out.println(count3);
		
		int count4 = 0;
		count4++; // 1
		System.out.println(count4);
		count4--; // 0
		System.out.println(count4);
		
		--count4; // -1
		System.out.println(count4);
		++count4; // 0
		System.out.println(count4);
		
		int count5 = 0;
		// 후위 연산, 출력을 먼저 한 후 연산을 진행함
		System.out.println(count5++); // 0
		System.out.println(count5); // 1
		System.out.println(count5--); // 1
		System.out.println(count5); // 0
		
		// 전위 연산, 연산을 진행한 후 출력함
		System.out.println(++count5); // 1
		System.out.println(--count5); // 0
		// 단항 연산자의 위치 때문에 나타난 결과
				
	}
}
