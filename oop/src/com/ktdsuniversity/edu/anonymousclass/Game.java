package com.ktdsuniversity.edu.anonymousclass;

public class Game {

	public static void main(String[] args) {
		
		/*
		 * 익명클래스의 한계점
		 * 클래스 : 여러개의 interface 를 구현할 수 있음
		 * 익명클래스 : 한번에 하나의 interface 만 구현할 수 있음
		 */
		
		Unit ahri = new Ahri("페이커");
		// 익명클래스 - 클래스 구현 없이 인스턴스를 만드려면 
		// "new 추상클래스 혹은 인터페이스() {};"
		Unit other = new Unit() {


			private String characterName = "히든";
			private String playerName = "강휘원";
			
			private int hp = 10000;
			private int level = 100;
			private int mana = 20000;
			private int money = 999999;
			private int attackDamage = 5000;
			private int defence = 100000;
			private float attackSpead = 0.1f;
			
			@Override
			public int getHp() {
				return this.hp;
			}
			
			@Override
			public void setHp(int hp) {
				this.hp = hp;
			}
			
			@Override
			public int getDefence() {
				return this.defence;
			}
			
			@Override
			public void move() {
				System.out.println(this.characterName + "(" + this.playerName + ") 이동중.");
			}

			@Override
			public void basicAttack(Unit otherCharacter) {
				int otherCharacterHp = otherCharacter.getHp();
				
				// 상대 캐릭터에게 가할 공격 포인트
				int attackDamage = this.attackDamage - otherCharacter.getDefence();
				if (attackDamage < 0) {
					attackDamage = 0;
				}
				otherCharacterHp -= attackDamage;
				otherCharacter.setHp(otherCharacterHp);
			}

			@Override
			public void skillAttack(Unit otherCharacter) {
				if (this.mana < 10) {
					return;
				}
				
				this.mana -= 10;
				int otherCharacterHp = otherCharacter.getHp();
				
				// 상대 캐릭터에게 가할 공격 포인트
				int attackDamage = (this.attackDamage + this.level) - otherCharacter.getDefence();
				if (attackDamage < 0) {
					attackDamage = 0;
				}
				otherCharacterHp -= attackDamage;
				otherCharacter.setHp(otherCharacterHp);
			}

			@Override
			public void recall() {
				System.out.println(this.characterName + "(" + this.playerName + ") 가 귀환했습니다.");
			}

			@Override
			public void buyItem() {
				this.money -= 100;
				System.out.println(this.money);
			}

			@Override
			public void sellItem() {
				this.money += 80;
				System.out.println(this.money);
			}

			@Override
			public void speack() {
				String[] script = new String[] { 
						"얍!", "이동~", "공격~"
				};
				int scrptIndex = (int) (Math.random() * script.length);
				System.out.println(scrptIndex);
			}

			@Override
			public void emotion() {
				String[] script = new String[] { 
						"웃기", "울기"
				};
				int scrptIndex = (int) (Math.random() * script.length);
				System.out.println(scrptIndex);
			}

			@Override
			public void die() {
				System.out.println(this.characterName + "(" + this.playerName + ") 가 죽었습니다.");
			}
			
			@Override
			public void takeMinions() {
				this.money += 3;
			}
		};
		
		ahri.move();
		other.move();
		
		ahri.basicAttack(other);
		other.skillAttack(other);
		
		ahri.speack();
		other.speack();
	}
}
