package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R04_HanoiTest {

	static StringBuilder result = new StringBuilder();

	private static void hanoi(int cnt, int from, int temp, int to) {
							// 원판갯수(맨아래 원판번호), 시작기둥, 임시기둥, 목적기둥
		if (cnt == 0) // 옮길 원판이 없을때
			return;
		// 시작기둥의 n-1 덩어리 원판을 임시기둥으로 옮김.
		hanoi(cnt - 1, from, to, temp);
		// 시작기둥의 n원판 목적기둥으로 옮김.
		result.append(cnt + " : " + from + "->" + to + "\n");
		// 임시기둥의 n-1 덩어리 원판을 목적기둥으로 옮김.
		hanoi(cnt - 1, temp, from, to);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, 1, 2, 3);
		System.out.println(result.toString());
	}
}
