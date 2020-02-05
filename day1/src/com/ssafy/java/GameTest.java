package com.ssafy.java;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.\n1. 5판 3승\n2. 3판 2승\n3. 1판 1승\n번호를 입력하세요.");
		int choice = sc.nextInt();
		String tmp = sc.nextLine();
		boolean flag = false;
		int win = 0, loose=0, nop=0;
		
		for (int i = 0; i < 1000; i++) {
			System.out.print("가위바위보 중 하나 입력 : ");
			String s = sc.nextLine();
			int a = 0;
			
			switch(s) {
			case "가위" : a = 1; break;
			case "바위" : a = 2; break;
			case "보" : a = 3; break;
			}
			
			int ran = (int) (Math.random() * 3) +1 ;
			if(a == ran) {
				System.out.println("비겼습니다~");
				nop++;
			} else if((a==1 & ran==2) || (a==2 & ran==3) || (a==3 & ran==1)) {
				System.out.println("졌습니다!!");
				loose++;
			} else {
				System.out.println("이겼습니다...");
				win++;
			}
			
			switch(choice) {
			case 1:
				flag = true;
				if(win == 3) System.out.println("\n###사용자 승!!!");
				else if (loose==3) System.out.println("\n###컴퓨터 승!!!!");
				else flag=false;
				break;
			case 2:
				flag = true;
				if(win == 2) System.out.println("\n###사용자 승!!!");
				else if (loose==2) System.out.println("\n###컴퓨터 승!!!!");
				else flag=false;
				break ;
			case 3:
				flag = true;
				if(win == 1) System.out.println("\n###사용자 승!!!");
				else if (loose==1) System.out.println("\n###컴퓨터 승!!!!");
				else flag=false;
				break ;
			}
			if(flag==true) break;
		}
		if(flag == false) System.out.println("승부가 안나요,,,");
		sc.close();
	}
}
