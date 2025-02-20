package com.ktdsuniversity.edu.fp.stream.file.csv;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private int id;
	private String name;
	private String wikiData;
	
	private List<SubRegion> subRegions;
	
	public Region(String[] regionData) {
		this(
			Integer.parseInt(regionData[0]),
			regionData[1],
			regionData[2]
		);
	}

	public Region(int id, String name, String wikiData) {
		this.id = id;
		this.name = name;
		this.wikiData = wikiData;
		this.subRegions = new ArrayList<>();
	}

	public void setSubRegions(List<SubRegion> subRegions) {
		this.subRegions = subRegions;
	}
	
	public List<SubRegion> getSubRegions() {
		return this.subRegions;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getWikiData() {
		return this.wikiData;
	}	
}
