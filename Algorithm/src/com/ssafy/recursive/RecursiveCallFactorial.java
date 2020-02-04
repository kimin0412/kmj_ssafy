package com.ssafy.recursive;

public class RecursiveCallFactorial {
	
	public static int recurFac(int n) {
//		System.out.println(recurFac(n));
		if(n==2)  //곱하기 1 해봤자 의미없으니까 2부터 시작. 1로 해도 상관은 없음.
			return 2;
		return n*recurFac(n-1);
	}
	public static void main(String[] args) {
		int n=7;
		int fac=1;
		for (int i = 2; i <= n; i++) {
			System.out.println(i-1+"! : "+fac);
			fac*=i;
			
		}
		System.out.println(n+"! : "+fac);
		
		System.out.println(recurFac(n));

	}

}
