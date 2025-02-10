package com.ktdsuniversity.edu.anonymousclass;

/**
 * LOL 캐릭터
 * 이동
 * 기본공격
 * 스킬공격
 * 귀환
 * 아이템구매
 * 아이템판매
 * 대사외치기
 * 감정표현
 * 사망
 * 미니언 잡기
 */
public interface Unit {

	public void move();
	public void basicAttack(Unit otherCharacter);
	public void skillAttack(Unit otherCharacter);
	public void recall();
	public void buyItem();
	public void sellItem();
	public void speack();
	public void emotion();
	public void die();
	public void takeMinions();
	
	public int getHp();
	public void setHp(int hp);
	public int getDefence();
}
