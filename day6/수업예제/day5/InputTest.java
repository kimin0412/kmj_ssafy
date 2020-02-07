package com.ssafy;

import java.io.IOException;

public class InputTest {
   public static void main(String[] args) throws Exception {
	  //바이트 단위 입력(아스키코드입력) 테스트
	   System.out.print("한자리 수 입력:");
	   int su = System.in.read(); //입력시점   '3  엔터' : '51' '13' '10'
	            System.in.read();
	            System.in.read();
	   System.out.print("같은 수를 다시 입력: ");
	   int su2 = System.in.read()-48; //입력시점 
	   System.out.println("당신이 입력한 수는 "+su2+"이고 그 수의 아스키 코드값은 "
			       +su+"입니다!!");
	   System.out.println(97);
	   System.out.println((char)97);
	   
   }
}





