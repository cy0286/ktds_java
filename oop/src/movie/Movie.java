package movie;

// 영화정보
public class Movie {

	// 멤버변수
	String title;
	
	// 멤버변수
	int runningTime;
	
	// this 는 아래 함수를 호출한 애에 해당함
	public void printMovieInformation() {
		System.out.println("Movie title : " + this.title);
		System.out.println("Movie running time : " + this.runningTime);
	}
	
}
