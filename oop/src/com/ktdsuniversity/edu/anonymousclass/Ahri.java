package com.ktdsuniversity.edu.anonymousclass;

public class Ahri implements Unit {

	private String characterName;
	private String playerName;
	
	private int hp;
	private int level;
	private int mana;
	private int money;
	private int attackDamage;
	private int defence;
	private float attackSpead;
	
	public Ahri(String playerName) {
		this.characterName = "아리";
		this.playerName = playerName;
		this.level = 1;
		this.hp = 100;
		this.mana = 100;
		// this.money = 0;
		this.attackDamage = 20;
		this.defence = 10;
		this.attackSpead = 1.5f;
	}
	
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
}
