package com.ktdsuniversity.edu.collections.map;

import java.util.*;

public class MapAndHashMapExam {

	public static void main(String[] args) {
		
		Map<String, Integer> priceMap = new HashMap<> ();
		
		// map 에 데이터 추가
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.put("Lg Gram", 1_800_000);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// map 데이터 조회
		int applePrice = priceMap.get("Apple Macbook Pro");
		System.out.println(applePrice);
		
		// java.lang.NullPointerException
//		applePrice = priceMap.get("apple macbook pro");
//		System.out.println(applePrice);
		
		// map 데이터 삭제
		priceMap.remove("Apple Macbook Pro");
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// map 데이터 모두 삭제
		priceMap.clear();
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// map 이 비어있는지 확인
		boolean isEmpty = priceMap.isEmpty();
		System.out.println(isEmpty);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// map 에 동일한 key 가 있는지 확인
		if (!priceMap.containsKey("LG Gram")) {
			priceMap.put("LG Gram", 1_600_000);
		}
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// map 에 동일한 value 가 있는지 확인
		priceMap.put("LG Gram", 1_700_000);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		if (priceMap.containsValue(1_700_000)) {
			priceMap.put("LG Gram", 1_600_000);
		}
		System.out.println(priceMap);
		System.out.println(priceMap.size());
	
		// map 복사
		Map<String, Integer> priceMap2 = new HashMap<>();
		priceMap2.putAll(priceMap);
		System.out.println(System.identityHashCode(priceMap));
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.put("LG Gram", 1_500_000);
		System.out.println(System.identityHashCode(priceMap2));
		System.out.println(priceMap2);
		System.out.println(priceMap2.size());
	}
}
