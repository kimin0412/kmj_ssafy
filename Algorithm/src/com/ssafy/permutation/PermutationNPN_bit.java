package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 순열(nPn)
 * n!개의 순열
 */

public class PermutationNPN_bit {
	static int n;		   //n개의 데이터로 순열 만들기
	static int[] numbers;  //순열을 담을 배열
	static int test_case;
	
	/**
	 * 순열을 만들어주는 함수
	 * @param cnt  배열 번호
	 * @param flag 데이터 중복을 검사하는 bit mask flag
	 */
	private static void permutation(int cnt, int flag) {
		if (cnt == n) { // nㅠr이라면 여기가 r로 바뀌면 됨
			test_case++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		top:
		for (int i = 1; i <= n; i++) {
////			동일한 데이터가 있는지 중복 검사
//			for (int j = 0; j < cnt; j++) {  //배열번호
//				if(numbers[j] == i)
//					continue top;
//			}
			
//			for문 대신 bit mask 사용할 예정
			if((flag & 1<<i)==0) {  //i숫자가 사용되지 않은 경우. 사용되지 않은거 0, 사용된거 1. *****외우기******
				numbers[cnt] = i;
				permutation(cnt+1, flag| 1<<i); //i숫자가 사용됐음을 표시
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];  //nㅠr이라면 배열 크기도 r로 바뀌면 됨
		permutation(0,0);
//        10TT10 0.1초컷 = 안전
//        1TT1 1초컷 = 약간 위험
//		n에 5를 넣으면 5의 5승인 3125가 나온다.
		System.out.printf("%dP%d 중복 순열이 생성된 수 : %d", n, n,  test_case);
		
		
	}



}
