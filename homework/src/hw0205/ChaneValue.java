package hw0205;

/**
 * prob2, prob3 method 로 만들어서 풀기
 */
public class ChaneValue {
	
	public static void changeValue(int arr[], int index1, int index2) {
		int tempValue = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tempValue;
	}
	
	public static void printValue(int[] arr) {
		
		StringBuffer textBuffer = new StringBuffer();
		textBuffer.append("[");
		for (int i = 0; i < arr.length; i++) {
			textBuffer.append(arr[i]);
			if (i < arr.length - 1) {
				textBuffer.append(", ");
			}
		}
		textBuffer.append("]");
		System.out.println(textBuffer.toString());
	}
	
	public static void main(String[] args) {
	
		int[] numArray = {10, 5, 20, 4};
		System.out.print("변경 전 : ");
		printValue(numArray);
		
		changeValue(numArray, 0, 1);
		changeValue(numArray, 2, 3);
		
		System.out.print("변경 후 : ");
		printValue(numArray);
		
		int[] numArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int length = numArray2.length;
		System.out.print("변경 전 : ");
		printValue(numArray2);
		
		for (int i = 0; i < length / 2; i++) {
			changeValue(numArray2, i, length - 1 - i);
		}
		System.out.print("변경 후 : ");
		printValue(numArray2);
	}
	
}
