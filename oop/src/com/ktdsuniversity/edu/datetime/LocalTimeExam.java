package com.ktdsuniversity.edu.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 시간 조회
 */
public class LocalTimeExam {

	public static void main(String[] args) {
		LocalTime nowTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		String strNowTime = timeFormatter.format(nowTime);
		System.out.println(nowTime);
		System.out.println(strNowTime);
	}
}
