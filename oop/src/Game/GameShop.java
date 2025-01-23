package Game;

public class GameShop {

	public static void main(String[] args) {
		
		CraneGameMachine game = new CraneGameMachine();
		
		game.isInsertCoin = false;
		game.dolls = 10;

//		인형이 없어질때까지 돈 넣고, 인형 뽑고 반복		
//		while(true) {
//			game.insertCoin();
//			int result = game.doGame();
//			if (game.dolls == 0) {
//				break;
//			}
//		}
		
		game.insertCoin();
		System.out.println("IsertionCoin: " + game.isInsertCoin);
		System.out.println("남은 인형 개수: " + game.dolls);
		System.out.println("뽑은 인형 개수: " + game.doGame());
	}
}
