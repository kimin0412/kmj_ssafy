package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Robot2 {
	static int T, N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("robot.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();  //테스트 케이스 입력
		for (int test_case = 0; test_case < T; test_case++) {
			sc.nextLine();
			N = sc.nextInt();  //배열의 크기 입력
			char[][] map = new char[N][N];
			for (int r = 0; r < N; r++) {  //배열 데이터 입력
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.next().charAt(0);  //입력된 문자열 중 첫글자
				}//end c
			}//end r
			
			//처리
			int Answer = 0;
			for (int r = 0; r < N; r++) {  //배열 데이터 탐색
				for (int c = 0; c < N; c++) {
					switch(map[r][c]) {
					case 'A':  //우탐색
						for (int ic = c+1; ic < N; ic++) {
							if(map[r][ic] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						break;
						
					case 'B':  //좌우탐색
						for (int ic = c+1; ic < N; ic++) {  //좌탐색
							if(map[r][ic] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						for (int jc = c-1; jc >= 0; jc--) {  //우탐색
							if(map[r][jc] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						break;
						
					case 'C':  //상하좌우탐색
						for (int ic = c+1; ic < N; ic++) {
							if(map[r][ic] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						for (int jc = c-1; jc >= 0; jc--) {
							if(map[r][jc] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						for (int iu = r+1; iu < N; iu++) {
							if(map[iu][c] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						for (int ju = r-1; ju >= 0; ju--) {
							if(map[ju][c] == 'S') {
								Answer++;
							}
							else {
								break;
							}
						}
						
						break; //마지막이니까 break; 굳이 없어도 상관없음
						
					}
				}
			}
//			case C : 상하좌우 *break 빼고*
//			case B : 상하좌우 *break 빼고*
//			case A : 상하좌우 *break 빼고*
			
			
			//출력
			System.out.println("#"+(test_case+1)+" "+Answer);	
		}
	}
}
