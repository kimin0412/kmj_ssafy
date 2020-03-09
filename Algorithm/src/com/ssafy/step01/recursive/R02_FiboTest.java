package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R02_FiboTest {

	// n! : n * (n-1)!
	
	// n! 계산 
	private static long fibo(int n) {
		// 기저(탈출) 파트
		if(n <= 1) return n;
		// 유도(파생) 파트  
		return fibo(n-1) + fibo(n-2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
	}

}
