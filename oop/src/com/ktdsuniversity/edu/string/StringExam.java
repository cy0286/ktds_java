package com.ktdsuniversity.edu.string;

public class StringExam {

	public static void main(String[] args) {
		
		// address 에 "서울"이 포함되어 있는지 확인
		String address = "서울특별시 서초구 효령로 176";
		boolean isSeoul = address.contains("서울");
		System.out.println(isSeoul);
				
		// address 가 176으로 끝나는지 확인
		isSeoul = address.endsWith("176");
		System.out.println(isSeoul);
		
		// name 이 ktdsUniversity와 정확히 같은지 비교	
		String name = "ktdsUniversity";
		boolean isEqual = name.equals("ktdsUniversity");
		System.out.println(isEqual);
		
		// name 이 ktdsUniversity와 같은지 비교 (대소문자 구분 x)
		isEqual = name.equalsIgnoreCase("ktdsUniversity");
		System.out.println(isEqual);
		
		// format 바인딩 기능
		String format = "%s에서 교육하는 %s 과정";
		String str = String.format(format, "ktdsUniversity", "Java");
		System.out.println(str);
		
		// format 바인딩 기능 (Java 15부터 가능)
		str = format.formatted("ktdsUniversity", "Java");
		System.out.println(str);
		
		// 문자 c 의 인덱스(위치) 찾기
		String alphabets = "abcdefg";
		int letterCIndex = alphabets.indexOf('c');
		System.out.println(letterCIndex);
		
		// 문자 C 의 인덱스(위치) 찾기
		letterCIndex = alphabets.indexOf('C');
		System.out.println(letterCIndex);
		
		// 문자 def 의 인덱스(위치) 찾기
		letterCIndex = alphabets.indexOf("def");
		System.out.println(letterCIndex);
		
		// str이 비어있거나 공백으로만 이루어져있는지 확인 (Java 11부터 가능)
		String str2 = "   ";
		boolean isBlank = str2.isBlank();
		System.out.println(isBlank);
		
		// str이 공백으로 비워져있는지 확인
		isBlank = str2.isEmpty();
		System.out.println(isBlank);
		
		// message 와 name 을 ","으로 연결하기
		String message = "안녕하세요";
		String name2 = "홍길동님";
		String helloMessage = String.join(",", message, name2);
		System.out.println(helloMessage);
		
		// message 에서 "a"의 마지막 인덱스(위치) 찾기
		String message2 = "abcdefgaijkb";
		int letterALastIndex = message2.lastIndexOf("a");
		System.out.println(letterALastIndex);
		
		// message 에서 "jj"의 마지막 인덱스(위치) 찾기
		int letterJJLastIndex = message2.lastIndexOf("jj");
		System.out.println(letterJJLastIndex);
		
		// message 의 문자열 길이 구하기
		int length = message2.length();
		System.out.println(length);
		
		// phone 이 숫자인지 확인하기
		String phone = "01012341234";
		boolean isNumber = phone.matches("^[0-9]+$");
		System.out.println(isNumber);
		
		// message 에서 홍길동을 ktds 로 변경하기
		String message3 = "안녕하세요, 홍길동님, 안녕히 가세요, 홍길동님.";
		message3 = message3.replace("홍길동", "ktds");
		System.out.println(message3);
		
		// phone 에서 숫자가 아닌 문자를 공백문자("")로 변경하기
		String phone2 = "010-1234-1234";
		phone2 = phone2.replaceAll("[^0-9]", "");
		System.out.println(phone2);
		
		// phone 을 "-"로 잘라 배열에 할당하기
		String phone3 = "010-1234-1234";
		String[] phoneArea = phone3.split("-");
		System.out.println(phoneArea[0]);
		System.out.println(phoneArea[1]);
		System.out.println(phoneArea[2]);
		
		// phone 이 +82로 시작하는지 확인하기
		String phone4 = "+82-010-1234-1234";
		boolean isKoreaNum = phone4.startsWith("+82");
		System.out.println(isKoreaNum);
		
		// datetime 에서 2023(연) 글자만 잘라내어 할당하기
		String datetime = "2023-05-02 14:56:13";
		String year = datetime.substring(0, 4);
		System.out.println(year);
		
		// datetime 에서 14(시) 글자만 잘라내어 할당하기
		String hour = datetime.substring(11, 13);
		System.out.println(hour);
		
		// datetime 에서 14:56:13(시:분:초) 글자만 잘라내어 할당하기
		String time = datetime.substring(11);
		System.out.println(time);
		
		// datetime 에서 앞뒤 공백 모두 제거하기
		String datetime2 = "    2023-05-02 14:56:13    ";
		System.out.println(datetime2.length());
		System.out.println(datetime2);
		datetime2 = datetime2.trim();
		System.out.println(datetime2.length());
		System.out.println(datetime2);
		
		// int 타입 1을 문자열로 변경하기 (Overloading)
		String iStr = String.valueOf(1);
		System.out.println(iStr);
		
		// Java 에서 \ (백슬래쉬) 는 Escape Code.
		// 문자열 내부에서 표현할 수 없는 특수 문자들을 입력하기 위한 방법
		
		String path = "C:\\devprograms\\eclipse-workspace\\eclipse.exe";
		// lastIndexOf, substring 을 이용해 "eclipse.exe"만 출력
		int lastIndex = path.lastIndexOf("\\");
		String filename = path.substring(lastIndex + 1);
		System.out.println(filename);
	
		// "eclipse.exe"에서 indexOf, substring 을 이용해 "eclipse" 만 출력
		int lastDoIndex = filename.lastIndexOf(".");
		String filenameWithoutExtension = filename.substring(0, lastDoIndex);
		System.out.println(filenameWithoutExtension);
		
		// "eclipse.copy.exe" 에서 indexOf, lastIndexOf, substring 을 이용해 "copy"만 출력
		String copyName =  "eclipse.copy.exe";
		int firstIndex = copyName.indexOf(".");
		int secondIndex = copyName.lastIndexOf(".");
		String copy = copyName.substring(firstIndex + 1, secondIndex);
		System.out.println(copy);
				
		String name3 = "ktdsUniversity";
		String lowerName = name3.toLowerCase();
		System.out.println(lowerName);
		
		String upperName = name3.toUpperCase();
		System.out.println(upperName);	
	}
}
