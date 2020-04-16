package algo;

import java.util.Scanner;

/*
 * 월말평가 소금배달 문제 
 */
public class 연습문제1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N+1];
		memo[1] = 2;
		memo[2] = 5;
		for (int i = 3; i <= N; i++) {
			memo[i] = memo[i-2]*2 + memo[i-1];
		}

		System.out.println(memo[N]);
		

	}
}
