package jungol.im;

import java.util.Scanner;

public class Main_1411_두줄로타일깔기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] memo = new long[n + 1];

		memo[1] = 1;
		memo[2] = 3;
		memo[3] = 5;

		for (int i = 4; i <= n; i++) {
			memo[i] = memo[i - 1] + 2 * memo[i - 2];
		}
		System.out.println(memo[n] % 20100529);
	}
}
