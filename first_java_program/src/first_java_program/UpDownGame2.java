package first_java_program;

import java.util.Scanner; // command + shift + O 사용시 생김

public class UpDownGame2 {

	public static void main(String[] args) {
		
		// 1. 정수(난수) 생성
		int quiz = (int) (Math.random() * 100) + 1; // 0 ~ 99 -> 1 ~ 100
		 
		// 2. 사용자에게 값을 입력 받음
		Scanner keyborkd = new Scanner(System.in);
		
		int fail_count = 0;
		
		while(true) {
			int answer = keyborkd.nextInt();
	
			// 3. 난수가 사용자가 입력한 값이 같은지 비교
			if (quiz == answer) {
				System.out.println("정답입니다.");
				break;
			}
			// 난수와 사용자가 입력한 값이 틀렸을 때 실패 횟수를 1 증가
			// 실패 횟수가 3보다 크거나 같다면, 게임 종료
			fail_count ++;
			
			// 실패횟수가 3보다 크거나 같다면 게임을 종료시킴
			if (fail_count >= 3) {
				System.out.println("3회 이상 틀려서 게임을 종료합니다.");
				System.out.println("정답은 " + quiz + "이였습니다.");
				break;	
			}
			// 4. 난수가 사용자가 입력한 값보다 큰지 비교
			else if (quiz > answer) {
				System.out.println("더 큰 수를 입력하세요.");
			}
			// 5. 난수가 사용자가 입력한 값보다 더 작은지 비교
			else {
				System.out.println("더 작은 수를 입력하세요.");
			}
		}
	}
}
