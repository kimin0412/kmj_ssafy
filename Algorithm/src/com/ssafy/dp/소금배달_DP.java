package com.ssafy.dp;

import java.util.Scanner;

public class 소금배달_DP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 3 <= M <= 5000

		int[] memo = new int[M + 1]; // 1667개 1000개
		for (int i = 0; i < memo.length; i++) {
			if (i % 3 == 0) {
				memo[i] = i / 3;
			} else { // 배달불가
				memo[i] = Integer.MIN_VALUE - 1;
			}
		}

		for (int i = 0; i < memo.length; i++) { // 5kg 봉지 고려
			if (memo[i] > memo[i - 5] + 1) {
				memo[i] = memo[i - 5] + 1;
			}
		}

		System.out.println(memo[M] == Integer.MAX_VALUE ? -1 : memo[M]);
	} // end of main
} // end of class
