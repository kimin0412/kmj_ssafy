package algo;

import java.util.Scanner;

/*
 * 월말평가 소금배달 문제 
 * BackTracking
 */
public class 소금배달1 {

	public static int min = Integer.MAX_VALUE; // 최소봉지 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();

		gogosing(M, 0); // 남은 무개, 사용된 봉지수
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}// end of main

	/**
	 * M 남은 무게, cnt 지금까지 사용한 봉지 개수
	 */
	private static void gogosing(int M, int cnt) {
		if (M < 0) { // 해가 없다.
			return;
		} else if (M == 0) { // 해
//			if (min > cnt) {
//				min = cnt;
//			}
			System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);
			System.exit(0);
		} else {
			gogosing(M - 5, cnt + 1);
			gogosing(M - 3, cnt + 1);
		}

	}
}// end of class
