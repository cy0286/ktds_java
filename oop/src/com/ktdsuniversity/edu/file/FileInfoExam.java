package com.ktdsuniversity.edu.file;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileInfoExam {

	public static void printFileInfo(String directoryPath, String filename) {
		File file = null;
		if(filename == null) {
			file = new File(directoryPath);
		}
		else {
			file = new File(directoryPath, filename);
		}
		
		// 파일이 존재하는지
		boolean exists = file.exists();
		System.out.println(filename + " exists: " + exists);
		
		// 파일인지
		boolean isFile = file.isFile();
		System.out.println(filename + " isFile: " + isFile);
		
		// 폴던지
		boolean isDirectory = file.isDirectory();
		System.out.println(filename + " isDirectory: " + isDirectory);
		
		// 전체 경로가 무엇인지
		String absolutePath = file.getAbsolutePath();
		System.out.println(filename + " absoulutePath: " + absolutePath);
		
		// 파일 이름이 무엇인지
		String name = file.getName();
		System.out.println(filename + " name: " + name);
		
		// 파일의 크기는 얼마인지 
		/*
		 * 파일의 크기는 long 타입으로 받아옴
		 * 이유는?
		 * 1 byte = 8 bit;
		 * 1000 bytes = 1 KiB
		 * 1000 KiB = 1 MiB
		 * 1000 MiB = 1 GiB
		 * 1000 GiB = 1 TiB
		 * 1000 TiB = 1 PiB
		 * 
		 * 1 GiB = ? bytes
		 * => 90억 bytes int 범위를 벗어나기 때문에 long 타입 사용
		 */
		long length = file.length();
		System.out.println(filename + " length: " + length + "bytes");
		// 크기가 0으로 나오는 이유는 저장한 정보가 없기 때문
		
		// 파일이 언제 만들어졌는지 => 지금은 모름 (filter 사용해야 하기 때문)
		
		// 파일이 언제 마지막으로 수정됐는지
		// 날짜와 시간을 long 으로 주는 이유
		// 컴퓨터가 날짜와 시간을 처리하는 방법
		// 	기준(1970-01-01 00:00:00.000)으로 부터 몇 밀리초(1초 / 1000) 가 지났는지 계산
		long lastModifiled = file.lastModified();
		System.out.println(filename + " lastModifiled: " + lastModifiled + "ms");
		// 밀리초를 날짜 형식으로 변경
		Date lastModifiedDate = new Date(lastModifiled); // java.util.Date
		System.out.println(filename + " lastModifiled: " + lastModifiedDate);
		
		// 이 파일의 부모 폴더는 누구인지
		// 이 파일이 어디에 있는지
		String parentDirectoryPath = file.getParent(); // 폴더 만들 때 유용하게 사용
		System.out.println(filename + " parent: " + parentDirectoryPath);
		
		// file 객체가 폴더였을 때 폴더 내부에 있는 항목이 무엇인지
		File[] listFiles = file.listFiles();
		System.out.println(filename + " listFiles: " + listFiles);
		System.out.println(filename + " Arrays listFiles: " + Arrays.toString(listFiles));

	}
	
	/**
	 * 탐색을 시작하고 싶은 폴더를 주면
	 * 하위에 존재하는 모든 폴더와 파일들의 목록을 출력한다
	 * 파일 구조는 트리구조기 때문에 트리구조를 출력하려면 재귀호출이 필요함
	 */
	public static void traversingAndPrintFileInfo(String startDirectoryPath) {
		// startDirecoryPath 경로의 File 인스턴스 (file)를 생성
		File file = new File(startDirectoryPath);
		// file 이 존재한다면
		if (file.exists()) {
			// file 의 전체경로 (파일의 크기) 를 출력한다
			System.out.println(file.getAbsolutePath() + "(" + file.length() + ")");
		}
		//file 이 폴더라면
		else if (file.isDirectory()) {
			// file 의 자식 요소 (폴더 + 파일) 들을 얻어온다
			File[] listFiles = file.listFiles();
			// file 의 자식 요소 (폴더 + 파일) 들을 반복한다
			for (File child : listFiles) {
				// traversingAndPrintFileInfo(자식요소의 전체 경로);
				traversingAndPrintFileInfo(child.getAbsolutePath());
			}
		}
	} // => 해당 코드는 종료조건을 만들지 않더라도 해당 조건들이면 파일이 없거나 코드가 없으면 자연스럽게 끊어짐
	
	public static void main(String[] args) {
		traversingAndPrintFileInfo("C:\\Users\\User\\Desktop\\fileexam");
		System.out.println();
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", "company.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", "example.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", "sample.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1", "sub_company.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1", "sub_example.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1", "sub_sample.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1\\subfolder", "sub1-1_company.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1\\subfolder", "sub1-1_example.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1\\subfolder", "sub1-1_sample.txt");
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfoler1\\subfolder2", "sub1-1_sample.txt"); 
		
		// fileexam 의 폴더만 바라보면서 그 해당 폴더에 있는 파일들을 모두 가져온다
		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", null); 
		
	}
}
