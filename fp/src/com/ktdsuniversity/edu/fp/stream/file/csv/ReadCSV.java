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
				System.out.println("City;s Country Name: " + city.getCountryName());
			});
	}
	
	/**
	 * state 의 id 에 소속된 모든 도시들 출력한다
	 * @param stateId sate 의 id (3849: Seoul)
	 */
	public void printAllCitiesOfState(int stateId) {
		System.out.println("======= printAllCitiesOfState(3849) =======");
		// State 정보를 stateId로 찾는다
		this.loadData(FileName.STATES, array -> new State(array), state -> state.getId() == stateId) // List<State>
		// 해당 state 가 조회된다
			.stream() // Stream<State>
			// 찾은 state 의 id 로 소속된 모든 도시를 가져온다
			.flatMap( state -> this.loadData(FileName.CITIES, cityArray -> new City(cityArray), city -> city.getStateId() == state.getId()) // List<City>
			.stream() ) // Stream<City>
			// 찾은 모든 도시들을 출력한다
			.forEach( city -> System.out.println(city.getName()) );
	}
	
	/**
	 * country 의 id 에 소속된 모든 도시들을 출력한다
	 * @param countryId country 의 id (116: South Korea)
	 */
	public void printAllCitiesOfCountry(int countryId) {
		System.out.println("======= printAllCitiesOfCountry(116) =======");
		// CountryId로 country 를 조회한다
		this.loadData(FileName.COUNTRIES, countryArray -> new Country(countryArray), country -> country.getId() == countryId) // List<Country>
			.stream() // Stream<Country>
			// 조회된 country 의 id 로 state 를 조회한다 (flatMap)
			.flatMap( country -> this.loadData(FileName.STATES, stateArray -> new State(stateArray), state -> state.getCountryId() == country.getId()) // List<State>
			.stream()) // Stream<State>
			// 조회된 state 의 id 로 city 를 조회한다 (flatMap)
			.flatMap( state -> this.loadData(FileName.CITIES, cityArray -> new City(cityArray), city -> city.getStateId() == state.getId()) // List<City>
			.stream()) // Stream<City>
			.forEach( city -> System.out.println(city.getName() + " / " + city.getStateName() + " / " + city.getCountryName()) );
		// city 만 출력한다
	}
	
	/**
	 * subRegion 의 id 에 소속된 모든 도시들을 출력한다
	 * @param subRegionId subRegion 의 id (12: Eastern Asia)
	 */
	public void printAllCitiesOfSubRegion(int subRegionId) {
		System.out.println("======= printAllCitiesOfSubRegion(12) =======");
		this.loadData(FileName.SUB_REGIONS, subRegionArray -> new SubRegion(subRegionArray), subregion -> subregion.getId() == subRegionId) // List<SubRegion>
			.stream() // Stream<SubRegion>
			.flatMap(subregion -> this.loadData(FileName.COUNTRIES, countryArray -> new Country(countryArray), country -> country.getSubregionId() == subregion.getId()) // List<Country>
			.stream()) // Stream<Country>
			.flatMap( country -> this.loadData(FileName.STATES, stateArray -> new State(stateArray), state -> state.getCountryId() == country.getId()) // List<State>
			.stream()) // Stream<State>
			.flatMap( state -> this.loadData(FileName.CITIES, cityArray -> new City(cityArray), city -> city.getStateId() == state.getId()) // List<City>
			.stream()) // Stream<City>
			.forEach( city -> System.out.println(city.getName()));
	}
	
	/**
	 * region 의 id 에 소속된 모든 도시들을 출력한다
	 * @param regionId region 의 id (3: Asia)
	 */
	public void printAllCitiesOfRegion(int regionId) {
		System.out.println("======= printAllCitiesOfSubRegion(3) =======");
//		this.loadData(FileName.REGIONS, regionArray -> new Region(regionArray), region -> region.getId() == regionId) // List<Region>
//		.stream() // Stream<Region>
//		.flatMap(region -> this.loadData(FileName.SUB_REGIONS, subRegionArray -> new SubRegion(subRegionArray), subregion -> subregion.getId() == region.getId())// List<SubRegion>
//		.stream()) // Stream<SubRegion>
//		.flatMap(subregion -> this.loadData(FileName.COUNTRIES, countryArray -> new Country(countryArray), country -> country.getSubregionId() == subregion.getId()) // List<Country>
//		.stream()) // Stream<Country>
//		.flatMap( country -> this.loadData(FileName.STATES, stateArray -> new State(stateArray), state -> state.getCountryId() == country.getId()) // List<State>
//		.stream()) // Stream<State>
//		.flatMap( state -> this.loadData(FileName.CITIES, cityArray -> new City(cityArray), city -> city.getStateId() == state.getId()) // List<City>
//		.stream()) // Stream<City>
//		.forEach( city -> System.out.println(city.getName()));
		
		// 매번 반복할 때 마다 파일을 읽고 가져오는 것보다
		// 데이터를 미리 조회 해놓으면 조회 속도가 더 빠르다. 대신 메모리는 많이 쓸 수 밖에 없다.
		// 메모리를 덜 쓰면 속도가 느리고 메모리를 많이 쓰면 속도가 빠르다.
		List<SubRegion> subRegions = this.loadData(FileName.SUB_REGIONS, SubRegion::new, null);
		List<Country> countries = this.loadData(FileName.COUNTRIES, Country::new, null);
		List<State> states = this.loadData(FileName.STATES, State::new, null);
		List<City> cities = this.loadData(FileName.CITIES, City::new, null);
		
		this.loadData(FileName.REGIONS, Region::new, region -> region.getId() == regionId)
			.stream()
			.flatMap(region -> subRegions.stream().filter(subRegion -> subRegion.getRegionId() == region.getId()))
			.flatMap(subRegion -> countries.stream().filter(country -> country.getSubregionId() == subRegion.getId()))
			.flatMap(country -> states.stream().filter(state -> state.getCountryId() == country.getId()))
			.flatMap(state -> cities.stream().filter(city -> city.getStateId() == state.getId()))
			.forEach(city -> System.out.println(city.getName()));
	}
	
	// has a 문제
	/**
	 * 한 도시의 정보와 해당 도시의 state 정보를 함께 조회한다
	 * @param cityName 
	 * @return 조회하고자 하는 도시 "Seoul" Seoul 의 정보와 state 의 정보를 함께 조회
	 */
	public City getOneCityWithState(String cityName) {
		return this.loadData(FileName.CITIES, cityArray -> new City(cityArray), city -> city.getName().equals(cityName)) // List<City>
			.stream() // Stream<City>
			.map( city -> {
				// city 인스턴스의 state 에 해당 도시의 state 정보를 채운다
				State stateOfCity = this.loadData(FileName.STATES, stateArray -> new State(stateArray), state -> state.getId() == city.getStateId())
										.stream()
										.findFirst()
										.orElse(null);
				city.setState(stateOfCity);
				return city;
			}) // Stream<City>
			.findFirst() // Optional<City>
			.orElse(null); // City
	}
	
	/**
	 * CountryName 에 해당하는 Country 정보 + Country 에 소속된 모든 State 의 정보 + State 에 소속된 모든 도시
	 * @param countryName 
	 * @return
	 */
	public Country getOneCountry(String countryName) {
		List<State> states = this.loadData(FileName.STATES, stateArray -> new State(stateArray), null);
		List<City> cities = this.loadData(FileName.CITIES, cityArray -> new City(cityArray), null);
		
		return this.loadData(FileName.COUNTRIES, countryArray -> new Country(countryArray), country -> country.getName().equals(countryName)) // List<Country>
				   .stream() // Stream<Country>
				   .map( country -> {
					   // 1. Country 의 state 를 모두 조회 -> country -> states(List) -> add
					   List<State> countryState = states.stream() // Stream<State>
					   		 							 .filter(state -> state.getCountryId() == country.getId()) // Stream<State>
					   		 							 // 2. Country 의 모든 state 에 해당하는 city 를 모두 조회 country -> states(List) -> each state -> city add
					   		 							 .map(state -> {
					   		 								 List<City> stateCity = cities.stream() // Stream<City>
					   		 										 					  .filter(city -> city.getStateId() == state.getId()) // Stream<City>
					   		 										 					  .toList(); // List<City>
					   		 								 state.setCities(stateCity);
					   		 								 return state;
					   		 							 }) // Stream<State>
					   		 							 .toList(); // List<State>
					   country.setStates(countryState);
					   return country;
				   }) // Stream<Country>
				   .findFirst() // Optional<Country>
				   .orElse(null); // Country
	}
	
	/**
	 * subRegionName 에 해당하는 SubRegion 정보 + Country 정보 + State 정보 + City 정보
	 * @param subRegionName
	 * @return
	 */
	public SubRegion getOneSubRegion(String subRegionName) {
		List<Country> countries = this.loadData(FileName.COUNTRIES, Country::new, null);
		List<State> states = this.loadData(FileName.STATES, State::new, null);
		List<City> cities = this.loadData(FileName.CITIES, City::new, null);
		
		return this.loadData(FileName.SUB_REGIONS, SubRegion::new, subregion -> subregion.getName().equals(subRegionName)) // List<SubRegion>
					.stream() // Stream<SubRegion>
					.map( subregion -> {
						List<Country> subRegionCountry = countries.stream()
																  .filter(country -> country.getSubregionId() == subregion.getId())
																  .map(country -> {
																		List<State> countryState = states.stream()
																										 .filter(state -> state.getCountryId() == country.getId())
																										 .map(state -> {
																												List<City> stateCity = cities.stream()
																																			.filter(city -> city.getStateId() == state.getId())
																																			.toList();
																												state.setCities(stateCity);
																												return state;
																											})
																											.toList();
																		country.setStates(countryState);
																		return country;
																	})
																	.toList();
																
						subregion.setCountries(subRegionCountry);
						return subregion;
					}) 
					.findFirst()
					.orElse(null);
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
		
//		csv.printAllRegions();
//		csv.printAllSubRegions();
//		csv.printAllCountreis();
//		csv.printAllStates();
//		csv.printAllCities();
//		csv.printAllCitiesOfSouthKorea();
//		
//		csv.printAllCitiesOfState(3849); // (3849: Seoul)
//		csv.printAllCitiesOfCountry(116); // (116: South Korea)
//		csv.printAllCitiesOfSubRegion(12); // (12: Eastern Asia)
//		csv.printAllCitiesOfRegion(3); // (3: Asia)
//		
//		City city = csv.getOneCityWithState("Seoul"); 
//		System.out.println("City name: " + city.getName());
//		System.out.println("City StateId: " + city.getStateId());
//		System.out.println("City StateName: " + city.getState().getName());
//		System.out.println("City StateType: " + city.getState().getType());
//		
//		Country country = csv.getOneCountry("\"South Korea\"");
//		System.out.println("Country Name: " + country.getName());
//		country.getStates()
//			   .forEach(state -> {
//				   System.out.println("Country's state Name: " + state.getName());
//				   state.getCities()
//				   		.forEach(eachCity -> System.out.println("Country's city Name: " + eachCity.getName()) );
//			   });
		
		SubRegion subRegion = csv.getOneSubRegion("\"Eastern Asia\"");
		System.out.println("SubRegion Id: " + subRegion.getId());
		System.out.println("SubRegion Name: " + subRegion.getName());
		subRegion.getCountries()
			     .forEach( country -> {
			     System.out.println("SubRegion's Country name: " + country.getName());
				 country.getStates()
				 		.forEach( state -> {
				 		System.out.println("SubRegion's State name: " + state.getName());
					  	state.getCities()
					  		.forEach(city -> System.out.println("SubRegion's City name: " + city.getName()));
				 		});
			     });
	}
}
