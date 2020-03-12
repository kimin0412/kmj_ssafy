package com.ssafy.hw;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int N, M, number[], totalCnt;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		number = new int[N];
		isSelected = new boolean[7]; // 1,2,3,4,5,6

		switch (M) {
		case 1: // 주사위 던지기 1 : 중복 순열
			dice1(0); // 기존까지 던져진 주사위의 횟수
			break;
		case 2: // 주사위 던지기2 : 순열 
			dice2(0);
			break;
		case 3: // 주사위 던지기3 : 중복 조합
			dice3(0, 1);
			break;
		case 4: // 주사위 던지기4 : 조합
			dice4(0, 1);
			break;

		}
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void dice1(int cnt) { // 주사위 던지기1 : 중복순열
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 1; i <= 6; i++) { // 주사위의 눈 1~6
			number[cnt] = i;
			dice1(cnt + 1);
		}
	}

	private static void dice2(int cnt) { // 주사위 던지기2 : 순열
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 1; i <= 6; i++) { // 주사위의 눈 1~6
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			number[cnt] = i;
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void dice3(int cnt, int cur) { // 주사위 던지기3 : 중복조합
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = cur; i <= 6; i++) { // 주사위의 눈 1~6
			number[cnt] = i;
			dice3(cnt + 1, i);
		}
	}

	private static void dice4(int cnt, int cur) { // 주사위 던지기4 : 조합 
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = cur; i <= 6; i++) { // 주사위의 눈 1~6
			number[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}
}
