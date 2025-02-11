package com.ktdsuniversity.edu.errorhandle;

import com.ktdsuniversity.edu.errorhandle.customexceptions.InvalidUserIdException;

public class Main {

	// 회원가입을 하는 메소드
	public static void registNewMember(String id, String password) {
		if (id == null || id.isEmpty()) {
//			System.out.println("아이디는 필수 입력값입니다. 올바르게 입력해주세요.");
			throw new InvalidUserIdException("아이디는 필수 입력값입니다. 올바르게 입력해주세요.");
		} 
		else if (id.equals("admin")) {
//			System.out.println("admin은 사용할 수 없습니다. 다른 아이디를 사용해주세요.");
			throw new InvalidUserIdException("admin은 사용할 수 없습니다. 다른 아이디를 사용해주세요.");
		}
//		성공 케이스는 다루지 않음
//		else {
//			System.out.printf("아이디: %s, 비밀번호: %s 가입이 완료되었습니다.\n", id, password);
//		}
	}

	public static void main(String[] args) {

		try {
			registNewMember(null, "abcde");
		} 
		catch (InvalidUserIdException iuie) {
			System.out.println("실패 사유: " + iuie.getMessage());
		}

		try {
			registNewMember("", "abc");
		} 
		catch (InvalidUserIdException iuie) {
			System.out.println("실패 사유: " + iuie.getMessage());
		}

		try {
			registNewMember("admin", "abc123");
		} 
		catch (InvalidUserIdException iuie) {
			System.out.println("실패 사유: " + iuie.getMessage());
		}

		try {
			registNewMember("aaa", "a1234");
		} 
		catch (InvalidUserIdException iuie) {
			System.out.println("실패 사유: " + iuie.getMessage());
		}

		// InvalidUserIdException iuie = new InvalidUserIdException("사용할 수 없는 아이디 입니다.
		// 다른 아이디를 사용해 주세요.");

		// 일반 클래스와 다른 점 : RuntimeException 상속함
		// System.out.println(iuie.getMessage());

		// throw new NumberFormatException("For input string: sadsf")
		// Integer.parseInt("sadsf");

		// RuntimeException 을 상속했을 때 할 수 있는 것?
		// iuie 예외를 던져서 애플리케이션을 강제로 죽일 수 있음
		// throw iuie;
		// throw new InvalidUserIdException(" 메시지 메시지 메시지 ");

		// throw 된 이후에(죽은 이후) 코드는 실행되지 않음
		// System.out.println("안녕");
	}
}
