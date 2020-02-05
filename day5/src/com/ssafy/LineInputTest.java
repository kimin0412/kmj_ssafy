package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class A { //BufferedReader
	
	int su = 100;
	
	//String readLine(){}
	void hello() {
		System.out.println("A클래스 안녕~~!!");
	}
}

public class LineInputTest {
	public static void main(String[] args) throws IOException {
		//라인 단위 입력
		A a = new A();  //new가 메모리를 할당해주는 키워드 (이걸 대신해주는게 static)
		//사용 : a.필드명, a.메소드명
		System.out.println("SU="+a.su);
		a.hello();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 : ");
		String str = br.readLine();
		System.out.println("STR = " + str);
		System.out.println("str+100 =  " + (str+100));
		//"123"+100 = "123100"
		System.out.println("123+100 = " + (Integer.parseInt(str)+100));
		//parseInt("123")+100 = 123+100 = 223
		
		
		
	}
}
