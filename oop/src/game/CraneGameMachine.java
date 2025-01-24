package game;
import java.util.Random;

public class CraneGameMachine {

	boolean isInsertCoin;
	int dolls;
	
	// 동전 넣는 메소드
	public void insertCoin() {
		if (dolls > 0) {
			isInsertCoin = true;
			System.out.println("동전을 넣었습니다. 게임을 진행합니다.");
		}
		else {
			System.out.println("인형이 없습니다. 게임을 진행할 수 없습니다.");
		}
		// isInsertCoin = dolls > 0; -> 이렇게도 가능
	}
	
	// 게임 진행 메소드
	public int doGame() {
		if (isInsertCoin) {
			// int result = (int) (Math.random() * 2); 
			Random random = new Random();
			int result = random.nextInt(2); // 0 또는 1 반환
			
			if (result == 1) {
				dolls --;
				System.out.println("인형을 뽑았습니다.");
			}
			else {
				System.out.println("인형을 뽑지못했습니다.");
			}
			isInsertCoin  = false;
			return result;
		}
		return 0;
		}
}
