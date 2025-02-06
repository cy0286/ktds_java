package hw0205;

/***
 * 배열 뒤집기
 */
public class Prob3 {

	public static void main(String[] args) {
		int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int temp = 0;
		
		// 원본 배열 출력
		System.out.println("원본 배열");
		System.out.print("[");
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i]);
			if (i < numArray.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
		
		// 배열 뒤집기
		for (int i = 0; i < numArray.length / 2; i++) {
			temp = numArray[i];
			numArray[i] = numArray[numArray.length - 1 - i];
			numArray[numArray.length - 1 - i] = temp;
		}

		// 뒤바뀐 배열 출력
		System.out.println("순서가 뒤바뀐 새로운 배열");
		System.out.print("[");
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i]);
			if (i < numArray.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
}
