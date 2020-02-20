package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileCopyTest { // 파일 복사
	// a.txt 파일을 읽어서 b.txt에 출력 : FileCopy!!
	
	//1)바이트 단위 입출력
	FileInputStream fis;
	FileOutputStream fos; //null값을 가지고 있다가 생성자에서 초기화 예정
	
	//2)문자 단위 입출력
	FileReader fr;
	FileWriter fw;
	
	//3)라인 단위 입출력 --> 문자들을 버퍼에 담았다가 한번에 읽고쓰기
	BufferedReader br;
	BufferedWriter bw;
	
	//4)바이트 단위 입출력(byte배열 사용) --> 문자들을 버퍼에 담았다가 한번에 읽고쓰기
	FileInputStream fis2;
	FileOutputStream fos2;
	
	public FileCopyTest() throws Exception { //파일 복사, 시간 체크
		//===============<바이트 단위 입출력>=====================
		fis = new FileInputStream("res/a.txt");
		fos = new FileOutputStream("res/b.txt");
		int i;
		long start = System.currentTimeMillis();
		while((i=fis.read()) != -1) {
			fos.write(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("[byte단위] 파일복사 성공!! ^^* " + (end-start));
		fos.close(); //입출력 객체 반환
		fis.close();

		//===============<문자단위 입출력>=====================
		fr = new FileReader("res/a.txt");
		fw = new FileWriter("res/b.txt");
		start = System.currentTimeMillis();
		while((i=fr.read()) != -1) {
			fw.write(i);
		}
		end = System.currentTimeMillis();
		System.out.println("[문자단위] 파일복사 성공!! ^^* " + (end-start));
		fw.close(); //입출력 객체 반환
		fr.close();
		
		//===============<라인단위 입출력>=====================
		br = new BufferedReader(new FileReader("res/a.txt"));
		bw = new BufferedWriter(new FileWriter("res/b.txt"));
		String str;
		start = System.currentTimeMillis();
		while((str=br.readLine()) != null) {
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("[라인단위(버퍼사용)] 파일복사 성공!! ^^* " + (end-start));
		bw.close(); //입출력 객체 반환
		br.close();
		
		//===============<바이트 단위(배열사용) 입출력>=====================
		fis2 = new FileInputStream("res/a.txt");
		fos2 = new FileOutputStream("res/b.txt");
		byte[] b = new byte[1024]; //보통 512 또는 1024
		start = System.currentTimeMillis();
		while((i=fis2.read(b)) != -1) {
			fos2.write(b,0,i);
		}
		end = System.currentTimeMillis();
		System.out.println("[byte단위(배열사용)] 파일복사 성공!! ^^* " + (end-start));
		fos2.close(); //입출력 객체 반환
		fis2.close();
		
		
	}//생성자

	public static void main(String[] args) throws Exception {
		new FileCopyTest();
	}

}
