package com.ktdsuniversity.edu.generic;

/**
 * 학생 한명의 성적을 구하는 클래스
 * 1. 추상클래스
 * 2. 합계, 평균 안구하기 -> 인스턴스를 사용하는 Main 클래스에서 직접 구해라
 * 3. 인터페이스 활용 
 * 	- 합계구하기, 평균 구하기를 할 수 있는 인터페이스 제작
 * 	- ScoreArray 클래스에서 인터페이스를 통해 합계를 구하고 평균을 구한다
 */
public class ScoreArray<T> {
	
	/**
	 * 학생의 이름
	 */
	private String name;
	
	/**
	 * 과목별 성적
	 */
	private Object[] scoreArray;

	/**
	 * 등록된 성적의 개수
	 */
	private int size;
	
	private T sum;
	
	public ScoreArray(String name) {
		this.name = name;
		// this.scoreArray = new T[4]; // [100, 80, 70, 90] + 95 + 85 + 77
		this.scoreArray = new Object[4];
	}
	
	public Object[] getScoreArray() {
		return this.scoreArray;
	}
	
	public int getSize() {
		return this.size;
	}
	
	/**
	 * 성적 배열에 성적을 추가한다
	 * @param score
	 */
	public void add(T score) {
		if (this.size >= this.scoreArray.length) {
			Object[] tempScoreArray = new Object[this.scoreArray.length + 4];
			// tempScoreArray 에 this.scoreArray 의 값을 일일이 할당한다
//			for (int i = 0; i < this.size; i++) {
//				tempScoreArray[i] = this.scoreArray[i];
//			}
			// 원본배열, 어디부터, 배열을 복사할 새로운 배열, 어디부터, 몇 번 반복?
			// scoreArray의 0번 부터 시작해서 모든 값들을 tempScoreArray에 0번부터 시작해서 집어 넣어
			System.arraycopy(this.scoreArray, 0, tempScoreArray, 0, this.size);
			/*
			 * this.scoreArray = [100, 80, 70, 90]
			 * tempScoreArray = [100, 80, 70, 90, 0, 0, 0, 0]
			 */
			this.scoreArray = tempScoreArray; // 메모리 교체
			// this.sum += score; -> 무슨 타입인지 모르니까 문법이 존재할 수 없음
		}
		this.scoreArray[size++] = score;
	}
	
	/**
	 * scoreArray에 들어있는 점수들의 합계를 반환
	 * @return
	 */
//	public T sum() {
//		this.sum = 0;
//		for (int i = 0; i < this.size; i++) {
//			this.sum += this.scoreArray[i];
//		}
//		return this.sum;
//	} -> 무슨타입인지 몰라서 산술 연산을 할 수가 없음

//	public T average() {
//		T sum = this.sum > 0 ? this.sum : this.sum();
//		return sum / (double) this.size;
//	}

	// 점수 등록 (add) ......
	// 합계 구하기 (sum)
	// 평균 구하기 (average)
	// 점수 등록 (add) => 점수 배열 변화가 생김
	// 합계 구하기 (sum) => 올바른 합계가 나올까? => sum 초기화 -> 올바른 합계가 나옴
	// 평균 구하기 (average) => 올바른 평균이 나올까? => 올바른 평균이 나옴
	// 점수 등록 (add) => 점수 배열 변화가 생김
	// 평균 구하기 (average) => 올바른 평균이 나올까? => 점수 등록할 때 합계의 변화를 주면 됨
}
