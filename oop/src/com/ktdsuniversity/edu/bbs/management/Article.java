package com.ktdsuniversity.edu.bbs.management;

import com.ktdsuniversity.edu.member.management.Member;

public class Article {

	Member author;
	String title;
	
	public static void main(String[] args) {
		
		Article notice = new Article();
		notice.author = new Member("system", "관리자");
		notice.title = "커뮤니티 이용 안내";
		
		System.out.println("게시글 제목: " + notice.title);
		System.out.println("작성자: " + notice.author.name);
		System.out.println("작성자 아이디: " + notice.author.id);
	}
}
