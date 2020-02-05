package com.ssafy.method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Miro {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("miro.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N+1][N+1];
			int rr = sc.nextInt();
			int cc = sc.nextInt();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = 1;
			}
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int d = sc.nextInt();  //이동 방향
				int dd = sc.nextInt();  //이동횟수
				int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; 
				top:
				for (int i = 0; i < dd; i++) {
					rr = rr + dir[d-1][0];
					cc = cc + dir[d-1][1];
					if(!(rr>-1 && rr<N && cc>-1 && cc<N)||map[rr][cc]==1 ) {
						rr = 0;
						cc=0;
						break top;
					}
				}
			}
			System.out.println(rr+ " "+cc);
		}
	}
}
