package hw0123;

import java.util.Scanner;

/**
 * 문제 20
 * Scanner 이용
 * 정수형 변수 enemyHealthPoint를 만들고 Scanner 의 nextInt() 함수를 이용해 값 할당
 * 무한히 반복 하며 난수를 생성해 enemyHealthPoint 값을 감소 시킴
 * 만약 enemyHealthPoint 값이 0이 되거나 음수가 되면 "Victory!"를 출력하며 반복문 종료
 */
public class Prob20 {
	public static void main(String[] args) {

		Scanner keybord = new Scanner(System.in);
		System.out.println("enemyHealthPoint를 입력하세요: ");
		int enemyHealthPoint = keybord.nextInt();
		int demage = 0;
		
		while (enemyHealthPoint > 0) {
			demage = (int) (Math.random() * 10) + 1;
			enemyHealthPoint -= demage;
			System.out.println("Demage :" + demage + ", Remain Health :" + enemyHealthPoint);
		}
		System.out.println("Victory!");
	}
}
