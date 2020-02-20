package com.ssafy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest_me {

	/**
	 * public class FileReader;
	 * public FileReader(String path) throws FileNotFoundException{
	 * }
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//a.txt 파일을읽어서 내용을 콘솔에 출력
		
		try{
			FileReader fr = new FileReader("res/a.txt");
			int i;
			while((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
			System.out.println();
//			FileReader fr = new FileReader("a.txt");
//			FileReader fr = new FileReader("src/com/ssafy/a.txt");
//			경로는 역슬래시 두번 아니면 슬래시 한번으로 
//			이클립스 JavaProject에서만 프로젝트명까지 생략하는 것이 가능하다.
			fr.read();
		}catch(FileNotFoundException e) { //e: 예외에러 메시지 객체
			//예외 발생시 처리할 문장
			System.out.println("#파일의 존재 또는 위치를 확인하세요~!");
//			//메시지 확인
//			e.printStackTrace();
//			System.out.println(e); //e.toString();
//			System.out.println(e.getMessage());
		}catch(IOException e) {
			
		}
		
	}

}
