package com.ktdsuniversity.edu.collections.list;

import java.lang.reflect.Array;
import java.util.*;

public class ListAndArrayListExam {

	public static void main(String[] args) {

		// list 에 데이터 추가
		List<Integer> scoreList = new ArrayList<> ();
		scoreList.add(100);
		scoreList.add(101);
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// list 데이터 조회
		int score = scoreList.get(0);
		System.out.println(score);
		
		// list 반복 데이터 조회
		for (int i = 0; i < scoreList.size(); i++) {
			score = scoreList.get(i);
			System.out.println(score);
		}
		
		// list 데이터 삭제
		scoreList.remove(1);
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// list 데이터 모두 삭제
		scoreList.clear();
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// list 가 비어있는지 확인
		System.out.println(scoreList.isEmpty());
		
		// 값 존재 여부 확인
		if (!scoreList.contains(90)) {
			scoreList.add(90);
		}
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// list 복사
		List<Integer> scoreList2 = new ArrayList<> ();
		scoreList2.addAll(scoreList);
		
		System.out.println(System.identityHashCode(scoreList));
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		

		System.out.println(System.identityHashCode(scoreList2));
		System.out.println(scoreList2);
		System.out.println(scoreList2.size());
		
		// of 예시
		List<Integer> readOnlyList = List.of(1, 2, 3, 4, 5);
		System.out.println(readOnlyList);
		System.out.println(readOnlyList.size());
		
		// List.of() => ImmutableCollections.listFromTrustedArray
		// ImmutableCollections는 add 지원 안 함
		// public boolean add(E e) { throw uoe; }
		// readOnlyList.add(2); // UnsupportedOperationException
		
		int[] array = new int[10];
		
		// for
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// for
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.println(scoreList.get(i));
		}
				
		// for-each
		// int[] array = new int[10];
		for (int number : array) {
			System.out.println("array for-each: " + number);
		}
		
		// for 를 쓸때와 for-each 를 쓸 때의 구분 케이스
		// 반복 중에 인덱스값을 사용해야 한다면 반드시 for 사용
		// 		-> [7, 45, 31, 23, 6, 7] 이 배열에서 31번은 몇 번 인덱스에 있나?
		//			0
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 31) {
				System.out.println(array[i] + "은 " + i + "인덱스에 있습니다.");
			}
		}
		
		// List<Integer> scoreList = new ArrayList<> ();
		// [100, 20, 56, 74, 96]
		// for-each
		for (int eachScore : scoreList) {
			System.out.println(eachScore);
		}
		
		// 배열 반복 방법 : for, for-each
		// 리스트 반복 방법 : for, for-each
		// for-each 사용할 수 있는 조건!
		// 반복을 시키려는 클래스가 Iterator, Iterable 인터페이스를 구현시켰을 때만 사용가능
	}
}
