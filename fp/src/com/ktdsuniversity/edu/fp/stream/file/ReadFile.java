package com.ktdsuniversity.edu.fp.stream.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * 파일의 내용을 읽어서 스트림 처리를 진행
 */
public class ReadFile {

	private final String FILE_PATH = "C:\\Users\\cy028\\바탕 화면\\streamexam";
	private final String FILE_NAME = "text.txt";
	
	public void printFileDescription() {
		
		Stream<String> fileStream = null;
		
		try {
			// 한 줄에서 데이터를 읽어올 수 있음 
			fileStream = Files.lines( new File(this.FILE_PATH, this.FILE_NAME).toPath() );
			
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
		if (fileStream != null) {
			fileStream.filter( line -> line.length() > 0) // 줄바꿈 제거
					  .map( line -> line.replace("\t", " ")) // 탭 제거
					  .map( line -> line.replaceAll("(KBS|KBS1|KBS2|SBS|MBC|tvN|JTBC|넷플릭스)", "")) // 그룹들은 () 소괄호 안에 나타냄
					  .map( line -> line.replaceAll("(《|》)", ""))
					  .map( line -> line.trim())
					  .filter( line -> line.contains(" MC"))
					  .filter( line -> !line.endsWith("MC상"))
					  .filter( line -> line.length() < 50)
					  .forEach( line -> System.out.println(line) );
		}
	}
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.printFileDescription();
	}
}
