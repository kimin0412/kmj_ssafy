package com.ssafy.combination;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest1 {
	static int test_case, n, r, numbers[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		
		r = sc.nextInt();
		numbers = new int[r];
		combination(0, 1);
		System.out.printf("%dC%d의 조합의 수 : %d\n", n, r, test_case);
		
	}
	
	/**
	 * 조합을 구하는 함수
	 * @param cnt     배열 번호
	 * @param start   조합을 구할 시작 수
	 */
	private static void combination(int cnt, int start) {
		if(cnt == r) {
			test_case++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= n; i++) {  //이전에 나왔던게 또 나올 필요가 없다.
			numbers[cnt] = i;
			combination(cnt+1, i+1);
//			재귀로 이렇게 짜는게 간단하다.
		}
		
	}
	

}
