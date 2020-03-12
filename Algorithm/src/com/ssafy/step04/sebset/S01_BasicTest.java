package com.ssafy.step04.sebset;

import java.util.Scanner;

public class S01_BasicTest {
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
		generateSubset(0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void generateSubset(int cnt) {
		if (cnt == N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i] ? input[i] : "X") + "\t");
			}
			System.out.println();
			return;
		}

		// 부분 집합에 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1);

		// 부분 집합에 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1);

	}

}
