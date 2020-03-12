package com.ssafy.step04.sebset;

import java.util.Scanner;

public class S02_BinaryCountingTest {
	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		totalCnt = 1 << N;
		generateSubset(totalCnt);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void generateSubset(int caseCnt) {
		for (int flag = 0; flag < caseCnt; flag++) {
			// flag 비트열 별로 원소 수만큼 각 자리 비트를 확인 (재귀 사용X -> 더빠름)
			for (int i = 0; i < N; i++) {
				System.out.print(((flag & 1 << i) != 0 ? input[i] : "X") + "\t");
			}
			System.out.println();
		}
	}
}
