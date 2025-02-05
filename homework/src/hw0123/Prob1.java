package hw0123;

/**
 * 문제 1
 * 손님이 영화관에 10_000원을 가지고 입장함
 * 손님은 관람비가 18_000원인 영화를 관람하려고 함
 * 영화를 관람할 수 있다면 -> "관람가능" 출력 후 지불하고 남은 금액 출력
 * 영화를 관람할 수 없다면 -> "관람불가능" 출력 후 모자란 금액 출력
 */
public class Prob1 {
	
	public static void main(String[] args) {
	
		int money = 10_000;
		int moviePrice = 18_000;
		
		if (money >= moviePrice) {
			System.out.println("관람가능");
			System.out.println("남은 금액: " + (money - moviePrice) + "원");
		}
		else {
			System.out.println("관람불가능");
			System.out.println("모자란 금액: " + (money - moviePrice) + "원");
		}
	}
}