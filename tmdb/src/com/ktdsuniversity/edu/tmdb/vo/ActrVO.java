package com.ktdsuniversity.edu.tmdb.vo;

import java.util.List;

public class ActrVO {

	private String actrId;
	private String actrNm;
	private String actrPht;
	
	/**
	 * 한 명의 배우는 여러 영화에서 배역을 담당했다.
	 */
	private List<CastVO> castList;
	
	public String getActrId() {
		return actrId;
	}
	
	public String getActrNm() {
		return actrNm;
	}
	
	public String getActrPht() {
		return actrPht;
	}
	
	public List<CastVO> getCastList() {
		return castList;
	}
	
	public void setActrId(String actrId) {
		this.actrId = actrId;
	}
	
	public void setActrNm(String actrNm) {
		this.actrNm = actrNm;
	}
	
	public void setActrPht(String actrPht) {
		this.actrPht = actrPht;
	}
	
	public void setCastList(List<CastVO> castList) {
		this.castList = castList;
	}
}
