package com.ssafy.method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution32 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int Y = sc.nextInt();
			int X = sc.nextInt();
			int N = sc.nextInt();
			int cash = -1000 * N;
			int rr = 0, cc = 0, n = 0, hr, hc;

			int[][] map = new int[Y + 1][X + 1];
			for (int i = 1; i <= Y; i++) {
				for (int j = 1; j <= X; j++) {
					int xy = sc.nextInt();
					map[i][j] = xy;
				}
			}

			int[][] member = new int[N][3];
			for (int i = 0; i < N; i++) {
				rr = sc.nextInt();
				cc = sc.nextInt();
				n = sc.nextInt();
				member[i][0] = rr;
				member[i][1] = cc;
				member[i][2] = n;
			}

			int hk = sc.nextInt();

			for (int i = 0; i < hk; i++) {
				hr = sc.nextInt(); //
				hc = sc.nextInt(); //
				map[hr][hc] = 0;
			}

//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}

			int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

			for (int i = 0; i < N; i++) {
				rr = member[i][0];
				cc = member[i][1];
				n = member[i][2];
				top: for (int j = 0; j < n; j++) {
					int d = map[rr][cc] / 10;
					int jk = map[rr][cc] % 10;
					rr = rr + (jk * dir[d - 1][0]);
					cc = cc + (jk * dir[d - 1][1]);
					if (!(rr >= 0 && rr <= X && cc >= 0 && cc <= Y) || map[rr][cc] == 0) {
						rr = 0;
						cc = 0;
						break top;
					}
				}
				cash += (map[rr][cc] * 100);
			}
			System.out.println(cash);
		}

	}

}
