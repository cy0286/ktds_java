package com.ktdsuniversity.edu.generic;

import school.Student;

public class Main {

	public static void main(String[] args) {
	
		ScoreArray<Integer> sa = new ScoreArray<>("ABC");
		for (int i = 0; i < 100; i++) {
			sa.add((int) (Math.random() * 101)); // int
		}
		//	System.out.println(sa.sum()); -> int
		//	System.out.println(sa.average()); -> double
		Object[] intScoreArray = sa.getScoreArray();
		int intSize =  sa.getSize();
		int sum = 0;
		for (int i = 0; i < intSize; i++) {
			// is a 규칙 위반
			// String is a Object
			// 여기서 Object is a String 이라고 해버림 (규칙 위반)
			// sum += Integer.parseInt(intScoreArray[i]);
			sum += Integer.parseInt(intScoreArray[i].toString());
		}
		System.out.println(sum);
		
		double average = sum / (double) intSize;
		System.out.println(average);
		
		ScoreArray<String> sa2 = new ScoreArray<>("ABC");
		for (int i = 0; i < 100; i++) {
			sa2.add((int) (Math.random() * 101) + ""); // String
		}
		Object[] stringScoreArray = sa2.getScoreArray();
		int stringSize =  sa2.getSize();
		int stringSum = 0;
		for (int i = 0; i < stringSize; i++) {
			stringSum += Integer.parseInt(stringScoreArray[i].toString());
		}
		System.out.println(stringSum);
		
		double stringAverage = stringSum / (double) stringSize;
		System.out.println(stringAverage);
		
		ScoreArray<Student> sa3 = new ScoreArray<>("ABC");
		for (int i = 0; i < 100; i++) {
			int score1 = (int) (Math.random() * 101);
			int score2 = (int) (Math.random() * 101);
			int score3 = (int) (Math.random() * 101);
			int score4 = (int) (Math.random() * 101);
			sa3.add(new Student(score1, score2, score3, score4)); // 100 명의 student
		}
		Object[] studentScoreArray = sa3.getScoreArray();
		int studentSize =  sa3.getSize();
		int studentSum = 0;
		for (int i = 0; i < studentSize; i++) {
			studentSum += ((Student) studentScoreArray[i]).getSumAllScores();
		}
		System.out.println(studentSum);
		
		double studentAverage = studentSum / (double) studentSize;
		System.out.println(studentAverage);
	}
}
