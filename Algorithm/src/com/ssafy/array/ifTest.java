package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ifTest {
	public static void main(String[] args) throws Exception {
		/*
		 * if(조건){
		 *   //조건이 참인경우 수행할 문장;
		 *   }
		 * if(조건) {
		 *   //조건이 참일 경우 수행할 문장
		 *   }else if (조건) {
		 *   //조건이 거짓일때 수행할 문장;
		 *   }else{
		 *   }
		 *
		 */
		//입력받고 싶을때 스캐너
		//system.in을 file로 입력받도록 설정
		System.setIn(new FileInputStream("res/a.txt"));
		
		//명령창으로부터 데이터를 입력받는다(system.in=명령창)
		Scanner scan = new Scanner(System.in);
		//next : 공백과 엔터를 기준으로 하나의 데이터로 인식
		//nextline : 엔터를 기준으로 데이터로 인식
		System.out.println("이름을 입력해주세요");
		System.out.println("이름은 :"+scan.next()+"입니다");
		System.out.println("시간을 입력해주세요");
		int time = scan.nextInt();
		if(time >=9 && time <12) {
			System.out.println("오전 수업시간입니다.");
		}else if (time==12) {
			System.out.println("점심시간입니다.");
		}else if(time>=13 && time <18) {
			System.out.println("오후 수업시간입니다.");
		}else {
			System.out.println("자유 시간입니다.");
		}
	}
}
