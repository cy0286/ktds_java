package first_java_program;

public class SwitchStatement {

	public static void main(String[] args) {
		
		int step = 1;
		
		// 라면 끓이기 절차를 출력
		switch(step) {
			case 1:
				System.out.println("1. 수납장 손잡이를 잡아 문을 연다.");
			case 2:
				System.out.println("2. 수납장에서 냄비 손잡이를 잡아 꺼낸다.");
			case 3:
				System.out.println("3. 냄비를 세척해야할지 판단한다.");
				
			case 4:
				int randomNumber = (int) (Math.random() * 10);
				if (randomNumber % 2 == 0){
					System.out.println("4. 냄비가 깨끗하다면 가스레인지에 올린다.");
				}
				else if (randomNumber == 9) {
					System.out.println("4. 냄비를 씻다가 떨어뜨려 깨져버렸다. 라면을 끓일 수가 없다.");
					break; // switch 흐름을 끊음
				}
				else {
					System.out.println("4. 냄비가 더럽다면 씻어서 가스레인지에 올린다.");
				}
			case 5:
				System.out.println("5. 냉장고로 걸어가 문을 열고 생수를 꺼내서 뚜껑을 열어 냄비에 물을 550 ml 만큼 따른다.");
			case 6:
				System.out.println("6. 가스레인지에 불을 켠다.");
			case 7:
				System.out.println("7. 수납장 문을 열어 라면을 꺼내온다.");
			case 8:
				System.out.println("8. 라면 봉지를 뜯는다.");
			case 9:
				System.out.println("9. 후레이크 스프를 꺼내 뜯어 냄비에 붓는다.");
			case 10:
				System.out.println("10. 물이 끓으면 면을 꺼내서 냄비에 넣는다.");
			case 11:
				System.out.println("11. 분말스프를 꺼내 뜯어 냄비에 넣는다.");
			case 12:
				System.out.println("12. 정해진 시간을 지켜 기다린다.");
			case 13:
				System.out.println("13. 정해진 시간이 지나면 가스레인지 불을 끈다.");
			case 14:
				System.out.println("14. 그릇을 찾는다.");
			case 15:
				System.out.println("15. 수저를 찾는다.");
			case 16:
				System.out.println("16. 찾은 그릇과 수저를 식탁에 셋팅한다.");
			case 17:
				System.out.println("17. 냄비를 가스레인지에서 옮겨 내용물을 그릇에 붓는다.");
			case 18:
				System.out.println("18. 맛있게 먹는다.");
		}
	}
}
