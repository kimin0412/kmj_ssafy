package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution13 {
	static int T, N;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("solution13.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt(); // 테스트 케이스 입력
		for (int test_case = 0; test_case < T; test_case++) {
			sc.nextLine();
			N = sc.nextInt(); // 배열의 크기 입력
			char[][] map = new char[N][N];
			for (int r = 0; r < N; r++) { // 배열 데이터 입력
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.next().charAt(0); // 입력된 문자열 중 첫글자
				} // end c
			} // end r
//																		왼쪽위		오른쪽 위		왼쪽아래	오른쪽아래
			int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
			int[][] cnt = new int[N][N];

			int nr, nc, n = dir.length;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'B') { // B를 찾으면 상하좌우 탐색
						for (int ic = c + 1; ic < N; ic++) {
							if (map[r][ic] == 'B') {
								cnt[r][c]++;
							}
						}
						for (int jc = c - 1; jc >= 0; jc--) {
							if (map[r][jc] == 'B') {
								cnt[r][c]++;
							}
						}
						for (int iu = r + 1; iu < N; iu++) {
							if (map[iu][c] == 'B') {
								cnt[r][c]++;
							}
						}
						for (int ju = r - 1; ju >= 0; ju--) {
							if (map[ju][c] == 'B') {
								cnt[r][c]++;
							}
						}

						for (int i = 0; i < n; i++) {
							nr = r + dir[i][0];
							nc = c + dir[i][1];
							if (nr > -1 && nr < N && nc > -1 && nc < N) {
								if (map[nr][nc] == 'G') {
									cnt[r][c] = 2;
								}
							}
						}

					}
				}
			}

			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
//					System.out.print(cnt[r][c] + " ");
					if (max < cnt[r][c]) {
						max = cnt[r][c];
					}
				}
//				System.out.println();
			}
			System.out.println(max+1);

		}

	}

}
