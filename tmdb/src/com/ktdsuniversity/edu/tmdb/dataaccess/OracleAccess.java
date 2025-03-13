package com.ktdsuniversity.edu.tmdb.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.vo.ActrVO;
import com.ktdsuniversity.edu.tmdb.vo.CastVO;
import com.ktdsuniversity.edu.tmdb.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.vo.MvVO;

public class OracleAccess {

	// 영화 목록을 조회 한다.
	public List<MvVO> selectMovies() {
		
		try {
			// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null; //DB와 연결되어있는 세션(DriverManager가 열어줌)
		try {
			String oracleURL = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(oracleURL, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스 접속할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT MV_ID                                                                 ");
		query.append("      , MV_TTL                                                                ");
		query.append("      , MV_ORGNL_TTL                                                          ");
		query.append("      , MV_SUB_TTL                                                            ");
		query.append("      , MV_LNG                                                                ");
		query.append("      , MV_RNG_TM                                                             ");
		query.append("      /*, FLOOR(MV_RNG_TM / 60) || '시간 ' || MOD(MV_RNG_TM, 60) || '분'*/    ");
		query.append("      , TO_CHAR(MV_OPN_DT, 'YYYY-MM-DD') AS MV_OPN_DT                         ");
		query.append("      , MV_DESC                                                               ");
		query.append("      , MV_PSTR                                                               ");
		query.append("      , CASE MV_OPN_STTS                                                      ");
		query.append("          WHEN 'Y' THEN '개봉됨'                                              ");
		query.append("          ELSE '개봉예정'                                                     ");
		query.append("        END AS MV_OPN_STTS                                                    ");
		query.append("      , CASE MV_RTNG                                                          ");
		query.append("          WHEN 'ALL' THEN '전체관람가'                                        ");
		query.append("          ELSE MV_RTNG || '세 이상 관람가'                                    ");
		query.append("        END AS MV_RTNG                                                        ");
		query.append("      , MV_CST                                                                ");
		query.append("      , MV_PRFT                                                               ");
		query.append("   FROM MV                                                                    ");
		
		// 데이터베이스에 전달할 쿼리 객체를 생성.
		PreparedStatement pstmt = null; // DB와 연결되어 있는 세션.(Connection이 열어줌)
		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null; // DB와 연결되어 있는 세션.(PreparedStatement가 열어줌)
		try {
			fetchResult = pstmt.executeQuery(); // 데이터베이스에 SELECT 쿼리 실행을 요청한다.
		} catch (SQLException e) {
			e.printStackTrace();
			// 이 시점에 열려있는 세션
			// Connection Open
			// PreparedStatement Open
			// ResultSet Close
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}
		
		// 3-1. List<MvVO>에 하나씩 add한다.
		List<MvVO> movieList = new ArrayList<>();
		MvVO movie = null;
		// Fetch Row를 하나씩 순회하면서 MvVO인스턴스로 생성하고
		//  MvVO인스턴스를 movieList에 add한다.
		try {
			while (fetchResult.next()) {
				movie = new MvVO();
				movie.setMvId( fetchResult.getString("MV_ID") );
				movie.setMvTtl( fetchResult.getString("MV_TTL") );
				movie.setMvOrgnlTtl( fetchResult.getString("MV_ORGNL_TTL") );
				movie.setMvSubTtl( fetchResult.getString("MV_SUB_TTL") );
				movie.setMvLng( fetchResult.getString("MV_LNG") );
				movie.setMvRngTm( fetchResult.getInt("MV_RNG_TM") );
				movie.setMvOpnDt( fetchResult.getString("MV_OPN_DT") );
				movie.setMvDesc( fetchResult.getString("MV_DESC") );
				movie.setMvPstr( fetchResult.getString("MV_PSTR") );
				movie.setMvOpnStts( fetchResult.getString("MV_OPN_STTS") );
				movie.setMvRtng( fetchResult.getString("MV_RTNG") );
				movie.setMvCst( fetchResult.getLong("MV_CST") );
				movie.setMvPrft( fetchResult.getLong("MV_PRFT") );
				
				// 이 영화의 장르아이디를 모두 조회해온다.
				List<String> genreIdList = 
						this.selectGenreIdByMovieId( 
								fetchResult.getString("MV_ID") );
				
				// 장르아이디 목록을 반복하면서 해당 장르 정보를 하나씩 조회해온다.
				List<GnrVO> gnrList = new ArrayList<>();
				for (String genreId : genreIdList) {
					GnrVO gnrVO = this.selectGenre(genreId);
					gnrList.add(gnrVO);
				}
				
				// 장르 목록을 movie 인스턴스에 할당해준다.
				movie.setGnrList(gnrList);
				
				List<CastVO> castList = this.selectCastbyMovieId(fetchResult.getString("MV_ID"));
				movie.setCastList(castList);
				
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			
			// 이 시점에 열려있는 세션
			// ResultSet Open (fetchResult)
			// PreparedStatement Open (pstmt)
			// Connection Open (session)
			
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
			
		}
		
		// 4. 영화 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return movieList;
	}
	
	// 파라미터로 전달한 영화의 정보만 조회한다.
	public MvVO selectMovie(String movieId) {
		
		try {
			// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null; //DB와 연결되어있는 세션(DriverManager가 열어줌)
		try {
			String oracleURL = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(oracleURL, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스 접속할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT MV_ID                                                                 ");
		query.append("      , MV_TTL                                                                ");
		query.append("      , MV_ORGNL_TTL                                                          ");
		query.append("      , MV_SUB_TTL                                                            ");
		query.append("      , MV_LNG                                                                ");
		query.append("      , MV_RNG_TM                                                             ");
		query.append("      /*, FLOOR(MV_RNG_TM / 60) || '시간 ' || MOD(MV_RNG_TM, 60) || '분'*/    ");
		query.append("      , TO_CHAR(MV_OPN_DT, 'YYYY-MM-DD') AS MV_OPN_DT                         ");
		query.append("      , MV_DESC                                                               ");
		query.append("      , MV_PSTR                                                               ");
		query.append("      , CASE MV_OPN_STTS                                                      ");
		query.append("          WHEN 'Y' THEN '개봉됨'                                              ");
		query.append("          ELSE '개봉예정'                                                     ");
		query.append("        END AS MV_OPN_STTS                                                    ");
		query.append("      , CASE MV_RTNG                                                          ");
		query.append("          WHEN 'ALL' THEN '전체관람가'                                        ");
		query.append("          ELSE MV_RTNG || '세 이상 관람가'                                    ");
		query.append("        END AS MV_RTNG                                                        ");
		query.append("      , MV_CST                                                                ");
		query.append("      , MV_PRFT                                                               ");
		query.append("   FROM MV                                                                    ");
		// query.append("  WHERE MV_ID = " + movieId + " "); // Black Hacker들의 먹잇감. - 개인정보 유출
		query.append("  WHERE MV_ID = ? "); // ? 자리에 파라미터 값(movieId)가 할당된다.
		
		// 데이터베이스에 전달할 쿼리 객체를 생성.
		PreparedStatement pstmt = null; // DB와 연결되어 있는 세션.(Connection이 열어줌)
		try {
			pstmt = session.prepareStatement(query.toString());
			// ? 파라미터의 값을 채워준다.
			// ?의 순서대로 값이 채워진다.
			pstmt.setString(1, movieId); // 첫 번째 물음표에 값을 채운다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null; // DB와 연결되어 있는 세션.(PreparedStatement가 열어줌)
		try {
			fetchResult = pstmt.executeQuery(); // 데이터베이스에 SELECT 쿼리 실행을 요청한다.
		} catch (SQLException e) {
			e.printStackTrace();
			// 이 시점에 열려있는 세션
			// Connection Open
			// PreparedStatement Open
			// ResultSet Close
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}
		
		// 3-1. List<MvVO>에 하나씩 add한다.
		MvVO movie = null;
		// Fetch Row를 하나씩 순회하면서 MvVO인스턴스로 생성하고
		//  MvVO인스턴스를 movieList에 add한다.
		try {
			while (fetchResult.next()) {
				movie = new MvVO();
				movie.setMvId( fetchResult.getString("MV_ID") );
				movie.setMvTtl( fetchResult.getString("MV_TTL") );
				movie.setMvOrgnlTtl( fetchResult.getString("MV_ORGNL_TTL") );
				movie.setMvSubTtl( fetchResult.getString("MV_SUB_TTL") );
				movie.setMvLng( fetchResult.getString("MV_LNG") );
				movie.setMvRngTm( fetchResult.getInt("MV_RNG_TM") );
				movie.setMvOpnDt( fetchResult.getString("MV_OPN_DT") );
				movie.setMvDesc( fetchResult.getString("MV_DESC") );
				movie.setMvPstr( fetchResult.getString("MV_PSTR") );
				movie.setMvOpnStts( fetchResult.getString("MV_OPN_STTS") );
				movie.setMvRtng( fetchResult.getString("MV_RTNG") );
				movie.setMvCst( fetchResult.getLong("MV_CST") );
				movie.setMvPrft( fetchResult.getLong("MV_PRFT") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			
			// 이 시점에 열려있는 세션
			// ResultSet Open (fetchResult)
			// PreparedStatement Open (pstmt)
			// Connection Open (session)
			
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
			
		}
		
		// 4. 영화 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return movie;
	}
	
	// 장르 목록을 조회 한다.
	public List<GnrVO> selectGenres() {
		
		// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT GNR_ID ");
		query.append("      , GNR_NM ");
		query.append("   FROM GNR ");
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		List<GnrVO> genreList = new ArrayList<>();
		GnrVO genre = null;
		
		try {
			while(fetchResult.next()) {
				genre = new GnrVO();
				genre.setGnrId( fetchResult.getString("GNR_ID") );
				genre.setGnrNm( fetchResult.getString("GNR_NM") );
				List<String> mvIdList = this.selectMovieIdByGenreId( fetchResult.getString("GNR_ID") );
				List<MvVO> mvList = new ArrayList<>();
				for (String movieId : mvIdList) {
					MvVO mvVO = this.selectMovie(movieId);
					mvList.add(mvVO);
				}
				genre.setMvList(mvList);
				genreList.add(genre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return genreList;
	}
	
	public GnrVO selectGenre(String genreId) {
		
		// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT GNR_ID ");
		query.append("      , GNR_NM ");
		query.append("   FROM GNR ");
		query.append("  WHERE GNR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		GnrVO genre = null;
		
		try {
			while(fetchResult.next()) {
				genre = new GnrVO();
				genre.setGnrId( fetchResult.getString("GNR_ID") );
				genre.setGnrNm( fetchResult.getString("GNR_NM") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return genre;
	}
	
	public List<String> selectGenreIdByMovieId(String movieId) {
		
		// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT GNR_ID    ");
		query.append("   FROM MV_GNR    ");
		query.append("  WHERE MV_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<String>에 하나씩 add한다.
		List<String> genreIdList = new ArrayList<>();
		
		try {
			while(fetchResult.next()) {
				genreIdList.add( fetchResult.getString("GNR_ID") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르아이디 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return genreIdList;
	}
	
	public List<String> selectMovieIdByGenreId(String genreId) {
		
		// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT MV_ID    ");
		query.append("   FROM MV_GNR    ");
		query.append("  WHERE GNR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<String>에 하나씩 add한다.
		List<String> genreIdList = new ArrayList<>();
		
		try {
			while(fetchResult.next()) {
				genreIdList.add( fetchResult.getString("MV_ID") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르아이디 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return genreIdList;
	}
	
	public int insertNewGenre(String genreName) {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결한다.
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String schema = "MV";
		String password = "MV1234";
		
		Connection session = null;
		try {
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 데이터베이스에 쿼리 실행을 요청한다.
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO GNR                                                                    ");
		query.append("  (GNR_ID                                                                           ");
		query.append(" , GNR_NM)                                                                          ");
		query.append(" VALUES                                                                             ");
		query.append("  ('GR-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(GNR_PK_SEQ.NEXTVAL, 6, '0') ");
		query.append(" , ?)                                                                        ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreName);
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 실행된 쿼리의 결과를 받아온다.
		try {
			int insertCount = pstmt.executeUpdate(); // insert, update, delete쿼리를 실행한다.
			return insertCount;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		// 4. 결과를 반환한다.
		// 반환하기 직전에 열려있는 모든 세션을 닫는다.
		// return 0; // 몇 개의 row를 만들었는가? 반환
	}
	
	public String selectGenreIdByGenreName(String genreName) {
		
		// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT GNR_ID ");
		query.append("   FROM GNR ");
		query.append("  WHERE GNR_NM = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		String genreId = null;
		
		try {
			while(fetchResult.next()) {
				genreId = fetchResult.getString("GNR_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return genreId;
	}
	
	public int insertMovieGenre(String movieId, String genreId) {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결한다.
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String schema = "MV";
		String password = "MV1234";
		
		Connection session = null;
		try {
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 데이터베이스에 쿼리 실행을 요청한다.
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO MV_GNR ");
		query.append("  (GNR_ID           ");
		query.append(" , MV_ID)           ");
		query.append(" VALUES             ");
		query.append("  (?                ");
		query.append(" , ?)               ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
			pstmt.setString(2, movieId);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 실행된 쿼리의 결과를 받아온다.
		try {
			int insertCount = pstmt.executeUpdate(); // insert, update, delete쿼리를 실행한다.
			return insertCount;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		// 4. 결과를 반환한다.
		// 반환하기 직전에 열려있는 모든 세션을 닫는다.
		// return 0; // 몇 개의 row를 만들었는가? 반환
	}
	
	public String selectNewMovieId() {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결한다.
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String schema = "MV";
		String password = "MV1234";
		
		Connection session = null;
		try {
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 데이터베이스에 쿼리 실행을 요청한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT 'MV-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(MV_PK_SEQ.NEXTVAL, 6, '0') AS MV_ID ");
		query.append(" FROM DUAL ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		String mvId = null;
		
		try {
			while(fetchResult.next()) {
				mvId = fetchResult.getString("MV_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return mvId;
	}
	
	public int insertNewMovie(MvVO movie) {
		
		// 새롭게 등록할 영화의 아이디
		String newMovieId = this.selectNewMovieId();
		movie.setMvId(newMovieId);
		
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결한다.
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String schema = "MV";
		String password = "MV1234";
		
		Connection session = null;
		try {
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 데이터베이스에 쿼리 실행을 요청한다.
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO MV                               ");
		query.append("  (MV_ID                                      ");
		query.append(" , MV_TTL                                     ");
		query.append(" , MV_ORGNL_TTL                               ");
		query.append(" , MV_SUB_TTL                                 ");
		query.append(" , MV_LNG                                     ");
		query.append(" , MV_RNG_TM                                  ");
		query.append(" , MV_OPN_DT                                  ");
		query.append(" , MV_DESC                                    ");
		query.append(" , MV_PSTR                                    ");
		query.append(" , MV_OPN_STTS                                ");
		query.append(" , MV_RTNG                                    ");
		query.append(" , MV_CST                                     ");
		query.append(" , MV_PRFT)                                   ");
		query.append(" VALUES                                       ");
		query.append("  (? /*1 MV_ID*/                              ");
		query.append(" , ? /*2 MV_TTL*/                             ");
		query.append(" , ? /*3 MV_ORGNL_TTL*/                       ");
		query.append(" , ? /*4 MV_SUB_TTL*/                         ");
		query.append(" , ? /*5 MV_LNG*/                             ");
		query.append(" , ? /*6 MV_RNG_TM*/                          ");
		query.append(" , TO_DATE(?, 'YYYY-MM-DD') /*7 MV_OPN_DT*/   ");
		query.append(" , ? /*8 MV_DESC*/                            ");
		query.append(" , ? /*9 MV_PSTR*/                            ");
		query.append(" , ? /*10 MV_OPN_STTS*/                       ");
		query.append(" , ? /*11 MV_RTNG*/                           ");
		query.append(" , ? /*12 MV_CST*/                            ");
		query.append(" , ?) /*13 MV_PRFT*/                          ");
		 
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movie.getMvId());
			pstmt.setString(2, movie.getMvTtl());
			pstmt.setString(3, movie.getMvOrgnlTtl());
			pstmt.setString(4, movie.getMvSubTtl());
			pstmt.setString(5, movie.getMvLng());
			pstmt.setInt(6, movie.getMvRngTm());
			pstmt.setString(7, movie.getMvOpnDt());
			pstmt.setString(8, movie.getMvDesc());
			pstmt.setString(9, movie.getMvPstr());
			pstmt.setString(10, movie.getMvOpnStts());
			pstmt.setString(11, movie.getMvRtng());
			pstmt.setLong(12, movie.getMvCst());
			pstmt.setLong(13, movie.getMvPrft());
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 실행된 쿼리의 결과를 받아온다.
		int insertCount = 0;
		try {
			insertCount = pstmt.executeUpdate(); // insert, update, delete쿼리를 실행한다.
			//return insertCount;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		// 4. 결과를 반환한다.
		// 반환하기 직전에 열려있는 모든 세션을 닫는다.
		// return 0; // 몇 개의 row를 만들었는가? 반환
		
		// 영화가 잘 등록되었다면! 장르 등록을 진행한다.
		if (insertCount > 0) {
			// 영화의 장르를 등록할지 여부를 결정한다.
			// 영화의 장르로 장르의 아이디를 조회해보고
			for (GnrVO gnr : movie.getGnrList()) {
				String gnrId = this.selectGenreIdByGenreName(gnr.getGnrNm());
				
				// 장르의 아이디가 NULL이 아니라면 장르는 등록이 되어있다는 의미.
				if (gnrId != null) {
					gnr.setGnrId(gnrId);
				}
				// 장르의 아이디가 NULL이라면 장르가 등록되어있지 않다는 의미.
				// 장르를 새롭게 등록해준다.
				else {
					this.insertNewGenre(gnr.getGnrNm()); // 새로운 장르를 등록하고
					// 새로운 장르의 아이디를 조회한다.
					gnrId = this.selectGenreIdByGenreName(gnr.getGnrNm());
					gnr.setGnrId(gnrId);
				}
				
				// 장르까지 등록이 완료되면 분류(MV_GNR)를 등록한다.
				this.insertMovieGenre(movie.getMvId(), gnr.getGnrId());
			}
			
			for (CastVO cast : movie.getCastList()) {
				cast.setMvId(movie.getMvId());

				String actorId = this.selectActorIdByActorName(cast.getActr().getActrNm());
				if (actorId != null) {
					cast.setActrId(actorId);
				}
				else {
					ActrVO actor = new ActrVO();
					actor.setActrNm(cast.getActr().getActrNm());
					actor.setActrPht(cast.getActr().getActrPht());
					
					this.insertNewActor(actor);
					actorId = this.selectActorIdByActorName(cast.getActr().getActrNm());
					cast.setActrId(actorId);
				}
				
				this.insertCast(cast);
			}
			
		}
		
		return insertCount;
	}

	public int deleteMovie(String movieId) {
		// 오라클 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 삭제 쿼리 준비
		StringBuffer query = new StringBuffer();
		query.append(" DELETE           ");
		query.append("   FROM MV        ");
		query.append("  WHERE MV_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 삭제 요청
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		if (deleteCount > 0) {
			// 영화 삭제가 완료되면 해당 영화의 분류정보도 삭제한다.
			this.deleteMovieGenreByMovieId(movieId);
			
			// 영화 삭제가 완료되면 해당 영화의 출연정보도 삭제한다.
			this.deleteCastByMovieId(movieId);
		}
		
		// 4. 삭제된 행의 개수 반환
		return deleteCount;
	}

	public int deleteMovieGenreByMovieId(String movieId) {
		// 오라클 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 삭제 쿼리 준비
		StringBuffer query = new StringBuffer();
		query.append(" DELETE           ");
		query.append("   FROM MV_GNR        ");
		query.append("  WHERE MV_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 삭제 요청
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		// 4. 삭제된 행의 개수 반환
		return deleteCount;
	}
	
	public int deleteGenre(String genreId) {
		// 오라클 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 삭제 쿼리 준비
		StringBuffer query = new StringBuffer();
		query.append(" DELETE           ");
		query.append("   FROM GNR        ");
		query.append("  WHERE GNR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 삭제 요청
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}

		if (deleteCount > 0) {
			this.deleteMovieGenreByGenreId(genreId);
		}
		
		// 4. 삭제된 행의 개수 반환
		return deleteCount;
	}
	
	public int deleteMovieGenreByGenreId(String genreId) {
		// 오라클 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 삭제 쿼리 준비
		StringBuffer query = new StringBuffer();
		query.append(" DELETE           ");
		query.append("   FROM MV_GNR        ");
		query.append("  WHERE GNR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, genreId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 삭제 요청
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		// 4. 삭제된 행의 개수 반환
		return deleteCount;
	}
	
	
	public ActrVO selectActorByActorName(String actorName) {// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT ACTR_ID        ");
		query.append("      , ACTR_NM        ");
		query.append("      , ACTR_PHT       ");
		query.append("   FROM ACTR ");
		query.append("  WHERE ACTR_NM = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actorName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		ActrVO actor = null;
		
		try {
			while(fetchResult.next()) {
				actor = new ActrVO();
				actor.setActrId(fetchResult.getString("ACTR_ID"));
				actor.setActrNm(fetchResult.getString("ACTR_NM"));
				actor.setActrPht(fetchResult.getString("ACTR_PHT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return actor;
	}
	
	public ActrVO selectActorByActorId(String actorId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT ACTR_ID        ");
		query.append("      , ACTR_NM        ");
		query.append("      , ACTR_PHT       ");
		query.append("   FROM ACTR ");
		query.append("  WHERE ACTR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actorId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		ActrVO actor = null;
		
		try {
			while(fetchResult.next()) {
				actor = new ActrVO();
				actor.setActrId(fetchResult.getString("ACTR_ID"));
				actor.setActrNm(fetchResult.getString("ACTR_NM"));
				actor.setActrPht(fetchResult.getString("ACTR_PHT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return actor;
	}
	
	public String selectActorIdByActorName(String actorName) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT ACTR_ID        ");
		query.append("   FROM ACTR ");
		query.append("  WHERE ACTR_NM = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actorName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		String actorId = null;
		
		try {
			while(fetchResult.next()) {
				actorId = fetchResult.getString("ACTR_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return actorId;
	}
	
	public int insertNewActor(ActrVO actrVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO ACTR ");
		query.append("  (ACTR_ID        ");
	    query.append(" , ACTR_NM        ");
	    query.append(" , ACTR_PHT)      ");
		query.append(" VALUES           ");
		query.append("  ('AC-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(ACTR_PK_SEQ.NEXTVAL, 6, '0') ");
	    query.append(" , ?              ");
	    query.append(" , ?)             ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actrVO.getActrNm());
			pstmt.setString(2, actrVO.getActrPht());
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}			
			throw new RuntimeException("파라미터가 잘못되었습니다.");
		}
		
		// 3. Select Fetch Result를 받아와서
		int insertCount = 0;
		try {
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		} finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return insertCount;
	}
	
	public int deleteActorByActorId(String actorId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" DELETE ");
		query.append("   FROM ACTR ");
	    query.append("  WHERE ACTR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actorId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}			
			throw new RuntimeException("파라미터가 잘못되었습니다.");
		}
		
		// 3. Select Fetch Result를 받아와서
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		} finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
		if (deleteCount > 0) {
			this.deleteCastByActorId(actorId);
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return deleteCount;
	}
	
	public int deleteCastByActorId(String actorId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" DELETE ");
		query.append("   FROM CAST ");
	    query.append("  WHERE ACTR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actorId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}			
			throw new RuntimeException("파라미터가 잘못되었습니다.");
		}
		
		// 3. Select Fetch Result를 받아와서
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		} finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return deleteCount;
	}
	
	public int deleteCastByMovieId(String movieId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" DELETE ");
		query.append("   FROM CAST ");
	    query.append("  WHERE MV_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.close();
			} catch (SQLException e1) {}			
			throw new RuntimeException("파라미터가 잘못되었습니다.");
		}
		
		// 3. Select Fetch Result를 받아와서
		int deleteCount = 0;
		try {
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		} finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return deleteCount;
	}
	
	public List<CastVO> selectCastByActorId(String actorId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT CAST_ID     ");
		query.append("      , CAST_NM     ");
		query.append("      , ACTR_ID     ");
		query.append("      , MV_ID       ");
		query.append("   FROM CAST        ");
		query.append("  WHERE ACTR_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, actorId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		List<CastVO> castList = new ArrayList<>();
		CastVO castVO = null;
		
		try {
			while(fetchResult.next()) {
				castVO = new CastVO();
				castVO.setActrId(fetchResult.getString("ACTR_ID"));
				castVO.setMvId(fetchResult.getString("MV_ID"));
				castVO.setCastNm(fetchResult.getString("CAST_NM"));
				
				MvVO movieVO = this.selectMovie(fetchResult.getString("MV_ID"));
				ActrVO actorVO = this.selectActorByActorId(fetchResult.getString("ACTR_ID"));
				castVO.setMv(movieVO);
				castVO.setActr(actorVO);
				
				castList.add(castVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return castList;
	}
	
	public List<CastVO> selectCastbyMovieId(String movieId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null;
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT CAST_ID     ");
		query.append("      , CAST_NM     ");
		query.append("      , ACTR_ID     ");
		query.append("      , MV_ID       ");
		query.append("   FROM CAST        ");
		query.append("  WHERE MV_ID = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, movieId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null;
		try {
			fetchResult = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("쿼리가 잘못되었습니다.");
		}
		// 3-1. List<GnrVO>에 하나씩 add한다.
		List<CastVO> castList = new ArrayList<>();
		CastVO castVO = null;
		
		try {
			while(fetchResult.next()) {
				castVO = new CastVO();
				castVO.setActrId(fetchResult.getString("ACTR_ID"));
				castVO.setMvId(fetchResult.getString("MV_ID"));
				castVO.setCastNm(fetchResult.getString("CAST_NM"));
				
				MvVO movieVO = this.selectMovie(fetchResult.getString("MV_ID"));
				ActrVO actorVO = this.selectActorByActorId(fetchResult.getString("ACTR_ID"));
				castVO.setMv(movieVO);
				castVO.setActr(actorVO);
				
				castList.add(castVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}			
		}
		
		// 4. 장르 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return castList;
	}
	
	public int insertCast(CastVO cast) {
		// 오라클 드라이버가 있는지 확인.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("오라클 드라이버를 찾을 수 없습니다.");
		}
		
		// 1. 데이터베이스에 연결한다.
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String schema = "MV";
		String password = "MV1234";
		
		Connection session = null;
		try {
			session = DriverManager.getConnection(dbUrl, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스에 연결할 수 없습니다.");
		}
		
		// 2. 데이터베이스에 쿼리 실행을 요청한다.
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO CAST                                                                     ");
		query.append("  (CAST_ID                                                                            ");
	    query.append(" , CAST_NM                                                                            ");
	    query.append(" , ACTR_ID                                                                            ");
	    query.append(" , MV_ID)                                                                             ");
		query.append(" VALUES                                                                               ");
		query.append("  ('CA-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(CAST_PK_SEQ.NEXTVAL, 6, '0')  ");
	    query.append(" , ?                                                                                  ");
	    query.append(" , ?                                                                                  ");
	    query.append(" , ?)                                                                                 ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = session.prepareStatement(query.toString());
			pstmt.setString(1, cast.getCastNm());
			pstmt.setString(2, cast.getActrId());
			pstmt.setString(3, cast.getMvId());
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("파라미터에 문제가 있습니다.");
		}
		
		// 3. 실행된 쿼리의 결과를 받아온다.
		try {
			int insertCount = pstmt.executeUpdate(); // insert, update, delete쿼리를 실행한다.
			return insertCount;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("쿼리에 문제가 있습니다.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
		}
		
	}
	
	public List<ActrVO> selectActors() {
		try {
			// Oracle에 연동하기 위한 OracleDriver가 있는지 체크.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 1. Oracle데이터베이스에 접속한다.
		Connection session = null; //DB와 연결되어있는 세션(DriverManager가 열어줌)
		try {
			String oracleURL = "jdbc:oracle:thin:@localhost:1521:XE";
			String schema = "MV";
			String password = "MV1234";
			session = DriverManager.getConnection(oracleURL, schema, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터베이스 접속할 수 없습니다.");
		}
		
		// 2. Select Query를 데이터베이스 전달한다.
		StringBuffer query = new StringBuffer();
		query.append(" SELECT ACTR_ID          ");
		query.append("      , ACTR_NM         ");
		query.append("      , ACTR_PHT   ");
		query.append("   FROM ACTR             ");
		
		// 데이터베이스에 전달할 쿼리 객체를 생성.
		PreparedStatement pstmt = null; // DB와 연결되어 있는 세션.(Connection이 열어줌)
		try {
			pstmt = session.prepareStatement(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. Select Fetch Result를 받아와서
		ResultSet fetchResult = null; // DB와 연결되어 있는 세션.(PreparedStatement가 열어줌)
		try {
			fetchResult = pstmt.executeQuery(); // 데이터베이스에 SELECT 쿼리 실행을 요청한다.
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
			} catch (SQLException e1) {}
			
			try {
				session.close();
			} catch (SQLException e1) {}
			
			throw new RuntimeException("SQL에 문제가 있습니다.");
		}
		
		// 3-1. List<MvVO>에 하나씩 add한다.
		List<ActrVO> actorList = new ArrayList<>();
		ActrVO actor = null;
		// Fetch Row를 하나씩 순회하면서 MvVO인스턴스로 생성하고
		//  MvVO인스턴스를 movieList에 add한다.
		try {
			while (fetchResult.next()) {
				actor = new ActrVO();
				actor.setActrId( fetchResult.getString("ACTR_ID") );
				actor.setActrNm( fetchResult.getString("ACTR_NM") );
				actor.setActrPht( fetchResult.getString("ACTR_PHT") );
				
				List<CastVO> castList = this.selectCastByActorId(fetchResult.getString("ACTR_ID"));
				actor.setCastList(castList);
				
				actorList.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("컬럼명이 잘못되었습니다.");
		} finally {
			try {
				fetchResult.close();
			} catch (SQLException e) {}
			
			try {
				pstmt.close();
			} catch (SQLException e) {}
			
			try {
				session.close();
			} catch (SQLException e) {}
			
		}
		
		// 4. 영화 목록을 반환시킨다.
		// 반환 직전에 데이터베이스에 연결된 모든 Session을 닫는다. (메모리 누수 방지)
		return actorList;
	}
}















