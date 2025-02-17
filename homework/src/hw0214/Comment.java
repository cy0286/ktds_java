package hw0214;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 댓글 데이터 클래스
 */
public class Comment {

	private String commentContent; // 댓글 내용
	private String commentWriter; // 댓글 작성자 이름
	private LocalDate commentWriteDate; // 댓글 작성 날짜 (연월일)
	private LocalTime commentWriteTime; // 댓글 작성 시간 (시분초)
	
	public Comment(String commentWriter, String commentContent) {
		this.commentContent = commentContent;
		this.commentWriter = commentWriter;
		this.commentWriteDate = LocalDate.now();
		this.commentWriteTime = LocalTime.now();
	}
	
	// 파일에서 게시글 load 시 필요한 생성자
	public Comment(String commentWriter, String commentContent, LocalDate commentWriteDate, LocalTime commentWriteTime) {
        this.commentWriter = commentWriter;
        this.commentContent = commentContent;
        this.commentWriteDate = commentWriteDate;
        this.commentWriteTime = commentWriteTime;
    }
	
	public String getCommentContent() {
		return this.commentContent;
	}

	public String getCommentWriter() {
		return this.commentWriter;
	}
	
	public LocalDate getCommentWriteDate() {
		return this.commentWriteDate;
	}
	
	public LocalTime getCommentWriteTime() {
		return this.commentWriteTime;
	}
}
