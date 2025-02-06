package hw0205;

/**
 * 배열 요소 값 교환하기
 */
public class Prob2 {

	public static void main(String[] args) {
		int[] numArray = {10, 5, 20, 4};
		
		// 배열 값 교환
		int temp = numArray[0];
		numArray[0] = numArray[1];
		numArray[1] = temp;
		
		temp = numArray[2];
		numArray[2] = numArray[3];
		numArray[3] = temp;

		// 교환한 배열 출력
		System.out.print("[");
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i]);
			if (i < numArray.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
}
