package com.ssafy;

import java.io.File;
import java.io.FileWriter;

public class FileTest {
  public static void main(String[] args) throws Exception{
	 //File클래스 ==> 파일의 속성 정보를 얻는 용도 
	 File f = new File("C:/SSAFY/01_java/day12/res/a.txt");
	      f = new File("res/a.txt");
	      f = new File(".");// .경로 : current directory (현재경로)
	      f = new File("..");// ..경로 : parent directory (부모경로)
	      f = new File("../..");// ..경로 : parent directory (부모경로)
	 
	 //경로정보 얻어오기
	 System.out.println("f.getPath()==> "+ f.getPath());
	 System.out.println("f.getAbsolutePath()==> "+ f.getAbsolutePath());
	 System.out.println("f.getCanonicalPath()==> "+ f.getCanonicalPath());
	 
	 File f2 = new File("res/a.txt");

	 System.out.println("f2파일(디렉토리)존재 유무: "+ f2.exists());
	   
	   if(f2.isFile()) {//f2이 파일이면 true
		   System.out.println("f2은 파일!!");
	   }
	   //is가 붙으면 파일의 상태를 묻는게 대부분
	   if(f2.isDirectory()) {//f2이 디렉토리(폴더)라면 true
		   System.out.println("f2은 디렉토리(폴더)!!");
	   }
//	   문제) song폴더에 c.txt파일을 생성하시오.
//	   new FileWriter("song/c.txt"); //이클립스에서 실행되는게 아니라 jvm에서 실행됨 -> 즉각 반영되는게 아님
	   
//	   ※참고: FileWriter, FileOutputStream은 파일을 생성하는 기능을 갖는다!!
//	   
//	   new FileReader("c.txt"); //----> 없는 파일의 경우 에러발생!!
//	   new FileWriter("c.txt"); //----> 없는 파일의 경우 파일생성!!
//	   
//	   new FileWriter("song/c.txt"); //---> 존재하지 않는 폴더에 대해 에러 발생!!
//	    ===> 해결방법)  File클래스를 사용 ---> 폴더를 생성하는 기능 메소드 존재. 
//	                                        mkdirs()	
	   String path="song/gildong/juwon";
	   String fileName="c.txt";
	   
	   File f3 = new File(path);
	   
	   if(f3.exists()) {//디렉토리가 존재한다면
		   System.out.println("#디렉토리가 이미 존재합니다!!");
	   }else {//폴더(디렉토리)가 존재하지 않는다면
		   f3.mkdirs();
		   System.out.println("#디렉토리를 새로 생성함!!");
	   }
	   
	   FileWriter fw = new FileWriter(path+"/"+fileName);
	   //명시된 파일을 생성!!	 
	   
	   //c.txt파일 삭제!!
	   File f4 = new File("song/gildong/juwon/c.txt");
	   fw.close();  //입출력 객체 반환
	   System.out.println("c.txt파일삭제: "+ f4.delete());//삭제 성공시 true!! =>삭제 안되는 이유 : fw에서 사용중이라서
	   
	   
	   //juwon폴더 삭제!!
	   File f5 = new File("song/gildong/juwon");
	   System.out.println("f5디렉토리삭제: "+ f5.delete());//삭제 성공시 true!!
	                                 //--->  빈 폴더 삭제 가능!! 
  }//main
}





