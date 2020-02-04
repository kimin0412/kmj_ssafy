package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 중복 순열(nㅠn)
 * n의 n승개의 순열
 */

public class PermutationNPN2 {
	static int n;		   //n개의 데이터로 순열 만들기
	static int[] numbers;  //순열을 담을 배열
	static int test_case;
	static boolean[] selected;
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt  배열 번호
	 */
	private static void permutation(int cnt) {
		if (cnt == n) { // nㅠr이라면 여기가 r로 바뀌면 됨
			test_case++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= n; i++) {
//			동일한 데이터가 있는지 중복 검사
			if (!selected[i]) {  //i 숫자가 사용되지 않은 경우
				numbers[cnt] = i;
				selected[i] = true;  //i 숫자를 사용했다고 표시
				permutation(cnt+1);
				selected[i] = false;  //다른 순열을 생성하기 위해 i 숫자를 다시 미사용으로 표시
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];  //nㅠr이라면 배열 크기도 r로 바뀌면 됨
		selected = new boolean[n+1];
		permutation(0);
//		순열은 10P10 0.1초컷	=>안전
//		순열은 11P11 1.2초컷	=>위험
//		n에 5를 넣으면 5의 5승인 3125가 나온다.
		System.out.printf("%dP%d 중복 순열이 생성된 수 : %d", n, n,  test_case);
		
		
	}



}
