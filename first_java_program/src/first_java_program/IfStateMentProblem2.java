package first_java_program;

public class IfStateMentProblem2 {

	public static void main(String[] args) {
		
//		int money = 1_000_000;
//		int father = 40;
//		int mother = 36;
//		int daughter = 11;
		
		int money = (int) (Math.random() * 1_000_000);
		int father = (int) (Math.random() * 100);
		int mother = (int) (Math.random() * 100);
		int daughter = (int) (Math.random() * 100);
		// int father = (int) (Math.random() * 80) + 20; // 20 ~ 99 - 최소 나이 최대 나이 설정 가능
		
		System.out.println("아빠 나이는 " + father + " 엄마 나이는 " + mother + " 딸 나이는 " + daughter);
		System.out.println("총 여행 경비 " + money);
		
		int adultOneWayFlightFare = 300_000;
		int kindOneWayFlightFare = 120_000;
		int cost = 0;
		
		if (father > 19) {
			cost += adultOneWayFlightFare;
		}
		else {
			cost += kindOneWayFlightFare;
		}
		if (mother > 19) {
			cost += adultOneWayFlightFare;
		}
		else {
			cost += kindOneWayFlightFare;
		}
		if (daughter > 19) {
			cost += adultOneWayFlightFare;
		}
		else {
			cost += kindOneWayFlightFare;
		}
		
		System.out.println("쓴 돈 : " + cost);
		System.out.println("남은 돈 : " + (money - cost));
		if (money - cost > 0) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에가자");
		}
	}
}
