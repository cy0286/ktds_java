package first_java_program;

/**
 * 묵시적 형변환 실습
 */
public class TypeCasting {
	public static void main(String args[]) {
		
		// 1. int (4byte) 타입의 변수 정의 및 값 할당
		int intNumber = Integer.MAX_VALUE;
		
		// 2. long (8byte) 타입의 변수 정의 및 값 할당 ( int 타입의 값을 할당 )
		long longNumber = intNumber; // 아무론 문제 없이 할당 ( 묵시적 형변환 : 작은 byte에서 큰 byte로 자연스러운 이동을 함 )
		
		// 3. 각 변수들의 값을 출력
		System.out.println(intNumber); // 2147483647
		System.out.println(longNumber); // 2147483647
		
		// ========================================================
		
		// 반대 케이스 실습
		
		// 1. long (8byte) 타입의 변수 정의 및 값 할당 ( 30억 이상의 값으로 할당 )
		long longNumber2 = 3_000_000_000L; 
		
		// 2. int (4byte) 타입의 변수 정의 및 값 할당 ( int 타입의 값을 할당 )
		// int intNumber2 = longNumber2; -> Error! int의 byte가 부족해서 생기는 문제
		// 묵시적 형변환이 불가능하므로, 개발자가 직접 형변환을 해야함
		// -- > long 타입의 값을 int 타입으로 명시해서 변환이 필요함 == > 명시적 형변환
		int intNumber2 = (int) longNumber2;
		
		// 3. 각 변수들의 값을 출력
		System.out.println(longNumber2);
		System.out.println(intNumber2);
		
		System.out.println("=============");
		
		// ========================================================
		System.out.println("decimal = > float number");
		// 실습 : 정수 -> 부동소수점
		int num = 10;
		//long num = Long.MAX_VALUE;
		float fnum = num;
		double dnum = num;
		// -> byte 크기에 상관없이 묵시적 형변환이 일어남
		
		System.out.println(num); // 10
		System.out.println(fnum); // 10.0
		System.out.println(dnum); // 10.0
		
		System.out.println("float number = > decimal");
		// 실습 : 부동소수점 -> 정수
		float fnum2 = 10.9f;
		int num2 = (int) fnum2; // 명시적 형변환 필수!
		System.out.println(fnum2); // 10.9
		System.out.println(num2); // 10
		
		double dnum2 = 11.15;
		int num3 = (int) dnum2;
		System.out.println(dnum2); // 11.15
		System.out.println(num3); // 11
		
		System.out.println("소수점 처리 ");
		// 실습 : 부동소수점 소수점 
		double dnum3 = 10.1;
		// 소수점 올림
		dnum3 = Math.ceil(dnum3); 
		System.out.println(dnum3); // 11.0
		double dnum4 = 10.9;
		// 소수점 버림
		dnum4 = Math.floor(dnum4); 
		System.out.println(dnum4); // 10.0
		double dnum5 = 15.18;
		// 소수점 반올림
		dnum5 = Math.round(dnum5); 
		System.out.println(dnum5); // 15.0
		double dnum6 = 10.56;
		dnum6 = Math.round(dnum6); 
		System.out.println(dnum6); // 11.0
		// -> 소수점 이하에 대한 처리가 안 됨
		
		System.out.println("소수점 이동시키기");
		// 실습 : 부동소수점 소수점 올림처리
		double dnum7 = 29.37;
		double dnum8 = dnum7 * 10;
		System.out.println(dnum8); // 293.7
		
		dnum8 = Math.round(dnum8);
		System.out.println(dnum8); // 294.0
		
		double dnum9 = dnum8 / 10;
		System.out.println(dnum9); //29.4
		
		System.out.println("문자열 정수 변환");
		// 실습 : 문자열 -> 정수 변환
		String numberString = "10"; // Byte의 범위 -128 ~ 127을 벗어나면 -> value out of ranges
		byte byteNumber = Byte.parseByte(numberString);
		System.out.println(byteNumber); // 10
		
		numberString = "10000"; 
		short shortNumber = Short.parseShort(numberString);
		System.out.println(shortNumber); // 10000
		
		numberString = "1000000";
		int intnumber = Integer.parseInt(numberString);
		System.out.println(intnumber); // 1000000
		
		numberString = "1000000000";
		long longNumber3 = Long.parseLong(numberString);
		System.out.println(longNumber3); // 1000000000
		
		// 실습 : 문자열 -> 정수 오류 실습 
//		numberString = "A";
//		byte byteNumber2 = Byte.parseByte(numberString);
//		System.out.println(byteNumber2); Error! 정수형이 아닌 문자열을 변환해서
		
//		numberString = "10.5";
//		byte byteNumber3 = Byte.parseByte(numberString); 
//		System.out.println(byteNumber3); Error! 정수형이 아닌 문자열을 변환함, 정수의 입장에서 소수점이 없음
//		공백도 문자로 포함함		
		
		System.out.println("소수점 변환");
		// 실습 : 문자열 -> 부동소수점 변환
		numberString = "10.5";
		// numberString = "10.123456123456"; // float이 처리할 수 있는 소수점 이하 자리수에 제한이 있음
		// numberString = "10.666666666666";
		float floatNumber = Float.parseFloat(numberString);
		System.out.println(floatNumber); // 10.5
		
		numberString = "11.577777777";
	    //  numberString = "11.12345678901234567890"; // double이 처리할 수 있는 소수점 이하 자리수에 제한이 있음
		// numberString = "11.1234567891E34567890"; -> Infinity가 나옴
		
		double doubleNumber = Double.parseDouble(numberString);
		System.out.println(doubleNumber); // 11.577777777
		
		numberString = "12";
		double doubleNumber2 = Double.parseDouble(numberString);
		System.out.println(doubleNumber2); // 12.0
	
		// 실습 : 문자열 -> 불린 변환 
		String str = "true";
		boolean bool = Boolean.parseBoolean(str);
		System.out.println(bool); // true
		
		str = "TRUE";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool); // true
		
		str = "tRUE";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool); // true
		
		str = "false";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool); // false
		
		str = "";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool); // false
		
		str = "anystring";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool); // false
		// "Java"에서는 대소문자를 구분하지 않고 "true"와 동일한 경우에만 "true"로 변환됨
		
		// 숫자를 문자로 변경하기
		// 1.
		int age = 30;
		String ageString = String.valueOf(age); // String으로 형 변환이 안 됨
		
		System.out.println(age + 1); // 31
		System.out.println(ageString + 1); // "301"
		
		// 2.
		int count = 16;
		String countString = count + ""; // 문자가 됨
		System.out.println(count + 1); // 17
		System.out.println(countString +  1); // "161"
	}
}
