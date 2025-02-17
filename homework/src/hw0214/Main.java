package hw0214;

import java.util.Scanner;

/**
 * 메인 클래스
 */
public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		Scanner keybord = new Scanner(System.in);
		String input;
		
		while (true) {
			System.out.println("기능을 선택하세요.");
			System.out.println("1.게시글 목록 조회");
			System.out.println("2.게시글 내용 조회");
			System.out.println("3. 게시글 등록");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("6. 댓글 등록");
			System.out.println("7. 댓글 조회");
			System.out.println("8. 댓글 삭제");
			System.out.println("0. 종료");
			System.out.println("기능 번호를 입력하세요: ");
			input = keybord.nextLine();
			
			switch (input) {
			case "0":
				System.out.println("게시판 애플리케이션을 종료합니다.");
				board.writeFile();
				return;
			case "1":
				board.getPostList();
				break;
			case "2":
				board.getPostContent(keybord);
				break;
			case "3":
				board.uploadPost(keybord);
				break;
			case "4":
				board.updatePost(keybord);
				break;
			case "5":
				board.deletePost(keybord);
				break;
			case "6":
				board.addComment(keybord);;
				break;
			case "7":
				board.getCommentList(keybord);
				break;
			case "8":
				board.deleteComment(keybord);
				break;
			default:
				System.out.println("잘못된 기능입니다. 다시 입력해주세세요.");
			}
		}
	}
}
