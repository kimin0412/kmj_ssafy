package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Robot {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		/day3/robot.txt
		System.setIn(new FileInputStream("robot2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			sc.nextLine();
			int N = sc.nextInt();
			String temp = new String();
			String[][] arr = new String[N][N];
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.next();
				}
			}
			
//			for (int i = 0; i < arr.length; i++) {
//				for (int j = 0; j < arr.length; j++) {
//					System.out.print(arr[i][j]+" ");					
//				}
//				System.out.println();
//			}//출력해보기
			
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				int tmp = 0;
				for (int j = 0; j<N; j++) {
					if(arr[i][j].equals("A")) {
//						System.out.println("!!");
						tmp = j;
						flag = true;
					}
					else if(!arr[i][j].equals("S") && flag == true) {
						sum+=(j-tmp-1);
//						System.out.println(sum);
//						System.out.println(j+" "+tmp);
						flag = false;
					}
				}
				
				for (int j = 0; j<N; j++) {
					if(arr[i][j].equals("B")) {
						
						tmp = j;
						flag = true;
					}
					else if(!arr[i][j].equals("S") && flag == true) {
						sum+=(j-tmp-1);
//						System.out.println(sum);
//						System.out.println(j+" "+tmp);
						flag = false;
					}
				}
				
				for (int j = 0; j<N; j++) {
					if(arr[i][j].equals("A")) {
//						System.out.println("!!");
						tmp = j;
						flag = true;
					}
					else if(!arr[i][j].equals("S") && flag == true) {
						sum+=(j-tmp-1);
//						System.out.println(sum);
//						System.out.println(j+" "+tmp);
						flag = false;
					}
				}
			}
			System.out.println(sum);
			
			
			
			
			
		}
		
		
		
	}

}
