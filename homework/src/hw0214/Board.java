package hw0214;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 게시판 클래스
 */
public class Board implements BoardOperation {
	private List<Post> posts;
	private final String FILE_NAME = "board.txt";
	// private final String FILE_PATH = "C:\\dev_program\\eclipse-workspace\\homework\\board.txt";
	public Board() {
		this.posts = new ArrayList<>();
		loadFile(); // 프로그램 시작하면 데이터 로드
	}

	/**
	 * board.txt 파일에서 데이터를 읽어와 posts 에 추가
	 */
	public void loadFile() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			System.out.println("파일이 존재하지 않습니다." + file.getAbsolutePath());
			try {
				if (file.createNewFile()) {
					System.out.println("board.txt 파일을 생성했습니다.");
				}
				else {
					System.out.println("board.txt 파일 생성을 실패했습니다.");
				}
			} 
			catch (IOException ioe) {
				ioe.getMessage();
			}
			return;
		}
		
		try {
			List<String> lines = Files.readAllLines(file.toPath());
			int i = 0;
			int j = 0;
			String line = "";
			String title = "";
			String writer = "";
			String dateString = "";
			String timeString = "";
			LocalDate date;
			LocalTime time;
			String content = "";
			
			String commentLine = "";
			int commentCount = 0;
			String commentComment = "";
			String commentWriter = "";
			String commentContent = "";
			String commentDateString = "";
			String commentTimeString = "";
			LocalDate commentDate;
			LocalTime commentTime;
			
			while (i < lines.size()) {
				line = lines.get(i).trim();
				
				if (line.equals("POST")) {
					title = lines.get(++i).substring("Title: ".length()).trim();
					writer = lines.get(++i).substring("Writer: ".length()).trim();
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					dateString = lines.get(++i).substring("Date: ".length()).trim();
					date = LocalDate.parse(dateString, dateFormatter);
					timeString = lines.get(++i).substring("Time: ".length()).trim();
					time = LocalTime.parse(timeString, timeFormatter);
					content = lines.get(++i).substring("Content: ".length()).trim();
					Post post = new Post(title, writer, content, date, time);
				
					commentLine = lines.get(++i).trim();
					commentComment = commentLine.substring("Comments: ".length()).trim();
					commentCount = Integer.parseInt(commentComment);
					
					for (j = 0; j < commentCount; j++) {
						i++; // "COMMENT" 줄
						commentWriter = lines.get(++i).substring("Writer: ".length()).trim();
						commentDateString = lines.get(++i).substring("Date: ".length()).trim();
						commentDate = LocalDate.parse(commentDateString, dateFormatter);
						commentTimeString = lines.get(++i).substring("Time: ".length()).trim();
						commentTime = LocalTime.parse(commentTimeString, timeFormatter);
						commentContent = lines.get(++i).substring("Content: ".length()).trim();
						i++; // "COMMENTEND" 줄
						Comment comment = new Comment(commentWriter, commentContent, commentDate, commentTime);
						post.addComment(comment);
					}
					i++; // "POSTEND" 줄
					this.posts.add(post);
				}
				else {
					i++;
				}
			}
			System.out.println("게시판 데이터가 로드되었습니다.");
		} 
		catch (IOException ioe) {
			ioe.getMessage();
		}
	}
	
	/**
	 * posts 의 데이터를 board.txt 에 저장
	 */
	public void writeFile() {
		File file = new File(this.FILE_NAME);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		try {
			List<String> data = new ArrayList<String>();	
			for (Post post : this.posts) {
				// 게시글과 댓글의 시작과 끝 구분 위해 필요
				data.add("POST");
				data.add("Title: " + post.getPostTitle());
				data.add("Writer: " + post.getPostWriter());
				data.add("Date: " + post.getPostWriteDate());
				data.add("Time: " + post.getPostWriteTime().format(timeFormatter));
				data.add("Content: " + post.getPostContent());
				List<Comment> comments = post.getCommentList();
				data.add("Comments: " + comments.size());
				
				for (Comment comment : comments) {
					data.add("COMMENT");
					data.add("Writer: " + comment.getCommentWriter());
					data.add("Date: " + comment.getCommentWriteDate());
					data.add("Time: " + comment.getCommentWriteTime().format(timeFormatter));
					data.add("Content: " + comment.getCommentContent());
					data.add("COMMENTEND");
				}
				data.add("POSTEND");
			}
			Files.write(file.toPath(), data);
			
			
			System.out.println("게시판 데이터가 저장되었습니다.");
		} 
		catch (IOException ioe) {
			ioe.getMessage();
		}
	}
	
	/**
	 * 1. 게시글 목록 조회
	 */
	@Override
	public void getPostList() {
		if (this.posts.isEmpty()) {
			System.out.println("등록된 게시물이 없습니다.");
			return;
		}
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		for (int i = 0; i < this.posts.size(); i++) {
			Post post = this.posts.get(i);
			System.out.printf("Index: %d | 제목: %s | 작성자: %s | 작성일시: %s %s\n"
					, i + 1, post.getPostTitle(), post.getPostWriter(), post.getPostWriteDate(), post.getPostWriteTime().format(timeFormatter));
		}
	}

	/**
	 * 2. 게시글 내용 조회
	 */
	@Override
	public void getPostContent(Scanner sc) {
		System.out.println("게시글 번호를 입력하세요: ");
		int index = sc.nextInt();
		sc.nextLine();
		if (index < 1 || index > this.posts.size()) {
			System.out.println("해당 게시글은 존재하지 않습니다.");
			return;
		}
		
		Post post = this.posts.get(index - 1);
		System.out.println("Index: " + index);
		System.out.println("제목: " + post.getPostTitle());
		System.out.println("작성자: " + post.getPostWriter() + " | 작성일시: " + post.getPostWriteDate() + " " + post.getPostWriteTime());
		System.out.println("내용: " + post.getPostContent());
		System.out.println("댓글목록");
		List<Comment> comments = post.getCommentList();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		if (comments.isEmpty()) {
			System.out.println("댓글이 없습니다. 첫 댓글의 주인공이 되어보세요.");
		}
		else {
			for (int i = 0; i < comments.size(); i++) {
				Comment comment = comments.get(i);
				System.out.printf("%d %s | %s | %s %s\n",
				i + 1, comment.getCommentContent(), comment.getCommentWriter(), comment.getCommentWriteDate(), comment.getCommentWriteTime().format(timeFormatter));
			}
		}	
	}

	/**
	 * 3. 게시글 등록
	 */
	@Override
	public void uploadPost(Scanner sc) {
		String title = "";
		while (title.trim().isEmpty()) {
			System.out.println("제목을 입력하세요: ");
			title = sc.nextLine();	
		}
		
		String writer = "";
		while (writer.trim().isEmpty()) {
			System.out.println("작성자를 입력하세요: ");
			writer = sc.nextLine();
		}
		
		System.out.println("내용읍 입력하세요: ");
		String content = sc.nextLine();
		
		Post post = new Post(title, writer, content);
		this.posts.add(post);
		System.out.println("게시글 등록이 완료되었습니다.");
		
	}

	/**
	 * 4. 게시글 수정
	 */
	@Override
	public void updatePost(Scanner sc) {
		System.out.println("수정하려는 게시글 번호를 입력하세요: ");
		int index = sc.nextInt();
		sc.nextLine();
		if (index < 1 || index > this.posts.size()) {
			System.out.println("해당 게시글은 존재하지 않습니다.");
			return;
		}
		String title = "";
		while (title.trim().isEmpty()) {
			System.out.println("제목을 입력하세요: ");
			title = sc.nextLine();
		}
		System.out.println("내용을 입력하세요; ");
		String content = sc.nextLine();
		Post post = this.posts.get(index - 1);
		post.updatePost(title, content);
		System.out.println("게시글 수정이 완료되었습니다.");
	}

	/**
	 * 5. 게시글 삭제
	 */
	@Override
	public void deletePost(Scanner sc) {
		System.out.println("삭제하고 싶은 게시글의 번호를 입력하세요: ");
		int index = sc.nextInt();
		sc.nextLine();
		if (index < 1 || index > this.posts.size()) {
			System.out.println("해당 게시글은 존재하지 않습니다.");
			return;
		}
		System.out.printf("%d번 게시글을 삭제합니다. 계속 진행할까요? (y/n): ", index);
		String key = sc.nextLine().toLowerCase();
		switch (key) {
		case "y":
			this.posts.remove(index - 1);
			System.out.println("삭제가 완료되었습니다.");
			break;
		default:
			System.out.println("삭제가 취소되었습니다.");
			break;
		}
	}

	/**
	 * 6. 댓글 등록
	 */
	@Override
	public void addComment(Scanner sc) {
		System.out.println("댓글을 등록하고 싶은 게시글의 번호를 입력하세요: ");
		int index = sc.nextInt();
		sc.nextLine();
		if (index < 1 || index > this.posts.size()) {
			System.out.println("해당 게시글은 존재하지 않습니다.");
			return;
		}
		Post post = this.posts.get(index - 1);
		System.out.printf("%d번 게시글의 %d번째 댓글을 등록합니다.\n", index, post.getCommentList().size() + 1);
		String content = "";
		while (content.trim().isEmpty()) {
			System.out.println("댓글 내용을 입력하세요: ");
			content = sc.nextLine();
		}
		String writer = "";
		while (writer.trim().isEmpty()) {
			System.out.println("댓글 작성자를 입력하세요: ");
			writer = sc.nextLine();
		}
		Comment comment = new Comment(writer, content);
		post.addComment(comment);
		System.out.println("댓글 등록이 완료되었습니다.");
	}

	/**
	 * 7. 댓글 조회
	 */
	@Override
	public void getCommentList(Scanner sc) {
		System.out.println("댓글을 조회하고 싶은 게시글의 번호를 입력하세요: ");
		int index = sc.nextInt();
		sc.nextLine();
		if (index < 1 || index > this.posts.size() ) {
			System.out.println("해당 게시글은 존재하지 않습니다.");
			return;
		}
		Post post = posts.get(index - 1);
		List<Comment> comments = post.getCommentList();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		if (comments.isEmpty()) {
			System.out.println("댓글이 없습니다. 첫 댓글의 주인공이 되어보세요.");
		}
		else {
			for (int i = 0; i < comments.size(); i++) {
				Comment comment = comments.get(i);
				System.out.printf("%d %s | %s | %s %s\n", i + 1, comment.getCommentContent(), comment.getCommentWriter(), comment.getCommentWriteDate(), comment.getCommentWriteTime().format(timeFormatter));
			}
		}
		
	}

	/**
	 * 8. 댓글 삭제
	 */
	@Override
	public void deleteComment(Scanner sc) {
		System.out.println("댓글을 삭제하고 싶은 게시글의 번호를 입력하세요: ");
		int index = sc.nextInt();
		sc.nextLine();
		if (index < 1 || index > this.posts.size()) {
			System.out.println("해당 게시글은 존재하지 않습니다.");
			return;
		}
		Post post = this.posts.get(index - 1);
		if (post.getCommentList().isEmpty()) {
			System.out.println("해당 게시글에는 댓글이 없습니다.");
			return;
		}
		System.out.println("삭제하고 싶은 댓글의 번호를 입력하세요: ");
		int commentIndex = sc.nextInt();
		sc.nextLine();
		if (commentIndex < 1 || commentIndex > post.getCommentList().size()) {
			System.out.println("해당 댓글은 존재하지 않습니다.");
			return;
		}
		System.out.printf("%d번 게시글의 %d번 댓글을 삭제합니다. 계속 진행할까요? (y/n): ", index, commentIndex);
		String key = sc.nextLine().toLowerCase();
		switch (key) {
		case "y":
			post.deleteComment(commentIndex - 1);
			System.out.println("삭제가 완료되었습니다.");
			break;
		default:
			System.out.println("삭제가 취소되었습니다.");
			break;
		}
	}
}
