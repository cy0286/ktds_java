package com.ktdsuniversity.edu.fp.stream.file.csv;

import java.util.ArrayList;
import java.util.List;

public class State {

	private int id;
	private String name;
	private int countryId;
	private String countryCode;
	private String countryName;
	private String stateCode;
	private String type;
	private double latitude;
	private double longitude;
	
	private Country country;
	private List<City> cities;
	
	public State(String[] stateData) {
		this(
			Integer.parseInt(stateData[0]),
			stateData[1],
			Integer.parseInt(stateData[2]),
			stateData[3],
			stateData[4],
			stateData[5],
			stateData[6],
			stateData.length > 7 ? Double.parseDouble(stateData[7]) : 0,
			stateData.length > 8 ? Double.parseDouble(stateData[8]) : 0
		);
	}
	
	public State(int id, String name, int contryId, String countryCode, String countryName, String stateCode, String type, double latitude, double longtidute) {
		this.id = id;
		this.name = name;
		this.countryId = contryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.stateCode = stateCode;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longtidute;
		this.cities = new ArrayList<>();
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public List<City> getCities() {
		return cities;
	}
	
	public Country getCountry() {
		return this.country;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCountryId() {
		return this.countryId;
	}
	
	public String getCountryCode() {
		return this.countryCode;
	}
	
	public String getCountryName() {
		return this.countryName;
	}
	
	public String getStateCode() {
		return this.stateCode;
	}
	
	public String getType() {
		return this.type;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
}
