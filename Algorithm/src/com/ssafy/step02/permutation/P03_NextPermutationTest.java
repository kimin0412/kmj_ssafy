package com.ssafy.step02.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P03_NextPermutationTest {

	static int N, R;
	static int[] input, number;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 2~10개
		R = sc.nextInt();
		input = new int[N];
		number = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void permutation(int cnt, int flag) { // cnt: 순열을 뽑는 자리

		if (cnt == R) { // 기저조건
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		// 해당 자리에 뽑을 가능한 모든 수에 대해 시도(앞자리까지 선택된 수 배제)
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			number[cnt] = input[i];
			permutation(cnt + 1, flag | 1 << i); // 다음 자리의 순열 뽑기

		}
	}

}
