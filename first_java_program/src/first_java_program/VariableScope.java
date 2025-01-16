package first_java_program;


public class VariableScope {
	public static void main(String args[]) {
		
		// 중괄호를 기준으로 변수의 범위를 지정
		int age = 41; // 만들어진 줄 부터 중괄호 끝날 때 까지 가능
		System.out.println(age);
		
		{
			System.out.println(age); // 블록 내부에서도 출력이 가능해짐
			
			int limit = 30;
			System.out.println(limit);
		}
		// System.out.println(limit) -> 중괄호를 벗어나서 안 됨 해당 영역에서는 limit의 존재를 모름
		System.out.println("실행이 종료되었습니다."); // 변수의 존재 유무
	}
}
