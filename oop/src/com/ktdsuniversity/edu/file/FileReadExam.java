package com.ktdsuniversity.edu.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.file.data.Product;

/**
 * 바탕화면 > FileIOExam > readSample.txt
 * Lorem Ipsum 사이트에서 참고
 * readSample.txt 를 읽을 수 있는 방법이 2가지 있음
 */
public class FileReadExam {

	public static void loadProducts() {
		File targetFile = new File(
				"C:\\Users\\User\\Desktop\\fileexam\\fileioexam",
				"products.txt");
		List<Product> productsList = new ArrayList<Product> (); // 상품 목록을 가져오기 위함
		
		try {
			// 한줄 한줄 읽을 결과를 리스트에 넣어줌
			List<String> fileLine = Files.readAllLines(targetFile.toPath()); // Autocloseable 로 된 파이프를 자동으로 닫아줌
			for ( String line : fileLine ) {
				System.out.println(line);
				 // new Product 안에  ,를 기준으로 배열에 넣어줌
				productsList.add(new Product(line.split(",")));
			}
		} 
		catch (IOException ioe) {
			System.out.println("파일을 읽어오는 중에 에러가 발생했습니다.");
			System.out.println("원인: " + ioe.getMessage());
		}
		for (Product eachProduct : productsList) {
			System.out.println(eachProduct);
		}
	}
	
	// 요즘 파일 읽어오는 방식
	public static void fileReadUseNewIO(String directoryPath, String filename) {
		File targetFile = new File(directoryPath, filename);
		try {
			// 한줄 한줄 읽을 결과를 리스트에 넣어줌
			List<String> fileLine = Files.readAllLines(targetFile.toPath()); // Autocloseable 로 된 파이프를 자동으로 닫아줌
			for ( String line : fileLine ) {
				System.out.println(line);
			}
		} 
		catch (IOException ioe) {
			System.out.println("파일을 읽어오는 중에 에러가 발생했습니다.");
			System.out.println("원인: " + ioe.getMessage());
		}
	}
	
	public static void fileReadUseOldIO(String directoryPath, String filename) {
		// 읽어오려는 파일 객체 만든다 (targetFile)
		File targetFile = new File(directoryPath, filename);
		// targetFile 이 존재하지 않거나 내가 읽을려는 파일이 아니면 return
		if( !targetFile.exists() || !targetFile.isFile() ) {
			return;
		}
		
		
		// fileReader , bufferedReader를 try 밖으로 빼야 finally 까지 갈 수 있음
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			// 파일을 읽기 위한 java.io.FileReader 객체를 만든다 (fileReader)
			fileReader = new FileReader(targetFile);
			// Note. 파일의 내용을 바이트 단위로 읽는다
			// 영어, 숫자, 특수문자 : 1 byte "abc"
			// 그 외 나머지 외국어들 : 3 byte "한글"
			// "한글" 에서 1 바이트를 읽었다 => "?ㅁ " 이상하게 읽어진다 한글은 3byte 를 완전히 읽어야 하기 때문
			
			// 파일을 한 줄 씩 읽기 위한 BufferedReader 객체를 만든다 (bufferedReader)
			bufferedReader = new BufferedReader(fileReader);
			// Note. 내부에서 FileReader 를 이용해서 한 줄 자체를 통째로 읽음
			 // 캐리지리턴(\n) 이 나올때 까지 바이트를 계속 읽는다
			
			// BuffuerReader를 통해서 EOF 까지 한줄 씩 읽는다
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				// 한줄 씩 출력한다
				System.out.println(line);
			}
		} 
		catch (FileNotFoundException fene) {
			System.out.println(targetFile.getName() + " 파일이 존재하지 않습니다.");
			return;
		}
		catch (IOException ioe) {
			System.out.println("파일을 읽어오는 중에 에러가 발생했습니다.");
			System.out.println("원인: " + ioe.getMessage());
			return;
		}
		finally {
			// 파이프를 닫는다 (오픈의 역순)
				// BufferReader 를 닫는다
			// null 이라는 의미는 파이프가 연결되어있다는 의미이기 때문에 반드시 null 체크를 해줘야함
			if (bufferedReader != null) {
				try {
					//시스템 적인 영역이라 file 을 닫다가 에러나면 잡을 수가 없음 => close() 만 함
					bufferedReader.close();
					
				} 
				catch (IOException ioe) {}
			}
			// FileReader 를 닫는다
			if (fileReader != null) {
				try {
					fileReader.close();
				}
				catch (IOException ioe) {}
			}
		}
		// try-catch 는 에러가 났을 경우 return 되기 직전에 즉시 종류가 아니라
		// finally 가 존재한다면 무조건 finally 를 갔다가 return 으로 온다
	}
	
	
	public static void main(String[] args) {
//		fileReadUseOldIO("sdfsdfsfe", "fesfsefesf");
//		fileReadUseOldIO("C:\\Users\\User\\Desktop\\fileexam", "readSample.txt");
		
//		fileReadUseNewIO("sdfsdfsfe", "fesfsefesf");
//		fileReadUseNewIO("C:\\Users\\User\\Desktop\\fileexam", "sample.txt");
		
		loadProducts();
	}
}
