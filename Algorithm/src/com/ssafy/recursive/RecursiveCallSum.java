package com.ssafy.recursive;

public class RecursiveCallSum {
	static int cnt;  //static으로 선언하면 자동으로 0이 됨
//	10+9+8+...+1
	public static int recurSum(int n) {
		cnt++;
		if(n==1) {
			return 1;
		}
		return recurSum(n-1)+n;
	}
	public static void main(String[] args) {
		int sum = 0;
		int n = 10;
		System.out.println(11*n/2);  //가우스 법칙
//		1+2+3+ ... +10
		for (int i = 1; i <= n; i++) {
			sum+=i;
		}
		System.out.println(sum);
		System.out.println(recurSum(n));
		System.out.println(cnt);
		
	}

}
