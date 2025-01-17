package first_java_program;

public class Variables {
	public static void main(String args[]) {
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MAX_VALUE + 1);
		
		byte byteNumberVariable = 127; // 1, 10, 100은 가능 200은 불가능(범위를 벗어남, 127까지)
		System.out.println(byteNumberVariable);
		
		int intNumberVariable;
		intNumberVariable = 50;
		System.out.println(intNumberVariable);
		
		double doubleNumberVariable = 3.14;
		System.out.println(doubleNumberVariable);
		
		float floatNumberVariable = 3.14f; // f or F
		System.out.println(floatNumberVariable);
		
		byte firstNumber = 3;
		byte secondNumber = 4;
		byte thirdNumber = (byte) (firstNumber + secondNumber);
		System.out.println(thirdNumber);
		
		int hugeNumber = 1_000_000_000;
		long hugeNumber2 = 3_000_000_000L; // l or L
		
		boolean yesOrno = true;
		boolean yesOrno2 = false;
		
		boolean isGreateThan = 3 > 1;
		System.out.println(isGreateThan);
		
		char letter = 'a'; // 글자 한 개만 가능
		System.out.println(letter); 
		System.out.println(letter + 1); 
		System.out.println((char) (letter + 1)); 
	}
}
