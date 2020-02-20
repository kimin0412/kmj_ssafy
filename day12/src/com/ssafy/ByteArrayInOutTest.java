package com.ssafy;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteArrayInOutTest {
    //c.txt읽기   ----> d.txt쓰기
	
   public static void main(String[] args) throws Exception{
	  
	  //InputStream과 OutputStream은 자바 입출력의 기본이며
	  //이미지, 실행파일, 동영상 파일에 대한 입출력에 용이함.
	  FileInputStream fis = new FileInputStream("res/c.txt");//내용 : abcd / 내용 : abcdefg
	  FileOutputStream fos = new FileOutputStream("res/d.txt");
	  
	  byte []b = new byte[5];
	  int i; //i= 5, 2, -1
	  while((i=fis.read(b)) != -1) { //fis.read():7번 반복돌아감, fis.read(b):5번 반복 돌아감.
//		  fos.write(b);
		  fos.write(b,0,i);
	  }
	  System.out.println("복사 성공~!!");
	  
//	  System.out.println(fis.read());//97
//	  System.out.println(fis.read());//98
//	  System.out.println(fis.read());//99
//	  System.out.println(fis.read());//100
//	  System.out.println(fis.read());//-1
//	  ==> while(fis.read() != -1) {}
	  
//	  byte []b = new byte[5];
//	  for (int i = 0; i < b.length; i++) {
//		  System.out.println("b["+i+"]="+ b[i]);
//	  }
//	  
//	  fis            .read     (b);
//   ------------------------------	  
//	 'c.txt'파일을         읽어서     b배열에 복사!!     ===> 리턴 : 읽은 바이트 수!!
//	  System.out.println("=============");
//	  System.out.println(fis.read(b));//4  (읽은 바이트 수)
//	  for (int i = 0; i < b.length; i++) {
//		  System.out.println("b["+i+"]="+ b[i]);
//	  }
//	  System.out.println("=============");
//	  System.out.println(fis.read(b));//-1 (읽은 바이트가 없다면)
//	  for (int i = 0; i < b.length; i++) {
//		  System.out.println("b["+i+"]="+ b[i]);
//	  }
	  
	  //fos.write(byte[]b);
	  //바이트 배열 b를 읽어서 fos('d.txt')에 써라!!
	  
	  //fos.write(byte[]b, int offset, int length);
	  //바이트 배열 b를 읽어서 fos('d.txt')에 써라!!(조건 : offset부터 시작해서 length만큼)          
	  
//	  byte[]b2 = {65,66,67,68};
	  //          'A''B''C''D'
//	  fos.write(b2);
	  //fos.write(b2,0,3);//0인덱스 부터 3개!!
//	  fos.write(b2,1,2);//1인덱스 부터 2개!!
  
   }	
}
