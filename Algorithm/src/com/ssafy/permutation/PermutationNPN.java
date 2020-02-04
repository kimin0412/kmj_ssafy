package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 중복 순열(nㅠn)
 * n의 n승개의 순열
 */

public class PermutationNPN {
	static int n;		   //n개의 데이터로 순열 만들기
	static int[] numbers;  //순열을 담을 배열
	static int test_case;
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt  배열 번호
	 */
	private static void permutation(int cnt, int flag) {
		if (cnt == n) { // nㅠr이라면 여기가 r로 바뀌면 됨
			test_case++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		top:
		for (int i = 1; i <= n; i++) {
//			동일한 데이터가 있는지 중복 검사
			for (int j = 0; j < cnt; j++) {  //배열번호
				if(numbers[j] == i)
					continue top;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];  //nㅠr이라면 배열 크기도 r로 바뀌면 됨
		permutation(0, 0);
//		n에 5를 넣으면 5의 5승인 3125가 나온다.
		System.out.printf("%dP%d 중복 순열이 생성된 수 : %d", n, n,  test_case);
		
		
	}



}
