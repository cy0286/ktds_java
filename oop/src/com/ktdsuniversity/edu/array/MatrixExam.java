package com.ktdsuniversity.edu.array;

public class MatrixExam {

	/**
	 * 가변 이차원 배열 (5 x n)
	 */
	public static void variableMatrix() {
		int[][] matrix = new int[5][];

		// 인덱스마다 크기가 다른 배열들을 만들어 할당
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[(int) (Math.random() * 10 + 1)];
		}

		// 데이터 채우기
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = j + 1;
			}
		}

		// 데이터 출력하기
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(i + "배열 정보입니다.");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * 고정 이차원 배열 (5 x 5)
	 */
	public static void matix() {
		int[][] matrix= new int[5][5];
		
		// 데이터 채우기
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = j + 1; 
			}
		}
		
		// 데이터 출력하기
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(i + "배열 정보입니다.");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		int[] n = new int[0]; // 개수가 0개인 배열은 의미 x
		// n[0] = 100; 의미 없는 코드 -> 배열의 개수가 없는데 넣으려고 함 에러 발생 !
		System.out.println(n.length); // 길이도 0임 
		// variableMatrix에서 Math.random 에 +1을 해준 이유
		
		matix();
		variableMatrix();
	}
}
