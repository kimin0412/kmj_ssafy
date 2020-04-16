package com.ssafy.dp;

public class Fibo {

	private static long fiboRec(int n) {
		if(n<=1) {
			return n;
		}
		return fiboRec(n-1) + fiboRec(n-2);
	}
	
	private static long fiboDP(int n) {
		long[] fibo = new long[n+1];
		// 1. 초항에 대한 설정
		// fibo[0] = 0;
		fibo[1] = 1;
		// f(n) = f(n-1) + f(n-2);
		// 2. n번째 항에 대한 값을 구하기 위해 점화식 + 메모이제이션
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		return fibo[n];
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		// 1 1 2 3 5
//		System.out.println(fiboRec(45));
//		Fibo[45] : 1134903170
		System.out.println(fiboDP(45));
		long end = System.currentTimeMillis();
		
		System.out.printf("%dms", end-start);

	}

	

}
