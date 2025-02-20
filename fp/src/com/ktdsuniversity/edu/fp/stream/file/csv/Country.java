package com.ktdsuniversity.edu.fp.stream.file.csv;

import java.util.ArrayList;
import java.util.List;

public class Country {
	
	private int id;	
	private String name;
	private String iso3;
	private String iso2;
	private String numericCode;
	private String phonecode;
	private String capital;	
	private String currency;	
	private String currencyName;	
	private String currencySymbol;	
	private String tld;	
	private String translate; // native
	private String region;
	private int region_id;
	private String subregion;
	private int subregionId;
	private String nationality;
	private String timezones;
	private double latitude;
	private double longitude;
	private String emoji;
	private String emojiU;
	
	private SubRegion subRegionInfo;
	private List<State> states;
	
	public Country(String[] countryData) {
		this(
			Integer.parseInt(countryData[0]), // id
			countryData[1], // name
			countryData[2], // iso3
			countryData[3], // iso2
			countryData[4], // numericCode
			countryData[5], // phonecode
			countryData[6], // capital
			countryData[7], // currency
			countryData[8], // currencyName
			countryData[9], // currencySymbol
			countryData[10], // tld
			countryData[11], // translateNative (native)
			countryData[12], // region
			Integer.parseInt(countryData[13]), // regionId
			countryData[14], // subRegion
			Integer.parseInt(countryData[15]), // subRegionId
			countryData[16], // nationality
			countryData[17], // timezones
			Double.parseDouble(countryData[18]), // latitude
			Double.parseDouble(countryData[19]), // longitude
			countryData[20],
			countryData[21]
		);
	}
	
	public Country(int id, String name, String iso3, String iso2, String numericCode, String phonecode, String capital,
			String currency, String currencyName, String currencySymbol, String tld, String translate, String region,
			int region_id, String subregion, int subregionId, String nationality, String timezones, double latitude,
			double longitude, String emoji, String emojiU) {
		this.id = id;
		this.name = name;
		this.iso3 = iso3;
		this.iso2 = iso2;
		this.numericCode = numericCode;
		this.phonecode = phonecode;
		this.capital = capital;
		this.currency = currency;
		this.currencyName = currencyName;
		this.currencySymbol = currencySymbol;
		this.tld = tld;
		this.translate = translate;
		this.region = region;
		this.region_id = region_id;
		this.subregion = subregion;
		this.subregionId = subregionId;
		this.nationality = nationality;
		this.timezones = timezones;
		this.latitude = latitude;
		this.longitude = longitude;
		this.emoji = emoji;
		this.emojiU = emojiU;
		this.states = new ArrayList<>();
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	
	public List<State> getStates() {
		return this.states;
	}
	
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}	
	
	public SubRegion getSubRegionInfo() {
		return this.subRegionInfo;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getIso3() {
		return this.iso3;
	}

	public String getIso2() {
		return this.iso2;
	}

	public String getNumericCode() {
		return this.numericCode;
	}

	public String getPhonecode() {
		return this.phonecode;
	}

	public String getCapital() {
		return this.capital;
	}

	public String getCurrency() {
		return this.currency;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public String getCurrencySymbol() {
		return this.currencySymbol;
	}

	public String getTld() {
		return this.tld;
	}

	public String getTranslate() {
		return this.translate;
	}

	public String getRegion() {
		return this.region;
	}

	public int getRegion_id() {
		return this.region_id;
	}

	public String getSubregion() {
		return this.subregion;
	}

	public int getSubregionId() {
		return this.subregionId;
	}

	public String getNationality() {
		return this.nationality;
	}

	public String getTimezones() {
		return this.timezones;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public String getEmoji() {
		return this.emoji;
	}

	public String getEmojiU() {
		return this.emojiU;
	}
	
	
}
