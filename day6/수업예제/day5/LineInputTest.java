package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class A{//BufferedReader
	
   int su=100;
   
   //String readLine(){}
   void hello() {
	 System.out.println("A클래스 안녕~!!");
   }
}

public class LineInputTest {
	public static void main(String[] args) throws Exception{
	 //라인단위 입력
       A  a = new A();//a.필드명   a.메소드명
       System.out.println("SU="+a.su);
       a.hello();
       
       BufferedReader br = new BufferedReader(
    		        new InputStreamReader(System.in));
       
       System.out.print("입력: ");
       String str=br.readLine();//입력시점
       System.out.println("STR="+str);
       System.out.println("str+100="+ (str+100) );
       //"123"+100 ="123100"
       System.out.println("123+100="+ (Integer.parseInt(str)+100) );
       //parseInt("123")+100 = 123+100 = 223
    }
}











