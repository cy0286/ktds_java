package com.ktdsuniversity.edu.array;

import java.util.Arrays;

public class Lotto {

	public static void makeLottoNumber() {
		
		// 로또 복권
		// 1 ~ 45 6개 찍기 (중복불가) -> 1게임 1,000원
		// 내가 찍은 6개의 번호와 주관사가 랜덤하게 찍은 6개의 번호와 정확하게 일치하면 1등
		// 1등 당첨자가 적립금을 다 먹는게임 (400억)
		
		// 로또 번호 6개 모아보기
		/*
		 * 시작: [ 0, 0, 0, 0, 0, 0 ]
		 * 1. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 37
		 * 	  => 배열에 37이 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 첫 번째 인덱스에 37을 할당
		 *    => [ 37, 0, 0, 0, 0, 0 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 * 2. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 15
		 *    => 배열에 15가 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 두 번째 인덱스에 15를 할당
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 *    => [ 37, 15, 0, 0, 0, 0 ]
		 * 3. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 3
		 *    => 배열에 3이 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 세 번째 인덱스에 3을 할당
		 *    => [ 37, 15, 3, 0, 0, 0 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 * 4. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 37
		 *    => 배열에 37이 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 네 번째 인덱스에 37을 할당
		 *    => [ 37, 15, 3, 0, 0, 0 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 * 5. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 33
		 *    => 배열에 33이 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 네 번째 인덱스에 33을 할당
		 *    => [ 37, 15, 3, 33, 0, 0 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 * 6. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 15
		 *    => 배열에 15가 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 다섯 번째 인덱스에 15를 할당
		 *    => [ 37, 15, 3, 33, 0, 0 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 * 7. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 22
		 *    => 배열에 22가 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 다섯 번째 인덱스에 22를 할당
		 *    => [ 37, 15, 3, 33, 22, 0 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 * 8. 1 ~ 45 중 랜덤하게 하나만 뽑기 => 결과 45
		 *    => 배열에 45가 존재하는지 확인 => 존재할 경우는 아무것도 하지 않는다
		 *    => 존재하지 않는 경우 => 여섯 번째 인덱스에 45를 할당
		 *    => [ 37, 15, 3, 33, 22, 45 ]
		 *    => 인덱스카운트가 7인지 확인 => 7이라면 반복을 종료한다
		 *    	=> 반복 종료시킨다
		 */
		
		int[] lottoNumbers = new int[6];
		
		int indexCount = 0;
		int randomNumber = 0;
		boolean isDuplicated = false;
		
		while(indexCount < 6) {
			// 매 반복마다 중복 여부값 초기화 시켜주기
			isDuplicated = false;
			
			// 로또번호 랜덤하기 뽑기
			randomNumber = (int) (Math.random() * 45 + 1);
			
			// lottoNumber에 randomNumber 가 존재하는지 확인하기
			for (int i = 0; i < indexCount; i++) {
				if (lottoNumbers[i] == randomNumber) {
					isDuplicated = true;
					break; // 중복숫자 찾기 for 종료
				}
			}
			
			// 중복된 숫자가 아니라면
			if (!isDuplicated) {
				// lottoNumbers[indexCount]에 랜덤값을 할당한다
				lottoNumbers[indexCount] = randomNumber;
				// indexCount를 1 증가시킨다
				indexCount++;
			}
		}
		System.out.println(Arrays.toString(lottoNumbers));
		sortNumbers(lottoNumbers);
	}
	
	public static void sortNumbers(int[] lottoNumbers) {
		// 아이템 개수만큼 반복
		for (int i = 0; i < lottoNumbers.length; i++) {
			// 대/소비교를 위한 반복
			for (int j = 0; j < lottoNumbers.length - 1 - i; j++) {
				System.out.println(lottoNumbers[j] + ">" + lottoNumbers[j + 1]);
				if (lottoNumbers[j] > lottoNumbers[j + 1]) {
					int temp = lottoNumbers[j];
					lottoNumbers[j] = lottoNumbers[j + 1];
					lottoNumbers[j + 1] = temp;
				}
			}
			System.out.println(i + "=>" + Arrays.toString(lottoNumbers));
		}
	}
	
	public static void main(String[] args) {
		makeLottoNumber();
	}
}
