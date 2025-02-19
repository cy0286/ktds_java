package com.ktdsuniversity.edu.fp.stream.file.csv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReadCSV {

	private final String CSV_PATH = "C:\\Users\\cy028\\바탕 화면\\streamexam";
	
	// 로컬 제네릭: 메소드에 제네릭을 정의하는 것
	// Function<T, R> function -> T가 무엇인지 아니까 String[] 으로 변경
	// 하지만 R은 무엇이 될 지 몰라서 R로 냅둠
	// T는 알게 됐으니까 제네릭에서 T를 지우고 R로 변경
	/**
	 * 파일을 알아서 읽어 리스트로 변환한다
	 * @param <R> 리스트의 제네릭 (로컬 제네릭: 메소드 내부에서만 사용할 수 있는 제네릭)
	 * @param filename 
	 * @param function
	 * @return
	 */
	public <R> List<R> loadData(FileName filename, Function<String[], R> function, Predicate<R> condition) {		
		try {
			return Files.lines( new File(CSV_PATH, filename.filename).toPath() ) // Stream<String>
					    .skip(1) // Stream<String>
				      	.map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))")) // Stream<String[]> -> ,와 , 사이에 있는 것은 자르지 말라는 의미
						.map(array -> function.apply(array)) // Stream<State> -> State 가 R이 되는 거고 T는 다시 array 가 됨 -> Stream<R>
						.filter(inst -> condition != null ? condition.test(inst) : true) // Stream<R> -> 검색을 위함
						.toList(); // List<R>
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}
	
	public void printAllRegions() {
		System.out.println("======= print all regions =======");
		this.loadData(FileName.REGIONS, array -> new Region(array), null)
			.forEach(Region -> {
				System.out.println("Region Id: " + Region.getId());
				System.out.println("Region Name: " + Region.getName());
			});
	}
	
	public void printAllSubRegions() {
		System.out.println("======= print all subregions =======");
		this.loadData(FileName.SUB_REGIONS, array -> new SubRegion(array), null)
			.forEach(subRegion -> {
				System.out.println("SubRegion Id: " + subRegion.getId());
				System.out.println("SubRegion Name: " + subRegion.getName());
			});
	}
	
	public void printAllCountreis() {
		System.out.println("======= print all countries =======");
		this.loadData(FileName.COUNTRIES, array -> new Country(array), null)
			.forEach(country -> {
				System.out.println("Country Id: " + country.getId());
				System.out.println("Country Name: " + country.getName());
			});
	}

	public void printAllStates() {
		System.out.println("======= print all states =======");
		this.loadData(FileName.STATES, array -> new State(array), null)
			.forEach(state -> {
				System.out.println("State Id: " + state.getId());
				System.out.println("State Name: " + state.getName());
			});
	}
	
	public void printAllCities() {
		System.out.println("======= print all cities =======");
		this.loadData(FileName.CITIES, array -> new City(array), null)
			.forEach(city -> {
				System.out.println("City Id: " + city.getId());
				System.out.println("City Name: " + city.getName());
			});
	}
	
	public void printAllCitiesOfSouthKorea() {
		System.out.println("======= print all cities of south korea =======");
		this.loadData(FileName.CITIES, array -> new City(array), city -> city.getCountryName().equals("\"South Korea\""))
			.forEach(city -> {
				System.out.println("City ID: " + city.getId());
				System.out.println("City Name: " + city.getName());
				System.out.println("City's State Name: " + city.getStateName());
				System.out.println("City;s COuntry Name: " + city.getCountryName());
			});
	}
	
	public static void main(String[] args) {
		ReadCSV csv = new ReadCSV();
//		List<City> cities = csv.loadData(FileName.CITIES, (array) -> new City(array));
//		List<Country> countries = csv.loadData(FileName.COUNTRIES, (array) -> new Country(array));
//		List<Region> regions = csv.loadData(FileName.RECIONS, (array) -> new Region(array), region -> region.getName().equals("Asia")); // [Asia]
//		List<Region> regions = csv.loadData(FileName.RECIONS, (array) -> new Region(array), null); 
//		List<State> states = csv.loadData(FileName.STATES, (array) -> new State(array));
//		List<SubRegion> subRegions = csv.loadData(FileName.SUB_REGIONS, (array) -> new SubRegion(array));
		// List<State> states = csv.loadData(FileName.STATES, State :: new);
		
//		cities.forEach( city -> System.out.println(city.getName()) );
//		countries.forEach(coutry -> System.out.println(coutry.getName()) );
//		regions.forEach(region -> System.out.println(region.getName()) ); // Asia
//		states.forEach(state -> System.out.println(state.getCountryName()));
//		subRegions.forEach(subRegion -> System.out.println(subRegion.getName()) );
		
		csv.printAllRegions();
		csv.printAllSubRegions();
		csv.printAllCountreis();
		csv.printAllStates();
		csv.printAllCities();
		csv.printAllCitiesOfSouthKorea();
	}
}
