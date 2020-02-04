package com.ssafy.recursive;

public class RecursiveCallFibo {
	
/**
 * n번째 까지의 피보나치 수열과 합을 구하는 함수
 * @param cnt   n번째
 * @param old   n-2
 * @param next  n-1
 * @return 현재 수열까지의 합
 */
	public static int recurFibo2(int cnt, int old, int next) {
		if(cnt == 1) {  //이때 끝남
			System.out.print(next + " ");
			return next;
		}
		System.out.print(next + " ");
		return next+recurFibo2(--cnt, next, old+next);
	}
	
	public static int recurFibo1(int n) {
		
//		if(n==1)
//			return 1;
//		if(n==0)
//			return 0;
		
//		위에 두개 합치면 이렇게 됨
		if(n<=1)
			return n;
		
		return recurFibo1(n-1) + recurFibo1(n-2);
	}
	
	public static int fibo1(int n) {
		int sum = 0;
		int oldsu = 0;
		int su = 1;
		int newsu = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print(su+" ");
			sum+=su;
			newsu = oldsu+su;
			oldsu = su;
			su = newsu;
		}
		return sum;
	}
//	1 1 2 3 5 8
	public static void main(String[] args) {
		System.out.println("합 : "+fibo1(7));
		System.out.println("합 : "+recurFibo1(7));
		System.out.println("합 : "+recurFibo2(7, 0, 1));
		
		
		
		
	}

}
