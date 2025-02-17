package hw0214;

import java.util.Scanner;

/**
 * 게시판 기능 인터페이스
 */
public interface BoardOperation {

	public void getPostList(); // 게시글 목록 조회
	public void getPostContent(Scanner sc); // 게시글 내용 조회
	public void uploadPost(Scanner sc); // 게시글 등록
	public void updatePost(Scanner sc); // 게시글 수정
	public void deletePost(Scanner sc); // 게시글 삭제
	public void addComment(Scanner sc); // 댓글 등록
	public void getCommentList(Scanner sc); // 댓글 조회
	public void deleteComment(Scanner sc); // 댓글 삭제
}