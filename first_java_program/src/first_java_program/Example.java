package first_java_program;

public class Example {

	public static void main(String[] args) {
		
		// 1. 1부터 100 까지의 합을 구해 출력
		System.out.println("1번");
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println();
		
		// 2. 1부터 100 중 홀수의 합을 구해 출력
		System.out.println("2번");
		int odd_sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				odd_sum += i;
			}
		}
		System.out.println(odd_sum);
		System.out.println();
		
		// 3. 1부터 100 중 3, 5, 6의 배수만 출력
		System.out.println("3번");
		for (int i = 1; i <= 100; i ++) {
			if (i % 3 == 0 && i % 5 == 0 && i % 6 == 0) {
				System.out.println(i);
			}
		}
		System.out.println();
		
		// 4. 별표 그리기
		System.out.println("4번");
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 추가 문제
		// num = 7237일 때 각 자리의 합 구하기
		System.out.println("추가 문제 1");
		int num = 7237;
		int num_sum = 0;
		
		for(; num > 0; num /= 10) {
			num_sum += num % 10;
		}
		System.out.println("모든 자리를 더하면 " + num_sum + "입니다.");
		System.out.println();
		
//		while (num > 0) {
//			num_sum += num % 10;
//			num /= 10;
//		}
//		System.out.println(num_sum);
		
		// 추가 문제 2
		// num = 7327이 몇 자리 인지 구하기
		System.out.println("추가 문제 2");
		int num2 = 7237;
		String str1 = Integer.toString(num2);
		System.out.println(str1.length() + "자리");
	
//		강사님 풀이
//		case 1. 자리수마다 더하기
//		num = 7327;
//		int length = (int) Math.log10(num) + 1;
//		int sum3 = 0;
//		for (int i = 0; i < length; i++) {
//			int n = num % 10;
//			sum3 +=n;
//			num/= 10;
//		}
//		System.out.println(sum3);
//		
//		case 2. 자리수마다 더하기 (문자열로)
//		num = 7237;
//		String numStr = num + "";
//		int sum4 = 0;
//		for (char n: numStr.toCharArray()) {
//			sum4 += Integer.parseInt(n + "");
//		}
//		System.out.println(sum4);
	}
}
