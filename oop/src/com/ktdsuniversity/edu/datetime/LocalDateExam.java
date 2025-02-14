package com.ktdsuniversity.edu.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 날짜 조회
 */
public class LocalDateExam {

	public static void main(String[] args) {
		LocalDate nowDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		String strNowDate = dateTimeFormatter.format(nowDate);
		System.out.println(nowDate);
		System.out.println(strNowDate);
	}
}
