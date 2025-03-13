package com.ktdsuniversity.edu.tmdb.vo;

/**
 * 한 명의 배우는 하나의 배역으로 한 개의 영화에 출연한다.
 */
public class CastVO {

	private String castId;
	private String castNm;
	private String actrId;
	private String mvId;
	
	/**
	 * 영화의 배역을 담당(연기)한 배우의 정보
	 */
	private ActrVO actr;
	
	/**
	 * 배역을 담당(연기)한 영화의 정보
	 */
	private MvVO mv;
	
	public String getCastId() {
		return castId;
	}
	
	public String getCastNm() {
		return castNm;
	}
	
	public String getActrId() {
		return actrId;
	}
	
	public String getMvId() {
		return mvId;
	}
	
	public ActrVO getActr() {
		return actr;
	}
	
	public MvVO getMv() {
		return mv;
	}
	
	public void setCastId(String castId) {
		this.castId = castId;
	}
	
	public void setCastNm(String castNm) {
		this.castNm = castNm;
	}
	
	public void setActrId(String actrId) {
		this.actrId = actrId;
	}
	
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	
	public void setActr(ActrVO actr) {
		this.actr = actr;
	}
	
	public void setMv(MvVO mv) {
		this.mv = mv;
	}
}
