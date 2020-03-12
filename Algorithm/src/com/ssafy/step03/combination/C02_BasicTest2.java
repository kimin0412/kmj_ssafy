package com.ssafy.step03.combination;

import java.security.AllPermission;
import java.util.Arrays;
import java.util.Scanner;

public class C02_BasicTest2 {

	static int N, R;
	static int[] input, number;
	static boolean[] isSelected;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		number = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		combination(N, R);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	// n번째 원소(순서)를 r위치(순서)에 조합해보기 
	private static void combination(int n, int r) { // cnt: 순열을 뽑는 자리
		
		if(r == 0) { // 다뽑은거 (조합이 완성) 
			++totalCnt;
			System.out.println(Arrays.toString(number));
			return;
		}
		if(n < r) { // 불가능한 상황 (r==0인 상황이랑 다름)
			return;
		}
		
		// 선택
		number[r-1] = input[n-1]; // 인덱스 계산으로 인해 -1 해줌
		combination(n-1, r-1);
		// 비선택
		combination(n-1, r);
		
		
	}
}
