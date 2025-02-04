package com.ktdsuniversity.edu.staticexam;

public class StaticUtils {
	public static boolean isValidAge(int age, int min, int max) {
		
		return age > min && age < max;
	}
	
	public static double getCourseCredit(double average) {
		
		int courseCredit = (int) (Math.abs(average - 55) / 10.0);
		return courseCredit;
	}
}
