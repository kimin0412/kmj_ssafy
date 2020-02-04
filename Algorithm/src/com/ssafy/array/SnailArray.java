package com.ssafy.array;

import java.util.Scanner;

public class SnailArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] snail = new int[n][n];
			int cnt = 0; // 증가시키는 변수
			int i = 0; // 배열의 행
			int j = -1; // 배열 열
			int sw = 1; // -1,1 부호변경
			int k = n; // 반복하는 횟수
			while (k > 0) {
				for (int a = 0; a < k; a++) { // 가로 숫자 채우기
					cnt++;
					j = j + sw;
					snail[i][j] = cnt;
				}
				k--;
				if (k > 0) {
					for (int a = 0; a < k; a++) {
						cnt++;
						i = i + sw;
						snail[i][j] = cnt;
					}
				}
				sw = sw * (-1);
			}
			System.out.println("#" + test_case);
			for (int x = 0; x < snail.length; x++) {
				for (int y = 0; y < snail[x].length; y++)
					System.out.print(snail[x][y] + " ");
				System.out.println();
			}
		}
	}
}
