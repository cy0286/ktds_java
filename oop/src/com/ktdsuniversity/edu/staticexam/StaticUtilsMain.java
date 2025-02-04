package com.ktdsuniversity.edu.staticexam;

public class StaticUtilsMain {

	public static void main(String[] args) {
		boolean isValidAge = StaticUtils.isValidAge(10, 0, 101);
		System.out.println(isValidAge);
		
		isValidAge = StaticUtils.isValidAge(200, 0, 101);
		System.out.println(isValidAge);
		
		double courseCredit = StaticUtils.getCourseCredit(85.19);
		System.out.println(courseCredit);
		
		courseCredit = StaticUtils.getCourseCredit(39.11);
		System.out.println(courseCredit);
	}
}
