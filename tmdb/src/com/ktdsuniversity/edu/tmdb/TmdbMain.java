package com.ktdsuniversity.edu.tmdb;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.dataaccess.OracleAccess;
import com.ktdsuniversity.edu.tmdb.vo.ActrVO;
import com.ktdsuniversity.edu.tmdb.vo.CastVO;
import com.ktdsuniversity.edu.tmdb.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.vo.MvVO;

public class TmdbMain {

	private OracleAccess oracleAccess;
	
	public TmdbMain() {
		this.oracleAccess = new OracleAccess();
	}
	
	public void printAllMovies() {
		// oracleAccess에서 영화 목록을 조회해온다.
		List<MvVO> movieList = this.oracleAccess.selectMovies();
		
		movieList.forEach( mv -> {
			System.out.println("=".repeat(30));
			System.out.println("영화 아이디: " + mv.getMvId());
			System.out.println("영화 제목: " + mv.getMvTtl());
			System.out.println("영화 원 제목: " + mv.getMvOrgnlTtl());
			System.out.println("영화 부 제목: " + mv.getMvSubTtl());
			System.out.println("원어: " + mv.getMvLng());
			System.out.println("상영시간: " + mv.getMvRngTm() + "분");
			System.out.println("개봉날짜: " + mv.getMvOpnDt());
			System.out.println("영화 개요: " + mv.getMvDesc());
			System.out.println("영화 포스터: " + mv.getMvPstr());
			System.out.println("영화 개봉상태: " + mv.getMvOpnStts());
			System.out.println("영화 관람등급: " + mv.getMvRtng());
			System.out.println("영화 제작비: " + mv.getMvCst());
			System.out.println("영화 수익: " + mv.getMvPrft());
			
			mv.getGnrList()
			  .forEach(genre -> {
				System.out.println("이 영화의 장르: " + genre.getGnrNm());
			});
			
			mv.getCastList()
			  .forEach(cast -> {
				  System.out.println("이 영화 출연진: " + cast.getActr().getActrNm() + "(" + cast.getCastNm() + ")");
			  });
		});
	}
	
	public void printAllGenre() {
		List<GnrVO> genreList = this.oracleAccess.selectGenres();
		genreList.forEach(gnr -> {
			System.out.println("=".repeat(30));
			System.out.println("장르 아이디: " + gnr.getGnrId());
			System.out.println("장르 명: " + gnr.getGnrNm());
			
			gnr.getMvList()
			   .forEach(mv -> {
				System.out.println("이 장르의 영화: " + mv.getMvTtl());
			});
		});
	}
	
	public void printOneGenre() {
		// 영화정보와 영화의 장르 정보를 함께 조회한다.
		// 첫 번째로 만들어야 할 메소드 => 장르의 아이디로 장르 명 조회하기 => 영화의 장르를 모두 조회해라.
		GnrVO gnrVO = oracleAccess.selectGenre("GR-20250305-000002");
		System.out.println(gnrVO.getGnrNm());
	}
	
	public void printOneMovie() {
		// 두 번째로 만들어야 할 메소드 => 영화의 아이디로 영화 정보 조회하기 => 해당하는 장르의 영화를 모두 조회해라.
		MvVO movie = oracleAccess.selectMovie("MV-20250305-000001");
		System.out.println(movie.getMvTtl());
	}
	
	public void printGenreIdList() {
		// 영화의 아이디로 장르의 아이디 조회하기. - selectGenreIdByMovieId(String movieId): List<String>
		List<String> gnrIdList = oracleAccess.selectGenreIdByMovieId("MV-20250305-000001");
		System.out.println(gnrIdList);
	}
	
	public void printMovieIdList() {
		// 장르의 아이디로 영화의 아이디 조회하기. - selectMovieIdByGenreId(String genreId): List<String>
				List<String> mvIdList = oracleAccess.selectMovieIdByGenreId("GR-20250305-000001");
				System.out.println(mvIdList); // [MV-20250305-000001, MV-20250305-000002]
	}
	
	public void addNewGenre(String genreName) {
		int insertRowCount = oracleAccess.insertNewGenre(genreName);
		System.out.println(insertRowCount + "개의 행이 생성되었습니다.");
	}
	
	public void addNewMovie() {
		// 영화 정보
		MvVO newMovie = new MvVO();
//		newMovie.setMvId(null); <- Database에서 만들어지는 값.
		newMovie.setMvTtl("범죄도시1");
		newMovie.setMvOrgnlTtl("범죄도시1");
		newMovie.setMvSubTtl("장첸");
		newMovie.setMvLng("한국어");
		newMovie.setMvRngTm(121);
		newMovie.setMvOpnDt("2017-10-03");
		newMovie.setMvDesc("2004년 서울. 중국 하얼빈에서 활동하다 피신한 신흥 범죄조직의 악랄한 보스 장첸. 가리봉동 일대로 넘어온 장첸과 그의 일당들은 단숨에 기존 조직들을 장악하고 가장 강력한 세력인 춘식이파 보스 황사장까지 위협하며 도시 일대의 최강자로 급부상한다. 한편 대한민국을 뒤흔든 장첸 일당을 잡기 위해 오직 주먹 한방으로 도시의 평화를 유지해 온 괴물형사 마석도와 인간미 넘치는 든든한 리더 전일만 반장이 이끄는 강력반은 눈에는 눈 방식의 소탕 작전을 기획하는데...");
		newMovie.setMvPstr("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ayk6y2D5v5VACFqrPfF05MARZ9n.jpg");
		newMovie.setMvOpnStts("Y");
		newMovie.setMvRtng("19");
		newMovie.setMvCst(5_900_000);
		newMovie.setMvPrft(52_946_454);
		
		List<CastVO> moviesCastList = new ArrayList<>();
		
		CastVO cast = new CastVO();
		cast.setCastNm("마석도");
		ActrVO actr = new ActrVO();
		actr.setActrNm("마동석");
		cast.setActr(actr);
		moviesCastList.add(cast);
		
		cast = new CastVO();
		cast.setCastNm("장첸");
		actr = new ActrVO();
		actr.setActrNm("윤계상");
		cast.setActr(actr);
		moviesCastList.add(cast);
		
		cast = new CastVO();
		cast.setCastNm("장이수");
		actr = new ActrVO();
		actr.setActrNm("박지환");
		cast.setActr(actr);
		moviesCastList.add(cast);
		newMovie.setCastList(moviesCastList);
		
		// 영화의 장르정보 -> 액션, 범죄, 스릴러
		List<GnrVO> moviesGenreList = new ArrayList<>();
		GnrVO moviesGenre = new GnrVO();
		moviesGenre.setGnrNm("액션");
		moviesGenreList.add(moviesGenre);
		
		moviesGenre = new GnrVO();
		moviesGenre.setGnrNm("범죄");
		moviesGenreList.add(moviesGenre);
		
		moviesGenre = new GnrVO();
		moviesGenre.setGnrNm("스릴러");
		moviesGenreList.add(moviesGenre);
		
		// 영화에 영화의 장르정보 할당
		newMovie.setGnrList(moviesGenreList);
		
		// 영화 등록
		oracleAccess.insertNewMovie(newMovie);
	}
	
	public void deleteMovie(String movieId) {
		// 영화 삭제
		// 영화가 삭제되면, 분류 테이블의 영화 정보도 함께 삭제된다.
		// 영화가 삭제되면, 출연 테이블의 배우 정보도 함께 삭제된다.
		oracleAccess.deleteMovie(movieId);
	}
	
	public void deleteGenre(String genreId) {
		// 장르 삭제
		// 장르가 삭제되면, 분류 테이블의 장르 정보도 함께 삭제된다.
		oracleAccess.deleteGenre(genreId);
	}
	
	public void addNewActor(String name, String pht) {
		ActrVO actor = new ActrVO();
		actor.setActrNm(name);
		actor.setActrPht(pht);
		this.oracleAccess.insertNewActor(actor);
	}
	
	public void printActorByActorName(String name) {
		ActrVO actor = this.oracleAccess.selectActorByActorName(name);
		System.out.println(actor.getActrId());
		System.out.println(actor.getActrNm());
		System.out.println(actor.getActrPht());
	}
	
	public void printActorByActorId(String actorId) {
		ActrVO actor = this.oracleAccess.selectActorByActorId(actorId);
		System.out.println(actor.getActrId());
		System.out.println(actor.getActrNm());
		System.out.println(actor.getActrPht());
	}
	
	public void deleteActor(String actorId) {
		int deleteCount = this.oracleAccess.deleteActorByActorId(actorId);
		System.out.println(deleteCount + "명의 배우가 삭제됨.");
	}
	
	public void printAllActor() {
		List<ActrVO> actorList = this.oracleAccess.selectActors();
		actorList.forEach(actr -> {
			System.out.println("=".repeat(30));
			System.out.println("배우 아이디: " + actr.getActrId());
			System.out.println("배우 이름: " + actr.getActrNm());
			System.out.println("배우 프로필 사진: " + actr.getActrPht());
			System.out.println("====== 필모그래피 ======");
			actr.getCastList()
			    .forEach(cast -> {
			    	if (cast.getMv() != null) {
			    		System.out.println("영화: " + cast.getMv().getMvTtl());
			    		System.out.println("배역: " + cast.getCastNm());
			    	}
			    });
		});
	}
	
	public static void main(String[] args) {
		
		TmdbMain tmdb = new TmdbMain();
		
//		tmdb.printAllMovies();
//		tmdb.printAllGenre();
//		
//		tmdb.printOneMovie();
//		tmdb.printOneGenre();
//		
//		tmdb.printGenreIdList();
//		tmdb.printMovieIdList();
//		
////		tmdb.addNewGenre("스릴러");
////		tmdb.addNewGenre("SF");
//		
//		tmdb.addNewMovie();
//		
//		tmdb.deleteMovie("MV-20250307-000030");
//		tmdb.deleteGenre("GR-20250307-000004");
		
		// (제외) 배우 삭제
		// 배우가 삭제되면, 출연 테이블의 배우 정보도 함께 삭제된다.
		
		
		tmdb.printAllActor();
		// 직접 해보기
		// 1. 배우 조회 (PK로)
//		tmdb.printActorByActorId("AC-20250305-000001");
//		tmdb.printActorByActorId("AC-20250305-000002");
		
		// 1. 배우 조회 (이름으로) - 동명이인 고려하지 않는다.
//		tmdb.printActorByActorName("마동석");
//		tmdb.printActorByActorName("이정재");
		
		// 2. 배우 등록
		//tmdb.addNewActor("이정재", "이정재.png");
		
		// 3. 배우 삭제
		//tmdb.deleteActor("AC-20250307-000082");
		
		// 4. 영화 등록할 때 배우 등록하기
		//    (이미 등록된 배우는 등록X, 등록안된 배우만 등록O) + 출연정보 등록하기
		
		// 5. 영화 조회할 때 출연 배우 함께 조회하기 (지금은 영화 + 장르만 조회됨)
		
	}
}












