package first_java_program;

public class SwitchStatement {

	public static void main(String[] args) {
		
		// java 1.6 switch
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
		
		// Switch 를 이용해서 변수에 값을 할당하기
		// java 13 switch
		// 회원가입을 받을 때, 사용자가 등록할 수 없는 아이디 목록이 있음 (black list)
		// 관리자들이 사용하는 아이디
		// -> admin, root, superuser, administrator
		// 운영자들이 사용하는 아이디
		// -> master, operator, system, sysopr
		
		String memberId = "user";
		String memberGrade = switch (memberId) {
		case "admin":
		case "root":
		case "superuser":
		case "administrator":
			yield "관리자";
		case "master":
		case "opertor":
		case "system":
		case "sysopr":
			yield "운영자";
		default:
			yield "일반사용자";
		}; // yield 변수에 할당하라는 명령어이기 때문
		System.out.println(memberId + "는 " + memberGrade + "입니다.");
		
		// java 14 switch
		String memberId2 = "superuser";
		String memberGrade2 = switch (memberId2) {
		case "admin", "root","superuser","administrator":
			yield "관리자";
		case "master", "opertor", "system", "sysopr":
			yield "운영자";
		default:
			yield "일반사용자";
		};
		System.out.println(memberId2 + "는 " + memberGrade2 + "입니다.");
		
		// yield 간소화 -> 배열, 자료구조를 사용 시 -> 한 줄로 표현 가능
		String memberId3 = "system";
		String memberGrade3 = switch (memberId3) {
		case "admin", "root","superuser","administrator" -> "관리자";
		case "master", "opertor", "system", "sysopr" -> "운영자";
		default -> "일반사용자";
		};
		System.out.println(memberId3 + "는 " + memberGrade3 + "입니다.");
		
	}
}
