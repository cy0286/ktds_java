package com.ktdsuniversity.edu.datetime;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		
		// Calendar 인스턴스 가져오기
		Calendar nowCal = Calendar.getInstance();
		
		// 현재 연월일 시분초 조회하기
		System.out.println(nowCal.get(Calendar.YEAR));
		System.out.println(nowCal.get(Calendar.MONTH) + 1);
		System.out.println(nowCal.get(Calendar.DAY_OF_MONTH));
		System.out.println(nowCal.get(Calendar.HOUR));
		System.out.println(nowCal.get(Calendar.MINUTE));
		System.out.println(nowCal.get(Calendar.SECOND));
		// 1(일요일) ~ 7(토요일)
		System.out.println(nowCal.get(Calendar.DAY_OF_WEEK));
		
		// 현재 연월일만 문자열로 가져오기
		// 현재 날짜/시간
		Date now = Calendar.getInstance().getTime();
		System.out.println(now);
		
		// 날짜 포멧 지정
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 날짜를 포멧에 맞춰 변경
		String formatDate = format.format(now);
		System.out.println(formatDate);
		
		System.out.println();
		// 날짜를 지정 (2025년 2월 13일)
		nowCal.set(2025, 01, 13);
		System.out.println(nowCal.get(Calendar.YEAR));
		System.out.println(nowCal.get(Calendar.MONTH) + 1);
		System.out.println(nowCal.get(Calendar.DAY_OF_MONTH));
		
		// 날짜에 10일 더하기
		nowCal.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(nowCal.get(Calendar.YEAR));
		System.out.println(nowCal.get(Calendar.MONTH) + 1);
		System.out.println(nowCal.get(Calendar.DAY_OF_MONTH));
		
		// 날짜에 20일 빼기
		nowCal.add(Calendar.DAY_OF_MONTH, -20);
		System.out.println(nowCal.get(Calendar.YEAR));
		System.out.println(nowCal.get(Calendar.MONTH) + 1);
		System.out.println(nowCal.get(Calendar.DAY_OF_MONTH));
	}
}
