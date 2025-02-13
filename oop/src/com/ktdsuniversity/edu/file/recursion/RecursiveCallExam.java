package com.ktdsuniversity.edu.file.recursion;

/**
 * Recursive Call (재귀호출)
 * - 메소드가 자신을 다시 호출하는 것
 * - a() 메소드 내부에서 a() 메소드를 다시 호출 (내가 나를 계속 호출함)
 */
public class RecursiveCallExam {

	// 2. printHello(); call
	public static void printHello() {
		// 4. 다시 호출
		int randomNumber = (int) (Math.random() * 10);
		System.out.println("재귀호출 중입니다." + randomNumber); // 3. 출력
		
		// 재귀호출의 종료는 printHello()를 다시 호출하지 않는 것
		if (randomNumber < 5) {
			printHello();
		}
		System.out.println("재귀호출이 끝나는 중입니다: " + randomNumber);
	}
	
	/**
	 * startNumber에서 0까지 재귀호출을 이용해서 출력한다
	 * @param startNumber
	 */
	public static void printNumbers(int startNumber) {
		// call stack push 할 때 실행
		System.out.println("현재 번호: " + startNumber);
		if (startNumber > 0) {  // if 조건문 없이 출력하면 -5707까지 찍힘
			printNumbers(startNumber - 1); // -1을 안 해주면 무한히 돔
		}
		// call stack pop 할 때 실행
		System.out.println("현재번호 출력 끝: " + startNumber);
	}
	
	/**
	 * startNumber부터 1까지 모두 더한 결과 값을 조회 (재귀호출)
	 * @param startNumber
	 * @return
	 */
	public static int addAllNumbers(int startNumber) {
		System.out.println("현재번호: " + startNumber);
		
		int addResult = 0;
		if (startNumber > 0) {
			addResult = addAllNumbers(startNumber - 1);
		}
		System.out.println("더한 결과: " + addResult);
		return startNumber + addResult;
		//return startNumber + addAllNumbers(startNumber -1 ); => 위의 재귀호출을 한줄로 줄인 코드
	}
	
	public static void main(String[] args) {
		// printHello(); 1. printHello(); 실행
		// printNumbers(5);;
		int result = addAllNumbers(3);
		System.out.println("\n재귀 호출 더한 최종 결과: " + result);
	}
}
