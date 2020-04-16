package algo;

import java.util.Arrays;
import java.util.Scanner;

public class 동전거스름돈 {
	// 1차원 배열에 업데이트 해서 동전 거스름돈 개수를 저장해보자
	public static int min = Integer.MAX_VALUE; // 최소봉지 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 8;
		int[] c = new int[n + 1];

		for (int i = 0; i < c.length; i++) {
			c[i] = i; // 1원짜리 필요한 개수
		}
		System.out.println(Arrays.toString(c));

		// 1, 4원 동전을 모두 고려
		for (int i = 4; i < c.length; i++) {
			// c[i] : 1원짜리 동전만 고려한 최소 개수
			// c[i-4] + 1 : 1원짜리, 4원짜리 동전을 고려한 최소 개수
			if (c[i] > c[i - 4] + 1) {
				c[i] = c[i - 4] + 1;
			}
		}
		System.out.println(Arrays.toString(c));

		// 1, 4, 6원 동전을 모두 고려
		for (int i = 6; i < c.length; i++) {
			// c[i] : 1, 4원짜리 동전을 고려한 최소 개수
			// c[i-6] + 1 : 1원짜리, 4원짜리, 6원짜리 동전을 고려한 최소 개수
			if (c[i] > c[i - 6] + 1) {
				c[i] = c[i - 6] + 1;
			}
		}
		System.out.println(Arrays.toString(c));

		System.out.println(c[n]);
	}// end of main

}// end of class
