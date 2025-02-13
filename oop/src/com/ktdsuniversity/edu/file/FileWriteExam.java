package com.ktdsuniversity.edu.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.file.data.Product;

public class FileWriteExam {

	public static void fileWriteUseNewIO(String directoryPath, String filename, List<String> data) {
		
		// 1. 새로 작성할 파일 인스턴스 만들기
		File writerFile = new File(directoryPath, filename);
		
		// 2. 파일을 만든 위치가 존재하는지 확인하기
		if ( ! writerFile.getParentFile().exists()) { 
			// 3. 없다면 폴더 새롭게 만들기
			// mkdir() 경우 - 폴더 한개만 만들어짐
			// C:\\Users\\User\\Desktop\\fileexam\\sefsef\\Store => sefsef 해당 폴더가 없는 상태라면
			// C:\\Users\\User\\Desktop\\fileexam\\sefsef\\는 만들고 Store 는 만들어주지 않음
			
			// mkdirs() 경우
			// C:\\Users\\User\\Desktop\\fileexam\\sefsef\\Store => sefsef 해당 폴더가 없는 상태라면
			// /Users/user/Desktop/sfsafsafd 폴더 생성
			// /Users/user/Desktop/sfsafsafd/Store 폴더 생성
			
			writerFile.getParentFile().mkdirs();
		}
		
		// 4. 같은 이름의 파일이 이미 존재하는지 확인하기
		int index = 2;
		while (writerFile.exists()) {
			// 5. 다른 이름의 파일이 나올 때까지 파일 명에 순번 붙이기
			// storeProduct.txt => storeProduct
			String newFileName = filename.substring(0, filename.lastIndexOf("."));
			// storeProduct => storeProduct (2).
			newFileName += "(" + (index++) + ").";
			// storeProduct (2).txt
			newFileName += filename.substring(filename.lastIndexOf(".")+1);
			writerFile = new File(directoryPath, newFileName);
		}
		
		// 6. 파일 쓰기
		try {
			Files.write(writerFile.toPath(), data);
			System.out.println(writerFile.getAbsolutePath());
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void fileWriteUseOldIO(String directoryPath, String fileName, String ... data) {
		
	}
	
	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
		data.add(new Product("스마트폰1", 200_000, 100).toFileFormat());
		data.add(new Product("스마트폰2", 200_001, 90).toFileFormat());
		data.add(new Product("스마트폰3", 200_002, 80).toFileFormat());
		data.add(new Product("스마트폰4", 200_003, 70).toFileFormat());
		data.add(new Product("스마트폰5", 200_004, 60).toFileFormat());
		data.add(new Product("스마트폰6", 200_005, 50).toFileFormat());
		
		// 내 컴퓨터에 Stroe 라는 폴더는 없고 storeProduct.txt 도 없지만 임의로 만들고 싶은 경우
		fileWriteUseNewIO("C:\\Users\\cy028\\바탕 화면\\fileexam\\fileioexam\\Store", "storeProduct.txt", data);
	}
}
