package com.ktdsuniversity.edu.fp.stream.file.csv;

public class Region {

	private int id;
	private String name;
	private String wikiData;
	
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
