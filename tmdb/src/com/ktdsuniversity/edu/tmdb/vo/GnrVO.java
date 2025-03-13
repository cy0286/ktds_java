package com.ktdsuniversity.edu.tmdb.vo;

import java.util.List;

public class GnrVO {

	private String gnrId;
	private String gnrNm;

	/**
	 * 한 개의 장르에는 여러 개의 영화가 있다.
	 */
	private List<MvVO> mvList; // [데드풀 2, 데드풀]
	
	public String getGnrId() {
		return gnrId;
	}
	
	public String getGnrNm() {
		return gnrNm;
	}
	
	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}
	
	public void setGnrNm(String gnrNm) {
		this.gnrNm = gnrNm;
	}
	
	public List<MvVO> getMvList() {
		return mvList;
	}
	
	public void setMvList(List<MvVO> mvList) {
		this.mvList = mvList;
	}
}
