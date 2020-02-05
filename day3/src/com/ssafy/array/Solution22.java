package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
	static int T, N, M;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("solution22.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt(); // 테스트 케이스 입력
		for (int test_case = 0; test_case < T; test_case++) {
			sc.nextLine();
			N = sc.nextInt(); // 배열의 크기 입력
			int[][] map = new int[N][N];
			M = sc.nextInt(); // 소금쟁이 수 입력
			int rr, cc, dd, cnt = M;
			
			top:
			for (int m = 0; m < M; m++) {
				rr = sc.nextInt();
				cc = sc.nextInt();
				dd = sc.nextInt();

				int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

				int nr, nc, n = dir.length;
				for (int i = 3; i > 0; i--) {
					rr = rr + i * (dir[dd - 1][0]);
					cc = cc + i * (dir[dd - 1][1]);
					if (!(rr > -1 && rr < N && cc > -1 && cc < N)) {
						cnt--;
						continue top;
					}
					if(map[rr][cc] == 1) {
						cnt--;
						continue top;
					}
				}
				map[rr][cc] = 1;
			}
			System.out.println(cnt);
		}

	}

}
