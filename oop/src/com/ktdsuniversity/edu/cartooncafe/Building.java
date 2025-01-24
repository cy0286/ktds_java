package com.ktdsuniversity.edu.cartooncafe;

public class Building {

public static void main(String[] args) {
		
		Cartoon batman = new Cartoon("베트맨", false);
		Cartoon superman = new Cartoon("슈퍼맨", false);
		Cartoon greenLantern = new Cartoon("그린랜턴", false);
		Cartoon joker = new Cartoon("조커", true);
		
		CartoonCafe dcComics = new CartoonCafe(0, batman, superman, greenLantern, joker);
		
		System.out.println("만화카페 보유금액: " + dcComics.getWallet());
		dcComics.printAllBook();
		
		dcComics.rentBook("베트맨");
		dcComics.rentBook("베트맨");
		dcComics.rentBook("조커");
		dcComics.rentBook("펭귄맨");
		
		dcComics.printAllBook();
		dcComics.returnBook("그린랜턴");
		dcComics.returnBook("베트맨");
		dcComics.returnBook("펭귄맨");
		
		dcComics.printAllBook();
		System.out.println("만화카페 보유금액: " + dcComics.getWallet());
	}
}
