package hw0214;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 데이터 클래스
 */
public class Post {

	private String postTitle; // 게시글 제목
	private LocalDate postWriteDate; // 게시글 작성 날짜(연월일)
	private LocalTime postWriteTime; // 게시글 작성 시간(시분초)
	private String postWriter; // 게시글 작성자 이름
	private String postContent; // 게시글 내용
	private List<Comment> commentList; // 댓글 목록
	
	public Post(String postTitle, String postWriter, String postContent) {
		this.postTitle = postTitle;
		this.postWriter = postWriter;
		this.postContent = postContent;
		this.postWriteDate = LocalDate.now();
		this.postWriteTime = LocalTime.now();
		this.commentList = new ArrayList<>();
	}
	
	// 파일에서 게시글 load 시 필요한 생성자
	public Post(String postTitle, String postWriter, String postContent, LocalDate postWriteDate, LocalTime postWriteTime) {
	    this.postTitle = postTitle;
	    this.postWriter = postWriter;
	    this.postContent = postContent;
	    this.postWriteDate = postWriteDate;
	    this.postWriteTime = postWriteTime;
	    this.commentList = new ArrayList<>();
	}
	
	// 게시글 수정
	public void updatePost(String postTitle, String postContent) {
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postWriteDate = LocalDate.now();
		this.postWriteTime = LocalTime.now();
	}
	
	public String getPostTitle() {
		return this.postTitle;
	}
	
	public LocalDate getPostWriteDate() {
		return this.postWriteDate;
	}
	
	public LocalTime getPostWriteTime() {
		return this.postWriteTime;
	}
	
	public String getPostWriter() {
		return this.postWriter;
	}

	public String getPostContent() {
		return this.postContent;
	}
	
	public List<Comment> getCommentList() {
		return this.commentList;
	}	

	public void setPostWriteDate(LocalDate postWriteDate) {
		this.postWriteDate = postWriteDate;
	}
	
	public void setPostWriteTime(LocalTime postWriteTime) {
		this.postWriteTime = postWriteTime;
	}
	
	// 댓글 등록
	public void addComment(Comment comment) {
		this.commentList.add(comment);
	}
	
	// 댓글 삭제
	public void deleteComment(int index) {
		if (index >= 0 && index < commentList.size()) {			
			this.commentList.remove(index);
		}
	}
}
	
