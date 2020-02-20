package com.ssafy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
public class FileReader{
  public FileReader(String path) throws FileNotFoundException{
  }
  public int read()throws IOException{  
  }
}
 */
public class ExceptionTest {
  public static void main(String[] args) throws IOException {
	  try {
		FileReader fr = new FileReader("res/a.txt");
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		/*
		
		
		//a.txt파일을 읽어서 내용을 콘솔에 출력  
		try{
		//정석!!
		//	    FileReader fr = new FileReader("C:\\SSAFY\\01_java\\day12\\src\\com\\ssafy\\a.txt");
		//	    FileReader fr = new FileReader("C:/SSAFY/01_java/day12/src/com/ssafy/a.txt");
		//이클립스 JavaProject에서만 프로젝트명까지 생략하는 것이 가능!!	    
		//	    FileReader fr = new FileReader("src/com/ssafy/a.txt");
		FileReader fr = new FileReader("res/a.txt");
		int i;
		while(  (i=fr.read())  !=  -1 ) {
		  System.out.print((char)i);
		}
		}catch(FileNotFoundException e) {//e: 예외에러메시지 객체
		 //예외발생시 처리할 문장
		  System.out.println("#파일의 존재 또는 위치를 확인하세요~!!");
		  
		 //메시지 확인
		//		  e.printStackTrace();
		//		  System.out.println(e);//e.toString()
		//		  System.out.println(e.getMessage());
		  
		}catch(IOException e) {
		  System.out.println("#입출력 예외발생~!!");
		  
		}
		*/
	} catch (Exception e) {
		// TODO: handle exception
	}
	  
	  
	  
	  
  }//main
}







