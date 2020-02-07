package com.ssafy;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.floor(4.5));
		System.out.println(Math.ceil(4.2));
		System.out.println(Math.round(4.2));
		System.out.println(Math.round(4.5));
		
		//log는  자연로그이므로 base로 나눠야한다.		
		System.out.println(Math.log(8)/Math.log(2));  //base로 나눠줘야함
		//상용log는 계산이 잘됨
		System.out.println(Math.log10(100));
		
		System.out.println(Math.log(500000)/Math.log(2)*500000);  //base로 나눠줘야함
		
//		21억은 2의 19승
		
//		Math.random() : 0 <= x < 1 의 데이터를 랜덤하게 추출
		
//		1~10까지의 데이터 추출
		System.out.println((int)(Math.random()*10)+1);
		
		Random ran = new Random();
		System.out.println(ran.nextInt());
		
//		지정한 범위 내에서 난수 발생
		System.out.println(ran.nextInt(10));
		
	}

}
