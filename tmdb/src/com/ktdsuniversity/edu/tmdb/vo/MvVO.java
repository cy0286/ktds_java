package com.ktdsuniversity.edu.tmdb.vo;

import java.util.List;

/**
 * 실제로 해야하는 것 -> INNER JOIN 으로 영화, 장르, 출연배우, 배우 등등
 *  	MvVO, CastVO, ActrVO, GnrVO 데이터 셋팅
 *  
 *  우리가 내일 할 것 (각각 따로따로 조회)
 *  MvVO -> MV 테이블에서만 조회 SELECT, INSERT, UPDATE, DELETE
 *    - GnrVO -> GNR 테이블에서만 조회 SELECT, INSERT, UPDATE, DELETE
 *    - CastVO -> CAST 테이블에서만 조회 SELECT, INSERT, UPDATE, DELETE
 *    - ActrVO -> ACTR 테이블에서만 조회 SELECT, INSERT, UPDATE, DELETE
 * 데이터베이스를 연동하는 프로젝트의 VO 클래스는 테이블의 구조와 동일한 형태의 데이터 클래스로 작성한다.
 */

/**
 * 데이터베이스를 연동하는 프로젝트의 VO 클래스는
 * 테이블의 구조와 동일한 형태의 데이터 클래스로 작성한다.
 */
public class MvVO {
	
	// DB Type => NUMBER => Java int
	// DB Type => Not NUMBER => Java String
	private String mvId;
	private String mvTtl;
	private String mvOrgnlTtl;
	private String mvSubTtl;
	private String mvLng;
	private int mvRngTm; // NUMBER (3,0)
	private String mvOpnDt;
	private String mvDesc;
	private String mvPstr;
	private String mvOpnStts;
	private String mvRtng;
	private long mvCst; // NUMBER (11, 0)
	private long mvPrft; // NUMBER (20, 0)
	
	/**
	 * 한 개의 영화에는 여러개의 장르가 있다.
	 */
	private List<GnrVO> gnrList; // [액션, 코미디, 모험]
	
	/**
	 * 한 개의 영화에는 여러 명의 배우가 출연한다.
	 */
	private List<CastVO> castList; 
	
	public String getMvId() {
		return mvId;
	}
	
	public String getMvTtl() {
		return mvTtl;
	}
	
	public String getMvOrgnlTtl() {
		return mvOrgnlTtl;
	}
	
	public String getMvSubTtl() {
		return mvSubTtl;
	}
	
	public String getMvLng() {
		return mvLng;
	}
	
	public int getMvRngTm() {
		return mvRngTm;
	}
	
	public String getMvOpnDt() {
		return mvOpnDt;
	}
	
	public String getMvDesc() {
		return mvDesc;
	}
	
	public String getMvPstr() {
		return mvPstr;
	}
	
	public String getMvOpnStts() {
		return mvOpnStts;
	}
	
	public String getMvRtng() {
		return mvRtng;
	}
	
	public long getMvCst() {
		return mvCst;
	}
	
	public long getMvPrft() {
		return mvPrft;
	}
	
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	
	public void setMvTtl(String mvTtl) {
		this.mvTtl = mvTtl;
	}
	
	public void setMvOrgnlTtl(String mvOrgnlTtl) {
		this.mvOrgnlTtl = mvOrgnlTtl;
	}
	
	public void setMvSubTtl(String mvSubTtl) {
		this.mvSubTtl = mvSubTtl;
	}
	
	public void setMvLng(String mvLng) {
		this.mvLng = mvLng;
	}
	
	public void setMvRngTm(int mvRngTm) {
		this.mvRngTm = mvRngTm;
	}
	
	public void setMvOpnDt(String mvOpnDt) {
		this.mvOpnDt = mvOpnDt;
	}
	
	public void setMvDesc(String mvDesc) {
		this.mvDesc = mvDesc;
	}
	
	public void setMvPstr(String mvPstr) {
		this.mvPstr = mvPstr;
	}
	
	public void setMvOpnStts(String mvOpnStts) {
		this.mvOpnStts = mvOpnStts;
	}
	
	public void setMvRtng(String mvRtng) {
		this.mvRtng = mvRtng;
	}
	
	public void setMvCst(long mvCst) {
		this.mvCst = mvCst;
	}
	
	public void setMvPrft(long mvPrft) {
		this.mvPrft = mvPrft;
	}	
	
	public List<GnrVO> getGnrList() {
		return gnrList;
	}
	
	public List<CastVO> getCastList() {
		return castList;
	}
	
	public void setGnrList(List<GnrVO> gnrList) {
		this.gnrList = gnrList;
	}
	
	public void setCastList(List<CastVO> castList) {
		this.castList = castList;
	}
}