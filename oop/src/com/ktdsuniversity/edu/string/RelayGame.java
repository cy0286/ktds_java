package com.ktdsuniversity.edu.string;

import java.util.Scanner;

public class RelayGame {

	public static void testStringBuffer() {
		
		StringBuffer textBuffer = new StringBuffer();
		
		// 버퍼에 문자열들을 채운다
		textBuffer.append(10.0f)
				  .append("this")
				  .append(textBuffer)
				  .append("2134");
		
		textBuffer.append(false);
		textBuffer.append(true);
		textBuffer.append('a');
		textBuffer.append("adflkjasdf");
		
		// 버퍼에 있는 내용들을 하나의 스트링으로 모아준다
		String text = textBuffer.toString();
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		
		// testStringBuffer();
		
		// 1. 시작 단어 제시
		String startWord = "자전거";
		
		int wordLength = 0;
		int relayCount = 0;
		String endLetter = null;
		String nextWord = null;
		Scanner keybord = new Scanner(System.in);
		
		StringBuffer wordBuffer = new StringBuffer();
		
		while (true) {
			// 2. 시작 단어에서 마지막 글자 추출하기
			wordLength = startWord.length(); // 시작 단어의 길이를 구한다
			endLetter = startWord.substring(wordLength - 1); // 시작 단어의 마지막 글자를 추출한다

			// 3. 사용자로부터 다음 단어를 입력받는다.
			System.out.println("제시단어 : " + startWord);
			System.out.println("다음 단어를 입력해주세요.");

			nextWord = keybord.nextLine(); // 다음 단어를 입력받는다
			nextWord = nextWord.trim(); // 좌우공백을 제거한 다음 단어를 할당받는다

			// 4. 다음 단어가 시작 단어의 마지막 글자로 시작하는가?
			// 5. 다음 단어가 3글자 이상인가?
			if (nextWord.startsWith(endLetter) && nextWord.length() >= 3) {
				// 6. 다음 단어를 시작 단어로 옮긴다
				startWord = nextWord;
				// 7. 이어나간 단어의 수를 1 증가시킨다
				relayCount++;
				// 8. 다음 단어를 버퍼에 넣는다
				wordBuffer.append(startWord);
				wordBuffer.append("\n");
			}
			else {
				System.out.println("게임이 종료되었습니다.");
				System.out.println("총 " + relayCount + "번 이어나갔습니다.");
				System.out.println("이어나간 단어들 입니다.");
				System.out.println(wordBuffer.toString());
				return;
			}
			
			// 4. 다음 단어가 시작 단어의 마지막 글자로 시작하는가?
//			if (nextWord.startsWith(endLetter)) {
//
//				// 5. 다음 단어가 3글자 이상인가?
//				if (nextWord.length() >= 3) {
//					// 6. 다음 단어를 시작 단어로 옮긴다
//					startWord = nextWord;
//					// 7. 이어나간 단어의 수를 1 증가시킨다
//					relayCount++;
//				} 
//				else {
//					System.out.println("게임이 종료되었습니다.");
//					System.out.println("총 " + relayCount + "번 이어나갔습니다.");
//					return;
//				}
//			} 
//			else {
//				System.out.println("게임이 종료되었습니다.");
//				System.out.println("총 " + relayCount + "번 이어나갔습니다.");
//				return;
//			}
		}
	}
}
