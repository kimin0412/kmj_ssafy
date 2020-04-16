package com.ssafy.dp;

import java.util.Scanner;

/**
 * 1cm 짜리 파란 막대, 2cm 짜리 노란 막대, 3cm 짜리 빨간 막대가 있다.
 * 이 막대들을 연결하여 길이가 ncm인 막대를 만드는 방법의 수를 f(n)이라 하자.
 * 예를 들면 3cm 막대를 만드는 방법은
 * – (파란 막대, 파란 막대, 파란 막대),
 * – (파란 막대, 노란 막대),
 * – (노란 막대, 파란 막대),
 * – (빨간 막대)
 * – 4가지이므로 f(3) = 4이다. f(8)의 값은?
 */
public class Stick2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memo = new int[n+1];
		
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for (int i = 4; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
		}
		System.out.println(memo[n]);

	}

}
