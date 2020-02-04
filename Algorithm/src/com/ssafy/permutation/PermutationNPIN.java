package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 중복 순열(nㅠn)
 * n의 n승개의 순열
 */

public class PermutationNPIN {
	static int n;		   //n개의 데이터로 순열 만들기
	static int[] numbers;  //순열을 담을 배열
	static int test_case;
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt  배열 번호
	 */
	private static void permutation(int cnt) {
		if(cnt==n) {  //nㅠr이라면 여기가 r로 바뀌면 됨
			test_case++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= n; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		long start = System.currentTimeMillis();
		numbers = new int[n];  //nㅠr이라면 배열 크기도 r로 바뀌면 됨
		permutation(0);
//		n에 5를 넣으면 5의 5승인 3125가 나온다.
		long end = System.currentTimeMillis();
//		중복순열은 8TT8 0.1초컷 = 안전
//		        10TT10 1초컷 = 약간 위험
//		        1TT1 1초컷 = 약간 위험
		System.out.printf("순열 %dㅠ%d 생성된 수 : %d, 걸린시간 : %d", n,  n, test_case, end-start);
		
		
	}



}
