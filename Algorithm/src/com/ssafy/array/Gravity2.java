package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Gravity2 { //시뮬레이션 - 디버깅 필수(window-preference-java-debug-step filtering)

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();   //배열의 크기
		
		int[][] map= new int [n][n];  //상자가 쌓일 맵
		int m; //상자의 높이
		for (int i = 0; i < n; i++) { //열반복
			m=scan.nextInt();
			for (int j = n-1; j >=0; j--) { //행반복
				if(m==0) {
					break; //다 쌓은거니까 break
				}
				map[j][i] = 1; //1은 상자
				m--; //쌓았으니까 마이너스
				
			}
			System.out.println(Arrays.toString(map[i]));
		}
//		for (int[] box : map) {
//			System.out.println(Arrays.toString(box)); //확인			
//		}
		 int answer=-1;    //최대 낙차
		 int next = 0;
		 int count = 0;
		 
		 //n-2번째 열부터 박스를 이동하기
		 for (int i = n-2; i >=0; i--) {
			for (int j = 0; j < n; j++) { //행이동
				if(map[j][i] == 1) {
					next = n-1 -i;  
					for (int k = 1; k <= next; k++) {
						if(map[j][i+k]==0) { //다음 칸이 움직일 수있다.
							count++;
							map[j][i+k]=1;  //다음 칸으로 박스를 이동
							map[j][i+k-1]=0;  //현재 칸은 비우기
							 }else {
								 break;  //다음 칸이 움직일 수 없는 경우에는 멈춘다.
							 }
						
					}
					answer=Math.max(count, answer);
					count=0; //다시 세야되니까 초기화
				}
				
			}
			 
			
		}
		 System.out.println("answer:"+answer);
		 for (int[] box : map) {
				System.out.println(Arrays.toString(box)); //확인			
			}
	}

}
